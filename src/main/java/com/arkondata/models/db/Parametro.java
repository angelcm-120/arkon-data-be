package com.arkondata.models.db;

/**
 * Parametro
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.arkondata.utils.enums.TipoDato;
import com.arkondata.utils.enums.TipoInputOutput;


/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Parametro
 * Descripción:  Clase que crea objeto para manipular los parametros de las consultas a bd.
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MTIB
 * Descripción de modificación:

 */
@Data
@ApiModel("Parametro")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parametro {
	
	/**
	 * indice
	 */
	@ApiModelProperty(name = "indice",
	                  position = 1,
	                  notes = "Indica el índice del parámetro")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int indice;
	
	/**
	 * nombre
	 */
	@ApiModelProperty(name = "nombre",
	                  position = 2,
	                  notes = "Indica el nombre del parámetro")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nombre;
	
	/**
	 * tamano
	 */
	@ApiModelProperty(name = "tamaño",
	                  position = 3,
	                  notes = "Indica el tamaño del parámetro de texto")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int tamano;
	
	/**
	 * tipo
	 */
	@ApiModelProperty(name = "tipo",
	                  position = 4,
	                  notes = "Indica el tipo de dato del parámetro")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private TipoDato tipo;
	
	/**
	 * tipoIO
	 */
	@ApiModelProperty(name = "tipoIO",
	                  position = 5,
	                  notes = "Indica si el parámetro es de entrada o salida")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private TipoInputOutput tipoIO;
	
	/**
	 * valor
	 */
	@ApiModelProperty(name = "valor",
	                  position = 6,
	                  notes = "Indica el valor del parámetro")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String valor;
	
	/**
	 * Constructor Parametro
	 *
	 * @param indice
	 * @param valor
	 * @param tipo
	 * @param tamano
	 * @param tipoIO
	 */
	public Parametro(int indice, String valor, TipoDato tipo, int tamano, TipoInputOutput tipoIO) {
		this.indice = indice;
		this.valor = valor;
		this.tipo = tipo;
		this.tamano = tamano;
		this.tipoIO = tipoIO;
		this.nombre = "";
	}
}
