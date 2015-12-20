package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase4
{

	@Test
	public void customSemicolonDelimeterTest()
	{
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	@Test
	public void customAtSymbolDelimeterTest()
	{
		assertEquals(3, StringCalculator.add("//@\n1@2"));
	}

}
