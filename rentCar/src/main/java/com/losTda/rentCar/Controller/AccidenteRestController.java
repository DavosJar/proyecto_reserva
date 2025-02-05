package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Accidente;
import com.losTda.rentCar.requests.AccidenteSaveRequest;
import com.losTda.rentCar.service.AccidenteService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accidentes")
public class AccidenteRestController {

    private final AccidenteService accidenteService;

    public AccidenteRestController(AccidenteService accidenteService) {
        this.accidenteService = accidenteService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerAccidentes() {
        List<Accidente> accidentes = accidenteService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(accidentes)
                .message("Accidentes obtenidos correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerAccidente(@PathVariable("id") Long id) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(accidenteService.findById(id).get())
                    .message("Accidente obtenido correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener el accidente")
                    .build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarAccidente(@PathVariable("id") Long id) {
        try {
            accidenteService.delete(id);
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Accidente eliminado correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo eliminar el accidente")
                    .build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarAccidente(@RequestBody AccidenteSaveRequest accidente) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .data(accidenteService.save(accidente).get())
                    .message("Accidente guardado correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo guardar el accidente")
                    .build();
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarAccidente(@RequestBody AccidenteSaveRequest accidente) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(accidenteService.update(accidente).get())
                    .message("Accidente actualizado correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo actualizar el accidente")
                    .build();
        }
    }




}
