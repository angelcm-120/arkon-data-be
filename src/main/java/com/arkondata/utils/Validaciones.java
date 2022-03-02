package com.arkondata.utils;

import com.arkondata.utils.log.Log;
import java.util.Objects;
import java.util.logging.Level;

public class Validaciones {
	/**
	 * logs
	 */
	private static final Log LOGGER = new Log();
	
	private static final String CEROPUNTOCERO = "0.0";
	
	public Validaciones() {
		/*No hace nada*/
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isNumber
	 * Descripción:  Metodo que permite validar si el dato de entrada
	 * es numerico
	 * Fecha de Modificación:2021-11-02
	 * Persona que modifico: MACM
	 * Descripción de modificación: Verifica que un String sea un número.
	 * OT:
	 */
	public static boolean isNumber(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			Integer.parseInt(valor);
			return true;
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isNumberIgualCero
	 * Descripción:  Metodo que permite validar si el dato de entrada
	 * es numerico
	 * Fecha de Modificación:2021-11-02
	 * Persona que modifico: MACM
	 * Descripción de modificación: Verifica que un String sea un número igual a cero.
	 * OT:
	 */
	public static boolean isNumberIgualCero(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			return Integer.parseInt(valor) == 0;
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isNumberMenorCero
	 * Descripción:  Metodo que permite validar si el dato de entrada
	 * es numerico
	 * Fecha de Modificación:2021-11-02
	 * Persona que modifico: MACM
	 * Descripción de modificación: Verifica que un String sea un número menor a cero.
	 * OT:
	 */
	public static boolean isNumberMenorCero(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			return Integer.parseInt(valor) < 0;
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isNumberMayorCero
	 * Descripción:  Metodo que permite validar si el dato de entrada es numerico y mayor a cero
	 * Fecha de Modificación:2021-08-27
	 * Persona que modifico: MACM
	 * Descripción de modificación: Verifica que un String sea un número y sea mayor a cero.
	 * OT:
	 */
	public static boolean isNumberMayorCero(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			return Integer.parseInt(valor) > 0;
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isFloat
	 * Fecha de Modificación:2021-11-02
	 * Persona que modifico: MACM
	 * Descripción:  Metodo que permite validar si el dato de entrada es flotante y mayor a cero
	 * OT:
	 */
	public static boolean isFloat(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			Float.parseFloat(valor);
			return true;
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isFloatMenorCero
	 * Fecha de Modificación:2021-11-02
	 * Persona que modifico: MACM
	 * Descripción:  Metodo que permite validar si el dato de entrada es flotante y menor a cero
	 * OT:
	 */
	public static boolean isFloatMenorCero(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			return Float.parseFloat(valor) < Float.parseFloat(CEROPUNTOCERO);
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data
	 * Nombre de clase: Validaciones
	 * Nombre del metodo: isFloatMayoCero
	 * Fecha de Modificación:2021-10-27
	 * Persona que modifico: MACM
	 * Descripción:  Metodo que permite validar si el dato de entrada es flotante y mayor a cero
	 * OT:
	 */
	public static boolean isFloatMayorCero(String valor) {
		try {
			valor = valor.replace('\t', '_').replace('\n', '_').replace('\r', '_');
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", null);
			return Float.parseFloat(valor) > Float.parseFloat(CEROPUNTOCERO);
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}

	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: validaCadenas
	 * Descripción: Valida que la cadena sea valida
	 * Fecha de Modificación:2021-11-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	public static boolean validaCadenas(String cadena){
		return (Objects.nonNull(cadena) && !"".equals(cadena) && !"null".equals(cadena) && !"true".equals(cadena));
	}
}
