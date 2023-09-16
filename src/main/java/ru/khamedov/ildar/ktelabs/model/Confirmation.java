package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Confirmation extends AbstractPersistable<Long> {

    @Basic(optional = false)
    private String phone;

    @Basic(optional = false)
    private String code;


}
