package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.NegativeNumbersException;
import calc.StringCalculator;

public class TestCase5
{
	
	@Test(expected=NegativeNumbersException.class)
	public void exceptionOnlyTest()
	{
		StringCalculator.add("-1,2,-3");
	}

	@Test
	public void exceptionOutputTest()
	{
		try
		{
			StringCalculator.add("-1,2,-3");
			fail("MyMessage: NumberFormatException should be thrown)");
		}
		catch(NegativeNumbersException e)
		{
			assertEquals(e.getMessage(), "Negatives not allowed: [-1, -3]");
		}
	}

}
