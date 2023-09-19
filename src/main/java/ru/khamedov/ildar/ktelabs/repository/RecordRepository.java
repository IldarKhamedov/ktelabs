package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Record;

import java.util.Date;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {

    /**
     * Проверка записи по дате и времени.
     * @param date
     * @param time
     */
    @Query("SELECT COUNT(r)>0 FROM Record r WHERE r.date=:date AND r.time=:time")
    boolean existsByDateAndTime(@Param("date") Date date,@Param("time")Date time);
}
