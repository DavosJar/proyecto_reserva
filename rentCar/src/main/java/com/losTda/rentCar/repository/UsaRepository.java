package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.model.Usa;
import com.losTda.rentCar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsaRepository extends JpaRepository<Usa, Long> {
    Optional<Usa> findByUsuario(Usuario usuario);
    Optional<Usa> findByMetodoPago(MetodoPago metodoPago);
}
