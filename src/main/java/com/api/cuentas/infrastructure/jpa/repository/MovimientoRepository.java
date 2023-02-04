package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {

}
