package com.arkondata.configuracion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Alcaldia
 * Descripción:  Clase dto para el objeto de Alcaldia response
 * Detona los miembros para los datos de Alcaldia response.
 * Fecha de Modificación:2022-03-01
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Data
@ApiModel("Alcaldia")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alcaldia {
    @ApiModelProperty(name = "calle",
            position = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String calle;

    @ApiModelProperty(name = "region",
            position = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String region;

    @ApiModelProperty(name = "alcaldia",
            position = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String alcaldia;

    @ApiModelProperty(name = "pais",
            position = 4)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pais;

    /**
     * Nombre de proyecto: mso_metrobus
     * Sistema:MSO Base
     * Arkon Data Test
     * Nombre de clase: Alcaldia
     * Descripción:  Clase dto para el objeto de Alcaldia response
     * Detona los miembros para los datos de Alcaldia response.
     * Fecha de Modificación:2022-03-02
     * Persona que modifico: MACM
     * Descripción de modificación:
     */
    public Alcaldia(String calle, String region, String alcaldia, String pais) {
        this.calle = calle;
        this.region = region;
        this.alcaldia = alcaldia;
        this.pais = pais;
    }

    /**
     * Nombre de proyecto: mso_metrobus
     * Sistema:MSO Base
     * Arkon Data Test
     * Nombre de clase: Alcaldia
     * Descripción:  Clase dto para el objeto de Alcaldia response
     * Detona los miembros para los datos de Alcaldia response.
     * Fecha de Modificación:2022-03-02
     * Persona que modifico: MACM
     * Descripción de modificación:
     */
    public Alcaldia() {
        /**
         * Constructor default
         */
    }
}
