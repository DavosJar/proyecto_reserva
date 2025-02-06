package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Alquiler;
import com.losTda.rentCar.service.AlquilerService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alquileres")
public class AlquilerRestController {

    private final AlquilerService alquilerService;

    public AlquilerRestController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerAlquileres() {
        List<Alquiler> alquileres = alquilerService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(alquileres)
                .message("Alquileres obtenidos correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerAlquiler(@PathVariable("id") Long id) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(alquilerService.findById(id).get())
                    .message("Alquiler obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener el alquiler")
                    .build();
        }
    }

    @GetMapping("/fechaInicio/{fechaInicio}")
    public ResponseEntity<Map<String, Object>> obtenerAlquilerPorFechaInicio(@PathVariable("fechaInicio") LocalDate fechaInicio) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(alquilerService.findByFechaInicio(fechaInicio))
                    .message("Alquiler obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener el alquiler")
                    .build();
        }
    }

    @GetMapping("/fechaDevolucion/{fechaDevolucion}")
    public ResponseEntity<Map<String, Object>> obtenerAlquilerPorFechaDevolucion(@PathVariable("fechaDevolucion") LocalDate fechaDevolucion) {

        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(alquilerService.findByFechaDevolucion(fechaDevolucion))
                    .message("Alquiler obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener el alquiler")
                    .build();
        }
    }

    @GetMapping("/costoDia/{costoDia}")
    public ResponseEntity<Map<String, Object>> obtenerAlquilerPorCostoDia(@PathVariable("costoDia") String costoDia) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(alquilerService.findByCostoDia(costoDia))
                    .message("Alquiler obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener el alquiler")
                    .build();
        }
    }

    @GetMapping("/estadoAlquiler/{estadoAlquiler}")
    public ResponseEntity<Map<String, Object>> obtenerAlquilerPorEstadoAlquiler(@PathVariable("estadoAlquiler") String estadoAlquiler) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(alquilerService.findByEstadoAlquiler(estadoAlquiler))
                    .message("Alquiler obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener el alquiler")
                    .build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarAlquiler(@PathVariable("id") Long id) {
        try {
            alquilerService.delete(id);
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Alquiler eliminado correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo eliminar el alquiler")
                    .build();
        }
    }

}
