package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.TipoCuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCuentaRepository extends JpaRepository<TipoCuentaEntity, Integer> {

    TipoCuentaEntity findByCodigo(String code);

}
