using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace SEP_lab1_UnitTests
{
    public class Calculator
    {
        public int Add(string numbers)
        {
            if (numbers == String.Empty)
            {
                return 0;
            }
            string delPattern = @"//\D\n";
            Regex reg = new Regex(delPattern);
            Match match = reg.Match(numbers);
            string[] strNums;
            if (match.Success)
            {
                char split = char.Parse(match.Value.Substring(2, 1));
                numbers = numbers.Remove(0, 4);
                strNums = numbers.Split(split);
            }
            else
            {
                strNums = numbers.Split(',', '\n');
            }
            int[] nums = new int[strNums.Length];

            for(int i = 0; i < strNums.Length; i++)
            {
                nums[i] = int.Parse(strNums[i]);
            }
            string excNums = String.Empty;
            bool exc = false;
            for(int i = 0; i < nums.Length;i++)
            {
                if(nums[i] < 0)
                {
                    excNums += ' ' +nums[i];
                    exc = true;
                }
            }
            if(exc)
            {
                throw new ArgumentException("Negatives are not allowed:" + excNums);
            }

            if(nums.Length == 1)
            {
                return nums[0];
            }
            else if(nums.Length == 2)
            {
                return nums[0] + nums[1];
            }
            else
            {
                int result = 0;
                for(int i = 0; i < nums.Length; i++)
                {
                    result += nums[i];
                }
                return result;
            }
        }
    }
}
