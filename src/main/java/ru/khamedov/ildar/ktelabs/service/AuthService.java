package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.model.Doctor;
import ru.khamedov.ildar.ktelabs.repository.DoctorRepository;

@Service
/**
 * Сервис для получения авторизованного доктора.
 */
public class AuthService {

    @Resource
    private DoctorRepository doctorRepository;

    public Doctor getUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return doctorRepository.findByLogin(name);
    }
}
