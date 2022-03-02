package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: OrigenesCifrado *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum OrigenesCifrado {
	
	/**
	 * CLIENTE
	 */
	CLIENTE(1),
	
	/**
	 * SERVIODR
	 */
	SERVIDOR(2);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * OrigenesCifrado
	 *
	 * @param value
	 */
	OrigenesCifrado(int value) {
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
