package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: TipoDato *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum TipoDato {
	
	/**
	 * VARCHAR
	 */
	VARCHAR(1),
	
	/**
	 * INTEGER
	 */
	INTEGER(2),
	
	/**
	 * BOOLEAN
	 */
	BOOLEAN(3),
	
	/**
	 * CHAR
	 */
	CHAR(4),
	
	/**
	 * DECIMAL
	 */
	DECIMAL(5),
	
	/**
	 * FLOAT
	 */
	FLOAT(6),
	
	/**
	 * BIT
	 */
	BIT(7),
	
	/**
	 * ORACLECURSOR
	 */
	ORACLECURSOR(8),
	
	/**
	 * BIGINT
	 */
	BIGINT(9),
	
	/**
	 * LONGVARCHAR
	 */
	LONGVARCHAR(10),
	
	/**
	 * LONGNVARCHAR
	 */
	LONGNVARCHAR(11),
	
	/**
	 * NVARCHAR
	 */
	NVARCHAR(12),
	
	/**
	 * DATE
	 */
	DATE(13),
	;
	
	
	/**
	 * value
	 */
	private int value;
	
	/**
	 * TipoDato
	 *
	 * @param value
	 */
	TipoDato(int value) {
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
