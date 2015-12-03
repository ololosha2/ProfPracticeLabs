package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.StringCalculator;

public class TestCase7
{

	@Test
	public void anyLengthDelimetersTest()
	{
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}

}
