package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Licencia;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.repository.UsuarioRepository;
import com.losTda.rentCar.requests.LicenciaSaveRequest;
import com.losTda.rentCar.service.LicenciaService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/licencias")
public class LicenciaRestController {

    private final LicenciaService licenciaService;
    private final UsuarioRepository usuarioRepository;

    public LicenciaRestController(LicenciaService licenciaService, UsuarioRepository usuarioRepository) {
        this.licenciaService = licenciaService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerLicencias() {
        List<Licencia> licencias = licenciaService.findAll();
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(licencias)
                .message("Licencias obtenidas correctamente")
                .build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Map<String, Object>> obtenerLicenciaPorCodigo(@PathVariable String codigo) {
        Optional<Licencia> licencia = licenciaService.findByCodigo(codigo);

        if (licencia.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Licencia encontrada")
                    .data(licencia.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró una licencia con el código: " + codigo)
                    .build();
        }
    }

    /*@PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardarLicencia(@RequestBody LicenciaSaveRequest request) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByDni(String.valueOf(request.getIdUsuario()));

        if(usuarioOptional.isEmpty()) {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró un usuario con el ID: " + request.getIdUsuario())
                    .build();
        }

        Licencia licencia = new Licencia();
        licencia.setCodigo(request.getCodigo());
        licencia.setFechaCaducidad(request.getFechaCaducidad());
        licencia.setFechaExpedicion(request.getFechaExpedicion());
        licencia.setUsuario(usuarioOptional.get());

        try {
            Licencia licenciaGuardada = licenciaService.save(licencia);
            return new ResponseBuilder()
                    .status(HttpStatus.CREATED)
                    .message("Licencia guardada correctamente")
                    .data(licenciaGuardada)
                    .build();
        } catch (RuntimeException e) {
            return new ResponseBuilder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
        }
    }*/

    @PutMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarLicencia(@RequestBody Licencia licencia) {
        Optional<Licencia> licenciaActualizada = licenciaService.update(licencia);

        if (licenciaActualizada.isPresent()) {
            return new ResponseBuilder()
                    .status(HttpStatus.OK)
                    .message("Licencia actualizada correctamente")
                    .data(licenciaActualizada.get())
                    .build();
        } else {
            return new ResponseBuilder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("No se encontró una licencia con el ID: " + licencia.getId())
                    .build();
        }
    }
}