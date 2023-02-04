package com.api.cuentas.infrastructure.jpa.repository;

import com.api.cuentas.infrastructure.jpa.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

}
