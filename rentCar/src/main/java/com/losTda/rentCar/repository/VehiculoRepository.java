package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Optional<Vehiculo> findByMatricula(String matricula);
    List<Vehiculo> findByMarca(String marca);
    List<Vehiculo> findByModelo(String modelo);
    List<Vehiculo> findByEstadoVehiculo(String estadoVehiculo);
    List<Vehiculo> findByMarcaAndModelo(String marca, String modelo);
    Boolean existsByMatricula(String matricula);

}
