package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase6
{

	@Test
	public void biggerThanThousandsTest()
	{
		assertEquals(2, StringCalculator.add("1001,2"));
	}
	
	@Test
	public void biggerThanMultipleThousandsTest()
	{
		assertEquals(5, StringCalculator.add("1001,2,1005,3"));
	}

}
