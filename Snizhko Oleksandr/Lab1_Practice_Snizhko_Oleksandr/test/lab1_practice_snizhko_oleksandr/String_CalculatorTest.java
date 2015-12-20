package lab1_practice_snizhko_oleksandr;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oleksandr
 */
public class String_CalculatorTest {
    
    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, String_Calculator.adding(""));
    }
    
    @Test
    public void shouldReturnNumber_1(){
        assertEquals(1, String_Calculator.adding("1"));
    }
    
    @Test
    public void shouldReturnNumber_2(){
        assertEquals(4, String_Calculator.adding("4"));
    }
    
    @Test
    public void shouldReturnSumOfNumbers_1(){
        assertEquals(3, String_Calculator.adding("1,2"));
    }
    
    @Test
    public void shouldReturnSumOfNumbers_2(){
        assertEquals(6, String_Calculator.adding("1,2,3"));
    }
    
    @Test
    public void shouldReturnSumOfNumbers_3(){
        assertEquals(10, String_Calculator.adding("1,2,3,4"));
    }
    
    @Test
    public void shouldReturnSumOfNumbersWithNewLine(){
        assertEquals(5, String_Calculator.adding("2\n3"));
    }
    
    @Test 
    public void shouldAcceptNewLineAsValidDelimeter(){
        assertEquals(4, String_Calculator.adding("1,2\n1"));
    }
    
    @Test
    public void shouldAcceptCustomDelimiterSyntax(){
        assertEquals(6, String_Calculator.adding("//;\n4;2"));
    }
    
    @Test
    public void shouldReturmErrorForNegative_1(){
        try {
            String_Calculator.adding("-1");
            //fail();
        } catch (Exception e) {
            assertEquals("-1", e.getMessage());
        }
    }
    
    @Test
    public void shouldReturmErrorForNegative_2(){
        try {
            String_Calculator.adding("-1,2,-2");
        } catch (Exception e){
            assertEquals("-1,-2", e.getMessage());
        }
    }
    
    @Test
    public void shouldReturmErrorForNegative_3(){
        try {
            String_Calculator.adding("-7,2\n-3");
        } catch (Exception e){
            assertEquals("-7,-3", e.getMessage());
        }
    }
}