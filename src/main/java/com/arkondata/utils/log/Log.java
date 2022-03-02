package com.arkondata.utils.log;

import com.arkondata.models.log.Mensaje;
import com.arkondata.models.log.Servicio;
import com.arkondata.utils.enums.Numeros;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;
import java.util.regex.Pattern;

import static com.arkondata.utils.Constantes.SISTEMA;
import static com.arkondata.utils.Funciones.formateaFechaHora;
import static com.arkondata.utils.Funciones.gsonConverter;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Log
 * Descripción:  Clase para el manejo de logs de las aplicaciones *
 * Este logs es utilizado para guardar los archivos físicamente en los contenedores inside "application/logs" como
 * ruta default
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public class Log {
	
	/**
	 * strLog
	 */
	private static String strLog = "{\"log_data\":";
	private static final Pattern ERROR = Pattern.compile("(?i)error");
	private static final Pattern EXCEPCION = Pattern.compile("(?i)excepcion");
	private static final Pattern EXCEPTION = Pattern.compile("(?i)exception");
	private static final Pattern WARN = Pattern.compile("(?i)warn");
	
	/**
	 * startTime
	 */
	private long startTime;
	
	/**
	 * stopTime
	 */
	private long stopTime;
	
	/**
	 * logjson
	 */
	private com.arkondata.models.log.Log logjson;
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger("com.arkondata");
	
	/**
	 * file
	 */
	private static File file;
	
	/**
	 * fh
	 */
	private static FileHandler fh;
	
	
	/**
	 * XXXXX
	 */
	private static final String XXXXX = "xxxxxx";
	
	/**
	 * XXXXX
	 */
	private static final String EXSTR = "Ex";
	
	/**
	 * XXXXX
	 */
	private static final String ERSTR = "Ex";
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de constructor: Log
	 * Descripción:  Método utilizado para crear el objeto de logs
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * LOG
	 */
	public Log() {
		LOGGER.setUseParentHandlers(false);
		Logger globalLogger = Logger.getLogger("global");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}
		
		startTime = System.currentTimeMillis();
		logjson = new com.arkondata.models.log.Log();
		logjson.setServicios(new ArrayList<>());
		if (fh == null) {
			try {
				if (Objects.isNull(getFile())) {
					setFile(new File(System.getProperty("user.dir") + "/logs"));
				}
				
				if (Objects.isNull(getFileHandler())) {
					setFileHandler(new FileHandler(System.getProperty("user.dir") + "/logs/application.log", true));
					
				}
			}
			catch (IOException e) {
				Logger.getLogger("")
				      .log(Level.INFO, String.format("%s%s", strLog, depuraMensajes(e.getMessage(),
				                                                                    true)));
			}
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de constructor: Log
	 * Descripción:  Método utilizado para manipular el objeto de logs
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * Función getFile utilizada para recuperar el file de logs
	 *
	 * @return
	 */
	private static File getFile() {
		return file;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de constructor: Log
	 * Descripción:  Método utilizado para manipular el objeto de logs
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * Función setFile utilizada para setear el file de logs
	 *
	 * @param fl
	 * 	fileutilizado
	 */
	private static void setFile(File fl) {
		file = fl;
		file.mkdirs();
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de constructor: Log
	 * Descripción:  Método utilizado para manipular el objeto de logs
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * Función getFileHandler utilizada para recuperar el filehandler de logs
	 *
	 * @return filehandler
	 */
	private static FileHandler getFileHandler() {
		return fh;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de constructor: Log
	 * Descripción:  Método utilizado para manipular el objeto de logs
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * Función setFileHandler utilizada para setear el filehandler de logs
	 *
	 * @param fileHandler
	 * 	filehandlerparam
	 */
	private static void setFileHandler(FileHandler fileHandler) {
		fh = fileHandler;
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(fh); //NOSONAR
		fh.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord reg) {
				return String.format("%s%s", reg.getMessage(), "\n");
			}
		});
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: depuraMensajes
	 * Descripción:  Método utilizado para depurar mensajes con palabras especiales para logs
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * depuraMensajes
	 *
	 * @param cadena
	 * @param bRespetaCase
	 *
	 * @return
	 */
	private static String depuraMensajes(String cadena, boolean bRespetaCase) {
		if (!bRespetaCase) {
			cadena = cadena.toLowerCase()
			               .replaceAll(ERROR.pattern(), ERSTR)
			               .replaceAll(EXCEPCION.pattern(), EXSTR)
			               .replaceAll(EXCEPTION.pattern(), EXSTR)
			               .replaceAll(WARN.pattern(), XXXXX);
		}
		else {
			cadena = cadena.replace("error", ERSTR)
			               .replace("Error", ERSTR)
			               .replace("excepcion", EXSTR)
			               .replace("excepcion", EXSTR)
			               .replace("excepción", EXSTR)
			               .replace("exception", EXSTR)
			               .replace("warn", XXXXX)
			               .replace("Warn", XXXXX)
			               .replaceAll(ERROR.pattern(), ERSTR)
			               .replaceAll(EXCEPCION.pattern(), ERSTR)
			               .replaceAll(EXCEPTION.pattern(), ERSTR)
			               .replaceAll(WARN.pattern(), XXXXX);
			
		}
		return cadena;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: escribeLog
	 * Descripción:  Método utilizado para escribir mensajes en log con fix de tiempo no superior a 1 segundo
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * escribeLog
	 *
	 * @param guardaLog
	 * @param lvl
	 * @param aplicacion
	 * @param servicio
	 * @param peticion
	 * @param respuesta
	 * @param mensaje
	 * @param e
	 */
	public void escribeLog(Boolean guardaLog, Level lvl, String aplicacion, String servicio, String peticion,
	                       String respuesta, String mensaje, Exception e) {
		
		stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		if (Boolean.FALSE.equals(guardaLog)) {
			var servicioLog = new Servicio();
			servicioLog.setNombreServicio(servicio);
			servicioLog.setSistema(SISTEMA);
			servicioLog.setPeticion(peticion);
			servicioLog.setTiempo(elapsedTime / Numeros.MIL.getByte());
			logjson.getServicios()
			       .add(servicioLog);
		}
		else if (Boolean.TRUE.equals(guardaLog) && (logjson.getServicios()
		                                                   .isEmpty())) {
			logjson.setFecha(formateaFechaHora(ZonedDateTime.now()));
			
			if (peticion != null) {
				peticion = depuraMensajes(peticion, true);
			}
			if (respuesta != null) {
				respuesta = depuraMensajes(respuesta, true);
			}
			if (mensaje != null) {
				respuesta = depuraMensajes(mensaje, true);
			}
			
			if (e != null) {
				respuesta = e.getMessage();
			}
			
			logjson.getServicios()
			       .forEach((var s) -> logjson.setTiempoTotal(logjson.getTiempoTotal() + s.getTiempo()));
			
			logjson.setMensaje(new Mensaje());
			logjson.getMensaje()
			       .setPeticion(peticion);
			
			if (Objects.nonNull(e)) {
				logjson.getMensaje()
				       .setMensajes(logjson.getMensaje()
				                           .getMensajes() + e.getMessage());
			}
			logjson.getMensaje()
			       .setRespuesta(respuesta);
			logjson.setLvl(lvl);
			
			
			escribeLogger(lvl, aplicacion, depuraMensajes(strLog + gsonConverter().toJson(logjson) + "}", false));
			logjson.setServicios(new ArrayList<>());
			logjson.setTiempoTotal(0);
			logjson.setMensaje(new Mensaje());
		}
		else {
			if (Boolean.TRUE.equals(guardaLog)) {
				logjson.setFecha(formateaFechaHora(ZonedDateTime.now()));
				logjson.setMensaje(new Mensaje());
				logjson.getMensaje()
				       .setPeticion(peticion);
				if (Objects.nonNull(e)) {
					logjson.getMensaje()
					       .setMensajes(logjson.getMensaje()
					                           .getMensajes() + e.getMessage());
				}
				logjson.getMensaje()
				       .setRespuesta(respuesta);
				logjson.setLvl(lvl);
				
				
				escribeLogger(lvl, aplicacion,
				              depuraMensajes(strLog + gsonConverter().toJson(logjson) + "}", false));
			}
		}
		
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: escribeLog
	 * Descripción:  Método utilizado para escribir mensajes en log
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * escribeLogMS
	 *
	 * @param guardaLog
	 * @param lvl
	 * @param aplicacion
	 * @param servicio
	 * @param peticion
	 * @param respuesta
	 * @param mensaje
	 * @param e
	 */
	public void escribeLogMS(Boolean guardaLog, Level lvl, String aplicacion, String servicio, String peticion,
	                         String respuesta, String mensaje, Exception e) {
		
		stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		if (Boolean.FALSE.equals(guardaLog)) {
			var servicioLog = new Servicio();
			servicioLog.setNombreServicio(servicio);
			servicioLog.setSistema(SISTEMA);
			servicioLog.setPeticion(peticion);
			servicioLog.setTiempo(elapsedTime);
			logjson.getServicios()
			       .add(servicioLog);
		}
		else if (Boolean.TRUE.equals(guardaLog) && (!logjson.getServicios()
		                                                    .isEmpty())) {
			logjson.setFecha(formateaFechaHora(ZonedDateTime.now()));
			
			if (peticion != null) {
				peticion = depuraMensajes(peticion, true);
			}
			if (respuesta != null) {
				respuesta = depuraMensajes(respuesta, true);
			}
			if (mensaje != null) {
				mensaje = depuraMensajes(mensaje, true);
			}
			
			logjson.getServicios()
			       .forEach((var s) -> logjson.setTiempoTotal(logjson.getTiempoTotal() + s.getTiempo()));
			
			logjson.setMensaje(new Mensaje());
			logjson.getMensaje()
			       .setPeticion(peticion);
			logjson.getMensaje()
			       .setRespuesta(respuesta);
			logjson.setLvl(lvl);
			if (Objects.nonNull(e)) {
				logjson.getMensaje()
				       .setMensajes(logjson.getMensaje()
				                           .getMensajes() + e.getMessage());
			}
			logjson.getMensaje()
			       .setMensajes(mensaje);
			
			escribeLogger(lvl, aplicacion, depuraMensajes(strLog + gsonConverter().toJson(logjson) + "}", true));
			logjson.setServicios(new ArrayList<>());
			logjson.setMensaje(new Mensaje());
		}
		else if (Boolean.TRUE.equals(guardaLog)) {
			logjson.setFecha(formateaFechaHora(ZonedDateTime.now()));
			logjson.setMensaje(new Mensaje());
			logjson.getMensaje()
			       .setPeticion(peticion);
			logjson.getMensaje()
			       .setRespuesta(respuesta);
			logjson.setLvl(lvl);
			
			escribeLogger(lvl, aplicacion, depuraMensajes(strLog + gsonConverter().toJson(logjson) + "}", true));
		}
		else {
			escribeLogger(lvl, aplicacion, depuraMensajes(strLog + gsonConverter().toJson(logjson) + "}", true));
		}
		
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: escribeLog
	 * Descripción:  Método utilizado para escribir mensajes en log
	 * Fecha de Modificación:2021-08-10
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	/**
	 * escribeLogger función utilizada para enviar a escribir en logger consola y archivo el mensaje enviado por app
	 * @param lvl nidel de criticidad
	 * @param aplicacion  nombre de la aplicación
	 * @param mensaje mensaje a escribir
	 */
	private static void escribeLogger(Level lvl, String aplicacion, String mensaje) {
		mensaje = mensaje.replace("lvl", "Level").replace("mensaje","Mensaje").replace("tiempoTotal",
		                                                                                       "TiempoTotal");
		Logger.getLogger(aplicacion.trim())
		      .log(lvl, mensaje);
		
		if (lvl.equals(Level.INFO)){
			LOGGER.info(mensaje);
		}else if (lvl.equals(Level.WARNING)){
			LOGGER.warning(mensaje);
		}else if (lvl.equals(Level.SEVERE)){
			LOGGER.severe(mensaje);
		}
		else{
			LOGGER.info(mensaje);
		}
		
	}
	
}
