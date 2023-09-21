package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.dto.PatientRecordDTO;
import ru.khamedov.ildar.ktelabs.dto.RecordDTO;
import ru.khamedov.ildar.ktelabs.model.Patient;
import ru.khamedov.ildar.ktelabs.model.Record;

@Service
/**
 * Сервис для сопоставления объектов.
 */
public class ModelMapperService {

    @Resource
    private ModelMapper modelMapper;


    public RecordDTO convertToRecordDTO(Record record){
        return modelMapper.map(record,RecordDTO.class);
    }

    public Patient convertToPatient(PatientRecordDTO patientRecordDTO){
        return modelMapper.map(patientRecordDTO,Patient.class);
    }
}
