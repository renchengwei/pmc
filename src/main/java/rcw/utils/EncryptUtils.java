package rcw.utils;

import org.apache.commons.codec.binary.Base64;

public class EncryptUtils {

	public static String byte64EncodeToString(byte[] data) {
		Base64 base = new Base64();
		return base.encodeToString(data);
	}
	
	public static byte[] byte64DecodeToByteArray(byte[] data) {
		Base64 base = new Base64();
		return base.decode(data);
	}
	
	public static byte[] byte64DecodeToString(String data) {
		Base64 base = new Base64();
		return base.decode(data);
	}
	
}
