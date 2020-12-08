package com.shubham.test;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shubham.EncoderDecoderUtil;

public class EncoderDecoderUtilTest {

	private static EncoderDecoderUtil util=null;
	
	@BeforeClass
	public static void init()
	{
		util=new EncoderDecoderUtil();
	}
	
	@Test
	public void encodeStringTest()
	{
		String encodedString=util.encodeString("shubham");
		System.out.println("encoded="+encodedString);
		assertNotNull(encodedString);
	}
	@Test
	public void decodeStringTest()
	{
		String decodedString=util.decodeString("c2h1YmhhbQ==");
		System.out.println("decoded="+decodedString);
		assertNotNull(decodedString);
	}
	
	
	@AfterClass
	public static void destroy()
	{
		util=null;
	}
}
