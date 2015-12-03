package calc;

import java.util.List;

public class NegativeNumbersException extends RuntimeException
{
	public NegativeNumbersException(List<Integer> negatives)
	{
		super("Negatives not allowed: " + negatives.toString());
	}
}
