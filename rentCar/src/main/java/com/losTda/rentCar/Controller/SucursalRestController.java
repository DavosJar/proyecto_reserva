package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Sucursal;
import com.losTda.rentCar.requests.SucursalSaveRequest;
import com.losTda.rentCar.service.SucursalService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sucursales")
public class SucursalRestController {
    private final SucursalService sucursalService;

    public SucursalRestController(SucursalService sucursalService){
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerSucursales(){
        List<Sucursal> sucursales = sucursalService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(sucursales)
                .message("Sucursales obtenidas correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerSucursal(Long id){
        return sucursalService.findById(id)
                .map(sucursal -> new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(sucursal)
                        .message("Sucursal obtenida correctamente")
                        .build())
                .orElseGet(() -> new ResponseBuilder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("No se encontró la sucursal")
                        .build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarSucursal(@RequestBody SucursalSaveRequest sucursal){
        return sucursalService.save(sucursal)
                .map(sucursalGuardada -> new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(sucursalGuardada)
                        .message("Sucursal guardada correctamente")
                        .build())
                .orElseGet(() -> new ResponseBuilder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message("No se pudo guardar la sucursal")
                        .build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarSucursal(Long id){
        sucursalService.deleteById(id);
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .message("Sucursal eliminada correctamente")
                .build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Map<String, Object>> obtenerSucursalPorNombre(String nombre){
        List<Sucursal> sucursales = sucursalService.findByNombreSucursal(nombre);

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(sucursales)
                .message("Sucursales obtenidas correctamente")
                .build();
    }

    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<Map<String, Object>> obtenerSucursalPorTelefono(String telefono){
        return sucursalService.findByTelefono(telefono)
                .map(sucursal -> new ResponseBuilder()
                        .status(HttpStatus.OK)
                        .data(sucursal)
                        .message("Sucursal obtenida correctamente")
                        .build())
                .orElseGet(() -> new ResponseBuilder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("No se encontró la sucursal")
                        .build());
    }
}
