package com.api.cuentas.infrastructure.resources;

import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UsuarioResource {

    @Operation(summary = "Obtiene todos los usuarios")
    @GetMapping("/usuarios")
    List<Persona> obtenerUsuarios();

    @Operation(summary = "Obtiene un usuario por su id")
    @GetMapping("/usuario/{id}")
    Persona obtenerUsuario(@PathVariable("id") Integer id);

    @Operation(summary = "Crea un nuevo usuario")
    @PostMapping("/usuario")
    ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) throws LogicaException;

    @Operation(summary = "Actualiza un usuario")
    @PutMapping("/usuario")
    Usuario actualizarUsuario(@RequestBody Usuario usuario);

    @Operation(summary = "Elimina un usuario por su id")
    @DeleteMapping("/usuario/{id}")
    Persona eliminarUsuario(@PathVariable("id") Integer id);

}
