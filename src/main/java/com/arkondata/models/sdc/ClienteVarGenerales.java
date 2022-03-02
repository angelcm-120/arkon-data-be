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
 * Nombre de clase: ClienteVarGenerales
 * Descripción:  Clase modelo para la manipulación de  bloques de clientes para el proyecto de aedc
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@Data
@ApiModel("ClienteVarGenerales")
@JsonPropertyOrder({"fiIdCte", "fcCtesVarGral", "fcAsignacionCartera", "fiStatus"})
public class ClienteVarGenerales {
	
	/**
	 * bloque
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "bloque",
	                  position = 1,
	                  notes = "Indica el id númerico de CU para SDC",
	                  example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private BloquesClientes bloque = new BloquesClientes();
	
	/**
	 * fiIdCte
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fiIdCte",
	                  position = 2,
	                  notes = "Indica el id númerico de CU para SDC",
	                  example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int fiIdCte = 0;
	
	/**
	 * fcCtesVarGral
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fcCtesVarGral",
	                  position = 3,
	                  notes = "Indica las variables generales por cliente para realizar la consulta de clasificación",
	                  example = "{\"tipoDepto\":33,\"diasAtraso\":1014,\"ultimaGestion\":105,\"score\":6," +
	                            "\"segmento\":0}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fcCtesVarGral = "";
	
	/**
	 * fcAsignacionCartera
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fcAsignacionCartera",
	                  position = 4,
	                  notes = "Indica el tipo de cartera a la que pertenece el cliente despues de validar las reglas " +
	                          "de " +
	                          "BRMS",
	                  example = "{\"result\":{\"codigo\":\"0\",\"mensaje\":\"Consulta Exitosa\"," +
	                            "\"respuesta\":{\"tipoCartera\":3}},\"version\":[{\"nombre\":\"Asignación de " +
	                            "cartera\"," +
	                            "\"version\":\"1.0.0\",\"fecha\":\"23-04-2021\"}],\"log_message\":false}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fcAsignacionCartera = "";
	
	/**
	 * fiStatus
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fiStatus",
	                  position = 5,
	                  notes = "Indica el estatus de procesamiento por cliente",
	                  example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Short fiStatus = 0;
	
	/**
	 * fdInicio
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fdInicio",
	                  position = 6,
	                  notes = "Indica la fecha de inicio del procesamiento del cliente",
	                  example = "2020/04/27 00:54:00")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fdInicio = "";
	
	/**
	 * fdFin
	 * Variable utilizada por el proyecto de aedc
	 */
	@ApiModelProperty(name = "fdFin",
	                  position = 7,
	                  notes = "Indica la fecha de fin del procesamiento del cliente",
	                  example = "2020/04/27 01:01:00")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fdFin = "";
}
