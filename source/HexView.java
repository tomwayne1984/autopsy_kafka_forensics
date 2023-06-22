/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forensic;

import java.util.Collections;

public class HexView {

	/**
	 * formatHexBytes
	 * Method to convert long series of bytes to a hexadecimal string
	 * representation including line breaks so it can be shown in a
	 * scrollable view.
	 */
	public static String formatHexBytes(byte[] bytes, int lineLength) {
		StringBuilder resultString = new StringBuilder();
		int i = 0;
		int distance = bytes.length - i;
		String filling = "";
		byte[] lineBuffer = new byte[lineLength];
		while (i < bytes.length) {
			if (distance < lineLength) {
				filling = String.join("", Collections.nCopies(lineLength-distance, "   "));
				lineLength = distance;
				lineBuffer = new byte[lineLength];
			}
			System.arraycopy(bytes, i, lineBuffer, 0, lineLength);
			resultString.append(bytesToHex(lineBuffer, true));
			resultString.append(filling);
			resultString.append("  |  ");
			for (int j = 0; j < lineLength; j++) {
				int val = bytes[i+j];
				if (!Character.isISOControl(val)) {
					resultString.append((char) val);
				} else {
					// Character is not convertable, just print a dot symbol
					resultString.append(".");
				}
			}
			resultString.append("\n");
			i = i + lineLength;
			distance = bytes.length - i;
		}
		return resultString.toString();
	}

	/**
	 * bytesToHex
	 * Simple Method to convert bytes to a hexadecimal string representation.
	 * The spacing parameter determines whether the representation is in
	 * consecutive or in spaced form (the latter looks like e.g. "A9 F5 6E").
	 */
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes, boolean spacing) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		if (spacing) {
			return String.valueOf(hexChars).replaceAll("(.{2})", "$1 ");
		} else {
			return String.valueOf(hexChars);
		}
	}
}