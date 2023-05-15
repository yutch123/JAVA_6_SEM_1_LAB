package com.psuti.raz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, length = 25, name = "first_name")
    private String firstName;

    @Column(nullable = false, length = 25,name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "role")
    private Role role;

    @Column(nullable = false)
    private String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore // скрывает поле от изменения при передачи объекта User внутри JSON
    private boolean enabled = true; // указывает на признак входа пользователя
}
