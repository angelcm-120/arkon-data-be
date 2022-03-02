package com.arkondata.utils.db;

import com.arkondata.models.db.Parametro;
import com.arkondata.utils.enums.Numeros;
import com.arkondata.utils.enums.TipoInputOutput;
import com.arkondata.utils.log.Log;
import com.google.gson.JsonObject;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static com.arkondata.utils.Funciones.gsonConverter;
import static org.apache.commons.lang.StringEscapeUtils.unescapeJava;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Utilerias
 * Descripción:  Clase utileria para el manejo de lobs objetos utilizados en la clase de consultas, reduce nivel de
 * complejidad ciclomatica de sonar
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
public class Utilerias {
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de constructor: Utilerias
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * Constructor Vacio
	 */
	private Utilerias() {
		/* No hace nada */
	}

	/**
	 * Nombre de proyecto: core
	 * Sistema:COB-CLOUD
	 * Cloud y DevOps
	 * Nombre de método: parametrosList
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: EYMG
	 * Descripción de modificación:

	 */
	/**
	 * parametrosList
	 *
	 * @param parametros
	 *
	 * @return
	 */
	public static List<SqlParameter> parametrosList(List<Parametro> parametros) {
		List<SqlParameter> paramList = new ArrayList<>();

		if (parametros != null && !parametros.isEmpty()) {
			for (Parametro parametro : parametros) {
				paramList.add(validaTipos(parametro));
			}
		}
		return paramList;
	}

