package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.UsuarioInterno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioInternoRepository extends JpaRepository<UsuarioInterno, Long> {
    List<UsuarioInterno> findByDepartamento(String departamento);
    List<UsuarioInterno> findByPuesto(String puesto);
}
