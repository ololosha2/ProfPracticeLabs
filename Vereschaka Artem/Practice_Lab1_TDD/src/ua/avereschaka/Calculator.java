package ua.avereschaka;

public class Calculator {

    /**
     * Adds numbers in <b>input</b> string separated by delimiters.
     * Numbers that are larger than 1000 will be ignored. <br>
     * You can use default delimiters such as ; and \n.
     * Or you can add delimiters to the string in next format: //delimiters\nnumbers <br>
     * Examples: <br> //.,;\n1.2,3;4 <br> //[***];.[,,]\n1***2,,2.5;4
     * @param input input string
     * @return sum of numbers
     * @throws NumberFormatException
     */
    public static int add(String input) throws NumberFormatException {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        int result = 0;
        StringBuilder regex = new StringBuilder();
        // case when dynamic delimiters
        if (input.startsWith("//")) {
            int i;
            boolean multipleFlag = false;
            String multiple = "";
            for (i = 2; i < input.length() && '\n' != input.charAt(i); ++i) {
                char c = input.charAt(i);
                if ('[' == c) {
                    multiple = "";
                    multipleFlag = true;
                } else if (']' == c) {
                    multipleFlag = false;
                    // adding multi delimiter to the beginning
                    for (int j = multiple.length() - 1; j > -1; --j) {
                        regex.insert(0, "\\" + multiple.charAt(j));
                    }
                    regex.insert(multiple.length() * 2, '|');
                } else if (!multipleFlag) {
                    regex.append(c);
                } else {
                    multiple += c;
                }

            }
            // cuts the delimiters out of main string with numbers
            input = input.substring(i + 1);
        }

        regex.insert(regex.lastIndexOf("|") + 1, "[,\n");
        regex.append(']');

        String[] strings = input.split(regex.toString());
        StringBuilder negativeNumbers = new StringBuilder();
        for (String str : strings) {

            int number = Integer.parseInt(str.trim());
            if (number < 0) {
                negativeNumbers.append(number).append(", ");
            } else {
                if (number <= 1000) {
                    result += number;
                }
            }
        }
        if (negativeNumbers.length() > 0) {
            negativeNumbers.replace(negativeNumbers.length() - 2, negativeNumbers.length(), "");
            throw new NumberFormatException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return result;
    }
}
