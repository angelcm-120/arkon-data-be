/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arkondata.utils;

import lombok.Data;
import com.arkondata.utils.enums.Numeros;

import java.io.*;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import static com.arkondata.utils.Funciones.bytesToStr;

/**
 * Nombre de proyecto: mso_metrobus
 * Sistema:MSO Base
 * Arkon Data Test
 * Nombre de clase: GZip
 * Descripción:  Clase para el manejo de compresiones de cadenas o archivos en cadenas de texto
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@Data
public class GZip {
	private GZip() {
		/**
		 * No hace nada
		 */
	}

	/**
	 * compress
	 *
	 * @param str valor para str
	 *
	 * @return los byte de la compress
	 *
	 * @throws IOException Excepción
	 */
	public static byte[] compress(final String str) throws
	                                                IOException {
		if ((str == null) || (str.length() == 0)) {
			return new byte[0];
		}
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes(Constantes.ENCODING));
		gzip.flush();
		gzip.close();
		return obj.toByteArray();
	}

	/**
	 * compressToString
	 *
	 * @param str valor para str
	 *
	 * @return string
	 *
	 * @throws IOException Excepción
	 */
	public static String compressToString(final String str) throws
	                                                        IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes(Constantes.ENCODING));
		gzip.flush();
		gzip.close();
		return new String(obj.toByteArray());
	}

	/**
	 * compressToBase64
	 *
	 * @param str valor para str
	 * @param encode valor para encode
	 *
	 * @return string con la compresión en base 64
	 *
	 * @throws IOException Excepción
	 */
	public static String compressToBase64(final String str, String encode) throws
	                                                                       IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}

		if (encode == null) {
			encode = Constantes.ENCODING;
		}

		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes(encode));
		gzip.flush();
		gzip.close();
		return bytesToStr(Base64.getEncoder()
		                        .encode(obj.toByteArray()));
	}

	/**
	 * decompress
	 *
	 * @param compressed valor para compressed
	 * @param encode valor para encode
	 *
	 * @return la descompresión
	 *
	 * @throws IOException Excepción
	 */
	public static String decompress(final byte[] compressed, String encode) throws
	                                                                        IOException {

		if ((compressed == null) || (compressed.length == 0)) {
			return "";
		}

		if (encode == null) {
			encode = Constantes.ENCODING;
		}

		final StringBuilder outStr = new StringBuilder();

		if (isCompressed(compressed)) {
			final GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, encode));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				outStr.append(line);
			}
		}
		else {
			outStr.append(compressed);
		}
		return outStr.toString();
	}

	/**
	 * decompressFromBase64
	 *
	 * @param str valor para str
	 * @param encode valor para encode
	 *
	 * @return descompresión en base 64
	 *
	 * @throws IOException Excepción
	 */
	public static String decompressFromBase64(String str, String encode) throws
	                                                                     IOException {
		byte[] compressed = Base64.getDecoder()
		                          .decode(str);
		if ((compressed == null) || (compressed.length == 0)) {
			return "";
		}
		if (encode == null) {
			encode = Constantes.ENCODING;
		}

		final StringBuilder outStr = new StringBuilder();

		if (isCompressed(compressed)) {
			final GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, encode));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				outStr.append(line);
			}
		}
		else {
			outStr.append(compressed);
		}
		return outStr.toString();
	}

	/**
	 * isCompressed
	 *
	 * @param compressed valor para compressed
	 *
	 * @return valida la compresión
	 */
	public static boolean isCompressed(final byte[] compressed) {
		return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte)
			(GZIPInputStream.GZIP_MAGIC >> Numeros.OCHO.getByte()));
	}
}
