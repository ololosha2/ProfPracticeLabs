package calculator;

import java.util.regex.*;


public class StringCalculator {

    public static int add(String numbers) {

        //empty string check
        if (numbers.length() == 0) {
            return 0;
        }
        int sum = 0;
        StringBuilder negativeValues = new StringBuilder();


        //beginning of string check
        if(numbers.startsWith("//")) {
            numbers = numbers.substring(2);
            String delimiter = "";

            //list of all numbers
            String allNums = "";

            //supporting different delimiters
            if(numbers.startsWith("[")) {

                Pattern pat = Pattern.compile("(\\[)(.+)(\\])");
                Matcher match = pat.matcher(numbers);

                //find all delimiters
                while (match.find()) {
                    delimiter += match.group(2);
                    delimiter += "\n";
                }

                //deleting delimiters
                for (String s : numbers.split("(\\[)(.+)(\\])")) {
                    allNums += s;
                }

            } else {
                //one delimiter
                delimiter += numbers.charAt(0);
                allNums = numbers.substring(1);
            }


            if(!allNums.startsWith("\n")) {
                throw new IllegalArgumentException("symbol \n is required");
            }


            Pattern p = Pattern.compile("([-]?[\\d]+)(\\D*)");
            Matcher m = p.matcher(allNums);

            //find and parse all numbers
            while (m.find()) {

                int number = Integer.parseInt(m.group(1));
                String s = m.group(2);

                //check for corresponding delimiters
                if(!delimiter.contains(m.group(2))) {
                    throw new IllegalArgumentException();
                }
                if (number < 0) {
                    negativeValues.append(number);
                }
                if (number <= 1000) {
                    sum += number;
                }
            }
        } else {

            //case with one delimiter
            Pattern p = Pattern.compile("([-]?[\\d]+)(\\,|\\\n)*");
            Matcher m = p.matcher(numbers);
            while (m.find()) {
                int number = Integer.parseInt(m.group(1));


                if (number < 0) {
                    negativeValues.append(number);
                }
                if (number <= 1000) {
                    sum += number;
                }
            }
        }
        if (negativeValues.length() != 0) {
            throw new IllegalArgumentException("negatives not allowed: " + negativeValues.toString());
        }
        return sum;
    }


}
