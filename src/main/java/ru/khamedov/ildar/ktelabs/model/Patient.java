package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Patient extends SuperUser {

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private Double discount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,name = "patient_id")
    private Set<Contact> contactSet =new HashSet<>();
}
