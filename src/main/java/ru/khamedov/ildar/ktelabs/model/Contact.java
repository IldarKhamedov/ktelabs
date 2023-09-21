package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
public abstract class Contact extends AbstractPersistable<Long> {

    @Basic(optional = false)
    private String contact;

    private boolean active=true;

    private String note;
}
