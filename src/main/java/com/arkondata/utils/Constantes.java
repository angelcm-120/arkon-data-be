package com.arkondata.utils;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Constantes
 * Descripción:  Clase de constantes de Arkon Data
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */

@lombok.Generated
public class Constantes {
	
	/**
	 * URL_REGEX
	 */
	public static final String URL_REGEX =
		"^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
		"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
		"([).!';/?:,][[:blank:]])?$";
	
	/**
	 * HTTPS
	 */
	public static final String HTTPS = "https";
	
	/**
	 * TOKENLOCAL
	 */
	public static final String TOKENLOCAL =
		"esteesmitoken";
	
	/**
	 *
	 */
	public static final String JSON = "JSON_";
	
	/**
	 * ContentType
	 */
	public static final String CONTENT_TYPE = "Content-Type";
	
	/**
	 * Numero 0
	 */
	public static final int CERO = 0;
	
	/**
	 * Numero 10
	 */
	public static final int DIEZ = 10;
	
	/**
	 * Numero 8
	 */
	public static final int OCHO = 8;
	
	/**
	 * Numero 5
	 */
	public static final int CINCO = 5;
	
	/**
	 * Numero 7
	 */
	public static final int SIETE = 7;
	
	/**
	 * Numero 4
	 */
	public static final int CUATRO = 4;
	
	/**
	 * Numero 200
	 */
	public static final int DOCIENTOS = 200;
	
	/**
	 *
	 */
	
	/**
	 * Codigo 200
	 */
	public static final int CODIGO200 = 200;
	
	/**
	 * Codigo 201
	 */
	public static final int CODIGO201 = 201;
	
	/**
	 * Codigo 400
	 */
	public static final int CODIGO400 = 400;
	
	/**
	 * Codigo 401
	 */
	public static final int CODIGO401 = 401;
	
	/**
	 * Codigo 403
	 */
	public static final int CODIGO403 = 403;
	
	/**
	 * Codigo 404
	 */
	public static final int CODIGO404 = 404;
	
	/**
	 * Codigo 405
	 */
	public static final int CODIGO405 = 405;
	
	/**
	 * Codigo 422
	 */
	public static final int CODIGO422 = 422;
	
	/**
	 * Codigo 500
	 */
	public static final int CODIGO500 = 500;
	
	/**
	 * Codigo 501
	 */
	public static final int CODIGO501 = 501;
	
	/**
	 * SISTEMA
	 */
	public static final String SISTEMA = "Mso Base";
	
	/**
	 * ENCODING
	 */
	public static final String ENCODING = "UTF-8";
	
	/**
	 * CONN_TIMEOUT
	 */
	public static final int CONN_TIMEOUT = 30000;
	
	/**
	 * READ_TIMEOUT
	 */
	public static final int READ_TIMEOUT = 30000;
	
	/**
	 * PARAMETROS_DEFAULT
	 */
	public static final String PARAMETROS_DEFAULT = "cadena,token";

	/**
	 * FORMATO_FECHAS
	 */
	public static final String FORMATO_FECHAS = "yyyy-MM-dd";
	
	/**
	 * FORMATO_FECHAS_2
	 */
	public static final String FORMATO_FECHAS_2 = "dd/MM/yyyy";
	
	/**
	 * FORMATO_FECHAS_HORAS
	 */
	public static final String FORMATO_FECHAS_HORAS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * FORMATO_FECHAS_HORAS_TIME_STAMP
	 */
	public static final String FORMATO_FECHAS_HORAS_TIME_STAMP = "yyyy-MM-dd HH:mm:ss.SSS";
	
	/**
	 * FORMATO_FECHAS_HORAS_2
	 */
	public static final String FORMATO_FECHAS_HORAS_2 = "dd/MM/yyyy HH:mm:ss";
	
	/**
	 * FORMATO_FECHAS_HORAS_2_TIME_STAMP
	 */
	public static final String FORMATO_FECHAS_HORAS_2_TIME_STAMP = "dd/MM/yyyy HH:mm:ss.SSS";

	/**
	 * API_KEY_GOOGLE
	 */
	public static final String API_KEY_GOOGLE = "AIzaSyAndF_bbK1xXbymv0c34tNxhiExL4hrZwQ";
	
	/**
	 * URL_DIRECTIONS
	 */
	public static final String URL_DIRECTIONS =
		"https://maps.googleapis.com/maps/api/directions/json?origin=@@LAT_ORIGEN@@," +
		"@@LONG_ORIGEN@@&destination=@@LAT_DESTINO@@,@@LONG_DESTINO@@&units=metric&language=es&key=" +
		API_KEY_GOOGLE;
	
	/**
	 * URL_DIRECTIONSV_2
	 */
	public static final String URL_DIRECTIONSV_2 =
		"https://maps.googleapis.com/maps/api/directions/json?origin=@@LAT_ORIGEN@@," +
		"@@LONG_ORIGEN@@&destination=@@DESTINO@@&units=metric&language=es&mode=driving&sensor=false&key=" +
		API_KEY_GOOGLE;
	
	/**
	 * URL_GOOGLEMARCAAGUA
	 */
	public static final String URL_GOOGLEMARCAAGUA =
		"http://maps.googleapis.com/maps/api/staticmap?center=@@LAT_CENTRO@@," +
		"@@LONG_CENTRO@@&zoom=@@ZOOM@@&size=256x256&key=" +
		API_KEY_GOOGLE;
	
	/**
	 * URL_GOOGLE
	 */
	public static final String URL_GOOGLE =
		"http://maps.googleapis.com/maps/api/staticmap?center=@@LAT_CENTRO@@," +
		"@@LONG_CENTRO@@&zoom=@@ZOOM@@&size=256x306&key=" +
		API_KEY_GOOGLE;
	
	/**
	 * URL_GEOCODE
	 */
	public static final String URL_GEOCODE =
		"https://maps.googleapis.com/maps/api/geocode/json?@@PARAMSGEOCODE@@&key=" + API_KEY_GOOGLE;
	
	/**
	 * URL_OPENSTREET
	 */
	public static final String URL_OPENSTREET = "https://a.tile.openstreetmap.org/@@ZOOM@@/@@PRMX@@/@@PRMY@@.png";
	
	/**
	 * HTTP
	 */
	public static final String HTTP = "http://";
	

	/**
	 * URL_MT_1_GOOGLE
	 */
	public static final String URL_MT_1_GOOGLE = HTTP + "mt1.google.com/vt/lyrs=r&x=@@PRMX@@&y=@@PRMY@@&z=@@ZOOM@@";
	
	/**
	 * URL_MT_0_GOOGLE
	 */
	public static final String URL_MT_0_GOOGLE = HTTP + "mt0.google.com/vt/lyrs=r&x=@@PRMX@@&y=@@PRMY@@&z=@@ZOOM@@";

	/**
	 * Constructor vacio
	 */
	private Constantes() {
	}
}
