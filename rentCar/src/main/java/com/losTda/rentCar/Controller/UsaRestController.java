package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.requests.UsaSaveRequest;
import com.losTda.rentCar.service.UsaService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usa")
public class UsaRestController {

    private final UsaService usaService;

    public UsaRestController(UsaService usaService) {
        this.usaService = usaService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll() {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usaService.findAll())
                .message("Lista de relaciones")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usaService.findById(id))
                .message("Relacion encontrada")
                .build();
    }

    @PostMapping("/usuario")
    public ResponseEntity<Map<String, Object>> findByUsuario(@RequestBody Usuario usuario) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usaService.findByUsuario(usuario))
                .message("Relacion encontrada")
                .build();
    }

    @PostMapping("/metodoPago")
    public ResponseEntity<Map<String, Object>> findByMetodoPago(@RequestBody MetodoPago metodoPago) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usaService.findByMetodoPago(metodoPago))
                .message("Relacion encontrada")
                .build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> save(@RequestBody UsaSaveRequest usa) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usaService.save(usa))
                .message("Relacion guardada")
                .build();
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> update(@RequestBody UsaSaveRequest usa) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(usaService.update(usa))
                .message("Relacion actualizada")
                .build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable("id") Long id) {
        usaService.deleteById(id);
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .message("Relacion eliminada")
                .build();
    }
}
