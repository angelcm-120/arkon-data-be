package com.arkondata.models.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: ClientesVarGenerales
 * Descripción:  Clase modelo para la manipulación de  bloques de clientes para el proyecto de aedc
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 
 */
@Data
@ApiModel("ClientesVarGenerales")
@JsonPropertyOrder({"clientesList", "fiStatus"})
public class ClientesVarGenerales {
	
	/**
	 * clientesList
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "clientesList",
	                  position = 1,
	                  notes = "Indica lista de clientes para procesar reglas de BRMS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ClienteVarGenerales> clientesList = new ArrayList<>();
	
	/**
	 * fiStatus
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fiStatus",
	                  position = 2,
	                  notes = "Indica el estatus de procesamiento por lista de clientes",
	                  example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Short fiStatus = 0;
	
	/**
	 * fdInicio
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fdInicio",
	                  position = 3,
	                  notes = "Indica la fecha de inicio del procesamiento del bloque",
	                  example = "2020/04/27 00:54:00")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fdInicio = "";
	
	/**
	 * fdFin
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fdFin",
	                  position = 4,
	                  notes = "Indica la fecha de fin del procesamiento del bloque",
	                  example = "2020/04/27 01:01:00")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fdFin = "";
}
