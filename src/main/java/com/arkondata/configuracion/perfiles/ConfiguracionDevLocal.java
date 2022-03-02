package com.arkondata.configuracion.perfiles;

import com.arkondata.configuracion.Configuracion;
import com.arkondata.utils.log.Log;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.logging.Level;

import static com.arkondata.configuracion.Configuracion.getDataSource;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: ConfiguracionDevLocal
 * Descripción:  Clase para la configuración del profile DevLocal
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Configuration
@Profile({"devlocal"})
public class ConfiguracionDevLocal
	implements EnvironmentAware {
	//<editor-fold desc="Variables">

	@Autowired
	private DataSourceProperties dataSourceProperties;

	//Cambiar por tu secret psw dado de alta en rancher y descomentar para crear imagen
	@Value("${spring.datasource.paw}")
	private String paw = "";

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

	/**
	 * Función oracleDatasource utilizada para recuperar el ds utilizado para conexiones a BD relacionadas al bean:
	 * spring
	 *
	 * @return Objeto DataSource
	 */
	@Bean(name = "spring")
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource oracleDatasource() {
		try {
			dataSourceProperties.setPassword(paw);
			return getDataSource(dataSourceProperties);
		}
		catch (Exception ex) {
			var log = new Log();
			log.escribeLogMS(false, Level.INFO, "", "", "", "",
					"", ex);
			return null;
		}
	}

	/**
	 * Función dsOracle utilizada para recuperar el ds utilizado para conexiones a BD relacionadas al bean: dsOracle
	 *
	 * @return Objeto DataSource
	 */
	@Bean(name = "dsOracle")
	public DataSource dsOracle() {

		return oracleDatasource();
	}

	/**
	 * Función jdbcOracle utilizada para recuperar el JdbcTemplate utilizado para conexiones a BD relacionadas
	 * al bean: jdbcOracle
	 *
	 * @param dsOracle
	 * 	- datasource para la conexión del jdbctemplate
	 *
	 * @return Objeto DataSource
	 */
	@Bean(name = "jdbcOracle")
	@Autowired
	public JdbcTemplate jdbcOracle(
			@Qualifier("dsOracle")
					DataSource dsOracle) {
		Configuracion.setJdbcOracle(new JdbcTemplate(dsOracle));
		return Configuracion.getJdbcTemplate();
	}
//</editor-fold>
}
