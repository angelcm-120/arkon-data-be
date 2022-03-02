package com.arkondata.seguridad;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.util.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.util.Objects;

import static com.arkondata.utils.Funciones.urlValidator;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: SecurityUtil
 * Descripción: Clase de utilidad para sanitización de cadenas de texto
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
public final class SecurityUtil {
	/**
	 * Constructor
	 */
	private SecurityUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Remove escape characters like Html/Js scripts from input if present
	 *
	 * @param str
	 * 	Input string
	 *
	 * @return sanitize string
	 */
	public static String cleanIt(String str) {
		if (!Objects.isNull(str) && !urlValidator(str)) {
			return Jsoup.clean(
				StringEscapeUtils.escapeHtml4(StringEscapeUtils.escapeEcmaScript(StringUtils.replace(str, "'", "''")))
				, Safelist.basic());
		}
		else if(urlValidator(str)){
			return Jsoup.clean(
				StringEscapeUtils.escapeHtml4(StringEscapeUtils.escapeJava(StringUtils.replace(str, "'", "''")))
				, Safelist.basic());
		}
		else {
			return null;
		}
	}
	
	/**
	 * Remove escape characters like Html/Js scripts from input if present
	 *
	 * @param str
	 * 	Input string
	 *
	 * @return sanitize string
	 */
	public static String cleanItStr(String str) {
		if (!Objects.isNull(str)) {
			return Jsoup.clean(
				StringEscapeUtils.escapeHtml4(StringEscapeUtils.escapeJava(StringUtils.replace(str, "'", "''")))
				, Safelist.basic());
		}
		else {
			return null;
		}
	}
}
