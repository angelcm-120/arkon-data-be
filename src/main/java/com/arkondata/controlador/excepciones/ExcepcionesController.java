package com.arkondata.controlador.excepciones;

import com.arkondata.responses.Respuesta;
import com.arkondata.utils.enums.RespuestasCodigos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: ExcepcionesController
 * Descripción:  Clase que controla las excepciones
 *
 * Fecha de Modificación:2021-08-18
 * Persona que modifico: EMORA
 * Descripción de modificación:

 */
@lombok.Generated
@ControllerAdvice
public class ExcepcionesController {
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: handleAllExceptions
	 * Descripción: Método que controla cualquier excepcion
	 *
	 * Fecha de Modificación:2021-08-18
	 * Persona que modifico: EMORA
	 * Descripción de modificación:
	 */
	/**
	 * Función handleAllExceptions para el manejo de excepciones no controladas
	 * @param ex - Excepción que se atrapa y reportará en estructura estandar de respuesta
	 * @return Respuesta como objeto de un resultado de una excepción no controlada
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Respuesta> handleAllExceptions(Throwable ex) {
		
		Respuesta respuesta = new Respuesta();
		
		List<String> listDetalles = new ArrayList<>();
		listDetalles.add(ex.getMessage());
		
		respuesta.setRespuesta(RespuestasCodigos.CODE400);
		respuesta.setDetalles(listDetalles);
		
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
}


