package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.TipoIdentificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacionEntity, Integer> {

    TipoIdentificacionEntity findByCodigo(String code);

}
