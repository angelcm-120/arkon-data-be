/**
 * This package has non null parameters and is documented.
 **/
package com.arkondata.seguridad;

import com.arkondata.responses.Respuesta;
import com.arkondata.utils.Cadenas;
import com.arkondata.utils.Constantes;
import com.arkondata.utils.enums.RespuestasCodigos;
import com.arkondata.utils.log.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;

import static com.arkondata.utils.Constantes.ENCODING;
import static com.arkondata.utils.Funciones.gsonConverter;
import static com.arkondata.utils.Funciones.urlValidator;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: JWTFilter
 * Descripción:  Clase para el middleware de seguridad de filtro por microcélulas
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
@Component
@WebFilter(urlPatterns = {"/V1/*"})
public class JWTFilter
	implements Filter {
//<editor-fold desc="Variables">
	
	@Value("${app.magicword}")
	private String magicword= Constantes.TOKENLOCAL;
	private String cspl = "Content-Security-Policy";
	private String csplVal = "default-src 'self'";
	private String xfops = "X-Frame-Options";
	private String cType = "application/json";
	private String deny = "DENY";
	private String token = "x-token";
	private String cors = "Access-Control-Allow-Origin";
	private String origin = "Origin";
	
	private String ct = "Expect-CT";
	private String max = "max-age=3600, enforce";
	//</editor-fold>
//<editor-fold desc="Funciones principales">
	public JWTFilter() {
		//Constructor
	}
	
	/**
	 * Función init utilizada para establecer y configurar valores iniciales que podrian ser tomados para doFilter
	 *
	 * @param filterConfig
	 * 	- Filtro de configuración
	 *
	 * @throws ServletException
	 * 	- Puede generar un ServletException
	 */
	@Override
	public void init(final FilterConfig filterConfig) throws
	                                                  ServletException {
		//no hace nada
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: doFilter
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función doFilter - Ejecuta la revisión del filtro sobre request y response antes de que esta llegue a algun
	 * controlador
	 *
	 * @param req
	 * 	- ServletRequest
	 * @param res
	 * 	- ServletResponse
	 * @param chain
	 * 	- FilterChain
	 *
	 * @throws IOException
	 * 	- Puede generar una IOException
	 * @throws ServletException
	 * 	- Puede generar una ServletException
	 */
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res,
	                     final FilterChain chain) throws
	                                              IOException,
	                                              ServletException {
		
		
		final HttpServletRequest request = (HttpServletRequest) req;
		if (validaExclusiones(request)) {
			chain.doFilter(req, res);
			return;
		}
		HttpServletResponse response = responseIsSecure(req, res);
		response.addHeader(ct,max);
		if (HttpMethod.OPTIONS.toString()
		                      .equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		}
		else {
			var respuestaJwtFilter = new Respuesta();
			final String authHeader =SecurityUtil.cleanItStr( request.getHeader(token));
			if (authHeader != null && !authHeader.startsWith(magicword)) {
				final var token2 = authHeader.substring(7);
				validaTokenJWT(response, token2, respuestaJwtFilter);
			}
			final var gson = gsonConverter();
			if (authHeader == null || (!authHeader.startsWith(magicword))) {
				respuestaJwtFilter.setDetalles(new ArrayList<>());
				respuestaJwtFilter.getDetalles()
				                  .add(Cadenas.MSJ_TOKEN_INVALIDO);
				respuestaJwtFilter.setRespuesta(RespuestasCodigos.CODE401);
				respuestaJwtFilter.setHttpStatus(null);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.addHeader(cspl, csplVal);
				response.addHeader(xfops, deny);
				response.setContentType(cType);
				response.getWriter()
				        .write(gson.toJson(respuestaJwtFilter));
				response.getWriter()
				        .flush();
				response.getWriter()
				        .close();
				return;
			}
			
			ejecutaFiltro(req, res, chain, response, respuestaJwtFilter);
			
		}
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: validaTokenJWT
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función validaTokenJWT - Utilizado para validar el contenido del token JWT
	 *
	 * @param response
	 * 	- HttpServletResponse
	 * @param token
	 * 	- Cadena Token JWT
	 * @param respuestaJwtFilter
	 * 	- Objeto Respuesta
	 *
	 * @throws IOException
	 * 	- Puede generar una IOException
	 */
	private void validaTokenJWT(HttpServletResponse response,
	                            String token,
	                            Respuesta respuestaJwtFilter
	                           ) throws
	                             IOException {
		
		try {
			
			final var claims = com.arkondata.utils.Funciones.validateToken(token);
			
			var epoch = Long.parseLong(claims.get("exp")
			                                 .toString());
			var instant = Instant.ofEpochSecond(epoch);
			
			var formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			
			var expiracion = LocalDate.parse(formatter.parse(instant.toString()
			                                                        .replace("T", " ")
			                                                        .replace("z", ""))
			                                          .toString());
			
			var actual = LocalDate.now();
			
			if (actual.isAfter(expiracion)) {
				respuestaJwtFilter.setDetalles(new ArrayList<>());
				respuestaJwtFilter.getDetalles()
				                  .add(Cadenas.MSJ_TOKEN_EXPIRADO);
				respuestaJwtFilter.setRespuesta(RespuestasCodigos.CODE401, null);
				respuestaJwtFilter.setHttpStatus(null);
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.addHeader(cspl, csplVal);
				response.addHeader(xfops, deny);
				response.setContentType(cType);
				response.getWriter()
				        .write(gsonConverter().toJson(respuestaJwtFilter));
				response.getWriter()
				        .flush();
				response.getWriter()
				        .close();
			}
		}
		catch (final Exception ex) {
			var logex = new Log();
			logex.escribeLog(Boolean.FALSE, Level.INFO, "", "", "",
			                 "", ex.getMessage(), ex);
			respuestaJwtFilter.setDetalles(new ArrayList<>());
			respuestaJwtFilter.getDetalles()
			                  .add(Cadenas.MSJ_TOKEN_INVALIDO);
			respuestaJwtFilter.setRespuesta(RespuestasCodigos.CODE401, null);
			respuestaJwtFilter.setHttpStatus(null);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
			response.addHeader(cspl, csplVal);
			response.addHeader(xfops, deny);
			
			response.setContentType(cType);
			response.getWriter()
			        .write(gsonConverter().toJson(respuestaJwtFilter));
			response.getWriter()
			        .flush();
			response.getWriter()
			        .close();
			
			
		}
	}
	
/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: ejecutaFiltro
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función ejecutaFiltro - Se encarga de detonar el chain.dofilter, este médoto permite la ejecución hacia el
	 * controlador
	 *
	 * @param req
	 * 	- ServletRequest
	 * @param res
	 * 	- ServletResponse
	 * @param chain
	 * 	- FilterChain
	 * @param response
	 * 	- HttpServletResponse
	 * @param respuesta
	 * 	- Respuesta
	 */
	private void ejecutaFiltro(final ServletRequest req, final ServletResponse res, final FilterChain chain,
	                           HttpServletResponse response, Respuesta respuesta) {
		var respuestaJwtFilter = respuesta;
		try {
			final HttpServletRequest request = (HttpServletRequest) req;
			final String hcors = SecurityUtil.cleanIt(request.getHeader(origin));
			if (Objects.nonNull(hcors) && urlValidator(hcors)) {
				HttpServletResponse res2 = responseIsSecure(req, response);
				res2.addHeader(cors, hcors);
				res2.setCharacterEncoding(ENCODING);
				chain.doFilter(req, res2);
			}
			else {
				res.setCharacterEncoding(ENCODING);
				chain.doFilter(req, res);
			}
		}
		catch (Exception ex) {
			var logex = new Log();
			logex.escribeLog(Boolean.FALSE, Level.INFO, "", "", "",
			                 "", ex.getMessage(), ex);
			respuestaJwtFilter = new Respuesta();
			respuestaJwtFilter.setRespuesta(RespuestasCodigos.CODE500);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.addHeader(cspl, csplVal);
			response.addHeader(xfops, deny);
			response.setContentType(cType);
			try {
				response.getWriter()
				        .write(gsonConverter().toJson(respuestaJwtFilter));
				response.getWriter()
				        .flush();
				response.getWriter()
				        .close();
			}
			catch (Exception ex2) {
				logex.escribeLog(Boolean.FALSE, Level.INFO, "", "", "",
				                 "", ex2.getMessage(), ex2);
			}
			
		}
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: destroy
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función destroy - Se debe de utilizar para destruir objetos creados durante la ejecución de esta clase
	 */
	@Override
	public void destroy() {
		//no hace nada
	}
//</editor-fold>

//<editor-fold desc="Funciones secundarias">

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: responseIsSecure
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función responseIsSecure - Se utiliza para agregar al header el Strict-Transport-Security
	 *
	 * @param req
	 * 	- ServletRequest
	 * @param res
	 * 	- ServletResponse
	 *
	 * @return HttpServletResponse
	 */
	private HttpServletResponse responseIsSecure(final ServletRequest req, final ServletResponse res) {
		final HttpServletResponse response = (HttpServletResponse) res;
		if (req.isSecure()) {
			response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
		}
		return response;
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: validaExclusiones
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función validaExclusiones - Se utiliza para agregar exclusiones de ejecución en este filtro.
	 *
	 * @param request
	 * 	- HttpServletRequest
	 *
	 * @return permite pasar de largo este filtro
	 */
	private boolean validaExclusiones(HttpServletRequest request) {
		if (request instanceof HttpServletRequest) {
			var url = request.getRequestURL()
			                 .toString();
			if (url.contains("actuator") || url.contains("v1") || url.contains("monitoreo")) {
				return true;
			}
		}
		return false;
	}
//</editor-fold>
}
