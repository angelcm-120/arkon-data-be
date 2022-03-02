/**
 * This package has non null parameters and is documented.
 **/
package com.arkondata.configuracion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: CifradoResponse
 * Descripción:  Clase dto para el objeto de cifrado response
 * Detona los miembros para los cifrados response.
 * Fecha de Modificación:2021-07-05
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
@Data
@ApiModel("EstatusResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CifradoResponse {
	@ApiModelProperty(name = "idAcceso",
	                  position = 1)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String idAcceso = "";
	
	@ApiModelProperty(name = "mensaje",
	                  position = 1)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mensaje = "";
}
