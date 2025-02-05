package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByCorreo(String correo);
    List<Cuenta> findByNombreUsuario(String nombreUsuario);
}

