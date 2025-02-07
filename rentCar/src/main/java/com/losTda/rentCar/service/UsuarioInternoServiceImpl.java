package com.losTda.rentCar.service;

import com.losTda.rentCar.model.UsuarioInterno;
import com.losTda.rentCar.repository.UsuarioInternoRepository;
import com.losTda.rentCar.requests.UsuarioInternoSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioInternoServiceImpl implements UsuarioInternoService {
    private final UsuarioInternoRepository usuarioInternoRepository;

    public UsuarioInternoServiceImpl(UsuarioInternoRepository usuarioInternoRepository) {
        this.usuarioInternoRepository = usuarioInternoRepository;
    }

    @Override
    public Optional<UsuarioInterno> save(UsuarioInternoSaveRequest request) {
        UsuarioInterno usuarioInterno = new UsuarioInterno();
        usuarioInterno.setIdUsuario(request.getIdUsuario());
        usuarioInterno.setDepartamento(request.getDepartamento());
        usuarioInterno.setPuesto(request.getPuesto());
        usuarioInterno.setUsuario(request.getUsuario());
        return Optional.of(usuarioInternoRepository.save(usuarioInterno));
    }

    @Override
    public List<UsuarioInterno> findByDepartamento(String departamento) {
        return List.of();
    }

    @Override
    public List<UsuarioInterno> findAll() {
        return List.of();
    }

    @Override
    public List<UsuarioInterno> findByPuesto(String puesto) {
        return List.of();
    }

    @Override
    public Optional<UsuarioInterno> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}