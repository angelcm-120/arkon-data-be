package com.arkondata.configuracion.perfiles;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: ConfiguracionDevLocal
 * Descripción:  Clase para la configuración del profile DevLocal
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
@Configuration
@Profile({"devlocal"})
public class ConfiguracionDevLocal
	implements EnvironmentAware {
	//<editor-fold desc="Variables">

	//</editor-fold>

	//<editor-fold desc="Constructor">
	public ConfiguracionDevLocal() {
		//Constructor
	}
	//</editor-fold>
	
	//<editor-fold desc="Funciones principales">
	/**
	 * Función setEnvironment - Utilizado para gestionar configuraciones adicionales al enviroment cargado por profile
	 *
	 * @param environment
	 * 	- Ambiente de ejecución
	 */
	@Override
	public void setEnvironment(Environment environment) {
		// No se usa actualmente en este flujo
	}
//</editor-fold>
}
