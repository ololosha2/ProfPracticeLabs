package unit_testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import mypackage.Calculator;

/**
 * Created by Valeriy on 8/11/2015.
 */
public class CalculatorClassTest {
    @Test
    public void calcAddMethodValuesGreaterThen1000Test() {
        Calculator c = new Calculator();
        assertEquals(1000, c.add("[[[[\\]]]]1;#$%1001;**;\n0;999"));
    }

    @Test
    public void calcAddMethodLinesSplitTest() {
        Calculator c = new Calculator();
        assertEquals(26, c.add("1;\\***;*****;*\n22;**********;3"));
    }

    /*
    @Test
    public void calcAddMethodNegativeValuesTest() {
        Calculator c = new Calculator();
        assertEquals(4, c.add("1;-11;-7;\\***;*****;*\n-22;**********;3"));
    }

    @Test
    public void calcAddMethodNegativeValues2Test() {
        Calculator c = new Calculator();
        assertEquals(4, c.add("1;\\***;*****;*\n-22;**********;3"));
    }*/

    @Test
    public void calcAddMethodLinesSplit2Test() {
        Calculator c = new Calculator();
        assertEquals(6, c.add("1\n2,3\n\n,"));
    }

    @Test
    public void calcAddMethodZeroNumbersTest() {
        Calculator c = new Calculator();
        assertEquals(0, c.add(" "));
    }

    @Test
    public void calcAddMethodOneNumberTest() {
        Calculator c = new Calculator();
        assertEquals(3, c.add("3"));
    }

    @Test
    public void calcAddMethodTwoNumbersTest() {
        Calculator c = new Calculator();
        assertEquals(3, c.add("1,2"));
    }

    @Test
    public void calcAddMethodThreeNumbersTest() {
        Calculator c = new Calculator();
        assertEquals(8, c.add("1,4,3"));
    }
}
