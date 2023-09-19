package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query("SELECT d FROM Doctor d WHERE d.login=:login")
    Doctor findByLogin(@Param("login")String login);
}
