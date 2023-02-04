package com.api.cuentas.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genero")
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

}
