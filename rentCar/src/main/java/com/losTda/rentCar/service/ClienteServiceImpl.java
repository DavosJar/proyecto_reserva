package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Cliente;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.repository.ClienteRepository;
import com.losTda.rentCar.requests.ClienteSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> findByUsuario(Usuario usuario) {
        return clienteRepository.findByUsuario(usuario);
    }

    @Override
    public Optional<Cliente> save(ClienteSaveRequest cliente) {
        Cliente clienteToSave = new Cliente();
        clienteToSave.setUsuario(cliente.getUsuario());
        clienteToSave.setEstaHabilitado(cliente.getEstaHabilitado());
        return Optional.of(clienteRepository.save(clienteToSave));
    }

    @Override
    public Optional<Cliente> update(ClienteSaveRequest cliente) {
        Cliente clienteToUpdate = new Cliente();
        clienteToUpdate.setUsuario(cliente.getUsuario());
        clienteToUpdate.setUsuario(cliente.getUsuario());
        clienteToUpdate.setEstaHabilitado(cliente.getEstaHabilitado());

        return Optional.of(clienteRepository.save(clienteToUpdate));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
