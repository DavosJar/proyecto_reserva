package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    List<Sucursal> findByNombreSucursal(String nombreSucursal);
    Optional<Sucursal> findByTelefono(String telefono);
}
