package com.arkondata.configuracion.dto.Unidades;

import com.arkondata.configuracion.dto.AlcaldiaModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: UnidadesResponse
 * Descripción:  Clase dto para el objeto de UnidadesResponse response
 * Detona los miembros para los datos de UnidadesResponse response.
 * Fecha de Modificación:2022-03-01
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Data
@ApiModel("UnidadesResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnidadesResponse {
    @ApiModelProperty(name = "id",
            position = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger id;

    @ApiModelProperty(name = "vehicle_id",
            position = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger vehicle_id;

    @ApiModelProperty(name = "vehicle_label",
            position = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger vehicle_label;

    @ApiModelProperty(name = "vehicle_current_status",
            position = 4)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger vehicle_current_status;

    @ApiModelProperty(name = "geographic_point",
            position = 5)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String geographic_point = "";

    @ApiModelProperty(name = "alcaldia",
            position = 6)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AlcaldiaModel ubicacion;

    /**
     * Nombre de proyecto: mso_metrobus
     * Sistema:MSO Base
     * Arkon Data Test
     * Nombre de clase: UnidadesResponse
     * Descripción:  Clase dto para el objeto de UnidadesResponse response
     * Detona los miembros para los datos de UnidadesResponse response.
     * Fecha de Modificación:2022-03-02
     * Persona que modifico: MACM
     * Descripción de modificación:
     */
    public UnidadesResponse(BigInteger id, BigInteger vehicle_id, BigInteger vehicle_label,
                            BigInteger vehicle_current_status, String geographic_point, AlcaldiaModel ubicacion) {
        this.id = id;
        this.vehicle_id = vehicle_id;
        this.vehicle_label = vehicle_label;
        this.vehicle_current_status = vehicle_current_status;
        this.geographic_point = geographic_point;
        this.ubicacion = ubicacion;
    }

    /**
     * Nombre de proyecto: mso_metrobus
     * Sistema:MSO Base
     * Arkon Data Test
     * Nombre de clase: UnidadesResponse
     * Descripción:  Clase dto para el objeto de UnidadesResponse response
     * Detona los miembros para los datos de UnidadesResponse response.
     * Fecha de Modificación:2022-03-02
     * Persona que modifico: MACM
     * Descripción de modificación:
     */
    public UnidadesResponse() {
        /**
         * Constructor por default
         */
    }
}
