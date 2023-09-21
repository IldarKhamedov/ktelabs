package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.dto.PatientRecordDTO;
import ru.khamedov.ildar.ktelabs.model.Contact;
import ru.khamedov.ildar.ktelabs.model.Patient;
import ru.khamedov.ildar.ktelabs.model.Phone;
import ru.khamedov.ildar.ktelabs.repository.ConfirmationRepository;
import ru.khamedov.ildar.ktelabs.repository.PatientRepository;

@Service
public class PatientService {

    @Resource
    private ConfirmationRepository confirmationRepository;
    @Resource
    private PatientRepository patientRepository;
    @Resource
    private ModelMapperService modelMapperService;


    public Patient createPatient(PatientRecordDTO fillRecordDTO) {
        Patient patient = patientRepository.findByContact(fillRecordDTO.getContact());
        if (patient == null) {
            patient = modelMapperService.convertToPatient(fillRecordDTO);
            Contact contact = new Phone();
            contact.setContact(fillRecordDTO.getContact());
            patient.getContactSet().add(contact);
            patientRepository.save(patient);
        }
        return patient;
    }
}
