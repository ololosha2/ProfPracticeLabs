package test;
import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;


public class TestCase1
{

	@Test
	public void emptyStringTest()
	{
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void oneStringTest()
	{
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void twoNumbersTest()
	{
		assertEquals(3, StringCalculator.add("1,2"));
	}

}
