package com.harium.etyl.networking.protocol;

public class ProtocolUtils {
	
	public static String nextPrefix(String lastPrefix, String msg) {
		String crop = msg.substring(lastPrefix.length() + 1);
		String prefix = crop.split(" ")[0];
		return prefix;
	}
}