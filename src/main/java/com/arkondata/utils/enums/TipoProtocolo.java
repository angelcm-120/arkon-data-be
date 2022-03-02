package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoProtocolo *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoProtocolo {
	
	/**
	 * HTTP
	 */
	HTTP(1),
	
	/**
	 * HTTPS
	 */
	HTTPS(2);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoProtocolo
	 *
	 * @param value
	 */
	TipoProtocolo(int value) {
		this.value = value;
	}
	
	/**
	 * getByte
	 *
	 * @return
	 */
	public byte getByte() {
		return (byte) value;
	}
}
