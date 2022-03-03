package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: Pais *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum Pais {
	
	/**
	 * MEXICO
	 */
	MEXICO(1),
	
	/**
	 * GUATEMALA
	 */
	GUATEMALA(2),
	
	/**
	 * HONDURAS
	 */
	HONDURAS(4),
	
	/**
	 * PERU
	 */
	PERU(6),
	
	/**
	 * PANAMA
	 */
	PANAMA(7),
	
	/**
	 * SALVADOR
	 */
	SALVADOR(8),
	
	/**
	 * ARGENTINA
	 */
	ARGENTINA(9),
	
	/**
	 * BRASIL
	 */
	BRASIL(11),
	
	/**
	 * COLOMBIA
	 */
	COLOMBIA(13);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * Pais
	 *
	 * @param value
	 */
	Pais(int value) {
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
	
	/**
	 * getValue
	 *
	 * @return valor de value
	 */
	public int getValue() {
		return value;
	}
}
