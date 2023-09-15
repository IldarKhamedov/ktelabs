package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.Duration;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Service extends AbstractPersistable<Long> {

    private int price;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String description;

    @Basic(optional = false)
    private Duration duration;
}
