package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoInputOutput *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoInputOutput {
	
	/**
	 * DB_ENTRADA
	 */
	DB_ENTRADA(1),
	
	/**
	 * DB_SALIDA
	 */
	DB_SALIDA(2);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoInputOutput
	 *
	 * @param value
	 */
	TipoInputOutput(int value) {
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
