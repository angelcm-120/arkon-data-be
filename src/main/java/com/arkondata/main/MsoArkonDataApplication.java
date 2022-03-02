package com.arkondata.main;

import com.arkondata.configuracion.Configuracion;
import com.arkondata.configuracion.perfiles.ConfiguracionDev;
import com.arkondata.configuracion.perfiles.ConfiguracionDevLocal;
import com.arkondata.configuracion.perfiles.ConfiguracionInt;
import com.arkondata.configuracion.perfiles.ConfiguracionProd;
import com.arkondata.configuracion.perfiles.ConfiguracionQA;
import com.arkondata.configuracion.WebSecurityConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: MsoArkonDataApplication
 * Descripción:  Clase principal del runnable de la aplicación
 * Realiza la importación de las clases de configuración necesarias para operar con todos los profiles
 * y el de seguridad
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@SpringBootApplication
@Import(value = {ConfiguracionDevLocal.class,
	WebSecurityConfig.class,
	Configuracion.class,
	ConfiguracionDev.class,
	ConfiguracionInt.class,
	ConfiguracionQA.class,
	ConfiguracionProd.class})
@ComponentScan("com.arkondata")
public class MsoArkonDataApplication {
	public MsoArkonDataApplication(){
		//Constructor
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MsoArkonDataApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setLogStartupInfo(false);
		app.run();
	}
}
