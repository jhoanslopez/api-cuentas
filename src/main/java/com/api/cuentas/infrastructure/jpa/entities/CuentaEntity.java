package com.api.cuentas.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_cuenta")
    private Long numeroCuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cuenta_id")
    private TipoCuentaEntity tipoCuenta;

    @Column(name = "saldo")
    private Long saldo;

    @Column(name = "estado")
    private Boolean estado;

}
