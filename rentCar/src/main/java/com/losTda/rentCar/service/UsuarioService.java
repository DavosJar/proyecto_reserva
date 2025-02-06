package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findByDni(String dni);
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> update(Usuario usuario);
}
