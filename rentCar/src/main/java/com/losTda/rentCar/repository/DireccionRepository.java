package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Direccion;
import com.losTda.rentCar.requests.DireccionSaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    List<Direccion> findByCalle(String calle);
    List<Direccion> findByNumero(String numero);
    List<Direccion> findByCiudad(String ciudad);
}
