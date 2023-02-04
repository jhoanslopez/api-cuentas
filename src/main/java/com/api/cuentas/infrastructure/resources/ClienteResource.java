package com.api.cuentas.infrastructure.resources;

import com.api.cuentas.domain.model.usuario.Persona;
import com.api.cuentas.domain.model.usuario.Usuario;
import com.api.cuentas.domain.usecase.exception.LogicaException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClienteResource {

    @Operation(summary = "Obtiene todos los clientes")
    @GetMapping("/clientes")
    ResponseEntity<List<Usuario>> obtenerUsuarios();

    @Operation(summary = "Obtiene un cliente por su id")
    @GetMapping("/cliente/{id}")
    ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Integer id);

    @Operation(summary = "Crea un nuevo cliente")
    @PostMapping("/cliente")
    ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario);

    @Operation(summary = "Actualiza un cliente")
    @PutMapping("/cliente")
    ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario);

    @Operation(summary = "Elimina un cliente por su id")
    @DeleteMapping("/cliente/{id}")
    ResponseEntity<Boolean> eliminarUsuario(@PathVariable("id") Integer id);

}
