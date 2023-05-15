package com.psuti.raz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City implements Serializable {
    @Id
    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "population")
    private long population;

    @ManyToOne
    @JoinColumn(name = "capital")
    private Capital capital;
}
