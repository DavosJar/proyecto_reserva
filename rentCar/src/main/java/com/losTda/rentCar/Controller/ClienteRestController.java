package com.losTda.rentCar.Controller;

import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.requests.ClienteSaveRequest;
import com.losTda.rentCar.service.ClienteService;
import com.losTda.rentCar.service.UsuarioService;
import com.losTda.rentCar.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private final ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll() {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(clienteService.findAll())
                .message("Clientes obtenidos correctamente")
                .build();
    }

    @PostMapping("/obtener")
    public ResponseEntity<Map<String, Object>> findById(@RequestBody Usuario usuario) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(clienteService.findByUsuario(usuario))
                .message("Cliente obtenido correctamente")
                .build();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(clienteService.findByIdUsuario(id))
                .message("Cliente obtenido correctamente")
                .build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> save(@RequestBody ClienteSaveRequest usuario) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(clienteService.save(usuario))
                .message("Cliente guardado correctamente")
                .build();
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ClienteSaveRequest usuario) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .data(clienteService.update(usuario))
                .message("Cliente actualizado correctamente")
                .build();
    }


}
