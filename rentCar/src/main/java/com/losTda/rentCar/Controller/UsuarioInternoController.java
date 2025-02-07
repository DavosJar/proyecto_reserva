package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.UsuarioInterno;
import com.losTda.rentCar.requests.UsuarioInternoSaveRequest;
import com.losTda.rentCar.service.UsuarioInternoService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarioInterno")
public class UsuarioInternoController {
    private final UsuarioInternoService usuarioInternoService;

    public UsuarioInternoController(UsuarioInternoService usuarioInternoService) {
        this.usuarioInternoService = usuarioInternoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerUsuariosInternos() {
        List<UsuarioInterno> usuariosInternos = usuarioInternoService.findAll();
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usuariosInternos)
                .message("Usuarios internos obtenidos correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerUsuarioInterno(@PathVariable Long id) {
        return usuarioInternoService.findById(id)
                .map(usuarioInterno -> new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(usuarioInterno)
                        .message("Usuario interno obtenido correctamente")
                        .build())
                .orElseGet(() -> new ResponseBuilder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("Usuario interno no encontrado")
                        .build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarUsuarioInterno(@RequestBody UsuarioInternoSaveRequest request) {
        try {
            return usuarioInternoService.save(request)
                    .map(usuarioInterno -> new ResponseBuilder()
                            .status(HttpStatus.CREATED)
                            .data(usuarioInterno)
                            .message("Usuario interno guardado correctamente")
                            .build())
                    .orElseGet(() -> new ResponseBuilder()
                            .status(HttpStatus.BAD_REQUEST)
                            .message("Error al guardar el usuario interno")
                            .build());
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Error interno del servidor")
                    .build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarUsuarioInterno(@PathVariable Long id) {
        try {
            usuarioInternoService.deleteById(id);
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Usuario interno eliminado correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Error interno del servidor")
                    .build();
        }
    }

    @GetMapping("/departamento/{departamento}")
    public ResponseEntity<Map<String, Object>> obtenerUsuariosPorDepartamento(@PathVariable String departamento) {
        List<UsuarioInterno> usuariosInternos = usuarioInternoService.findByDepartamento(departamento);
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usuariosInternos)
                .message("Usuarios internos obtenidos correctamente")
                .build();
    }

    @GetMapping("/puesto/{puesto}")
    public ResponseEntity<Map<String, Object>> obtenerUsuariosPorPuesto(@PathVariable String puesto) {
        List<UsuarioInterno> usuariosInternos = usuarioInternoService.findByPuesto(puesto);
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usuariosInternos)
                .message("Usuarios internos obtenidos correctamente")
                .build();
    }
}