package com.arkondata.configuracion;

import com.arkondata.utils.Cadenas;
import com.arkondata.utils.log.Log;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: Configuracion
 * Descripción:  Clase Configuracion se cargan los parámetros para ambiente e info de MSO
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Configuration
public class Configuracion
	implements EnvironmentAware {
	//<editor-fold desc="Variables">
	private static final int TIMEOUT = 5;
	@Autowired
	private static Environment ambiente;

	private static JdbcTemplate jdbcOracle;
	
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

	/**
	 * Función getDataSource - Función dsOracle utilizada para recuperar el ds utilizado para conexiones a BD
	 *
	 * @param user
	 * 	- usuario de la db
	 * @param pass
	 * 	- pwd de la db
	 * @param urlDB
	 * 	- urlcnx de la db
	 *
	 * @return Objeto datasource
	 *
	 * @throws SQLException
	 * 	Puede generar una SQLException
	 */
	public static DataSource getDataSource(String user, String pass, String urlDB) throws
			SQLException {
		var dsProd = new OracleDataSource();
		dsProd.setUser(user);
		dsProd.setPassword(pass);
		dsProd.setLoginTimeout(TIMEOUT);
		dsProd.setURL(urlDB);
		dsProd.setImplicitCachingEnabled(true);
		dsProd.setFastConnectionFailoverEnabled(true);
		return dsProd;
	}

	/**
	 * Función getDataSource - Función dsOracle utilizada para recuperar el ds utilizado para conexiones a BD
	 *
	 * @param dataSourceProperties
	 * 	- ds propoperties de la db
	 *
	 * @return Objeto datasource
	 */
	public static DataSource getDataSource(DataSourceProperties dataSourceProperties) {
		return DataSourceBuilder
				.create(dataSourceProperties.getClassLoader())
				.driverClassName(dataSourceProperties.getDriverClassName())
				.url(dataSourceProperties.getUrl())
				.username(dataSourceProperties.getUsername())
				.password(dataSourceProperties.getPassword())
				.build();
	}

	/**
	 * Función getDataSource - Función dsOracle utilizada para recuperar el ds utilizado para conexiones a BD
	 *
	 * @param dataSourceProperties
	 * 	- ds propoperties de la db
	 * @param user
	 * 	- usuario de la db
	 * @param pass
	 * 	- pwd de la db
	 * @param urlDB
	 * 	- urlcnx de la db
	 *
	 * @return Objeto datasource
	 */
	public static DataSource getDataSource(DataSourceProperties dataSourceProperties,
										   String user, String pass, String urlDB) {
		var log = new Log();
		log.escribeLog(true, Level.INFO, "", "getDataSource", "", "",
				String.format("usr: %s | pd: %s | cnx: %s", user, pass, urlDB),
				null);
		return DataSourceBuilder
				.create(dataSourceProperties.getClassLoader())
				.driverClassName(dataSourceProperties.getDriverClassName())
				.url(urlDB)
				.username(user)
				.password(pass)
				.build();
	}

	/**
	 * Función setJdbcOracle - Utilizado para establecer por fuera del proceso inicial de configuración
	 * un nuevo jdbctemplate
	 *
	 * @param jdbc
	 * 	- JdbcTemplate
	 */
	public static void setJdbcOracle(JdbcTemplate jdbc) {
		jdbcOracle = jdbc;
	}

	/**
	 * Función getUrlZonificacion - Utilizada para recuperar la url de Geocodificación
	 * @return URL de consumo de servicio
	 */
	public static String getUrlGeocodificacion(){
		return ambiente.getProperty("app.url.geocodificacion");
	}

	/**
	 * Función getUrlZonificacion - Utilizada para recuperar el token de Geocodificación
	 * @return URL de consumo de servicio
	 */
	public static String getTokenGeocodificacion(){
		return ambiente.getProperty("app.access.token.geocodificacion");
	}

	/**
	 * Función getJdbcTemplate - Utilizado para recuperar objeto jdbctemplate
	 * un nuevo jdbctemplate
	 *
	 * @return Objeto getJdbcTemplate
	 */
	public static JdbcTemplate getJdbcTemplate() {
		return jdbcOracle;
	}
//</editor-fold>
}
