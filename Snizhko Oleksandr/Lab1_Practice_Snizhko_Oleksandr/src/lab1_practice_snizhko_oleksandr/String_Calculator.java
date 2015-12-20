package lab1_practice_snizhko_oleksandr;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Oleksandr
 */
public class String_Calculator {
    
    public static int adding(String text){ 
        
        if(text.isEmpty()){
            return 0; 
        } else if(text.contains(",")) {
            String[] numbers = text.split(",|\n");
            
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
           
            checkNegatives(onlyNumbers);
            
            int sum = 0;
            for (String onlyNumber : onlyNumbers) {
                sum += Integer.parseInt(onlyNumber);
            }
            return sum;
        } else if(text.contains("\n")){
            String[] numbers = text.split("\n");
            
            checkNegatives(numbers);
            
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
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