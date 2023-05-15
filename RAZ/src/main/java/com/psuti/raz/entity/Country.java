package com.psuti.raz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    public Long population;

    @OneToOne
    @JoinColumn(name = "capital")
    private Capital capital;
}
