package com.estramipyme.data.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Rol")
public class Rol {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombreRol")
    private String nombreRol;

    @Column(name = "fechaCreacionRol")
    private Date fechaCreacionRol;

    @Column(name = "isActiveRol")
    private boolean isActiveRol;

}
