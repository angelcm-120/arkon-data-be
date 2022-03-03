package com.arkondata.utils.enums;

import com.arkondata.utils.Constantes;
import org.springframework.http.HttpStatus;

import static com.arkondata.utils.Cadenas.*;
import static com.arkondata.utils.Cadenas.MSJ_CODIGO_NA;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: RespuestasCodigos *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum RespuestasCodigos {
	/**
	 * CODE200
	 */
	CODE200(200),
	
	/**
	 * CODE200
	 */
	CODE201(201),
	
	/**
	 * CODE400
	 */
	CODE400(400),
	
	/**
	 * CODE401
	 */
	CODE401(401),
	
	/**
	 * CODE403
	 */
	CODE403(403),
	
	/**
	 * CODE404
	 */
	CODE404(404),
	
	/**
	 * CODE405
	 */
	CODE405(405),
	
	/**
	 * CODE422
	 */
	CODE422(422),
	
	/**
	 * CODE500
	 */
	CODE500(500),
	
	/**
	 * CODE501
	 */
	CODE501(501);
	
	/**
	 * valor
	 */
	private int valor;
	
	/**
	 * RespuestasCodigos
	 *
	 * @param valor
	 */
	RespuestasCodigos(int valor) {
		this.valor = valor;
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de método: obtenValor
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * obtenValor
	 *
	 * @return valor de tipo int de la variable valor
	 */
	public int obtenValor() {
		return valor;
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de método: esError
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * esError
	 *
	 * @return retorna si es un error o no
	 */
	public Boolean esError() {
		Boolean error = false;
		switch (this.valor) {
			case Constantes.CODIGO200:
				error = Boolean.FALSE;
				break;
			case Constantes.CODIGO201:
				error = Boolean.FALSE;
				break;
			case Constantes.CODIGO400:
				error = Boolean.TRUE;
				break;
			case Constantes.CODIGO401:
				error = Boolean.TRUE;
				break;
			case Constantes.CODIGO403:
				error = Boolean.TRUE;
				break;
			case Constantes.CODIGO404:
				error = Boolean.TRUE;
				break;
			case Constantes.CODIGO405:
				error = Boolean.TRUE;
				break;
			case Constantes.CODIGO422:
				error = Boolean.TRUE;
				break;
			case Constantes.CODIGO500:
				error = Boolean.TRUE;
				break;
			default:
				error = Boolean.TRUE;
				break;
		}
		return error;
		
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de método: obtenCodigo
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * obtenCodigo
	 *
	 * @return el valor del código de respuesta
	 */
	public String obtenCodigo() {
		var mensaje = "";
		switch (this.valor) {
			case Constantes.CODIGO200:
				mensaje = msjcodigo200();
				break;
			case Constantes.CODIGO201:
				mensaje = msjcodigo201();
				break;
			case Constantes.CODIGO400:
				mensaje = msjcodigo400();
				break;
			case Constantes.CODIGO401:
				mensaje = msjcodigo401();
				break;
			case Constantes.CODIGO403:
				mensaje = msjcodigo403();
				break;
			case Constantes.CODIGO404:
				mensaje = msjcodigo404();
				break;
			case Constantes.CODIGO405:
				mensaje = msjcodigo405();
				break;
			case Constantes.CODIGO422:
				mensaje = msjcodigo422();
				break;
			case Constantes.CODIGO500:
				mensaje = msjcodigo500();
				break;
			default:
				mensaje = MSJ_CODIGO_NA;
				break;
		}
		return mensaje;
		
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de método: obtenInfo
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * obtenInfo
	 *
	 * @return la info de la petición
	 */
	public String obtenInfo() {
		var mensaje = "";
		switch (this.valor) {
			case Constantes.CODIGO200:
				mensaje = msjCodigo200Info();
				break;
			case Constantes.CODIGO201:
				mensaje = msjCodigo201Info();
				break;
			case Constantes.CODIGO400:
				mensaje = msjcodigo400Info();
				break;
			case Constantes.CODIGO401:
				mensaje = msjcodigo401Info();
				break;
			case Constantes.CODIGO403:
				mensaje = msjcodigo403Info();
				break;
			case Constantes.CODIGO404:
				mensaje = msjcodigo404Info();
				break;
			case Constantes.CODIGO405:
				mensaje = msjcodigo405Info();
				break;
			case Constantes.CODIGO422:
				mensaje = msjcodigo422Info();
				break;
			case Constantes.CODIGO500:
				mensaje = msjcodigo500Info();
				break;
			default:
				mensaje = MSJ_CODIGO_NA;
				break;
		}
		return mensaje;
		
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de método: obtenMensaje
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * obtenMensaje
	 *
	 * @return el valor del mensaje
	 */
	public String obtenMensaje() {
		var mensaje = "";
		switch (this.valor) {
			case Constantes.CODIGO200:
				mensaje = MSJ_CODIGO_200_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO201:
				mensaje = MSJ_CODIGO_201_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO400:
				mensaje = MSJ_CODIGO_400_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO401:
				mensaje = MSJ_CODIGO_401_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO403:
				mensaje = MSJ_CODIGO_403_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO404:
				mensaje = MSJ_CODIGO_404_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO405:
				mensaje = MSJ_CODIGO_405_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO422:
				mensaje = MSJ_CODIGO_422_DESCRIPCION_OPEN;
				break;
			case Constantes.CODIGO500:
				mensaje = MSJ_CODIGO_500_DESCRIPCION_OPEN;
				break;
			default:
				mensaje = MSJ_CODIGO_NA;
				break;
		}
		return mensaje;
		
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de método: obtenEstatus
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * obtenEstatus
	 *
	 * @return el estatus http
	 */
	public HttpStatus obtenEstatus() {
		HttpStatus httpStatus;
		switch (this.valor) {
			case Constantes.CODIGO200:
				httpStatus = HttpStatus.OK;
				break;
			case Constantes.CODIGO201:
				httpStatus = HttpStatus.CREATED;
				break;
			case Constantes.CODIGO400:
				httpStatus = HttpStatus.BAD_REQUEST;
				break;
			case Constantes.CODIGO401:
				httpStatus = HttpStatus.UNAUTHORIZED;
				break;
			case Constantes.CODIGO403:
				httpStatus = HttpStatus.FORBIDDEN;
				break;
			case Constantes.CODIGO404:
				httpStatus = HttpStatus.NOT_FOUND;
				break;
			case Constantes.CODIGO405:
				httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
				break;
			case Constantes.CODIGO422:
				httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
				break;
			case Constantes.CODIGO500:
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
				break;
			default:
				httpStatus = HttpStatus.NOT_IMPLEMENTED;
				break;
		}
		return httpStatus;
		
	}
}
