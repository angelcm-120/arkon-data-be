package com.arkondata.dao;

import com.arkondata.utils.db.Consultas;
import com.arkondata.utils.log.Log;
import com.arkondata.configuracion.dto.CifradoResponse;

import java.util.logging.Level;



/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: EjemploDAO
 * Descripción:  Clase de ejemplo DAO para consumo contra base de datos.
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
public class EjemploDAO {
//<editor-fold desc="Variables">
	
	private Consultas consultas;
//</editor-fold>

//<editor-fold desc="Constructor">
	
	/**
	 * Constructor EjemploDAO
	 */
	public EjemploDAO() {
	}
//</editor-fold>

//<editor-fold desc="Funciones principales">
	
	/**
	 * Función consultaEjemplo, se utiliza para realizar el consumo en DB de una consulta
	 *
	 * return CifradoResponse
	 */
	public CifradoResponse consultaEjemplo() {
		try {
			/**
			 * Cifrado
			 */
		}
		catch (Exception ex) {
			var log = new Log();
			log.escribeLogMS(false, Level.INFO, "", "", "", "", ex.getMessage(),
			                 ex);
			return null;
		}
		return null;
	}
//</editor-fold>
}
