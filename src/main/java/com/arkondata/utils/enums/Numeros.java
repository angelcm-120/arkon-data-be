package com.arkondata.utils.enums;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de Enum: Numeros *
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
public enum Numeros {
	
	/**
	 * MENOSDIEZMIL
	 */
	MENOSDIEZMIL(-10000),
	
	/**
	 * CERO
	 */
	CERO(0),
	
	/**
	 * UNO
	 */
	UNO(1),
	
	/**
	 * DOS
	 */
	DOS(2),
	
	/**
	 * TRES
	 */
	TRES(3),
	
	/**
	 * CUATRO
	 */
	CUATRO(4),
	
	/**
	 * CINCO
	 */
	CINCO(5),
	
	/**
	 * SEIS
	 */
	SEIS(6),
	
	/**
	 * SIETE
	 */
	SIETE(7),
	
	/**
	 * OCHO
	 */
	OCHO(8),
	
	/**
	 * NUEVE
	 */
	NUEVE(9),
	
	/**
	 * DIEZ
	 */
	DIEZ(10),
	
	/**
	 * ONCE
	 */
	ONCE(11),
	
	/**
	 * DOCE
	 */
	DOCE(12),
	
	/**
	 * TRECE
	 */
	TRECE(13),
	
	/**
	 * CATORCE
	 */
	CATORCE(14),
	
	/**
	 * QUINCE
	 */
	QUINCE(15),
	
	/**
	 * DIECISEIS
	 */
	DIECISEIS(16),
	
	/**
	 * DIECISIETE
	 */
	DIECISIETE(17),
	
	/**
	 * DIECIOCHO
	 */
	DIECIOCHO(18),
	
	/**
	 * DIECINUEVE
	 */
	DIECINUEVE(19),
	
	/**
	 * VEINTE
	 */
	VEINTE(20),
	
	/**
	 * MIL
	 */
	MIL(1000);
	
	/**
	 * Value
	 */
	private int value;
	
	/**
	 * AccionCifrado
	 *
	 * @param value
	 */
	Numeros(int value) {
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
