package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
