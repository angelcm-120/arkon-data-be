package com.arkondata.configuracion;

import com.arkondata.utils.Cadenas;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Configuracion
 * Descripción:  Clase Configuracion se cargan los parámetros para ambiente e info de MSO
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
@Configuration
public class Configuracion
	implements EnvironmentAware {
	//<editor-fold desc="Variables">
	private static final int TIMEOUT = 5;
	@Autowired
	private static Environment ambiente;
	
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
		ambiente = environment;
	}

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: getApiArkonData
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
	/**
	 * Función getApiArkonData para obtener los valores de propiedades para la documentación de springfox swagger
	 *
	 * @return - objeto ApiArkonData
	 */
	@Bean(name = "apiArkonData")
	public static ApiArkonData getApiArkonData() {
		
		Cadenas.setCodigoApi(ambiente.getProperty("api.codigoApigee"));
		Cadenas.setCelula(ambiente.getProperty("api.direccion"),
		                                                      ambiente.getProperty("api.area"),
		                                                      ambiente.getProperty("api.app"));
		
		var apiArkonData = new ApiArkonData();
		apiArkonData.setTitle(ambiente.getProperty("api.titulo"));
		apiArkonData.setDescription(ambiente.getProperty("api.descripcion"));
		apiArkonData.setLicense(ambiente.getProperty("api.licencia"));
		apiArkonData.setLicenseUrl(ambiente.getProperty("api.licenciaUrl"));
		apiArkonData.setVersion(ambiente.getProperty("api.version"));
		var contact = new ApiArkonData.Contact();
		contact.setEmail(ambiente.getProperty("api.contacto.email"));
		contact.setName(ambiente.getProperty("api.contacto.nombre"));
		contact.setSite(ambiente.getProperty("api.contacto.sitio"));
		apiArkonData.setContact(contact);
		return apiArkonData;
	}

//</editor-fold>
}
