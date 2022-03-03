package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoReinicioValor *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoReinicioValor {
	
	/**
	 * OPERADOR
	 */
	OPERADOR(1),
	
	/**
	 * NEGOCIO
	 */
	NEGOCIO(2),
	
	/**
	 * MOVILES
	 */
	MOVILES(3);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoReinicioValor
	 *
	 * @param value
	 */
	TipoReinicioValor(int value) {
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
