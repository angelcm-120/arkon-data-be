package com.arkondata.utils;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Cadenas
 * Descripción:  Clase cadenas de texto para contener
 * Descripción: las constantes que se utilizan por todo el mso
 * Fecha de Modificación: 2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public class Cadenas {
	/**
	 * SECRET
	 */
	public static final String SECRET = "Q29icmFuemFfQ2xvdWR5RGV2T3Bz";
	
	/**
	 * FORMATO_FECHAS
	 */
	public static final String FORMATO_FECHAS = "yyyy-MM-dd";
	
	/**
	 * FORMATO_FECHAS_2
	 */
	public static final String FORMATO_FECHAS_2 = "dd/MM/yyyy";
	
	/**
	 * CARPETA_CLIENTE_360
	 */
	public static final String CARPETA_CLIENTE_360 = "Cliente360";
	
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
	 * MSJ_CODIGO_NA
	 */
	public static final String MSJ_CODIGO_NA = "No implementado.";
	
	/**
	 * MSJ_TOKEN_INVALIDO
	 */
	public static final String MSJ_TOKEN_INVALIDO = "El token no es válido.";
	
	/**
	 * MSJ_TOKEN_FECHA_INVALIDA
	 */
	public static final String MSJ_TOKEN_FECHA_INVALIDA = "Fecha no válida para generar token.";
	
	/**
	 * MSJ_TOKEN_EXPIRADO
	 */
	public static final String MSJ_TOKEN_EXPIRADO = "El token ha expirado.";
	
	/**
	 * MSJ_CADENATOKEN_DIFERENTE
	 */
	public static final String MSJ_CADENATOKEN_DIFERENTE =
		"La cadena no es la misma con la que se originó el token. Por favor verifique la información.";
	
	/**
	 * MSJ_CANTIDAD_PARAMETROS_INVALIDO
	 */
	public static final String MSJ_CANTIDAD_PARAMETROS_INVALIDO = "Cantidad de parámetros no válido.";
	
	/**
	 * MSJ_METODO_NO_EXISTE
	 */
	public static final String MSJ_METODO_NO_EXISTE = "El no. de método invocado no éxiste";
	
	/**
	 * ENCODING
	 */
	public static final String ENCODING = "UTF-8";
	
	/**
	 * MSJ_CODIGO_200_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_200_DESCRIPCION_OPEN = "Operación exitosa.";
	
	/**
	 * MSJ_CODIGO_201_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_201_DESCRIPCION_OPEN = "Solicitud creada de forma exitosa.";
	
	/**
	 * MSJ_CODIGO_400_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_400_DESCRIPCION_OPEN = "Solicitud Incorrecta.";
	
	/**
	 * MSJ_CODIGO_401_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_401_DESCRIPCION_OPEN = "No autorizado.";
	
	/**
	 * MSJ_CODIGO_403_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_403_DESCRIPCION_OPEN = "No es posible realizar esta operación.";
	
	/**
	 * MSJ_CODIGO_404_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_404_DESCRIPCION_OPEN = "No encontrado.";
	
	/**
	 * MSJ_CODIGO_405_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_405_DESCRIPCION_OPEN = "Método no permitido.";
	
	/**
	 * MSJ_CODIGO_422_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_422_DESCRIPCION_OPEN = "Entidad no procesable.";
	
	/**
	 * MSJ_CODIGO_500_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_500_DESCRIPCION_OPEN = "Error interno en el servicio.";
	
	/**
	 * MSJ_CODIGO_501_DESCRIPCION_OPEN
	 */
	public static final String MSJ_CODIGO_501_DESCRIPCION_OPEN = "No implementado.";
	
	private static String codigoApi = "145";
	private static String direccionp = "ArkonData";
	private static String areap = "Desarrollo";
	private static String appp = "Test";
	/**
	 * Cadenas
	 */
	private Cadenas() {
	}
	
	/**
	 * setCelula
	 *
	 * @param direccion valor para direccion
	 * @param area valor para area
	 * @param app valor para app
	 *
	 * @return la celula
	 */
	public static String setCelula(String direccion, String area, String app) {
		direccionp = direccion;
		areap = area;
		appp = app;
		
		return direccion + "-" + area.replace(' ', '-')
		                             .replace('.', '-') + "-" + app;
	}
	
	/**
	 * setCodigoApi
	 *
	 * @param codigo valor para el código
	 */
	public static void setCodigoApi(String codigo) {
		codigoApi = codigo;
	}
	
	/**
	 * getCodigoApi
	 *
	 * @return código codigoApi
	 */
	public static String getCodigoApi() {
		return codigoApi;
	}
	
	/**
	 * msjcodigo200
	 *
	 * @return código 200
	 */
	public static String msjcodigo200() {
		return "200." + getCelula() + "." + codigoApi + "200";
	}
	
	/**
	 * msjcodigo201
	 *
	 * @return código 201
	 */
	public static String msjcodigo201() {
		return "201." + getCelula() + "." + codigoApi + "201";
	}
	
	/**
	 * msjcodigo400
	 *
	 * @return código 400
	 */
	public static String msjcodigo400() {
		return "400." + getCelula() + "." + codigoApi + "400";
	}
	
	/**
	 * msjcodigo401
	 *
	 * @return código 401
	 */
	public static String msjcodigo401() {
		return "401." + getCelula() + "." + codigoApi + "401";
	}
	
	/**
	 * msjcodigo403
	 *
	 * @return código 403
	 */
	public static String msjcodigo403() {
		return "403." + getCelula() + "." + codigoApi + "403";
	}
	
	/**
	 * msjcodigo404
	 *
	 * @return código 404
	 */
	public static String msjcodigo404() {
		return "404." + getCelula() + "." + codigoApi + "404";
	}
	
	/**
	 * msjcodigo405
	 *
	 * @return código 405
	 */
	public static String msjcodigo405() {
		return "405." + getCelula() + "." + codigoApi + "405";
	}
	
	/**
	 * msjcodigo422
	 *
	 * @return código 422
	 */
	public static String msjcodigo422() {
		return "422." + getCelula() + "." + codigoApi + "422";
	}
	
	/**
	 * msjcodigo500
	 *
	 * @return código 500
	 */
	public static String msjcodigo500() {
		return "500." + getCelula() + "." + codigoApi + "500";
	}
	
	/**
	 * msjcodigo501
	 *
	 * @return código 501
	 */
	public static String msjcodigo501() {
		return "501." + getCelula() + "." + codigoApi + "501";
	}
	
	/**
	 * msjCodigo200Info
	 *
	 * @return codigoApi200
	 */
	public static String msjCodigo200Info() {
		return "https://arkon-data.com/info#200." + getCelula()
		       + "." + codigoApi + "200";
	}
	
	/**
	 * msjCodigo201Info
	 *
	 * @return codigoApi201
	 */
	public static String msjCodigo201Info() {
		return "https://arkon-data.com/info#201." + getCelula()
		       + "." + codigoApi + "201";
	}
	
	/**
	 * msjcodigo400Info
	 *
	 * @return codigoApi400
	 */
	public static String msjcodigo400Info() {
		return "https://arkon-data.com/info#400."
		       + getCelula() + "." + codigoApi + "400";
	}
	
	/**
	 * msjcodigo401Info
	 *
	 * @return codigoApi401
	 */
	public static String msjcodigo401Info() {
		return "https://arkon-data.com/info#401."
		       + getCelula() + "." + codigoApi + "401";
	}
	
	/**
	 * msjcodigo403Info
	 *
	 * @return codigoApi403
	 */
	public static String msjcodigo403Info() {
		return "https://arkon-data.com/info#403."
		       + getCelula() + "." + codigoApi + "403";
	}
	
	/**
	 * msjcodigo404Info
	 *
	 * @return codigoApi404
	 */
	public static String msjcodigo404Info() {
		return "https://arkon-data.com/info#404."
		       + getCelula() + "." + codigoApi + "404";
	}
	
	/**
	 * msjcodigo405Info
	 *
	 * @return codigoApi405
	 */
	public static String msjcodigo405Info() {
		return "https://arkon-data.com/info#405."
		       + getCelula() + "." + codigoApi + "405";
	}
	
	/**
	 * msjcodigo422Info
	 *
	 * @return codigoApi422
	 */
	public static String msjcodigo422Info() {
		return "https://arkon-data.com/info#422."
		       + getCelula() + "." + codigoApi + "422";
	}
	
	/**
	 * msjcodigo500Info
	 *
	 * @return codigoApi500
	 */
	public static String msjcodigo500Info() {
		return "https://arkon-data.com/info#500."
		       + getCelula() + "." + codigoApi + "500";
	}
	
	/**
	 * msjcodigo501Info
	 *
	 * @return codigoApi501
	 */
	public static String msjcodigo501Info() {
		return "https://arkon-data.com/info#501."
		       + getCelula() + "." + codigoApi + "501";
	}
	
	/**
	 * getCelula
	 *
	 * @return celula
	 */
	private static String getCelula() {
		return direccionp + "-" +
		       areap.replace(' ', '-')
		            .replace('.', '-') +
		       "-" +
		       appp;
	}
}
