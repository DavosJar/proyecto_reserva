package com.losTda.rentCar.Controller;

import com.losTda.rentCar.requests.TelefonoSaveRequest;
import com.losTda.rentCar.service.TelefonoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/telefonos")
public class TelefonoRestController {

    private final TelefonoService telefonoService;

    public TelefonoRestController(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("telefonos", telefonoService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable("id") Long id) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("telefono", telefonoService.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/obtener/{descripcion}")
    public ResponseEntity<HashMap<String, Object>> findByDescripcion(@PathVariable("descripcion") String descripcion) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("telefono", telefonoService.findByDescripcion(descripcion));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable("id") Long id) {
        HashMap<String, Object> response = new HashMap<>();
        telefonoService.deleteById(id);
        response.put("message", "Telefono eliminado correctamente");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/guardar")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody TelefonoSaveRequest telefonoSaveRequest) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("telefono", telefonoService.save(telefonoSaveRequest));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<HashMap<String, Object>> update(@RequestBody TelefonoSaveRequest telefonoSaveRequest) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("telefono", telefonoService.update(telefonoSaveRequest));
        return ResponseEntity.ok(response);
    }


}
