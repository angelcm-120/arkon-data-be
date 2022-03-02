package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoMapas *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoMapas {
	
	/**
	 * GOOGLE
	 */
	GOOGLE(1),
	
	/**
	 * OPENSTREET
	 */
	OPENSTREET(2),
	
	/**
	 * BANCOAZTECA
	 */
	BANCOAZTECA(3),
	
	/**
	 * MT0GOOGLE
	 */
	MT0GOOGLE(4),
	
	/**
	 * MT1GOOGLE
	 */
	MT1GOOGLE(5);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoMapas
	 *
	 * @param value
	 */
	TipoMapas(int value) {
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
