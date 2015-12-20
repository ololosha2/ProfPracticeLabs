package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator
{
	public static int add(String numbers)
	{
		// trim string
		numbers = numbers.trim();
		
		// if string is empty, then return 0
		if(numbers.isEmpty())
		{
			return 0;
		}
		String delimeters = "\n|,";
		if(numbers.startsWith("//"))
		{
			String[] data = numbers.split("\n");
			// extracting custom delimeter(s)
			String delimeterStr = data[0].replace("//", "").trim();
			Pattern pattern = Pattern.compile("(\\[|^)(.*?)(\\]|$)");
	        Matcher matcher = pattern.matcher(delimeterStr);
	        while (matcher.find())
	        {
	            String delimeter = matcher.group(2);
	            delimeters += "|" + Pattern.quote(delimeter);
	        }
			
			numbers = data[1];
		}
		
		// split numbers by comma
		String[] numbersArray = numbers.split("("+delimeters+")");
		
		// if it only has one number, then return it
		if(numbersArray.length == 1)
		{
			return Integer.valueOf(numbersArray[0]);
		}
		
		// iterate over values in array and sum them up
		// as well as check for negatives
		int sum = 0;
		List<Integer> negativesList = new ArrayList<Integer>();
		for(String num : numbersArray)
		{
			int intNum = Integer.valueOf(num.trim());
			if(intNum < 0)
			{
				negativesList.add(intNum);
			}
			else if(intNum <= 1000)
			{
				sum += intNum;
			}
		}
		
		if(!negativesList.isEmpty())
		{
			throw new NegativeNumbersException(negativesList);
		}
		
		return sum;
	}
}
