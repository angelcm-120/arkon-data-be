package com.arkondata.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.TextCodec;
import com.arkondata.utils.log.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;

import static com.arkondata.utils.Constantes.*;


/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Funciones
 * Descripción:  Clase para contener funcionalidades genéricas para el core de Arkon Data
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public class Funciones {
	/**
	 * URL_PATTERN
	 */
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	/**
	 * logs
	 */
	private static final Log LOGGER = new Log();
	
	/**
	 * Constructor vacio
	 */
	private Funciones() {
		/*No hace nada*/
	}
	
	/**
	 * urlValidator
	 * @param url - Url para ser validada en estructura
	 * @return Bandera para indicar si la url es válida en su construcción o no.
	 */
	public static boolean urlValidator(String url)
	{
		if (url == null) {
			return false;
		}
		var matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}
	
	/**
	 * folio
	 *
	 * @return
	 */
	public static String folio() {
		
		var pattern = "yyyyMMddHHmmssS";
		var today = ZonedDateTime.now();
		var timestamp = new Timestamp(System.currentTimeMillis());
		var formatter = DateTimeFormatter.ofPattern(pattern);
		return today.format(formatter) + "" + timestamp.getTime();
	}
	
	/**
	 * formateaFecha
	 *
	 * @param fecha
	 *
	 * @return
	 */
	public static String formateaFecha(Date fecha) {
		var formatter = new SimpleDateFormat(FORMATO_FECHAS);
		return formatter.format(fecha);
	}
	
	/**
	 * formateaFecha2
	 *
	 * @param fecha
	 *
	 * @return
	 */
	public static String formateaFecha2(Date fecha) {
		var formatter = new SimpleDateFormat(FORMATO_FECHAS_2);
		return formatter.format(fecha);
	}
	
	/**
	 * formateaFechaHora
	 *
	 * @param fecha
	 *
	 * @return
	 */
	public static String formateaFechaHora(ZonedDateTime fecha) {
		var formatter = DateTimeFormatter.ofPattern(FORMATO_FECHAS_HORAS);
		return fecha.format(formatter);
	}
	
	/**
	 * formateaFechaHoraTimeStamp
	 *
	 * @param fecha
	 *
	 * @return fecha y hora con formato yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static String formateaFechaHoraTimeStamp(Date fecha) {
		var formatter = new SimpleDateFormat(FORMATO_FECHAS_HORAS_TIME_STAMP);
		return formatter.format(fecha);
	}
	
	/**
	 * formateaFechaHora2
	 *
	 * @param fecha
	 *
	 * @return fecha y hora con formato dd/MM/yyyy HH:mm:ss
	 */
	public static String formateaFechaHora2(Date fecha) {
		var formatter = new SimpleDateFormat(FORMATO_FECHAS_HORAS_2);
		return formatter.format(fecha);
	}
	
	/**
	 * formateaFechaString
	 *
	 * @param strFecha
	 *
	 * @return fecha
	 */
	public static String formateaFechaString(String strFecha) {
		var nuevaFecha = "";
		
		strFecha = strFecha.substring(CERO, DIEZ);
		nuevaFecha = strFecha.substring(OCHO, DIEZ) + '/' + strFecha.substring(CINCO, SIETE) + '/' +
		             strFecha.substring(CERO, CUATRO);
		
		return nuevaFecha;
	}
	
	/**
	 * formateaFechaStringToDate
	 *
	 * @param strFecha
	 * @param formatoFechas
	 *
	 * @return formateaFechaStringToDate
	 */
	public static Date formateaFechaStringToDate(String strFecha, String formatoFechas) {
		Date nuevaFecha = null;
		try {
			var formatter = new SimpleDateFormat(formatoFechas);
			nuevaFecha = formatter.parse(strFecha);
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "",
			               ex.getMessage(), ex);
		}
		
		return nuevaFecha;
	}
	
	/**
	 * gsonConverter
	 *
	 * @return Gson
	 */
	public static Gson gsonConverter() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
		                        .create();
	}
	
	
	/**
	 * base64Archivo
	 *
	 * @param path
	 * @param contenido
	 *
	 * @return Archivo base 64
	 */
	public static File base64Archivo(String path, String contenido) {
		try {
			byte[] data = Base64.getDecoder()
			                    .decode(contenido);
			var archivo = new File(path);
			
			return write(data, archivo);
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "",
			               ex.getMessage(), ex);
			return null;
		}
	}
	
	public static File write(byte[] data, File archivo) {
		try (var writer = new BufferedOutputStream(new FileOutputStream(archivo))) {
			writer.write(data);
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "",
			               ex.getMessage(), ex);
		}
		return archivo;
	}
	
	/**
	 * cadenasv3
	 *
	 * @param cadenas
	 * @param cadenaOriginal
	 *
	 * @return List cadenasv3
	 */
	public static List<String> cadenasv3(List<String> cadenas, String cadenaOriginal) {
		if (cadenaOriginal.length() < DOCIENTOS) {
			cadenas.add(cadenaOriginal);
		}
		else {
			var aux = cadenaOriginal.substring(CERO, DOCIENTOS);
			cadenas.add(aux);
			cadenas = cadenasv3(cadenas, cadenaOriginal.replace(aux, ""));
		}
		return cadenas;
	}
	
	/**
	 * reemplazaParametros
	 *
	 * @param qry
	 * @param params
	 *
	 * @return reemplazaParametros
	 */
	public static String reemplazaParametros(String qry, String[] params) {
		StringBuilder resultado = new StringBuilder().append(bytesToStr(Base64.getDecoder()
		                                                                      .decode(qry)));
		if (params != null && params.length > CERO) {
			var i = 1;
			for (String param : params) {
				resultado = new StringBuilder().append(resultado.toString()
				                                                .replace("@param" + i, param));
				i += 1;
			}
		}
		return resultado.toString();
	}
	
	public static String bytesToStr(byte[] cadena) {
		return new String(cadena);
	}
	
	
	/**
	 * Nombre de proyecto: msos_template
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: ejecutaFiltro
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * Función validateToken para validar jwts
	 * @param authToken token
	 * @return Claims de parset jwt
	 */
	public static io.jsonwebtoken.Claims validateToken(String authToken) {
		String msgError = "";
		var logex = new Log();
		try {
			return Jwts.parser()
			           .setSigningKey(TextCodec.BASE64.encode(Cadenas.getCodigoApi()))
			           .parseClaimsJws(authToken).getBody();
		}
		catch (SecurityException | MalformedJwtException e) {
			msgError = "Invalid JWT signature.";
			logex.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "",
			                 "", msgError, e);
		}
		catch (ExpiredJwtException e) {
			msgError ="Expired JWT token.";
			logex.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "",
			                 "", msgError, e);
		}
		catch (UnsupportedJwtException e) {
			msgError="Unsupported JWT token.";
			logex.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "",
			                 "", msgError, e);
		}
		catch (IllegalArgumentException e) {
			msgError="JWT token compact of handler are invalid.";
			logex.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "",
			                 "", msgError, e);
		}
		
		return null;
	}
	
}
