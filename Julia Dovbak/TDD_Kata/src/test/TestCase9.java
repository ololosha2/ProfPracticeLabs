package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase9
{

	@Test
	public void multipleDelimeterMultipleLengthTest()
	{
		assertEquals(6, StringCalculator.add("//[***][%%%]\n1***2%%%3"));
	}
	
	@Test
	public void multipleDelimeterMultipleLengthTest2()
	{
		assertEquals(6, StringCalculator.add("//[*@#][%&$]\n1*@#2%&$3"));
	}

}
