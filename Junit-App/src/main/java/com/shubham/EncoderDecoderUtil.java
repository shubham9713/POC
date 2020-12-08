package com.shubham;

import java.util.Base64;

public class EncoderDecoderUtil {

	public String encodeString(String text)
	{
		String encodeToString= Base64.getEncoder().encodeToString(text.getBytes());
		return encodeToString;
	}
	
	public String decodeString(String encodedStr)
	{
		byte[] byteArray=Base64.getDecoder().decode(encodedStr);
		
		return new String(byteArray);
	}
}
