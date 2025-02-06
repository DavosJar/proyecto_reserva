package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> findByFechaInicio(LocalDate fechaInicio);
    List<Alquiler> findByFechaDevolucion(LocalDate fechaDevolucion);
    List<Alquiler> findByCostoDia(String costoDia);
    List<Alquiler> findByEstadoAlquiler(String estadoAlquiler);
}
