package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Doctor extends SuperUser{

    @ManyToMany
    private List<Post> postList=new ArrayList<>();
}
