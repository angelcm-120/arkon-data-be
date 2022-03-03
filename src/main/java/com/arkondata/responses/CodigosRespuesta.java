/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.responses;

import com.arkondata.utils.Funciones;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.arkondata.utils.enums.RespuestasCodigos;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data
 * Nombre de clase: CodigosRespuesta
 * Descripción:  Clase modelo para la manipulación de los códigos de respuesta estandar para los request de msos
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@Data
@ApiModel("CodigosRespuesta")
@JsonPropertyOrder({"servicio", "codigo", "descripcion", "httpStatus"})
public class CodigosRespuesta
	implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8051605784825034187L;
	
	/**
	 * codigo
	 * Maneja el código estandar en las respuestas http de acuerdo a la solicitud de CoE APIS
	 */
	@ApiModelProperty(name = "codigo",
	                  position = 1,
	                  notes = "Indica el código de respuesta http",
	                  example = "200.ArkonData.000200")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String codigo;
	
	/**
	 * mensaje
	 * Se utiliza como mensaje descriptivo de las respuestas de los servicios código http status
	 */
	@ApiModelProperty(name = "mensaje",
	                  position = 2,
	                  notes = "Indica el mensaje del código de respuesta http",
	                  example = "Operación exitosa.")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mensaje;
	
	/**
	 * folio
	 * Se utiliza para generar el folio de consumo para las respuestas como lo solicita CoE APIs
	 */
	@ApiModelProperty(name = "folio",
	                  position = 3,
	                  notes = "Indica el folio de la consulta del servicio")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String folio = Funciones.folio();
	
	/**
	 * info
	 * Se utiliza para retornar la liga info de arkon-data.com
	 */
	@ApiModelProperty(name = "info",
	                  position = 4,
	                  notes = "Indica la url info para consumo de APIS.",
	                  example = "https://arkon-data.com" +
	                            ".mx/errors#ArkonData.000400")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String info;
	
	/**
	 * detalles
	 * Se utiliza para retornar una lista de motivos de detalles en los consumos de servicios
	 */
	@ApiModelProperty(name = "detalles",
	                  position = 5,
	                  notes = "Indica una lista de detalles en cadenas de texto en caso de fallos.",
	                  example = "[\"Los parámetros esperados no son correctos\",\"El valor de empleado no puede ser " +
	                            "null\"]")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> detalles;
	
	/**
	 * servicio
	 * Indica el nombre del servicio que esta siendo consumido
	 */
	@ApiModelProperty(name = "servicio",
	                  position = 6,
	                  notes = "Indica el nombre del servicio",
	                  example = "Arkon {API} REST API")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String servicio;
	
	/**
	 * descripcion
	 * Contiene un mensaje como descripción en la respuesta
	 */
	@ApiModelProperty(name = "descripcion",
	                  position = 7,
	                  notes = "Indica la descripción del código de respuesta http",
	                  example = "Operación exitosa.")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String descripcion;
	
	/**
	 * httpStatus
	 * Retorna el código http status
	 */
	@ApiModelProperty(name = "httpStatus",
	                  position = 8,
	                  notes = "Indica el estatus del código de respuesta http",
	                  example = "OK")
	@JsonIgnore
	private HttpStatus httpStatus;
	
	/**
	 * exception
	 * Se utiliza para retornar los objetos excepción en las respuestas en caso de ser necesario.
	 */
	@ApiModelProperty(name = "exception",
	                  position = 9,
	                  hidden = true,
	                  notes = "Indica el mensaje de excepción interno para los microservicios")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Exception exception;
	
	/**
	 * setRespuesta
	 *
	 * @param respuesta valor para respuesta
	 */
	public void setRespuesta(RespuestasCodigos respuesta) {
		codigo = respuesta.obtenCodigo();
		mensaje = respuesta.obtenMensaje();
		httpStatus = respuesta.obtenEstatus();
		info = respuesta.obtenInfo();
	}
	
	/**
	 * setRespuesta
	 *
	 * @param respuesta valor para respuesta
	 * @param exception valor para exception
	 */
	public void setRespuesta(RespuestasCodigos respuesta, Exception exception) {
		codigo = respuesta.obtenCodigo();
		mensaje = respuesta.obtenMensaje();
		httpStatus = respuesta.obtenEstatus();
		info = respuesta.obtenInfo();
		this.exception = exception;
	}
	
}
