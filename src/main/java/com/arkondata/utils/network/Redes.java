package com.arkondata.utils.network;

import com.arkondata.utils.log.Log;

import javax.management.ObjectName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.http.HttpClient;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;

/**
* Nombre de proyecto: mso_metrobus
* Sistema:MSO Base
* Arkon Data Test
* Nombre de clase: Redes
* Descripción:  Clase utileria para el manejo de datos sobre redes
* Fecha de Modificación:2021-08-10
* Persona que modifico: MACM
* Descripción de modificación:

*/
@lombok.Generated
public class Redes {
	/**
	 * logs
	 */
	private static final Log LOGGER = new Log();
	
	/**
	 * ip
	 */
	private static String ip;
	
	/**
	 * getIP
	 *
	 * @return la IP
	 */
	public static String getIP() {
		return ip;
	}
	
	private Redes() {
		/**
		* No hace nada
		*/
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: getPuertoHttp
	* Utilizado para obtener el puerto http por el que esta operando la aplicación
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* getPuertoHttp
	*
	* @return el puerto http
	*/
	public static int getPuertoHttp() {
		try {
			return ((int) ManagementFactory.getPlatformMBeanServer()
			.getAttribute(new ObjectName(
			 "jboss.as:socket-binding-group=standard-sockets," +
			 "socket-binding=http"),
			"port")) +
			((int) ManagementFactory.getPlatformMBeanServer()
			.getAttribute(
			new ObjectName("jboss.as:socket-binding-group=standard-sockets"),
			"port-offset"));
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, null,
			"getPuertoHttp", "Ocurrió un error en getPuertoHttp", "",
			ex.getMessage(), ex);
			return 0;
		}
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: getPuertoHttps
	* Utilizado para obtener el puerto https por el que esta operando la aplicación
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* getPuertoHttps
	*
	* @return puerto https
	*/
	public static int getPuertoHttps() {
		try {
			return ((int) ManagementFactory.getPlatformMBeanServer()
			.getAttribute(new ObjectName(
			 "jboss.as:socket-binding-group=standard-sockets," +
			 "socket-binding=https"),
			"port")) +
			((int) ManagementFactory.getPlatformMBeanServer()
			.getAttribute(
			new ObjectName("jboss.as:socket-binding-group=standard-sockets"),
			"port-offset"));
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(false, Level.INFO, null,
			"getPuertoHttps", "Ocurrió un error en getPuertoHttps", "",
			ex.getMessage(), ex);
			return 0;
		}
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: cargaIP
	* Utilizado para recuperar la ip utilizada por la aplicación
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* cargaIP
	*
	* @return carga de la IP
	*/
	public static boolean cargaIP() {
		try {
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				NetworkInterface n = e.nextElement();
				Enumeration<InetAddress> ee = n.getInetAddresses();
				while (ee.hasMoreElements()) {
					InetAddress i = ee.nextElement();
					ip = i.getHostAddress();
					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "",
			               e.getMessage(), e);
			return false;
		}
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: servidoresLista
	* Utilizado para recuperar la lista de servidores admitidos
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* validaIP
	*
	* @param servidoresLista valor para lista de servidores
	*
	* @return valida la IP
	*/
	public static boolean validaIP(ArrayList<String> servidoresLista) {
		try {
			return obtenIP(servidoresLista);
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", ex.getMessage(), ex);
			return false;
		}
	}

	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de método: obtenIP
	 * Utilizado para recuperar la IP
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 *
	 * validaIP
	 *
	 * @param servidoresLista valor para lista de servidores
	 *
	 * @return la IP
	 */
	private static boolean obtenIP(ArrayList<String> servidoresLista) throws
	          SocketException {
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface n = e.nextElement();
			Enumeration<InetAddress> ee = n.getInetAddresses();
			while (ee.hasMoreElements()) {
				InetAddress i = ee.nextElement();
				if (servidoresLista.contains(i.getHostAddress())) {
					ip = i.getHostAddress();
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: trustAllCerts
	* Utilizado para autoconfiar en todos los certificados de terceros para consumos web
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* TrustManager
	*/
	private static TrustManager[] trustAllCerts = new TrustManager[]{getTrustCertificates()
	};
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: getTrustCertificates
	* Utilizado para autoconfiar en todos los certificados de terceros para consumos web
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* getTrustCertificates
	*
	* @return
	*/
	private static TrustManager getTrustCertificates() {
		return new X509TrustManager() {
		@lombok.Generated
		@Override
		public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
			try {
				xcs[0].checkValidity();
			}
			catch (Exception e) {
				throw new CertificateException("Certificate not valid or trusted. - " + e);
			}
		}
		
		@lombok.Generated
		@Override
		public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
			try {
				xcs[0].checkValidity();
			}
			catch (Exception e) {
				throw new CertificateException("Certificate not valid or trusted. - " + e);
			}
		}
		
		@lombok.Generated
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}
		};
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: httpClientCore
	* Utilizado para implementar el nuevo cliente http, constructor para informar tipo de certificado TLS o SSL
	* Persona que modifico: MACM
	* Descripción de modificación:

	*/
	/**
	* httpClientCore
	*
	* @param tipoSeguridad
	* 	(TLS|SSL)
	*
	* @return el cliente http
	*/
	public static HttpClient httpClientCore(String tipoSeguridad) {
		try {
			//tipoSeguridad SSL o TLS
			SSLContext sslContext = SSLContext.getInstance(tipoSeguridad);
			sslContext.init(null, trustAllCerts, new SecureRandom());
			final Properties props = System.getProperties();
			props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());
			// SSL context 'sc' initialised as earlier
			return HttpClient.newBuilder().sslContext(sslContext).build();
		}
		catch (Exception ex) {
			LOGGER.escribeLogMS(Boolean.FALSE, Level.INFO, "", "", "", "", "", ex);
			return null;
		}
	}
	
	/**
	* Nombre de proyecto: mso_metrobus
	* Sistema:MSO Base
	* Arkon Data Test
	* Nombre de método: httpClientCore
	* Utilizado para implementar el nuevo cliente http
	* Persona que modifico: MACM
	* Descripción de modificación:
	*
	*
	* httpClientCore
	*
	* @return cliente http
	*/
	public static HttpClient httpClientCore() {
		//tipoSeguridad SSL o TLS
		final Properties props = System.getProperties();
		props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());
		return HttpClient.newBuilder().build();
	}
}
