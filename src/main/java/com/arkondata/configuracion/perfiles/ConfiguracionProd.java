package com.arkondata.configuracion.perfiles;

import com.arkondata.utils.log.Log;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.logging.Level;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: ConfiguracionProd
 * Descripción:  Clase para la configuración del profile Prod
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Configuration
@Profile({"prod"})
public class ConfiguracionProd
	implements EnvironmentAware {
//<editor-fold desc="Variables">

//</editor-fold>

//<editor-fold desc="Funciones principales">
	public ConfiguracionProd(){
		//Constructor
	}
	/**
	 * Función setEnvironment - Utilizado para gestionar configuraciones adicionales al enviroment cargado por profile
	 *
	 * @param environment
	 * 	- Ambiente de ejecución
	 */
	@Override
	public void setEnvironment(Environment environment) {
		// No se usa actualmente en este flujo
		var log = new Log();
		log.escribeLogMS(false, Level.INFO, "", "", "", "",
		                 "", null);
		
	}

//</editor-fold>
}