	/**
	 * Nombre de proyecto: core
	 * Sistema:COB-CLOUD
	 * Cloud y DevOps
	 * Nombre de método: validaTipos
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: EYMG
	 * Descripción de modificación:

	 */
	/**
	 * validaTipos
	 * <p>
	 * Se valida el tipo de parámetro que se esta enviando a DAOS
	 * Se regresa un objecto de tipo sqlparameter con el tipo de dato requerido para que la ejecución contra la db
	 * sea correcta
	 *
	 * @param parametro
	 *
	 * @return SqlParameter
	 */
	public static SqlParameter validaTipos(Parametro parametro) {
		SqlParameter param = null;
		switch (parametro.getTipo()) {
			case INTEGER:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.INTEGER);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.INTEGER);
				}
				break;
			case BIGINT:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.BIGINT);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.BIGINT);
				}
				break;
			case VARCHAR:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.VARCHAR);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.VARCHAR);
				}
				break;
			case LONGNVARCHAR:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.LONGNVARCHAR);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.LONGNVARCHAR);
				}
				break;
			case NVARCHAR:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.NVARCHAR);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.NVARCHAR);
				}
				break;
			case BOOLEAN:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.BOOLEAN);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.BOOLEAN);
				}
				break;
			case CHAR:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.CHAR);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.CHAR);
				}
				break;
			case DECIMAL:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.DECIMAL);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.DECIMAL);
				}
				break;
			case FLOAT:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.FLOAT);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.FLOAT);
				}
				break;
			case BIT:
			case ORACLECURSOR:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.BIT);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.BIT);
				}
				break;
			case DATE:
				if (validaEntrada(parametro)) {
					param = new SqlParameter(Types.DATE);
				}
				else {
					param = new SqlOutParameter(parametro.getNombre(), Types.DATE);
				}
				break;
			default:
				break;
		}

		return param;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: validaTipos
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * validaEntrada
	 *
	 * @param parametro
	 *
	 * @return boolean
	 */
	public static boolean validaEntrada(Parametro parametro) {
		/**
		 * Valida si eltipo de parámetro es de entrada,
		 * retorna una bandera
		 */
		return parametro.getTipoIO().equals(TipoInputOutput.DB_ENTRADA);
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: resultMaptoJson
	 * Descripción:  Método para convertir objetos map string object en JsonObjects
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * resultMaptoJson
	 *
	 * @param resultMap
	 *
	 * @return
	 */
	public static JsonObject resultMaptoJson(Map<String, Object> resultMap) {
		var log = new Log();
		if (resultMap != null && resultMap.size() > 0) {
			resultMap.entrySet()
			         .stream()
			         .forEach((var entry) -> {
				         try {
					         if (entry.getValue() != null && validarEntry(entry)) {
						         entry.setValue(creaArreglo(entry));
					         }
				         }
				         catch (Exception ex) {
					         log.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "",
					                          ex.getMessage(), ex);
				         }
			         });
			return gsonConverter().fromJson(unescapeJava(
				gsonConverter().toJson(resultMap)
				                  .replace("\"\",", "\"root\",")), JsonObject.class);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: resultMaptoJson2
	 * Descripción:  Método para convertir objetos map string object en JsonObjects
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * resultMaptoJson
	 *
	 * @param resultMap
	 *
	 * @return
	 */
	public static JsonObject resultMaptoJson2(Map<String, Object> resultMap) {
		var log = new Log();
		if (resultMap != null && resultMap.size() > 0) {
			resultMap.entrySet()
			         .stream()
			         .forEach((var entry) -> {
				         try {
					         if (entry.getValue() != null && validarEntry(entry)) {
						         entry.setValue(creaArreglo(entry));
					         }
				         }
				         catch (Exception ex) {
					         log.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "",
					                          ex.getMessage(), ex);
				         }
			         });
			return gsonConverter().fromJson(gsonConverter().toJson(resultMap)
			                                                     .replace("\"\",", "\"root\","), JsonObject.class);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: creaArreglo
	 * Descripción:  Método para convertir objetos map string object en JsonObjects
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MTIB
	 * Descripción de modificación:

	 */
	/**
	 * validarEntry
	 *
	 * @param entry
	 */
	private static boolean validarEntry(Map.Entry<String, Object> entry) {
		if ((entry.getValue()
		          .toString()
		          .contains("{") && entry.getValue()
		                                 .toString()
		                                 .contains("}") && entry.getValue()
		                                                        .toString()
		                                                        .contains(":"))) {
			return true;
		}
		else if ((entry.getValue()
		               .toString()
		               .contains("<") && entry.getValue()
		                                      .toString()
		                                      .contains(">") && entry.getValue()
		                                                             .toString()
		                                                             .contains("</"))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: creaArreglo
	 * Descripción:  Método para convertir objetos map string object en JsonObjects
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MTIB
	 * Descripción de modificación:

	 */
	/**
	 * resultMaptoJson
	 *
	 * @param entry
	 *
	 * @return
	 */
	public static List<Object> creaArreglo(Map.Entry<String, Object> entry) {
		
		List<Object> array = (List<Object>) Arrays.asList(entry.getValue())
		                                          .get(0);
		
		array.forEach((var objeto) -> {
			Map<String, Object> aux2 = (Map<String, Object>) objeto;
			
			/**
			 * Se realiza limpieza de códigos de escape y formatos xml que pueden romper
			 * los
			 * bloques json
			 */
			for (Map.Entry<String, Object> entry2 : aux2.entrySet()) {
				if (entry2.getValue() != null) {
					creaEntry2(entry2);
				}
			}
		});
		return array;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: creaEntry2
	 * Descripción:  Método para convertir objetos map string object en JsonObjects
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MTIB
	 * Descripción de modificación:

	 */
	/**
	 * creaEntry2
	 */
	
	public static Map.Entry<String, Object> creaEntry2(Map.Entry<String, Object> entry) {
		var log = new Log();
		Map.Entry<String, Object> entry2 = entry;
		if (entry.getValue()
		         .toString()
		         .contains("{") && entry.getValue()
		                                .toString()
		                                .contains("}") && entry.getValue()
		                                                       .toString()
		                                                       .contains(
			                                                       ":")) {
			entry2.setValue(entry.getValue()
			                     .toString()
			                     .replace("\\\"", "\""));
			entry2.setValue(entry.getValue()
			                     .toString()
			                     .replace("\"", "\\\""));
		}
		else if (entry.getValue()
		              .toString()
		              .contains("<") &&
		         entry.getValue()
		              .toString()
		              .contains(
			              ">") &&
		         entry.getValue()
		              .toString()
		              .contains(
			              "xml") &&
		         entry.getValue()
		              .toString()
		              .contains(
			              "</")) {
			
			for (var i = 0; i <= 1; i++) {
				entry2.setValue(entry.getValue()
				                     .toString()
				                     .replace("\\\"", "\""));
			}
			
		}
		else {
			log.escribeLogMS(Boolean.FALSE, Level.INFO, "", "",
			                 "", "", "", null);
		}
		return entry2;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: creaEntry2
	 * Descripción:  Método para convertir objetos map string object en JsonObjects
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MTIB
	 * Descripción de modificación:

	 */
	public static String parametrosBD(int numero) {
		StringBuilder cadena = new StringBuilder();
		for (int i = Numeros.CERO.getByte(); i < numero; i++) {
			if (i == Numeros.CERO.getByte()) {
				cadena.append("?");
			}
			else {
				cadena.append(",?");
			}
		}
		return cadena.toString();
	}
}
