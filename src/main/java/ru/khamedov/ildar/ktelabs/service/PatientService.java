package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.dto.PatientDTO;
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
    @Resource
    private ConfirmationService confirmationService;


    public boolean createPatient(PatientDTO patientDTO) {
        if(!confirmationService.checkCode(patientDTO.getContact(), patientDTO.getCode()) || disallowPatientByContact(patientDTO.getContact()) ){
            return false;
        }
            Patient patient = modelMapperService.convertToPatient(patientDTO);
            Contact contact = new Phone();
            contact.setContact(patientDTO.getContact());
            patient.getContactSet().add(contact);
            patientRepository.save(patient);
        return true;
    }

    private boolean disallowPatientByContact(String contact){
        return patientRepository.findByContact(contact) != null;
    }
}
