package Test;
import calculator.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void addEmptyString() {
        int sum = calculator.add("");
        assertEquals(0, sum);
    }

    @Test
    public void addOneNumber() {
        int sum = calculator.add("1");
        assertEquals(1, sum);
    }

    @Test
    public void addTwoNumbers() {
        int sum = calculator.add("1,2");
        assertEquals(3, sum);
    }

    @Test
    public void addBigAmountOfNumbers() {
        int sum = calculator.add("1,2,3,4,5,6");
        assertEquals(21, sum);
    }
    @Test
    public void addLinesBetweenNumbers() {
        int sum = calculator.add("1\n2,3");
        assertEquals(6, sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNegativeNumbersExpectedException() {

        int sum = calculator.add("//[*]\n-2*1");
    }

    @Test
    public void anotherDelimiter() {
        int sum = calculator.add("//;\n1;2");
        assertEquals(3, sum);
    }

    @Test
    public void addNumbersBigger1000() {
        int sum = calculator.add("1,2,1001,1005,900");
        assertEquals(903, sum);
    }

    @Test
    public void multipleDelimiters() {
        int sum = calculator.add("//[**][&&]\n1**2&&7");
        //assertEquals(10, sum);
        assertTrue(10 == sum);
    }




}