package com.arkondata.controlador;

import com.arkondata.configuracion.Configuracion;
import com.arkondata.configuracion.dto.Alcaldia;
import com.arkondata.configuracion.dto.Unidades;
import com.arkondata.configuracion.dto.UnidadesResponse;
import com.arkondata.configuracion.dto.UnidadesService;
import com.arkondata.responses.Respuesta;
import com.arkondata.utils.enums.RespuestasCodigos;
import com.arkondata.utils.log.Log;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

import static com.arkondata.utils.Funciones.gsonConverter;
import static com.arkondata.utils.network.Redes.httpClientCore;


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

 */
@RestController
@Service
@Api(value = "Controlador para consultar salud de servicio")
@RequestMapping({"/v1"})
public final class UnidadesController {
//<editor-fold desc="Variables">
	@Value("${app.Url}")
	private String url;

	private String urlGeocodificacion;
	private String tokenGeocodificacion;
	private static final int TIMEOUT = 5;

	@Value("${api.titulo}")
	private String titulo;
//</editor-fold>

	//<editor-fold desc="Propiedades">
	public UnidadesController(){
		//Contsructor
		urlGeocodificacion = Configuracion.getUrlGeocodificacion();
		tokenGeocodificacion = Configuracion.getTokenGeocodificacion();
	}
	public void setURL(String url) {
		this.url = url;
	}

	private static final Log LOGGER = new Log();

	@Autowired
	private UnidadesService unidadesService;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	//</editor-fold>
//<editor-fold desc="Controladores">
	@GetMapping(value = "/unidades")
	public ResponseEntity<Respuesta> unidades() {
		var LOGGER = new Log();
		var gson = gsonConverter();
		var respuesta = new Respuesta();

		try {

			var unidades = unidadesService.getAllUnidadesDisponibles();

			if(unidades != null) {
				if(unidades.size() > 0) {
					respuesta.setRespuesta(RespuestasCodigos.CODE200);
					respuesta.setServicio(null);
					respuesta.setCodigo(null);
					respuesta.setInfo(null);

					respuesta.setResultado(getUnidadesList(unidades));

					LOGGER.escribeLogMS(true, Level.INFO, titulo, respuesta.getServicio(), "",
							gson.toJson(respuesta), "", null);
				}
				else {
					respuesta.setRespuesta(RespuestasCodigos.CODE404);
					respuesta.setMensaje("No se encontraron unidades disponibles.");
					respuesta.setResultado(null);
					respuesta.setDetalles(new ArrayList<>());
					respuesta.getDetalles().add("Estatus de unidades sin disponibilidad.");
				}
			}
			else {
				respuesta.setRespuesta(RespuestasCodigos.CODE400);
				respuesta.setMensaje("Error al realizar la consulta.");
			}

			return new ResponseEntity<>(respuesta, respuesta.getHttpStatus());
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return null;
		}
		
	}

	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: getUnidadesList
	 * Descripción: Método que genera la respuesta con la lista de unidades disponibles con ubicación getUnidadesList
	 * Detona los miembros para los datos de getUnidadesList
	 * Fecha de Modificación:2022-03-02
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 */
	private List<UnidadesResponse> getUnidadesList(List<Unidades> unidadesList) {
		List<UnidadesResponse> unidadesResponseList = new ArrayList<>();

		unidadesList.forEach((var unidad) -> {
			try {
				var geocodificacionDatosAux = httpClientCore("SSL")
						.sendAsync(HttpRequest.newBuilder()
										.uri(URI.create(urlGeocodificacion + tokenGeocodificacion + "&query=" + unidad.getGeographic_point() ))
										.GET()
										.build(),
								HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.get(TIMEOUT, TimeUnit.SECONDS);

				var alcaldia = gsonConverter().fromJson(geocodificacionDatosAux, JsonObject.class)
						.get("data")
						.getAsJsonArray().get(0).getAsJsonObject();

				unidadesResponseList.add(new UnidadesResponse(unidad.getId(), unidad.getVehicle_id(),
						unidad.getVehicle_label(), unidad.getVehicle_current_status(), unidad.getGeographic_point(),
						new Alcaldia(alcaldia.get("name").getAsString(), alcaldia.get("region").getAsString(),
								alcaldia.get("county").getAsString(), alcaldia.get("country").getAsString())));

			} catch (Exception ex) {
				LOGGER.escribeLogMS(true, Level.INFO, "", "", "", "Ubicación no válida: " + unidad.getGeographic_point(), "", null);
			}

		});
		return unidadesResponseList;
	}

//</editor-fold>

}
