package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.UUID;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public abstract class SuperUser extends AbstractPersistable<Long> {

    @Basic(optional = false)
    private String uuid=UUID.randomUUID().toString();

    @Basic(optional = false)
    private String password;

    @Basic(optional = false)
    private String firstName;

    @Basic(optional = false)
    private String middleName;

    @Basic(optional = false)
    private String lastName;
}