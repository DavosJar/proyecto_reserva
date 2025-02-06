package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Vehiculo;
import com.losTda.rentCar.requests.vehiculo.VehiculoSaveRequest;
import com.losTda.rentCar.service.VehiculoService;
import com.losTda.rentCar.utils.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoRestController {

    private final VehiculoService vehiculoService;

    public VehiculoRestController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(vehiculos)
                .message("Vehículos obtenidos correctamente")
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerVehiculo(@PathVariable Long id) {
        return vehiculoService.findById(id)
                .map(vehiculo -> new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(vehiculo)
                        .message("Vehículo obtenido correctamente")
                        .build())
                .orElseGet(() -> new ResponseBuilder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("No se encontró el vehículo con ID " + id)
                        .build());
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Map<String, Object>> obtenerVehiculoPorMatricula(@PathVariable String matricula) {
        return vehiculoService.findByMatricula(matricula)
                .map(vehiculo -> new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(vehiculo)
                        .message("Vehículo obtenido correctamente")
                        .build())
                .orElseGet(() -> new ResponseBuilder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("No se encontró el vehículo")
                        .build());
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<Map<String, Object>> obtenerVehiculosPorMarca(@PathVariable String marca) {

        try{
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(vehiculoService.findByMarca(marca))
                    .message("Vehículos obtenidos correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Algo salió mal")
                    .build();
        }

    }

    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<Map<String, Object>> obtenerVehiculosPorModelo(@PathVariable String modelo) {
        List<Vehiculo> vehiculos = vehiculoService.findByModelo(modelo);

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(vehiculos)
                .message("Vehículos obtenidos correctamente")
                .build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<Map<String, Object>> obtenerVehiculosPorEstado(@PathVariable String estado) {
        List<Vehiculo> vehiculos = vehiculoService.findByEstadoVehiculo(estado);
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(vehiculos)
                .message("Vehículos obtenidos correctamente")
                .build();
    }

    @GetMapping("/{marca}/{modelo}")
    public ResponseEntity<Map<String, Object>> obtenerVehiculosPorMarcaYModelo(@PathVariable String marca, @PathVariable String modelo) {
        List<Vehiculo> vehiculos = vehiculoService.findByMarcaAndModelo(marca, modelo);

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(vehiculos)
                .message("Vehículos obtenidos correctamente")
                .build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarVehiculo(@Valid @RequestBody VehiculoSaveRequest request) {
        if (vehiculoService.existsByMatricula(request.getMatricula())) {
            return new ResponseBuilder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Ya existe un vehículo con la matrícula: " + request.getMatricula())
                    .build();
        }
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .data(vehiculoService.save(request).get())
                    .message("Vehículo guardado correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo guardar el vehículo")
                    .build();
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarVehiculo(@RequestBody VehiculoSaveRequest request) {
        if (!vehiculoService.existsByMatricula(request.getMatricula())) {
            return new ResponseBuilder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("No existe un vehículo con la matrícula: " + request.getMatricula())
                    .build();
        }
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(vehiculoService.update(request).get()).build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo actualizar el vehículo")
                    .build();
        }
    }

}