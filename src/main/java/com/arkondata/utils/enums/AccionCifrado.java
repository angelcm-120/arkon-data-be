package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: AccionCifrado *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum AccionCifrado {
	
	/**
	 * ENCRIPTAR
	 */
	ENCRIPTAR(1),
	
	/**
	 * DESENCRIPTAR
	 */
	DESENCRIPTAR(2);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * AccionCifrado
	 *
	 * @param value
	 */
	AccionCifrado(int value) {
		this.value = value;
	}
	
	/**
	 * getByte
	 *
	 * @return los bytes del valor value
	 */
	public byte getByte() {
		return (byte) value;
	}
}
