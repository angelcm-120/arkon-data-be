/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.configuracion;

import lombok.Data;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: ApiArkonData
 * Descripción:  Clase modelo para la implementación y generación de documento consumo con springfox swagger
 * Fecha de Modificación:2021-05-20
 * Persona que modifico: MACM
 * Descripción de modificación:
 * Esta clase normalmente no sera modificada a no ser que quieran incluir datos adicionales en la documentación
 * que se genera de forma automática por springfox swagger
 * Si es necesario se puede eliminar toda la clase y remover la dependencia del build.gradle, se deberá de remover
 * tambien la clase de SpringFoxConfig
 * OT:
 */
@lombok.Generated
@Data
public class ApiArkonData {
	//<editor-fold desc="Variables">
	/**
	 * Definición de variables que serán utilizadas a traves de todas las pruebas unitarias
	 */
	private String title = "";
	private String description = "";
	private String license = "";
	private String licenseUrl = "";
	private String version = "";
	private Contact contact = new Contact();
	private String namespace = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	/**
	 * Nombre de proyecto: mso_metrobus
	 * Sistema:MSO Base
	 * Arkon Data Test
	 * Nombre de clase: Contact
	 * Descripción:  Clase modelo para contener datos de contacto
	 * Fecha de Modificación:2021-05-20
	 * Persona que modifico: MACM
	 * Descripción de modificación:
	 * Esta clase normalmente no sera modificada a no ser que quieran incluir datos adicionales en la documentación
	 * que se genera de forma automática por springfox swagger
	 * OT:
	 */
	@lombok.Generated
	public static class Contact {
		/**
		 * Definición de variables que serán utilizadas a traves de todas las pruebas unitarias
		 */
		private String name = "";
		private String site = "";
		private String email = "";

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}
	//</editor-fold>
}
