package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Vehiculo;
import com.losTda.rentCar.requests.vehiculo.VehiculoSaveRequest;
import com.losTda.rentCar.service.VehiculoService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vehiculos")
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

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarVehiculo(@RequestBody VehiculoSaveRequest request) {
        System.out.println("Guardando vehiculo");
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