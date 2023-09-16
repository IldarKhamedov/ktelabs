package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Confirmation;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {
}
