package com.yarolegovich.calc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by yarolegovich on 19.12.2015.
 */
public class CalculatorTest {

    @Test
    public void addTestEmptyString() {
        Calculator calculator = new Calculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void addTestNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(3, calculator.add("1,2"));
        assertEquals(23, calculator.add("5,5,10,3"));
    }

    @Test
    public void addTestCanHandleNewLine() {
        Calculator calculator = new Calculator();
        int result = calculator.add("10\n1,3\n1");
        assertEquals(15, result);
    }

    @Test
    public void addTestCanHandleCustomDelimiters() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add("//;\n2;2"));
        assertEquals(10, calculator.add("//*\n5*2*2*1"));
    }

    @Test(expected = NegativesNotSupportedException.class)
    public void addTestNotSupportNegativesIsThrown() {
        Calculator calculator = new Calculator();
        calculator.add("3,14,1,-1,4,-2");
    }

    @Test
    public void addTestIgnoresGreaterThenThousand() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("2,4,1001"));
        assertEquals(1, calculator.add("1001,2999,1,1999"));
    }

    @Test
    public void addTestCanHandleMulticharDelimiters() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("//[****]\n1****2****3"));
        assertEquals(10, calculator.add("//[%][&&&]\n1%3&&&6"));
        assertEquals(12, calculator.add("//[%%%][++]\n1%%%6++5"));
    }

}
