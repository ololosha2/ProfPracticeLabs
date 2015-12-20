/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_practice;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Pavilion
 */
public class StringCalculator {
    
    public static int add(String text){ 
        
        if(text.isEmpty()){
            return 0; 
        } else if(text.contains(",")) {
            String[] numbers = text.split(",|\n");
            
            // Check availability negative numbers
            checkNegatives(numbers);
            
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            return sum;
        } else if(text.startsWith("//")){
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            m.matches();  
            String delimeters = m.group(1);
            String numbers = m.group(2);
            
            String[] onlyNumbers = numbers.split(delimeters);
            
            // Check availability negative numbers
            checkNegatives(onlyNumbers);
            
            int sum = 0;
            for (int i = 0; i < onlyNumbers.length; i++) {
                sum += Integer.parseInt(onlyNumbers[i]);
            }
            return sum;
        } else if(text.contains("\n")){
            String[] numbers = text.split("\n");
            
            // Check availability negative numbers
            checkNegatives(numbers);
            
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += Integer.parseInt(numbers[i]);
            }
            return sum;
        } else {
            return Integer.parseInt(text);
        }        
    }

    private static void checkNegatives(String[] values){
        String negatives = "";
        for(String value: values){
            if(Integer.parseInt(value)<0){
                negatives += ","+value;
            }
        }
        
        if(negatives.length() > 0){
            throw new RuntimeException(negatives.substring(1));
        }
    }
}