/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data
 * Nombre de clase: Respuesta
 * Descripción:  Clase modelo para la manipulación de los códigos de respuesta estandar para los request de msos
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("Respuesta")
public class Respuesta
	extends CodigosRespuesta
	implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1371583101061129050L;
	
	/**
	 * resultado
	 */
	@ApiModelProperty(name = "resultado",
	                  position = 10,
	                  hidden = true,
	                  notes = "resultado interno para los microservicios")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object resultado = null;
	
}
