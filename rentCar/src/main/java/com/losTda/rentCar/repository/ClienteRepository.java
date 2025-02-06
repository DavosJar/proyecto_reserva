package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Cliente;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.requests.ClienteSaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByUsuario(Usuario usuario);
    Optional<Cliente> findByIdUsuario(Long idUsuario);
    List<Cliente> findAll();
    void deleteById(Long id);
}
