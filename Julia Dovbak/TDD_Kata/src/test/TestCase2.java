package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase2
{

	@Test
	public void unknowAmountOfNumbersTest()
	{
		assertEquals(6, StringCalculator.add("1,2,3"));
	}

}
