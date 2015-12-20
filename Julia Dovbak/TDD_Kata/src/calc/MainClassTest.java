package calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClassTest
{
	public static void main(String[] args)
	{
		String test3 = "1\n2,3";
		String test4 = "//;\n1;2";
		String test7 = "1***2***3";
		String test8 = "//[;][***]\n1*2%3";
		
//		String[] data = test7.split("***");
//		System.out.println(Arrays.toString(data));
		String[] data = test8.split("\n");
		// extracting custom delimeter
		String delimeter = data[0].replace("//", "").trim();
		Pattern pattern = Pattern.compile("(\\[|^)(.*?)(\\]|$)");
        Matcher matcher = pattern.matcher(delimeter);
        while (matcher.find())
        {
            String group = matcher.group(2);
            System.out.println(group);
        }
		
		
	}
}
