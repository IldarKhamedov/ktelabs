package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.dto.DoctorDTO;
import ru.khamedov.ildar.ktelabs.dto.PatientDTO;
import ru.khamedov.ildar.ktelabs.dto.RecordDTO;
import ru.khamedov.ildar.ktelabs.model.Doctor;
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

    public Patient convertToPatient(PatientDTO patientDTO){
        return modelMapper.map(patientDTO,Patient.class);
    }

    public DoctorDTO convertToDoctorDTO(Doctor doctor){
        return modelMapper.map(doctor,DoctorDTO.class);
    }
}
