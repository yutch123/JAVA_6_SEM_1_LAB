package com.psuti.raz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "capital")
public class Capital implements Serializable {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "name")
    @JsonBackReference
    private List<City> city;
}
