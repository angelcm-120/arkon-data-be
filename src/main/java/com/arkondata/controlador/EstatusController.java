package com.arkondata.controlador;

import io.swagger.annotations.Api;
import com.arkondata.responses.Respuesta;
import com.arkondata.utils.enums.RespuestasCodigos;
import com.arkondata.utils.log.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;

import static com.arkondata.utils.Funciones.gsonConverter;


/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: EstatusController
 * Descripción:  Clase Controller del endpoint de estatus
 * <p>
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@RestController
@Service
@Api(value = "Controlador para consultar salud de servicio")
@RequestMapping({"/monitoreo"})
public final class EstatusController {
//<editor-fold desc="Variables">
	@Value("${app.Url}")
	private String url;
	
	@Value("${api.titulo}")
	private String titulo;
//</editor-fold>
	
	//<editor-fold desc="Propiedades">
	public EstatusController(){
		//Contsructor
	}
	public void setURL(String url) {
		this.url = url;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	//</editor-fold>
//<editor-fold desc="Controladores">
	@GetMapping(value = "/estatus/v1")
	public ResponseEntity<Respuesta> estatus() {
		var log = new Log();
		var gson = gsonConverter();
		
		var respuesta = new Respuesta();
		respuesta.setRespuesta(RespuestasCodigos.CODE200);
		respuesta.setServicio(null);
		respuesta.setCodigo(null);
		respuesta.setInfo(null);
		
		
		log.escribeLogMS(true, Level.INFO, titulo, respuesta.getServicio(), "",
		                 gson.toJson(respuesta), "", null);
		
		return new ResponseEntity<>(respuesta, respuesta.getHttpStatus());
		
	}

//</editor-fold>

}
