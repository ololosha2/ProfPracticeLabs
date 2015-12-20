/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_practice;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pavilion
 */
public class StringCalculatorTest {
    
    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }
    
    @Test
    public void shouldReturnNumber_1(){
        assertEquals(1, StringCalculator.add("1"));
    }
    
    @Test
    public void shouldReturnNumber_2(){
        assertEquals(4, StringCalculator.add("4"));
    }
    
    @Test
    public void shouldReturnSumOfNumbers_1(){
        assertEquals(3, StringCalculator.add("1,2"));
    }
    
    @Test
    public void shouldReturnSumOfNumbers_2(){
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    
    @Test
    public void shouldReturnSumOfNumbers_3(){
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }
    
    @Test
    public void shouldReturnSumOfNumbersWithNewLine(){
        assertEquals(5, StringCalculator.add("2\n3"));
    }
    
    @Test 
    public void shouldAcceptNewLineAsValidDelimeter(){
        assertEquals(4, StringCalculator.add("1,2\n1"));
    }
    
    @Test
    public void shouldAcceptCustomDelimiterSyntax(){
        assertEquals(6, StringCalculator.add("//;\n4;2"));
    }
    
    @Test
    public void shouldReturmErrorForNegative_1(){
        try {
            StringCalculator.add("-1");
            //fail();
        } catch (Exception e) {
            assertEquals("-1", e.getMessage());
        }
    }
    
    @Test
    public void shouldReturmErrorForNegative_2(){
        try {
            StringCalculator.add("-1,2,-2");
        } catch (Exception e){
            assertEquals("-1,-2", e.getMessage());
        }
    }
    
    @Test
    public void shouldReturmErrorForNegative_3(){
        try {
            StringCalculator.add("-7,2\n-3");
        } catch (Exception e){
            assertEquals("-7,-3", e.getMessage());
        }
    }
}