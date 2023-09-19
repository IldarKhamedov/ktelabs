package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Patient extends SuperUser {

    private boolean confirmed;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private Double discount;
}
