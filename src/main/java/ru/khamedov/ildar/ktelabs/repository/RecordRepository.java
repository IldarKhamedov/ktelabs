package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Record;

import java.util.Date;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {

    /**
     * Проверка записи по дате и времени.
     * @param date
     * @param time
     */
    @Query("SELECT COUNT(r)>0 FROM Record r WHERE r.date=:date AND r.time=:time")
    boolean existsByDateAndTime(@Param("date") Date date,@Param("time")Date time);

    @Query("SELECT r FROM Record r WHERE r.doctor.id=:doctorId AND r.date=:date AND r.patient IS NULL")
    List<Record> findByDoctorAndDate(@Param("doctorId") Long doctorId, @Param("date") Date date);

    @Query("SELECT r FROM Record r WHERE r.patient.id=:id")
    List<Record> findByID(@Param("id") Long id);

    @Query("SELECT r FROM Record r WHERE r.patient.uuid=:id")
    List<Record> findByUUID(@Param("id") String id);
}
