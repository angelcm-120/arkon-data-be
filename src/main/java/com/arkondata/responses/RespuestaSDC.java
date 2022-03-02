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
import com.arkondata.models.sdc.ClientesVarGenerales;

import java.io.Serializable;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data
 * Nombre de clase: Respuesta
 * Descripción:  Clase modelo para la manipulación de los códigos de respuesta estandar para los request de msos de aedc
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("RespuestaSDC")
public class RespuestaSDC
	extends Respuesta
	implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3112339370736053775L;
	
	/**
	 * clientesVarGenerales
	 */
	@ApiModelProperty(name = "clientesVarGenerales",
	                  position = 2,
	                  hidden = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ClientesVarGenerales clientesVarGenerales = null;
}
