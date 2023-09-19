package ru.khamedov.ildar.ktelabs.service;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import ru.khamedov.ildar.ktelabs.model.Doctor;
import ru.khamedov.ildar.ktelabs.model.Record;
import ru.khamedov.ildar.ktelabs.repository.RecordRepository;

import java.time.Duration;
import java.util.Date;

@Service
/**
 * Сервис для создания слотов в расписании доктора.
 */
public class RecordService {

    @Resource
    private AuthService authService;

    @Resource
    private RecordRepository repository;

    public boolean createSlots(Date date, Date time, Duration duration,int count){
        Doctor doctor=authService.getUser();
        for(int i=1; i <= count; i++){
            repository.save(createRecord(doctor,date,time,duration));
            time= DateUtils.addMinutes(time,duration.toMinutesPart());
        }
        return true;

    }
    private Record createRecord(Doctor doctor, Date date, Date time, Duration duration){
        Record record=new Record();
        record.setDoctor(doctor);
        record.setDate(date);
        record.setTime(time);
        record.setDuration(duration);
        return record;
    }
}
