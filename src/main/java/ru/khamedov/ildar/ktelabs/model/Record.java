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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_id","date","time"})})
public class Record extends AbstractPersistable<Long> {

    @ManyToOne(optional = false)
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    private Date date;

    @Temporal(TemporalType.TIME)
    @Basic(optional = false)
    private Date time;

    @Basic(optional = false)
    private Duration duration;

    private boolean confirmed;

}
