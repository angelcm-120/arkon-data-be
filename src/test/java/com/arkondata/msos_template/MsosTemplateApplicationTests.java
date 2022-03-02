package com.arkondata.msos_template;

import jdk.jfr.Name;
import com.arkondata.configuracion.ApiArkonData;
import com.arkondata.configuracion.Configuracion;
import com.arkondata.configuracion.WebSecurityConfig;
import com.arkondata.configuracion.perfiles.ConfiguracionDev;
import com.arkondata.configuracion.perfiles.ConfiguracionDevLocal;
import com.arkondata.configuracion.perfiles.ConfiguracionInt;
import com.arkondata.configuracion.perfiles.ConfiguracionProd;
import com.arkondata.configuracion.perfiles.ConfiguracionQA;
import com.arkondata.controlador.EstatusController;
import com.arkondata.seguridad.SecurityUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: MsoArkonDataApplicationTests
 * Descripción:  Clase para pruebas unitarias
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@Import(value = {ConfiguracionDevLocal.class,
	WebSecurityConfig.class,
	Configuracion.class,
	ConfiguracionDev.class,
	ConfiguracionInt.class,
	ConfiguracionQA.class,
	ConfiguracionProd.class})
@ComponentScan("com.arkondata")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = MsoArkonDataApplicationTests.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MsoArkonDataApplicationTests {
//<editor-fold desc="Variables">
	/**
	 * Definición de variables que serán utilizadas a traves de todas las pruebas unitarias
	 */
	private static final String EXITO = "Éxito";
	private static final String ERROR = "Error";
	private static final String URL = "http://test.com";

//</editor-fold>
	
	//<editor-fold desc="Constructor">
	public MsoArkonDataApplicationTests(){
		//Constructor
	}
	//</editor-fold>
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: initAll
	 * Descripción: Función initAll Utilizado para establecer configuraciones antes de la ejecución de cualquiera
	 * de las pruebas unitarias.
	 * Establece el jdbctemplate que será utilizado.
	 * por lo que para poder validar los servicios relacionados a dao o los controladores, se recupera un ds y se
	 * setea para poder ejecutar las pruebas unitarias.
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	@BeforeAll
	void initAll() {

	}

//<editor-fold desc="Test">
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: estatusTest
	 * Descripción: Test - estatusTest - Ejecuta el controlador de Estatus
	 * Se espera que la respuesta de consumo sea un código 200 http
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	@Name("estatusTest")
	@Order(1)
	@Test
	void estatusTest() {
		String metodo = Thread.currentThread()
		                      .getStackTrace()[1]
			.getMethodName();
		
		EstatusController estatusController = new EstatusController();
		estatusController.setURL("");
		estatusController.setTitulo(metodo);
		var respuesta = estatusController.estatus();
		if (Objects.nonNull(respuesta)) {
			assertEquals(true, respuesta.toString()
			                            .contains("200"), EXITO);
		}
		else {
			fail(ERROR);
		}
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: estatusTest
	 * Descripción: Test - apiArkonDataTest - Prueba el modelo de ApiArkonDataTest
	 * Espera que la creación del objeto no genere error y que contact sea null por como fue creado.
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	@Name("apiArkonDataTest")
	@Order(3)
	@Test
	void apiArkonDataTest() {
		String metodo = Thread.currentThread()
		                      .getStackTrace()[1]
			.getMethodName();
		
		ApiArkonData apiArkonData = new ApiArkonData();
		apiArkonData.setContact(null);
		apiArkonData.setDescription(null);
		apiArkonData.setLicense(null);
		apiArkonData.setLicenseUrl(null);
		apiArkonData.setNamespace(null);
		apiArkonData.setTitle(metodo);
		apiArkonData.setDescription(null);
		assertEquals(true, !Objects.nonNull(apiArkonData.getContact()), EXITO);
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre del método: secureUtilTest
	 * Descripción: Test - apiArkonDataTest - Prueba el modelo de secureUtilTest
	 * Espera que la creación del objeto no genere error y que contact sea null por como fue creado.
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * OT:
	 */
	@Name("secureUtilTest")
	@Order(4)
	@Test
	void secureUtilTest() {
		assertEquals(true, SecurityUtil.cleanIt(URL).equals(URL), EXITO);
		assertEquals(true, !SecurityUtil.cleanIt(ERROR).equals(URL), EXITO);
		assertEquals(true, Objects.isNull(SecurityUtil.cleanIt(null)), EXITO);
		
		assertEquals(true, SecurityUtil.cleanItStr(ERROR).equals(ERROR), EXITO);
		assertEquals(true, Objects.isNull(SecurityUtil.cleanItStr(null)), EXITO);
	}


//<editor-fold desc="Test">

}
