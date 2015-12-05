package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase3
{

	@Test
	public void newLineDelimeterTest()
	{
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

}
