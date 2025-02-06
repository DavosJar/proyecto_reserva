package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Rol;
import com.losTda.rentCar.requests.RolSaveRequests;
import com.losTda.rentCar.service.RolService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/rol")
public class RolRestController {
    private final RolService rolService;
    public RolRestController(RolService rolService) {
        this.rolService = rolService;}

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerRoles() {
        List<Rol> roles = rolService.findAll();
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(roles)
                .message("Roles obtenidos correctamente")
                .build();
    }


    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarRol(@RequestBody RolSaveRequests requests) {
        try{
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .data(rolService.save(requests).get())
                    .message("Rol guardado correctamente")
                    .build();
        }catch (Exception e){
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo guardar el rol")
                    .build();
        }
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Map<String, Object>> actualizarRol(@PathVariable Long id, @RequestBody RolSaveRequests requests) {
        try {
            Optional<Rol> existingRol = rolService.findById(id);
            if (existingRol.isPresent()) {
                Rol rolToUpdate = existingRol.get();
                rolToUpdate.setNombreRol(requests.getNombreRol());
                rolToUpdate.setDescripcion(requests.getDescripcion());
                return new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(rolService.save(rolToUpdate).get())
                        .message("Rol actualizado correctamente")
                        .build();
            } else {
                return new ResponseBuilder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("Rol no encontrado")
                        .build();
            }
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo actualizar el rol")
                    .build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Map<String, Object>> obtenerId(@PathVariable Long id) {
        Optional<Rol> rolId = rolService.findById(id);
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(rolId)
                    .message("Rol obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se pudo obtener el rol")
                    .build();
        }
    }

}
