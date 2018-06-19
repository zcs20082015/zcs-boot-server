package com.zcs.boot.server.share.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class MD5Utils {
	private static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static final String MD5Encrpytion(String source) {

		try {
			byte[] strTemp = source.getBytes("UTF-8");

			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			//mdTemp.update(strTemp);
			byte[] md = mdTemp.digest(strTemp);
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; ++i) {
				byte byte0 = md[i];
				str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
				str[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			for (int m = 0; m < str.length; ++m) {
				if ((str[m] >= 'a') && (str[m] <= 'z')) {
					str[m] = (char) (str[m] - ' ');
				}
			}
			//System.out.println("[MD5Utils] [source String]" + source);
			//System.out.println("[MD5Utils] [MD5    String]" + new String(str));
			return new String(str);
		} catch (Exception e) {
		}
		return null;
	}

	public static final String MD5Encrpytion(byte[] source) {

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(source);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; ++i) {
				byte byte0 = md[i];
				str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
				str[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			for (int m = 0; m < str.length; ++m) {
				if ((str[m] >= 'a') && (str[m] <= 'z')) {
					str[m] = (char) (str[m] - ' ');
				}
			}
			//System.out.println("[MD5Utils] [source String]" + source);
			//System.out.println("[MD5Utils] [MD5    String]" + new String(str));
			return new String(str);
		} catch (Exception e) {
		}
		return null;
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException{
		String sign_field2="";
		//System.out.println(URLEncoder.encode(sign_field2,"utf-8"));
		System.out.println(MD5Encrpytion("1BBD886460827015E5D605ED44252251"));
		//System.out.println(MD5Encrpytion("11111111"));
	}
}