package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Cuenta;
import com.losTda.rentCar.service.CuentaService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cuentas")
public class CuentaRestController {

    private final CuentaService cuentaService;

    public CuentaRestController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerCuentas() {
        List<Cuenta> cuentas = cuentaService.findAll();

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(cuentas)
                .message("Cuentas obtenidas correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> obtenerCuenta(@PathVariable("id") Long id) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(cuentaService.findById(id).get())
                    .message("Cuenta obtenida correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener la cuenta")
                    .build();
        }
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<Map<String, Object>> obtenerCuentaPorCorreo(@PathVariable("correo") String correo) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(cuentaService.findByCorreo(correo).get())
                    .message("Cuenta obtenida correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener la cuenta")
                    .build();
        }
    }

    @GetMapping("/nombreUsuario/{nombreUsuario}")
    public ResponseEntity<Map<String, Object>> obtenerCuentaPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        try {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .data(cuentaService.findByNombreUsuario(nombreUsuario))
                    .message("Cuenta obtenida correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo obtener la cuenta")
                    .build();
        }
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarCuenta(@PathVariable("id") Long id) {
        try {
            cuentaService.delete(id);
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Cuenta eliminada correctamente")
                    .build();
        } catch (Exception e) {
            return new ResponseBuilder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("No se pudo eliminar la cuenta")
                    .build();
        }
    }
}
