package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Direccion;
import com.losTda.rentCar.requests.DireccionSaveRequest;
import com.losTda.rentCar.service.DireccionService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/direcciones")
public class DireccionRestController {

    private final DireccionService direccionService;

    public DireccionRestController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerDirecciones() {
        List<Direccion> direcciones = direccionService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(direcciones)
                .message("Direcciones obtenidas correctamente")
                .build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarDireccion(@RequestBody DireccionSaveRequest direccion) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .data(direccionService.save(direccion).get())
                    .message("Dirección guardada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo guardar la dirección")
                    .build();
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarDireccion(@RequestBody DireccionSaveRequest direccion) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(direccionService.update(direccion).get())
                    .message("Dirección actualizada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo actualizar la dirección")
                    .build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarDireccion(@PathVariable("id") Long id) {
        try {
            direccionService.delete(id);
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Dirección eliminada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo eliminar la dirección")
                    .build();
        }
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerDireccion(@PathVariable("id") Long id) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(direccionService.findById(id))
                    .message("Dirección obtenida correctamente")
                    .build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró la dirección")
                    .build();
        }

    }

    @GetMapping("/calle/{calle}")
    public ResponseEntity<Map<String, Object>> obtenerDireccionPorCalle(@PathVariable("calle") String calle) {
        List<Direccion> direccion = direccionService.findByCalle(calle);
        if (direccion.isEmpty()) {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontraron las direcciones")
                    .build();
        }
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(direccion)
                .message("Direccines obtenidas correctamente")
                .build();
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<Map<String, Object>> obtenerDireccionPorNumero(@PathVariable("numero") String numero) {
        List<Direccion> direccion = direccionService.findByNumero(numero);
        if (direccion.isEmpty()) {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontraron las direcciones")
                    .build();
        }
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(direccion)
                .message("Direccines obtenidas correctamente")
                .build();
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<Map<String, Object>> obtenerDireccionPorCiudad(@PathVariable("ciudad") String ciudad) {
        List<Direccion> direccion = direccionService.findByCiudad(ciudad);
        if (direccion.isEmpty()) {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontraron las direcciones")
                    .build();
        }
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(direccion)
                .message("Direccines obtenidas correctamente")
                .build();
    }

}
