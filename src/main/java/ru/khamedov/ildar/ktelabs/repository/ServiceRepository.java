package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
}
