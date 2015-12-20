package com.code.jpackage;


public class Calculator {

    public int add(String numbers) {
        int sum = 0;
        for(String s : numbers.split("[,|;|\n]+")) {
            try {
                int num = Integer.parseInt(s);
                if (num > 1000) {
                    num = 0;
                }
                if (num < 0) {
                    throw new Exception("Negative number");
                }
                sum += num;
            }
            catch (Exception exc) {
                System.out.println("Warning!" + exc.getMessage());
            }
        }
        return sum;
    }




}
