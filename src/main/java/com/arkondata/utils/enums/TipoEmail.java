package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoEmail *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
public enum TipoEmail {
	
	/**
	 * PERSONAL
	 */
	PERSONAL(0),
	
	/**
	 * GRUPO
	 */
	GRUPO(1);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoEmail
	 *
	 * @param value
	 */
	TipoEmail(int value) {
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
