package com.api.cuentas.infrastructure.resources.impl;

import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.PersonaUseCase;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class ClienteResourceImplTest {

    @InjectMocks
    private ClienteResourceImpl clienteResource;

    @Mock
    private PersonaUseCase personaUseCase;

    @BeforeEach
    void setup() throws LogicaException {

        MockitoAnnotations.openMocks(this);
        Usuario usuario = Usuario.builder()
                .idCliente(1)
                .edad((short) 25)
                .estado(true)
                .build();

        when(personaUseCase.obtenerUsuarios()).thenReturn(Collections.singletonList(usuario));
        when(personaUseCase.obtenerUsuario(anyInt())).thenReturn(usuario);
        when(personaUseCase.crearUsuario(any())).thenReturn(usuario);
        when(personaUseCase.actualizarUsuario(any())).thenReturn(usuario);
        when(personaUseCase.eliminarUsuario(anyInt())).thenReturn(true);
    }

    @Test
    void obtenerUsuarios() {
        ResponseEntity<List<Usuario>> response = clienteResource.obtenerUsuarios();
        assertFalse(CollectionUtils.isEmpty(response.getBody()));
    }

    @Test
    void obtenerUsuario() {
        ResponseEntity<Usuario> response = clienteResource.obtenerUsuario(1);
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void crearUsuario() {
        ResponseEntity<Usuario> response = clienteResource.crearUsuario(new Usuario());
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void actualizarUsuario() {
        ResponseEntity<Usuario> response = clienteResource.actualizarUsuario(new Usuario());
        assertTrue(Objects.nonNull(response.getBody()));
    }

    @Test
    void eliminarUsuario() {
        ResponseEntity<Boolean> response = clienteResource.eliminarUsuario(1);
        assertEquals(Boolean.TRUE, response.getBody());
    }
}