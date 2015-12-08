namespace StringCalculator.Library
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text.RegularExpressions;

    public class StringCalculator
    {
        public int Add(string numbers)
        {
            if (numbers == string.Empty)
            {
                return 0;
            }
            var parsedNumbers = this.ParseString(numbers);

            var negativeNumbers = parsedNumbers.Where(number => number < 0).ToArray();
            if (negativeNumbers.Length > 0)
            {
                var negativeNumbersAsStrings = negativeNumbers.Select(number => number.ToString());
                throw new NegativesNotAllowedException(string.Join(",", negativeNumbersAsStrings));
            }

            return parsedNumbers.Where(number => number <= 1000).Sum();
        }

        private List<string> GetDelimeters(string numbers)
        {
            if (numbers.StartsWith("//"))
            {
                var delimetersSubstring = numbers.Substring(0, numbers.IndexOf('\n'));
                delimetersSubstring = delimetersSubstring.Substring(2);
                if (delimetersSubstring.Contains('[') &&
                    delimetersSubstring.Contains(']') &&
                    delimetersSubstring.Length > 1)
                {
                    Regex regex = new Regex(@"\[.*?\]");
                    var matches = regex.Matches(delimetersSubstring);
                    var delimeters = new List<string>();
                    foreach (Match match in matches)
                    {
                        delimeters.Add(match.Value);
                    }
                    for (int i = 0; i < delimeters.Count; i++)
                    {
                        delimeters[i] = delimeters[i].Substring(1, delimeters[i].Length - 2);
                    }
                    return delimeters;
                }
                else
                {
                    return new List<string> { delimetersSubstring };
                }
            }
            return new List<string>();
        }

        private int[] ParseString(string numbers)
        {
            var delimeters = this.GetDelimeters(numbers).ToList();
            delimeters.AddRange(new[] { ",", "\n" });
            if (numbers.StartsWith("//"))
            {
                numbers = numbers.Substring(numbers.IndexOf('\n'));
            }

            return numbers.Split(delimeters.ToArray(), StringSplitOptions.RemoveEmptyEntries)
                          .Select(number => Convert.ToInt32(number)).ToArray();
        }
    }
}