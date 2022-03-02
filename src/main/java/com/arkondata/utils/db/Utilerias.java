package com.arkondata.utils.db;

import com.arkondata.models.db.Parametro;
import com.arkondata.utils.enums.Numeros;
import com.arkondata.utils.enums.TipoInputOutput;
import com.arkondata.utils.log.Log;
import com.google.gson.JsonObject;

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
 * OT:
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
	 * OT:
	 */
	/**
	 * Constructor Vacio
	 */
	private Utilerias() {
		/* No hace nada */
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: validaTipos
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
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
	 * OT:
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
	 * OT:
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
	 * OT:
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
	 * OT:
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
	 * OT:
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
	 * OT:
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
