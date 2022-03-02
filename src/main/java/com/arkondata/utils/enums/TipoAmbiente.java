package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoAmbiente *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
public enum TipoAmbiente {
	
	/**
	 * DESARROLLO
	 */
	DESARROLLO(1),
	
	/**
	 * PRODUCTIVOEXT
	 */
	PRODUCTIVOEXT(2),
	
	/**
	 * PRODUCTIVOINT
	 */
	PRODUCTIVOINT(3);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoAmbiente
	 *
	 * @param value
	 */
	TipoAmbiente(int value) {
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
