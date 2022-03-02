package com.arkondata.utils.enums;


import java.util.Arrays;

import static com.arkondata.utils.Constantes.*;
import static com.arkondata.utils.enums.Metodo.GET;
import static com.arkondata.utils.enums.Metodo.POST;
import static com.arkondata.utils.enums.TipoContenido.*;
import static com.arkondata.utils.enums.TipoContenido.APPLICATION_JSON;
import static com.arkondata.utils.enums.TipoContenido.APPLICATION_X_WWW_FORM_URLENCODED;
import static com.arkondata.utils.enums.TipoContenido.IMAGE_PNG;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: Servicios *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum Servicios {
	
	/**
	 * CONSULTA
	 */
	CONSULTA(0, "/Arkon-Data/DAOS/Servicios/consulta/v1", PARAMETROS_DEFAULT, POST, CONN_TIMEOUT,
	         READ_TIMEOUT, APPLICATION_X_WWW_FORM_URLENCODED),
	
	/**
	 * OPENSTREET
	 */
	OPENSTREET(1, URL_OPENSTREET, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, IMAGE_PNG),
	
	/**
	 * GOOGLEDIRECTIONS
	 */
	GOOGLEDIRECTIONS(2, URL_DIRECTIONS, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, APPLICATION_JSON),
	
	/**
	 * GOOGLEMARCAAGUA
	 */
	GOOGLEMARCAAGUA(3, URL_GOOGLEMARCAAGUA, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, IMAGE_PNG),
	
	/**
	 * GOOGLE
	 */
	GOOGLE(4, URL_GOOGLE, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, IMAGE_PNG),
	
	/**
	 * GEOCODE
	 */
	GEOCODE(5, URL_GEOCODE, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, IMAGE_PNG),
	
	/**
	 * MT0GOOGLE
	 */
	MT0GOOGLE(6, URL_MT_0_GOOGLE, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, IMAGE_PNG),
	
	/**
	 * MT1GOOGLE
	 */
	MT1GOOGLE(7, URL_MT_1_GOOGLE, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, IMAGE_PNG),
	
	/**
	 * INDICADORES
	 */
	INDICADORES(11, "/Arkon-Data/Indicadores/Servicios/parametrosrend/v1", PARAMETROS_DEFAULT, POST,
	            CONN_TIMEOUT, READ_TIMEOUT, APPLICATION_X_WWW_FORM_URLENCODED),
	
	/**
	 * BAZSTORE_REGISTRAAPP
	 */
	BAZSTORE_REGISTRAAPP(12, "/Arkon-Data/BazStore/Servicios/registraaplicacion/v1", PARAMETROS_DEFAULT,
	                     POST,
	                     CONN_TIMEOUT, READ_TIMEOUT, APPLICATION_X_WWW_FORM_URLENCODED),
	
	/**
	 * PUENTE
	 */
	PUENTE(13, "", PARAMETROS_DEFAULT, POST, CONN_TIMEOUT, READ_TIMEOUT, APPLICATION_X_WWW_FORM_URLENCODED),
	
	/**
	 * GOOGLEDIRECTIONSV2
	 */
	GOOGLEDIRECTIONSV2(15, URL_DIRECTIONSV_2, PARAMETROS_DEFAULT, GET, CONN_TIMEOUT, READ_TIMEOUT, APPLICATION_JSON);
	
	/**
	 * value
	 */
	private int value = 0;
	
	/**
	 * contexto
	 */
	private String contexto = "";
	
	/**
	 * contextoBase
	 */
	private String contextoBase = "";
	
	/**
	 * parametros
	 */
	private String[] parametros;
	
	/**
	 * metodo
	 */
	private Metodo metodo;
	
	/**
	 * tiempoConexion
	 */
	private int tiempoConexion;
	
	/**
	 * tiempoConsumo
	 */
	private int tiempoConsumo;
	
	/**
	 * tipoContenido
	 */
	private TipoContenido tipoContenido;
	
	/**
	 * Servicios
	 *
	 * @param value
	 * @param contexto
	 * @param parametros
	 * @param metodo
	 * @param tiempoConexion
	 * @param tiempoConsumo
	 * @param tipoContenido
	 */
	Servicios(int value, String contexto, String parametros, Metodo metodo, int tiempoConexion, int tiempoConsumo,
	          TipoContenido tipoContenido) {
		this.value = value;
		this.contexto = contexto;
		this.contextoBase = contexto;
		this.parametros = parametros.split(",");
		this.metodo = metodo;
		this.tiempoConexion = tiempoConexion;
		this.tiempoConsumo = tiempoConsumo;
		this.tipoContenido = tipoContenido;
	}
	
	/**
	 * getValue
	 *
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * getContexto
	 *
	 * @return
	 */
	public String getContexto() {
		return contexto;
	}
	
	/**
	 * getParametros
	 *
	 * @return
	 */
	public String[] getParametros() {
		return Arrays.copyOf(parametros, parametros.length);
	}
	
	/**
	 * getMetodo
	 *
	 * @return
	 */
	public Metodo getMetodo() {
		return metodo;
	}
	
	/**
	 * getTiempoConexion
	 *
	 * @return
	 */
	public int getTiempoConexion() {
		return tiempoConexion;
	}
	
	/**
	 * getTiempoConsumo
	 *
	 * @return
	 */
	public int getTiempoConsumo() {
		return tiempoConsumo;
	}
	
	/**
	 * getTipoContenido
	 *
	 * @return
	 */
	public TipoContenido getTipoContenido() {
		return tipoContenido;
	}
	
	/**
	 * replaceURL
	 *
	 * @param valorAnterior
	 * @param nuevoValor
	 */
	public void replaceURL(String valorAnterior, String nuevoValor) {
		this.contexto = this.contexto.replace(valorAnterior, nuevoValor);
	}
	
	
	/**
	 * contiene
	 *
	 * @param servicio
	 *
	 * @return
	 */
	public static boolean contiene(String servicio) {
		for (Servicios c : Servicios.values()) {
			if (c.name()
			     .equals(servicio)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param servicio
	 *
	 * @return
	 */
	public static Servicios servicio(String servicio) {
		for (Servicios c : Servicios.values()) {
			if (c.name()
			     .equals(servicio)) {
				c.contexto = c.contextoBase;
				return c;
			}
		}
		return null;
	}
	
}
