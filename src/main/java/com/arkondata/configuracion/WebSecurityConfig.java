/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.configuracion;

import com.arkondata.utils.log.Log;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.rsocket.RSocketSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.logging.Level;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: WebSecurityConfig
 * Descripción:  Clase WebSecurityConfig para implementar la seguridad del MSO
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class, RSocketSecurityAutoConfiguration.class})
public class WebSecurityConfig
	extends WebSecurityConfigurerAdapter {
	private static final int MAX_AGE = 31_536_000;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: configure
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * Función configure - Se encarga de definir las politicas de seguridad aplicadas para el consumo de servicios en
	 * la capa de aplicación o transporte dependiendo si es
	 * consumo web o rsocket
	 *
	 * @param http
	 * 	objeto de configuración http
	 */
	@Override
	protected void configure(HttpSecurity http) {
		var metodoConfigure = Thread.currentThread()
		                            .getStackTrace()[1]
			.getMethodName();
		try {
			http
				.headers()
				.frameOptions()
				.deny()
				.xssProtection()
				.and()
				.contentSecurityPolicy("default-src 'self'");
			http.headers()
			    .httpStrictTransportSecurity()
			    .maxAgeInSeconds(MAX_AGE);
				
			http.csrf().ignoringAntMatchers("/**");	
		}
		catch (Exception ex) {
			var logConfigure = new Log();
			logConfigure.escribeLogMS(true,
			                          Level.INFO,
			                          this.getClass()
			                              .getPackageName(),
			                          metodoConfigure,
			                          "",
			                          ex.getMessage(),
			                          "Ocurrió un error en la clase de configuración",
			                          ex);
		}
		
	}
}
