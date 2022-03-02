package com.arkondata.models.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: BloquesClientes
 * Descripción:  Clase modelo para la manipulación del bloques de clientes para el proyecto de aedc
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@Data
@ApiModel("bloquesClientes")
@JsonPropertyOrder({"idBloque", "rangoInf", "rangoSup"})
public class BloquesClientes {
	
	/**
	 * idBloque
	 */
	@ApiModelProperty(name = "idBloque",
	                  position = 1,
	                  notes = "ID del bloque procesado",
	                  example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int idBloque = 0;
	
	/**
	 * rangoInf
	 */
	@ApiModelProperty(name = "rangoInf",
	                  position = 2,
	                  notes = "Rango inferior o rango limite del bloque",
	                  example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int rangoInf = 0;
	
	/**
	 * rangoSup
	 */
	@ApiModelProperty(name = "rangoSup",
	                  position = 3,
	                  notes = "Rango superior o rango limite del bloque",
	                  example = "300")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int rangoSup = 0;
}
