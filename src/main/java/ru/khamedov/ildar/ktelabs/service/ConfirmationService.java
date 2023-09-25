package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.repository.ConfirmationRepository;

@Service
public class ConfirmationService {

    @Resource
    private ConfirmationRepository confirmationRepository;

    public boolean checkCode(String contact,String code){
        return confirmationRepository.checkByContactAndCode(contact,code);
    }
}
