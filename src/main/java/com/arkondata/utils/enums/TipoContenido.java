package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoContenido *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoContenido {
	
	/**
	 * APPLICATION_JAVAARCHIVE
	 */
	APPLICATION_JAVAARCHIVE("application/java-archive"),
	
	/**
	 * APPLICATION_EDIX_12
	 */
	APPLICATION_EDIX_12("application/EDI-X12"),
	
	/**
	 * APPLICATION_EDIFACT
	 */
	APPLICATION_EDIFACT("application/EDIFACT"),
	
	/**
	 * APPLICATION_JAVASCRIPT
	 */
	APPLICATION_JAVASCRIPT("application/javascript"),
	
	/**
	 * APPLICATION_OCTETSTREAM
	 */
	APPLICATION_OCTETSTREAM("application/octet-stream"),
	
	/**
	 * APPLICATION_OGG
	 */
	APPLICATION_OGG("application/ogg"),
	
	/**
	 * APPLICATION_PDF
	 */
	APPLICATION_PDF("application/pdf"),
	
	/**
	 * APPLICATION_XHTMLXML
	 */
	APPLICATION_XHTMLXML("application/xhtml+xml"),
	
	/**
	 * APPLICATION_XSHOCKWAVEFLASH
	 */
	APPLICATION_XSHOCKWAVEFLASH("application/x-shockwave-flash"),
	
	/**
	 * APPLICATION_JSON
	 */
	APPLICATION_JSON("application/json"),
	
	/**
	 * APPLICATION_LDJSON
	 */
	APPLICATION_LDJSON("application/ld+json"),
	
	/**
	 * APPLICATION_XML
	 */
	APPLICATION_XML("application/xml"),
	
	/**
	 * APPLICATION_ZIP
	 */
	APPLICATION_ZIP("application/zip"),
	
	/**
	 * APPLICATION_X_WWW_FORM_URLENCODED
	 */
	APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
	
	/**
	 * TEXT_CSS
	 */
	TEXT_CSS("text/css"),
	
	/**
	 * TEXT_CSV
	 */
	TEXT_CSV("text/csv"),
	
	/**
	 * TEXT_HTML
	 */
	TEXT_HTML("text/html"),
	
	/**
	 * TEXT_JAVASCRIPT
	 */
	TEXT_JAVASCRIPT("text/javascript"),
	
	/**
	 * TEXT_PLAIN
	 */
	TEXT_PLAIN("text/plain"),
	
	/**
	 * TEXT_XML
	 */
	TEXT_XML("text/xml"),
	
	/**
	 * MULTIPART_MIXED
	 */
	MULTIPART_MIXED("multipart/mixed"),
	
	/**
	 * MULTIPART_ALTERNATIVE
	 */
	MULTIPART_ALTERNATIVE("multipart/alternative"),
	
	/**
	 * MULTIPART_RELATED
	 */
	MULTIPART_RELATED("multipart/related"),
	
	/**
	 * MULTIPART_FORM_DATA
	 */
	MULTIPART_FORM_DATA("multipart/form-data"),
	
	/**
	 * IMAGE_PNG
	 */
	IMAGE_PNG("image/png");
	
	/**
	 * value
	 */
	private String value;
	
	/**
	 * TipoContenido
	 *
	 * @param value
	 */
	TipoContenido(String value) {
		this.value = value;
	}
	
	/**
	 * getValue
	 *
	 * @return los bytes del valor value
	 */
	public String getValue() {
		return value;
	}
	
}
