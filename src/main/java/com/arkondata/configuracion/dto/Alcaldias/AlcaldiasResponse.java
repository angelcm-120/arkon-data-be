package com.arkondata.configuracion.dto.Alcaldias;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: AlcaldiasResponse
 * Descripción:  Clase dto para el objeto de AlcaldiasResponse response
 * Detona los miembros para los datos de AlcaldiasResponse response.
 * Fecha de Modificación:2022-03-01
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Data
@ApiModel("AlcaldiasResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlcaldiasResponse {
    @ApiModelProperty(name = "id",
            position = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger id;

    @ApiModelProperty(name = "nombre",
            position = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nombre;

    @ApiModelProperty(name = "puntos_geograficos",
            position = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String puntos_geograficos;

    /**
     * Nombre de proyecto: mso_metrobus
     * Sistema:MSO Base
     * Arkon Data Test
     * Nombre de clase: AlcaldiasResponse
     * Descripción:  Clase dto para el objeto de AlcaldiasResponse response
     * Detona los miembros para los datos de AlcaldiasResponse response.
     * Fecha de Modificación:2022-03-02
     * Persona que modifico: MACM
     * Descripción de modificación:
     */
    public AlcaldiasResponse(BigInteger id, String nombre, String puntos_geograficos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos_geograficos = puntos_geograficos;
    }

    /**
     * Nombre de proyecto: mso_metrobus
     * Sistema:MSO Base
     * Arkon Data Test
     * Nombre de clase: AlcaldiasResponse
     * Descripción:  Clase dto para el objeto de AlcaldiasResponse response
     * Detona los miembros para los datos de AlcaldiasResponse response.
     * Fecha de Modificación:2022-03-02
     * Persona que modifico: MACM
     * Descripción de modificación:
     */
    public AlcaldiasResponse() {
        /**
         * Constructor por default
         */
    }
}
