package com.shubham.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.shubham.Calculator;

public class CalculatorTest {

  private static Calculator c=null;
	
	@BeforeClass
	public static void init()
	{
		c=new Calculator();
	}
	
	@Test
	public void addTest()
	{

		Integer actual=c.add(10, 30);
		Integer expected=40;
		
		assertEquals(expected, actual);
	}

	@Test
	public void multTest()
	{
	
		Integer actual=c.mult(2, 5);
		Integer expected=10;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void divTest()
	{
		
		Integer actual=c.div(10, 5);
		Integer expected=2;
		assertEquals(expected, actual);
	}

	@Ignore
	@Test(expected = ArithmeticException.class)
	public void divTest1()
	{
		
		c.div(10, 0);
		
	}
	@AfterClass
	public static void destroy()
	{
		c=null;
	}
	
}
