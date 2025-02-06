package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.requests.MetodoPagoSaveRequest;
import com.losTda.rentCar.service.MetodoPagoService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/metodo_pagos")
public class MetodoPagoRestController {

    private final MetodoPagoService metodoPagoService;

    public MetodoPagoRestController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerMetodos(){
        List<MetodoPago> metodoPago = metodoPagoService.findAll();
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(metodoPago)
                .message("Metodos de pago obtenidos correctamente")
                .build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarMetodoPago(@RequestBody MetodoPagoSaveRequest request) {
        List<MetodoPago> metodoPagoExistente = metodoPagoService.findByTipo(request.getTipo());

        if (!metodoPagoExistente.isEmpty()) {
            return new ResponseBuilder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Ya existe un método de pago con el tipo: " + request.getTipo())
                    .build();
        } else {
            MetodoPago metodoPagoGuardado = metodoPagoService.save(request);
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .message("Método de pago guardado correctamente")
                    .data(metodoPagoGuardado)
                    .build();
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarMetodoPago(@RequestBody MetodoPagoSaveRequest request) {
        Optional<MetodoPago> metodoPagoActualizado = metodoPagoService.update(request);
        if (metodoPagoActualizado.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Método de pago actualizado correctamente")
                    .data(metodoPagoActualizado.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un método de pago con el ID: " + request.getId())
                    .build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerMetodoPagoPorId(@PathVariable Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoService.findById(id);

        if (metodoPago.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Método de pago encontrado")
                    .data(metodoPago.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un método de pago con el ID: " + id)
                    .build();
        }
    }
}
