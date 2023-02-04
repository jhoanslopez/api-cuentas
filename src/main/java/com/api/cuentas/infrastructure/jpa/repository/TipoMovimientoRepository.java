package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.TipoMovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimientoEntity, Integer> {

    TipoMovimientoEntity findByCodigo(String code);

}
