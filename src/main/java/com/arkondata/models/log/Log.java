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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Log
 * Descripción:  Clase para el manejo de logs de las aplicaciones *
 * Se usa con el manejo de logs para los contenedores
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
@Data
@ApiModel("Log")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Log {
	
	/**
	 * String
	 */
	@ApiModelProperty(name = "fecha",
	                  position = 1,
	                  notes = "Fecha de la petición del servicio",
	                  example = "2019-07-07 19:47:48")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fecha = "";
	
	/**
	 * lvl
	 * Variable utilizada para registrar el nivel de mensaje en el log
	 */
	@ApiModelProperty(name = "lvl",
	                  position = 2,
	                  notes = "Nivel de severidad del resultado del servicio",
	                  example = "INFO|WARNING|DEBUG|ERROR|FATAL")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Level lvl = Level.INFO;
	
	/**
	 * Mensaje
	 */
	@ApiModelProperty(name = "mensaje",
	                  position = 3,
	                  notes = "Mensaje de respuesta del servicio",
	                  example = "{\n" +
	                            "    \"servicio\": \"Arkon Data REST API\",\n" +
	                            "    \"codigo\": \"200.ArkonData.000200\",\n" +
	                            "    \"descripcion\": \"Operación exitosa.\",\n" +
	                            "    \"httpStatus\": \"OK\"\n" +
	                            "}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Mensaje mensaje = new Mensaje();
	
	/**
	 * servicios
	 */
	@ApiModelProperty(name = "servicios",
	                  position = 4,
	                  notes = "Lista de los servicios que se consumieron y cada uno con su tiempo de respuesta.",
	                  example = "ArkonData")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Servicio> servicios = new ArrayList<>();
	
	/**
	 * tiempoTotal
	 */
	@ApiModelProperty(name = "tiempoTotal",
	                  position = 5,
	                  notes = "Tiempo que tomó en dar respuesta a cliente en ms",
	                  example = "3")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private long tiempoTotal;
	
	/**
	 * Log
	 */
	public Log(){
		/**No hace nada**/
	}
}
