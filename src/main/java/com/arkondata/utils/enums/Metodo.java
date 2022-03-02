package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: Metodo *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
public enum Metodo {
	
	/**
	 * GET
	 */
	GET(1),
	
	/**
	 * POST
	 */
	POST(2);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * Metodo
	 *
	 * @param value
	 */
	Metodo(int value) {
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
