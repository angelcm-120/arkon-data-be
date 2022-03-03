package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoConsulta *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoConsulta {
	
	/**
	 * DB_QUERY
	 */
	DB_QUERY(1),
	
	/**
	 * DB_FUNCION
	 */
	DB_FUNCION(2);
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoConsulta
	 *
	 * @param value
	 */
	TipoConsulta(int value) {
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
