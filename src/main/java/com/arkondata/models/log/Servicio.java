/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.models.log;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: LlavesSeguridad
 * Descripción:  Clase modelo para la manipulación del objeto Servicio para logs
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@Data
@ApiModel("Servicio")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Servicio {
	
	/**
	 * nombreServicio
	 */
	@ApiModelProperty(name = "nombreServicio",
	                  position = 1,
	                  notes = "Nombre del servicio que esta siendo consumido",
	                  example = "ArkonData")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nombreServicio = "";
	
	/**
	 * sistema
	 */
	@ApiModelProperty(name = "sistema",
	                  position = 2,
	                  notes = "Sistema al que pertenece",
	                  example = "ArkonDataSecurity")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String sistema = "";
	
	/**
	 * peticion
	 */
	@ApiModelProperty(name = "peticion",
	                  position = 3,
	                  notes = "Petición realizada")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String peticion = "";
	
	/**
	 * tiempo
	 */
	@ApiModelProperty(name = "tiempo",
	                  position = 4,
	                  notes = "Tiempo que tomó en dar respuesta a cliente en ms",
	                  example = "3")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private long tiempo;
	
	/**
	 * Log
	 */
	public Servicio(){
		/**No hace nada**/
	}
}
