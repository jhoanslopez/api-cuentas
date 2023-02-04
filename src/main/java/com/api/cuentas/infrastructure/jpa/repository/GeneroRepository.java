package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.domain.model.usuario.Genero;
import com.api.cuentas.infrastructure.jpa.entities.GeneroEntity;
import com.api.cuentas.infrastructure.jpa.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<GeneroEntity, Integer> {

    GeneroEntity findByCodigo(String code);

}
