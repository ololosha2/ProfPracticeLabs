package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase8
{

	@Test
	public void multipleDelimeterTest()
	{
		assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void multipleDelimeterTest2()
	{
		assertEquals(10, StringCalculator.add("//[*][%][@]\n1*2%3@4"));
	}

}
