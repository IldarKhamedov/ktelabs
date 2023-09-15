package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post extends AbstractPersistable<Long> {

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String description;

    @OneToMany
    private List<Service> serviceList=new ArrayList<>();
}
