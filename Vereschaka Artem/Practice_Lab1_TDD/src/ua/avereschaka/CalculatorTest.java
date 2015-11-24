package ua.avereschaka;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddDynamicLongDelimiters() throws Exception{
        assertEquals(10, Calculator.add("//[,,]\n1,,2,,3,,4"));
        assertEquals(15, Calculator.add("//[,,][..];\n1,,2..3,,4;5"));
        assertEquals(15, Calculator.add("//[,][.];\n1,2.3,4;5"));
        assertEquals(15, Calculator.add("//[,][.,];\n1,2.,3,4;5"));
        assertEquals(15, Calculator.add("//[***];*.\n1***2*3.4;5"));
    }

    @Test
    public void testAddDynamicDelimiters() throws Exception {

        assertEquals(10, Calculator.add("//;.,\n1;2,3.4"));

        assertEquals(8, Calculator.add("//;.,\n1;2,3.1001,2"));
        assertEquals(1007, Calculator.add("//;.,\n1;2,3.999,2"));
    }

    @Test
    public void testAddStaticDelimiters() throws Exception {
        assertEquals(0, Calculator.add(""));
        assertEquals(1, Calculator.add("1"));
        assertEquals(4, Calculator.add("1, 3"));
        assertEquals(4, Calculator.add("  1,3"));
        assertEquals(4, Calculator.add("  1 ,   3 "));
        assertEquals(8, Calculator.add("2,1,5"));
        assertEquals(23, Calculator.add("2,1,5,1,2,3,4,5"));

        assertEquals(5, Calculator.add("2\n3"));
        assertEquals(5, Calculator.add("2\n3\n"));
        assertEquals(14, Calculator.add("2\n3\n4,5\n"));
    }

    @Test
    public void testAddWithException() throws Exception {
        exception.expect(NumberFormatException.class);
        exception.expectMessage("Negatives not allowed: -1, -2, -3");
        Calculator.add("//;.,\n1;2,3.4;-1;-2;-3");
    }
}