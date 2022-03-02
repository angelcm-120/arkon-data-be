package com.arkondata.configuracion.dto.Alcaldias;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Alcaldias
 * Descripción:  Clase dto para el objeto de Alcaldias
 * Detona los miembros para los datos de Alcaldias
 * Fecha de Modificación:2022-03-01
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@Entity
@Table(name = "alcaldias")
@Getter
@Setter
public class Alcaldias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(nullable = false)
    private BigInteger vehicle_id;

    @Column(nullable = false)
    private BigInteger vehicle_label;

    @Column(nullable = false)
    private BigInteger vehicle_current_status;

    @Column(nullable = false)
    private String geographic_point;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(BigInteger vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public BigInteger getVehicle_label() {
        return vehicle_label;
    }

    public void setVehicle_label(BigInteger vehicle_label) {
        this.vehicle_label = vehicle_label;
    }

    public BigInteger getVehicle_current_status() {
        return vehicle_current_status;
    }

    public void setVehicle_current_status(BigInteger vehicle_current_status) {
        this.vehicle_current_status = vehicle_current_status;
    }

    public String getGeographic_point() {
        return geographic_point;
    }

    public void setGeographic_point(String geographic_point) {
        this.geographic_point = geographic_point;
    }
}
