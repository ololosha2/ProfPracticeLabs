package com.code.japackageTest;

import com.code.jpackage.Calculator;
import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {

    //Test empty string
    @Test
    public static void testAddEmptyString() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.add(""));
    }

    //Test string with 1 parameter
    @Test
    public static void testAddOneParameter() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(15, calculator.add("15"));
    }

    //Test string with 2 parameters
    @Test
    public static void testAddTwoParameters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(19, calculator.add("4,15"));
    }

    //Test string with changed delimiter
    @Test
    public static void testAddTwoParametersWithDelimeters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(306, calculator.add("6;300"));
    }

    //Test string with negative numbers
    @Test
    public static void testAddNegative() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.add("-5;-10"));
    }

    //Test with numbers that are more than 1000 are ignored
    @Test
    public static void testAddIgnoreMoreThanThousand() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(3, calculator.add("3;1005"));
    }

    //Test string with delimiter of any length(1 char or more)
    @Test
    public static void testAnyLengthDelimeters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(10, calculator.add("2;;;;7\n\n1"));
    }

    //Test string with multiple delimiters
    @Test
    public static void testMultipleDelimeters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(10, calculator.add("2,;7\n;,1"));
    }

    //Test string with multiple delimiters of any length(1 char or more)
    @Test
    public static void testLongMultipleDelimeters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(10, calculator.add("2,,,;7\n\n;;;;1"));
    }



    public static void main(String[] args) {
        /*
        testAddEmptyString();
        testAddOneParameter();
        testAddTwoParameters();
        testAddTwoParametersWithDelimeters();
        testAddNegative();
        testAddIgnoreMoreThanThousand();
        testAnyLengthDelimeters();
        testMultipleDelimeters();
        */

        testLongMultipleDelimeters();
    }


}
