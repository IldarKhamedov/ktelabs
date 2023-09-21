package ru.khamedov.ildar.ktelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.khamedov.ildar.ktelabs.model.Confirmation;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {

    @Query(" SELECT COUNT(c)>0 FROM Confirmation c WHERE " +
            " c.contact=:contact " +
            " AND c.code=:code ")
    boolean checkByContactAndCode(@Param("contact")String contact,
                                  @Param("code")String code);
}
