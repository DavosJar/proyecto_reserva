package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Cliente;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.requests.ClienteSaveRequest;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Optional<Cliente> findByUsuario(Usuario usuario);
    Optional<Cliente> findByIdUsuario(Long idUsuario);
    List<Cliente> findAll();
    Optional<Cliente> save(ClienteSaveRequest cliente);
    Optional<Cliente> update(ClienteSaveRequest cliente);
}
