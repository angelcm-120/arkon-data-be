package com.arkondata.controlador;

import com.arkondata.configuracion.Configuracion;
import com.arkondata.configuracion.dto.AlcaldiaModel;
import com.arkondata.configuracion.dto.Alcaldias.Alcaldias;
import com.arkondata.configuracion.dto.Alcaldias.AlcaldiasResponse;
import com.arkondata.configuracion.dto.Alcaldias.AlcaldiasService;
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
 * Nombre de clase: AlcaldiasController
 * Descripción:  Clase Controller del endpoint de alcaldias
 * <p>
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@RestController
@Service
@Api(value = "Controlador para consultar las alcaldias")
@RequestMapping({"/v1"})
public final class AlcaldiasController {
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
	public AlcaldiasController(){
		//Contsructor
		urlGeocodificacion = Configuracion.getUrlGeocodificacion();
		tokenGeocodificacion = Configuracion.getTokenGeocodificacion();
	}
	public void setURL(String url) {
		this.url = url;
	}

	private static final Log LOGGER = new Log();

	@Autowired
	private AlcaldiasService alcaldiasService;

	@Autowired
	private UnidadesService unidadesService;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	//</editor-fold>
//<editor-fold desc="Controladores">

	/**
	 * Nombre de método: alcaldias
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: AlcaldiasController
	 * Descripción: obtiene la lista con las alcaldias
	 * <p>
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
     *
	 * Recurso unidades
	 *
	 * @return devuelve una lista con las unidades disponibles y sus ubicaciones
	 */
	@GetMapping(value = "/alcaldias")
	public ResponseEntity<Respuesta> alcaldias() {
		var LOGGER = new Log();
		var respuesta = new Respuesta();

		try {
			var alcaldias = alcaldiasService.getAllAlcaldias();

			if (alcaldias != null) {
				if (alcaldias.size() > 0) {
					respuesta.setRespuesta(RespuestasCodigos.CODE200);
					respuesta.setServicio(null);
					respuesta.setCodigo(null);
					respuesta.setInfo(null);

					respuesta.setResultado(alcaldias);

					LOGGER.escribeLogMS(true, Level.INFO, titulo, respuesta.getServicio(), "",
							"Consulta exitosa", "", null);
				} else {
					respuesta.setRespuesta(RespuestasCodigos.CODE404);
					respuesta.setMensaje("No se encontraron alcaldias disponibles.");
					respuesta.setResultado(null);
				}
			} else {
				respuesta.setRespuesta(RespuestasCodigos.CODE400);
				respuesta.setMensaje("Error al realizar la consulta.");
			}

			return new ResponseEntity<>(respuesta, respuesta.getHttpStatus());
		} catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return null;
		}

	}

	/**
	 * Nombre de método: alcaldias
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: AlcaldiasController
	 * Descripción: obtiene la lista con las alcaldias
	 * <p>
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 *
	 * @param id valor para el id de la alcaldia
	 * @return objeto respuesta con los datos de las unidades
	 */
	@GetMapping(value = "/alcaldias/{id}")
	public ResponseEntity<Respuesta> alcaldiasUnidades(@PathVariable(required = true)
																   String id) {
		var LOGGER = new Log();
		var respuesta = new Respuesta();

		try {

			var unidades = unidadesService.getAllUnidadesDisponibles();

			if (validaId(id).isEmpty()) {
				var alcaldia = alcaldiasService.getAlcaldiaId(id);

				var geocodificacionAlcaldia = httpClientCore("SSL")
						.sendAsync(HttpRequest.newBuilder()
										.uri(URI.create(urlGeocodificacion + tokenGeocodificacion + "&location="+ alcaldia.get().getPuntos_geograficos() +"&includeRoadMetadata=true&includeNearestIntersection=true" ))
										.GET()
										.build(),
								HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.get(TIMEOUT, TimeUnit.SECONDS);

				var alcaldiaAux = gsonConverter().fromJson(geocodificacionAlcaldia, JsonObject.class)
						.get("results").getAsJsonArray()
						.get(0).getAsJsonObject()
						.get("locations").getAsJsonArray()
						.get(0).getAsJsonObject()
						.get("adminArea4").getAsString();

				respuesta.setRespuesta(RespuestasCodigos.CODE200);
				respuesta.setServicio(null);
				respuesta.setCodigo(null);
				respuesta.setInfo(null);

				respuesta = getUnidadesAlcaldiaList(unidades, alcaldiaAux, respuesta);

				LOGGER.escribeLogMS(true, Level.INFO, titulo, respuesta.getServicio(), "",
						"Consulta exitosa", "", null);
			} else {
				respuesta.setRespuesta(RespuestasCodigos.CODE400);
				respuesta.setMensaje("Error al realizar la consulta.");
			}

		} catch (Exception ex) {
			respuesta.setRespuesta(RespuestasCodigos.CODE404);
			respuesta.setMensaje("No se encontró la alcaldia.");
			respuesta.setResultado(null);

			LOGGER.escribeLogMS(false, Level.INFO, "", "", "", "", ex.getMessage(), ex);
		}
		return new ResponseEntity<>(respuesta, respuesta.getHttpStatus());

	}

	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: getUnidadesAlcaldiaList
	 * Descripción: Método que genera la respuesta con la lista de unidades disponibles de una alcaldia getUnidadesAlcaldiaList
	 * Detona los miembros para los datos de getUnidadesAlcaldiaList
	 * Fecha de Modificación:2022-03-01
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 */
	private Respuesta getUnidadesAlcaldiaList(List<Unidades> unidadesList, String alcaldiaAux, Respuesta respuesta) {
		List<UnidadesResponse> unidadesResponseList = new ArrayList<>();

		try {

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

					var alcaldiaUnidad = gsonConverter().fromJson(geocodificacionDatosAux, JsonObject.class)
							.get("results")
							.getAsJsonArray().get(0).getAsJsonObject().get("locations").getAsJsonArray().get(0).getAsJsonObject();

					if(alcaldiaAux.equals(alcaldiaUnidad.get("adminArea4").getAsString())) {
						unidadesResponseList.add(new UnidadesResponse(unidad.getId(), unidad.getVehicle_id(),
								unidad.getVehicle_label(), unidad.getVehicle_current_status(), unidad.getGeographic_point(),
								new AlcaldiaModel(alcaldiaUnidad.get("street").getAsString(), alcaldiaUnidad.get("adminArea3").getAsString(),
										alcaldiaUnidad.get("adminArea4").getAsString(), alcaldiaUnidad.get("adminArea1").getAsString())));
					}


				} catch (Exception ex) {
					LOGGER.escribeLogMS(true, Level.INFO, "", "", "", "Ubicación no válida: " + unidad.getGeographic_point(), "", null);
				}

			});

			if(!unidadesResponseList.isEmpty()) {
				respuesta.setResultado(unidadesResponseList);
			}
			else {
				respuesta.setRespuesta(RespuestasCodigos.CODE404);
				respuesta.setMensaje("No se encontraron unidades disponibles en esta alcaldía.");
				respuesta.setResultado(null);
			}
		}
		catch (Exception ex) {

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
