package mypackage;

/**
 * Created by Valeriy on 8/11/2015.
 */
public class Calculator {
    public int add(String numbers) {
        int result = 0;
        StringBuffer negativeVals = new StringBuffer();

        // Calculations
        int limit = -1;
        for (String s : numbers.split("\\D")) {
            // Checking limits of numbers (-1 - infinite amount)
            if (limit != -1 && limit-- < 1) break;

            try {
                int number = Integer.parseInt(s);

                // If negative number
                if(number < 0) {
                    negativeVals.append(number);
                    negativeVals.append(" ");
                    continue;
                }
                // If number greater than 1000
                if(number > 1000) {
                    continue;
                }

                result += number;
            } catch(Exception e) {
                //System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        try {
            if (negativeVals.length() != 0) {
                throw new Exception("Negative values are not allowed " + negativeVals);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
