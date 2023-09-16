package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.Duration;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Record extends AbstractPersistable<Long> {

    @ManyToOne(optional = false)
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    private Duration duration;

    private boolean confirmed;

}
