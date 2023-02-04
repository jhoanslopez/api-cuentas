package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.GeneroEntity;
import com.api.cuentas.infrastructure.jpa.entities.TipoIdentificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacionEntity, Integer> {

    TipoIdentificacionEntity findByCodigo(String code);

}
