package ru.khamedov.ildar.ktelabs.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
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

    @Column(nullable = false,unique = true)
    private String login;

    @Basic(optional = false)
    private String password;

    private boolean blocked;

    @ManyToMany
    private List<Post> postList=new ArrayList<>();
}
