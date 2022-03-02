/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.models.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.arkondata.utils.enums.DB;
import com.arkondata.utils.enums.TipoConsulta;

import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: LlavesSeguridad
 * Descripción:  Clase modelo para la manipulación de objetos DAOS
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@Data
@ApiModel("Daos")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Daos {
	
	/**
	 * db
	 */
	@ApiModelProperty(name = "db",
	                  position = 1,
	                  notes = "Indica la db para realizar la consulta")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private DB db;
	
	/**
	 * tipoConsulta
	 */
	@ApiModelProperty(name = "tipoConsulta",
	                  position = 2,
	                  notes = "Indica el tipo de consulta a la db")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private TipoConsulta tipoConsulta;
	
	/**
	 * consulta
	 */
	@ApiModelProperty(name = "consulta",
	                  position = 3,
	                  notes = "Indica la consulta de la db")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String consulta;
	
	/**
	 * funcion
	 */
	@ApiModelProperty(name = "funcion",
	                  position = 4,
	                  notes = "Indica la función de la consulta")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String funcion;
	
	/**
	 * parametros
	 */
	@ApiModelProperty(name = "parametros",
	                  position = 5,
	                  notes = "Indica la lista de parámetros para realizar la consulta")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Parametro> parametros;
	
	/**
	 * Constructor
	 */
	public Daos() {
		parametros = new ArrayList<>();
	}
	
	/**
	 * Contructor con parametros
	 *
	 * @param db
	 * valor para db
	 * @param tipoConsulta
	 * valor paratipoConsulta
	 * @param consulta
	 * valor paraconsulta
	 * @param funcion
	 * valor parafuncion
	 */
	public Daos(DB db, TipoConsulta tipoConsulta, String consulta, String funcion) {
		this.db = db;
		this.tipoConsulta = tipoConsulta;
		this.consulta = consulta;
		this.funcion = funcion;
		parametros = new ArrayList<>();
	}
	
}
