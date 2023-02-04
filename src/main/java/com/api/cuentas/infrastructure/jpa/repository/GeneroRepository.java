package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<GeneroEntity, Integer> {

    GeneroEntity findByCodigo(String code);

}
