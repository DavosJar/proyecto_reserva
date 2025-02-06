package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.requests.UsuarioSaveRequests;
import com.losTda.rentCar.service.UsuarioService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usuarios)
                .message("Usuarios obtenidos correctamente")
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(usuario.get())
                    .message("Usuario encontrado")
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un usuario con el ID: " + id)
                    .build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioSaveRequests request) {
        Usuario usuario = new Usuario();
        usuario.setDni(request.getDni());
        usuario.setNombres(request.getNombres());
        usuario.setDireccion(request.getDireccion());

        Usuario usuarioGuardado = usuarioService.save(usuario);
        return new ResponseBuilder()
                .status(HttpStatus.CREATED)
                .data(usuarioGuardado)
                .message("Usuario guardado correctamente")
                .build();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioSaveRequests request) {
        Usuario usuario = new Usuario();
        usuario.setId(request.getId());
        usuario.setDni(request.getDni());
        usuario.setNombres(request.getNombres());

        Optional<Usuario> usuarioActualizado = usuarioService.update(usuario);
        if (usuarioActualizado.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(usuarioActualizado.get())
                    .message("Usuario actualizado correctamente")
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un usuario con el ID: " + request.getId())
                    .build();
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> obtenerUsuarioPorDni(@PathVariable String dni) {
        Optional<Usuario> usuario = usuarioService.findByDni(dni);
        if (usuario.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(usuario.get())
                    .message("Usuario encontrado")
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un usuario con el DNI: " + dni)
                    .build();
        }
    }
}