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
    private String nombre;

    @Column(nullable = false)
    private String puntos_geograficos;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos_geograficos() {
        return puntos_geograficos;
    }

    public void setPuntos_geograficos(String puntos_geograficos) {
        this.puntos_geograficos = puntos_geograficos;
    }
}
