package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Traspaso;
import com.losTda.rentCar.requests.TraspasoSaveRequests;
import com.losTda.rentCar.service.TraspasoService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/traspasos")
public class TraspasoRestController {

    private final TraspasoService traspasoService;

    public TraspasoRestController(TraspasoService traspasoService) {
        this.traspasoService = traspasoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerTraspasos() {
        List<Traspaso> traspasos = traspasoService.findAll();
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(traspasos)
                .message("Traspasos obtenidos correctamente")
                .build();
    }

    @GetMapping("/responsable/{responsable}")
    public ResponseEntity<Map<String, Object>> obtenerPorResponsable(@PathVariable String responsable) {
        Optional<Traspaso> traspaso = traspasoService.findByResponsable(responsable);

        if (traspaso.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Traspaso encontrado")
                    .data(traspaso.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un traspaso con el responsable: " + responsable)
                    .build();
        }
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Map<String, Object>> obtenerPorTipo(@PathVariable String tipo) {
        Optional<Traspaso> traspaso = traspasoService.findByTipo(tipo);

        if (traspaso.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Traspaso encontrado")
                    .data(traspaso.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un traspaso del tipo: " + tipo)
                    .build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarTraspaso(@RequestBody TraspasoSaveRequests request) {
        Traspaso traspaso = new Traspaso();
        traspaso.setTipo(request.getTipo());
        traspaso.setResponsable(request.getResponsable());
        traspaso.setFecha(LocalDate.parse(request.getFecha()));

        try {
            Traspaso traspasoGuardado = traspasoService.save(traspaso);
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .message("Traspaso guardado correctamente")
                    .data(traspasoGuardado)
                    .build();
        } catch (RuntimeException e) {
            return new ResponseBuilder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarTraspaso(@RequestBody Traspaso traspaso) {
        Optional<Traspaso> traspasoActualizado = traspasoService.update(traspaso);

        if (traspasoActualizado.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Traspaso actualizado correctamente")
                    .data(traspasoActualizado.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un traspaso con el ID: " + traspaso.getId())
                    .build();
        }
    }
}
