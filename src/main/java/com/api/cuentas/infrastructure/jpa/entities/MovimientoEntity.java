package com.api.cuentas.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "movimiento")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    private CuentaEntity cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_movimiento_id")
    private TipoMovimientoEntity tipoMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Column(name = "saldo_inicial")
    private Long saldoInicial;

    @Column(name = "valor_movimiento")
    private Long valorMovimiento;

    @Column(name = "saldo_disponible")
    private Long saldoDisponible;

    @Column(name = "fecha")
    private Date fecha;

}
