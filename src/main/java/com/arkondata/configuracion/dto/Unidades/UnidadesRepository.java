package com.arkondata.configuracion.dto.Unidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UnidadesRepository extends JpaRepository<Unidades, BigInteger> {

    /**
     * Query: findByVehicleCurrentStatus
     *
     * @param vehicle_current_status valor del status de disponibilidad para una unidad
     * @return lista de unidades disponibles
     */
    @Query("SELECT f FROM Unidades f WHERE f.vehicle_current_status = 1")
    List<Unidades> findByVehicleCurrentStatus(@Param("vehicle_current_status") BigInteger vehicle_current_status);
}