package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: Paises *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum Paises {
	
	/**
	 * MEXICO
	 */
	MEXICO(0),
	
	/**
	 * GUATEMALA
	 */
	GUATEMALA(1),
	
	/**
	 * HONDURAS
	 */
	HONDURAS(2),
	
	/**
	 * PANAMA
	 */
	PANAMA(3),
	
	/**
	 * PERU
	 */
	PERU(4),
	
	/**
	 * SALVADOR
	 */
	SALVADOR(5);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * Paises
	 *
	 * @param value
	 */
	Paises(int value) {
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
