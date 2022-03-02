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
 * Descripción:  Clase modelo para la manipulación del objeto Mensaje para logs
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Data
@ApiModel("Mensaje")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mensaje {
	
	/**
	 * excepcion
	 * Variable utilizada para retornar objetos de tipo excepción en las respuestas de log
	 */
	/*@ApiModelProperty(name = "excepcion",
	                  position = 5,
	                  notes = "Excepción del servicio si es que hay",
	                  example =
		                  "Excepcion")
	@JsonIgnore
	private Exception excepcion = new Exception("");*/
	
	/**
	 * mensajes
	 * Variable utilizada para registrar mensajes particulares en los logs
	 */
	@ApiModelProperty(name = "mensajes",
	                  position = 4,
	                  notes = "Mensaje al servicio",
	                  example =
		                  "Esto es un mensaje")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mensajes = "";
	
	/**
	 * peticion
	 * Variable utilizada para almacenar peticiones que se llevan a cabo durante los procesos de consumos a terceros
	 * estos pueden ser bases de datos, servicios u de otro tipo.
	 */
	@ApiModelProperty(name = "peticion",
	                  position = 2,
	                  notes = "La petición hecha al servicio",
	                  example =
		                  "{\"noEmpleado\":\"73772\",\"noPlaca\":\"GS1613233\",\"fecha\":\"2020-02-04 14:36:00\"," +
		                  "\"longitud\":19.3093334,\"latitud\":-99.1870559,\"gerencia\":{\"pais\":{\"pais\":1," +
		                  "\"nombrePais\":\"México\"},\"region\":{\"pais\":{\"pais\":1,\"nombrePais\":\"México\"}," +
		                  "\"region\":8196,\"nombreRegion\":\"8196 RCR RCRBENITOJUAREZ1 2\"},\"gerencia\":8220," +
		                  "\"nombreGerencia\":\"8220 GCC GERENCIAPRUEBACENTRAL\"},\"puesto\":{\"puesto\":109," +
		                  "\"descripcion\":\"JEFE DE PORTAFOLIO\"},\"aplicacion\":{\"aplicacion\":85," +
		                  "\"nombre\":\"VERIFICACION DE CREDITO MOVIL (NVC)\",\"descripcion\":\"Nuevo sistema de " +
		                  "verificacion de credito JVC y Baz Digital\"},\"dispositivo\":{\"dispositivo\":2}," +
		                  "\"version\":{\"versionId\":4260,\"version\":99},\"os\":\"Android\"," +
		                  "\"os_version\":\"1523\"}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String peticion = "";
	
	/**
	 * respuesta
	 * Variable utilizada para registrar la respuesta de los consumos a terceros realizados
	 */
	@ApiModelProperty(name = "respuesta",
	                  position = 3,
	                  notes = "La respuesta del servicio",
	                  example =
		                  "{\"servicio\":\"Arkon Data REST API\",\"codigo\":\"200.ArkonData" +
		                  ".000200\",\"descripcion\":\"Operación exitosa.\"," +
		                  "\"httpStatus\":\"OK\"}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String respuesta = "";
}
