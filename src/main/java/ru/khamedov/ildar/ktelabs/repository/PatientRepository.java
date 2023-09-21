package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(" SELECT p FROM Patient p" +
            " LEFT JOIN p.contactSet as c" +
            " WHERE c.contact=:contact ")
    Patient findByContact(@Param("contact")String contact);
}
