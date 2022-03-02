/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.arkondata.configuracion.Configuracion.getApiArkonData;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: SpringFoxConfig
 * Descripción:  Clase que se encarga de construir la documentación para springfox swagger
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Configuration
@Component
@EnableSwagger2
public class SpringFoxConfig {
//<editor-fold desc="Funciones principales">

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre del método: api
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
	/**
	 * Función de tipo docket para springfox swagger
	 *
	 * @return objeto de tipo Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.arkondata"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiEndPointsInfo());
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: apiEndPointsInfo
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:

	 */
	private ApiInfo apiEndPointsInfo() {
		var apiArkonData = getApiArkonData();
		return new ApiInfoBuilder().title(apiArkonData.getTitle())
		                           .description(apiArkonData.getDescription())
		                           .contact(new Contact(apiArkonData.getContact()
		                                                              .getName(),
		                                                apiArkonData.getContact()
		                                                              .getSite(),
		                                                apiArkonData.getContact()
		                                                              .getEmail()))
		                           .license(apiArkonData.getLicense())
		                           .licenseUrl(apiArkonData.getLicenseUrl())
		                           .version(apiArkonData.getVersion())
		                           .build();
	}
//</editor-fold>
}
