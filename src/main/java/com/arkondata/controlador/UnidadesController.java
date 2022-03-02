package com.arkondata.controlador;

import com.arkondata.configuracion.Configuracion;
import com.arkondata.configuracion.dto.AlcaldiaModel;
import com.arkondata.configuracion.dto.Unidades.Unidades;
import com.arkondata.configuracion.dto.Unidades.UnidadesResponse;
import com.arkondata.configuracion.dto.Unidades.UnidadesService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.arkondata.utils.Funciones.gsonConverter;
import static com.arkondata.utils.Validaciones.isNumberPositivo;
import static com.arkondata.utils.network.Redes.httpClientCore;


/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: UnidadesController
 * Descripción:  Clase Controller del endpoint de ubicaciones
 * <p>
 * Fecha de Modificación:2022-03-01
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@RestController
@Service
@Api(value = "Controlador para consultar las unidades de metrobus")
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

	/**
	 * Nombre de método: unidades
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: UnidadesController
	 * Descripción: obtiene la lista con las unidades disponibles y sus ubicaciones
	 * <p>
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	/**
	 *
	 * Recurso unidades
	 *
	 * @return devuelve una lista con las unidades disponibles y sus ubicaciones
	 */
	@GetMapping(value = "/unidades")
	public ResponseEntity<Respuesta> unidades() {
		var LOGGER = new Log();
		var respuesta = new Respuesta();

		try {

			var unidades = unidadesService.getAllUnidadesDisponibles();

			if(unidades != null) {
				if(unidades.size() > 0) {
					respuesta.setRespuesta(RespuestasCodigos.CODE200);
					respuesta.setServicio(null);
					respuesta.setCodigo(null);
					respuesta.setInfo(null);

					respuesta.setResultado(unidades);

					LOGGER.escribeLogMS(true, Level.INFO, titulo, respuesta.getServicio(), "",
							"Consulta exitosa", "", null);
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
	 * Nombre de método: /unidades/{id}
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: UnidadesController
	 * Descripción: obtiene los datos de una unidad incluyendo la ubicación actual
	 * <p>
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	/**
	 *
	 * Recurso unidades
	 *
	 * @return devuelve una lista con las unidades disponibles y sus ubicaciones
	 */
	@GetMapping(value = "/unidades/{id}")
	public ResponseEntity<Respuesta> unidadesId(@PathVariable(required = true)
															String id) {
		var LOGGER = new Log();
		var respuesta = new Respuesta();

		try {

			if(validaId(id).isEmpty()) {
				var unidad = unidadesService.getUnidadDisponibleId(id);

				if (!unidad.isEmpty()) {
					respuesta.setRespuesta(RespuestasCodigos.CODE200);
					respuesta.setServicio(null);
					respuesta.setCodigo(null);
					respuesta.setInfo(null);

					respuesta = getUnidad(unidad, respuesta);

					LOGGER.escribeLogMS(true, Level.INFO, titulo, respuesta.getServicio(), "",
							"Consulta exitosa", "", null);

				} else {
					respuesta.setRespuesta(RespuestasCodigos.CODE404);
					respuesta.setMensaje("No se encontró la unidad solicitada.");
					respuesta.setResultado(null);
					respuesta.setDetalles(new ArrayList<>());
				}
			}
			else {
				respuesta.setRespuesta(RespuestasCodigos.CODE400);
				respuesta.setMensaje("Valores inválidos.");
				respuesta.setResultado(null);
				respuesta.setDetalles(validaId(id));
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
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 */
	private List<UnidadesResponse> getUnidadesList(List<Unidades> unidadesList) {
		List<UnidadesResponse> unidadesResponseList = new ArrayList<>();

		unidadesList.forEach((var unidad) -> {
			try {
				var geocodificacionDatosAux = httpClientCore("SSL")
						.sendAsync(HttpRequest.newBuilder()
										.uri(URI.create(urlGeocodificacion + tokenGeocodificacion + "&location="+ unidad.getGeographic_point() +"&includeRoadMetadata=true&includeNearestIntersection=true" ))
										.GET()
										.build(),
								HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.get(TIMEOUT, TimeUnit.SECONDS);

				var alcaldia = gsonConverter().fromJson(geocodificacionDatosAux, JsonObject.class)
						.get("results")
						.getAsJsonArray().get(0).getAsJsonObject().get("locations").getAsJsonArray().get(0).getAsJsonObject();

				if(!alcaldia.get("adminArea4").getAsString().isEmpty() && alcaldia.get("adminArea4").getAsString() != null) {
					unidadesResponseList.add(new UnidadesResponse(unidad.getId(), unidad.getVehicle_id(),
							unidad.getVehicle_label(), unidad.getVehicle_current_status(), unidad.getGeographic_point(),
							new AlcaldiaModel(alcaldia.get("street").getAsString(), alcaldia.get("adminArea3").getAsString(),
									alcaldia.get("adminArea4").getAsString(), alcaldia.get("adminArea1").getAsString())));
				}

			} catch (Exception ex) {
				LOGGER.escribeLogMS(true, Level.INFO, "", "", "", "Ubicación no válida: " + unidad.getGeographic_point(), "", null);
			}

		});
		return unidadesResponseList;
	}

	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: getUnidad
	 * Descripción: Método que genera la respuesta con la unidad disponible con ubicación getUnidad
	 * Detona los miembros para los datos de getUnidad
	 * Fecha de Modificación:2022-03-02
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 */
	private Respuesta getUnidad(Optional<Unidades> unidad, Respuesta respuesta) {

		try {
			var geocodificacionDatosAux = httpClientCore("SSL")
					.sendAsync(HttpRequest.newBuilder()
									.uri(URI.create(urlGeocodificacion + tokenGeocodificacion + "&location="+ unidad.get().getGeographic_point() +"&includeRoadMetadata=true&includeNearestIntersection=true" ))
									.GET()
									.build(),
							HttpResponse.BodyHandlers.ofString())
					.thenApply(HttpResponse::body)
					.get(TIMEOUT, TimeUnit.SECONDS);

			var x = geocodificacionDatosAux;

			var alcaldia = gsonConverter().fromJson(geocodificacionDatosAux, JsonObject.class)
					.get("results")
					.getAsJsonArray().get(0).getAsJsonObject().get("locations").getAsJsonArray().get(0).getAsJsonObject();

			if(alcaldia.get("adminArea4").getAsString().isEmpty() || alcaldia.get("adminArea4").getAsString() == null) {
				respuesta.setRespuesta(RespuestasCodigos.CODE404);
				respuesta.setMensaje("No se encontró la ubicación de la unidad.");
				respuesta.setResultado(null);
				respuesta.setDetalles(new ArrayList<>());
				respuesta.getDetalles().add("Ubicación no válida.");
				LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "Ubicación no válida: " + unidad.get().getGeographic_point(), "", null);
			}
			else {
				respuesta.setResultado(new UnidadesResponse(unidad.get().getId(), unidad.get().getVehicle_id(),
						unidad.get().getVehicle_label(), unidad.get().getVehicle_current_status(), unidad.get().getGeographic_point(),
						new AlcaldiaModel(alcaldia.get("street").getAsString(), alcaldia.get("adminArea3").getAsString(),
								alcaldia.get("adminArea4").getAsString(), alcaldia.get("adminArea1").getAsString())));
			}


		} catch (Exception ex) {
			respuesta.setRespuesta(RespuestasCodigos.CODE404);
			respuesta.setMensaje("No se encontró la ubicación de la unidad.");
			respuesta.setResultado(null);
			respuesta.setDetalles(new ArrayList<>());
			respuesta.getDetalles().add("Ubicación no válida.");
			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "Ubicación no válida: " + unidad.get().getGeographic_point(), "", null);
		}

		return respuesta;
	}

	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: getUnidad
	 * Descripción: Método que valida que el id enviado en el request sea válido para la consulta
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 */
	private List<String> validaId(String id) {
		List<String> detalles = new ArrayList();

		if(!isNumberPositivo(id)) {
			detalles.add("El id es un valor inválido.");
		}

		return detalles;
	}

//</editor-fold>

}
