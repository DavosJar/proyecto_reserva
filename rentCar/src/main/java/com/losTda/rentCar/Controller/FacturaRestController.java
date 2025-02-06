package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Factura;
import com.losTda.rentCar.requests.FacturaSaveRequest;
import com.losTda.rentCar.service.FacturaService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/facturas")
public class FacturaRestController {

    private final FacturaService facturaService;

    public FacturaRestController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerFacturas() {
        List<Factura> facturas = facturaService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(facturas)
                .message("Facturas obtenidas correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerFactura(@PathVariable("id") Long id) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(facturaService.findById(id).get())
                    .message("Factura obtenida correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener la factura")
                    .build();
        }
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<Map<String, Object>> obtenerFacturaPorFecha(@PathVariable("fecha") LocalDate fecha) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(facturaService.findByFechaEmision(fecha))
                    .message("Factura obtenida correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener la factura")
                    .build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarFactura(@PathVariable("id") Long id) {
        try {
            facturaService.delete(id);
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Factura eliminada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo eliminar la factura")
                    .build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarFactura(@RequestBody FacturaSaveRequest factura) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .data(facturaService.save(factura).get())
                    .message("Factura guardada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo guardar la factura")
                    .build();
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarFactura(@RequestBody FacturaSaveRequest factura) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(facturaService.update(factura).get())
                    .message("Factura actualizada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo actualizar la factura")
                    .build();
        }
    }
}
