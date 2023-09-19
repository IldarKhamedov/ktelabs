package ru.khamedov.ildar.ktelabs.security;

import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.khamedov.ildar.ktelabs.model.Doctor;
import ru.khamedov.ildar.ktelabs.repository.DoctorRepository;
import ru.khamedov.ildar.ktelabs.util.Constant;

import java.util.ArrayList;


public class DoctorDetailService implements UserDetailsService {
    @Resource
    private DoctorRepository doctorRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        Doctor doctor=doctorRepository.findByLogin(username);
        authorities.add(new SimpleGrantedAuthority(Constant.AUTHORITY_ROLE));
        return new User(doctor.getLogin(), doctor.getPassword(), !doctor.isBlocked(),true, true, true, authorities);
    }
}
