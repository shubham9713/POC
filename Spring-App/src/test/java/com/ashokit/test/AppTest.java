package com.ashokit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

	@Test
	public void test()
	{
		int a=10;
		int b=40;
		int sum=a+b;
		assertEquals(50, sum);
	}
}
