package ru.khamedov.ildar.ktelabs.service;


import https.ktelabs.web_service.shedule.rules.CreateRecordRequest;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.dto.PatientRecordDTO;
import ru.khamedov.ildar.ktelabs.dto.RecordDTO;
import ru.khamedov.ildar.ktelabs.exception.ExistsRecordException;
import ru.khamedov.ildar.ktelabs.exception.IncompleteRequestException;
import ru.khamedov.ildar.ktelabs.model.Doctor;
import ru.khamedov.ildar.ktelabs.model.Patient;
import ru.khamedov.ildar.ktelabs.model.Record;
import ru.khamedov.ildar.ktelabs.repository.PatientRepository;
import ru.khamedov.ildar.ktelabs.repository.RecordRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
/**
 * Сервис для создания слотов в расписании доктора.
 */
public class RecordService {

    private static final String EMPTY_DATE = "Заполните дату";
    private static final String EMPTY_TIME = "Заполните время";
    private static final String EMPTY_DURATION = "Заполните продолжительность";

    @Resource
    private AuthService authService;

    @Resource
    private RecordRepository recordRepository;

    @Resource
    private ModelMapperService modelMapperService;

    @Resource
    private PatientRepository patientRepository;

    @Resource
    private ConfirmationService confirmationService;

    @Resource
    private PatientService patientService;


    private static final String ERROR_MESSAGE = "Запись уже существует: ";

    public boolean createSlots(Date date, Date time, Duration duration, int count) throws ParseException {
        Doctor doctor = authService.getUser();
        for (int i = 1; i <= count; i++) {
            if (recordRepository.existsByDateAndTime(date, time)) {
                existsRecordError(date, time);
            }
            Record record = createRecord(doctor, date, time, duration);
            recordRepository.save(record);
            time = DateUtils.addMinutes(time, duration.toMinutesPart());
        }
        return true;

    }

    private Record createRecord(Doctor doctor, Date date, Date time, Duration duration) {
        Record record = new Record();
        record.setDoctor(doctor);
        record.setDate(date);
        record.setTime(time);
        record.setDuration(duration);
        return record;
    }

    public boolean checkRequest(CreateRecordRequest createRecordRequest) {
        return createRecordRequest.getDate() != null && createRecordRequest.getStartTime() != null && createRecordRequest.getDuration() != null;
    }

    public void emptyRequestError(CreateRecordRequest createRecordRequest) {
        String message = "";
        if (createRecordRequest.getDate() == null) {
            message = message + EMPTY_DATE;
        }
        if (createRecordRequest.getStartTime() == null) {
            message = message + "; " + EMPTY_TIME;
        }
        if (createRecordRequest.getDuration() == null) {
            message = message + "; " + EMPTY_DURATION;
        }
        throw new IncompleteRequestException(message);
    }

    private void existsRecordError(Date date, Date time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat(" HH:mm");
        throw new ExistsRecordException(ERROR_MESSAGE + dateFormat.format(date) + ", " + timeFormat.format(time));
    }

    public List<RecordDTO> getRecordDTOList(Long doctorId, Date date) {
        List<Record> recordList = recordRepository.findByDoctorAndDate(doctorId, date);
        return recordList.stream().map(r -> modelMapperService.convertToRecordDTO(r)).collect(Collectors.toList());
    }

    public boolean fillRecord(PatientRecordDTO patientRecordDTO) {
        if (!confirmationService.checkCode(patientRecordDTO.getContact(),
                patientRecordDTO.getCode())) {
            return false;
        }
        Record record = recordRepository.findById(patientRecordDTO.getRecordId()).get();
        if (record == null || (record != null && record.getPatient() != null)) {
            return false;
        }
        Patient patient =patientRepository.findByContact(patientRecordDTO.getContact());
        if(patient==null){
            return false;
        }
        record.setPatient(patient);
        recordRepository.save(record);
        return true;
    }
    public List<RecordDTO> getBusyRecords(String id){
        List<Record> recordList=null;
        try {
           Long idParse =Long.parseLong(id);
           recordList=recordRepository.findByID(idParse);
        }catch (NumberFormatException e) {
            recordList = recordRepository.findByUUID(id);
        }
        return recordList.stream().map(r->modelMapperService.convertToRecordDTO(r)).collect(Collectors.toList());
    }
}
