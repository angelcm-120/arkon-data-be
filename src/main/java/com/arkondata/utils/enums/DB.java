package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: DB *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:
 * OT:
 */
@lombok.Generated
public enum DB {
	
	/**
	 * DB_ORACLE
	 */
	DB_ORACLE(1),
	
	/**
	 * DB_MSQL
	 */
	DB_MSQL(2),
	
	/**
	 * DB_MONGO
	 */
	DB_MONGO(3);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * DB
	 *
	 * @param value
	 */
	DB(int value) {
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
