using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Lab1
{
    public class NegativeNumnerException : Exception
    {
        public NegativeNumnerException(IEnumerable<int> negs)
            : base("Negative numbers are not allowed ! See 'Details'")
        {
            Details = "Negatives: ";
            foreach (int i in negs)
            {
                Details += i + " ";
            }
        }
        public string Details { get; set; }
    }
    public static class Program
    {
        public static string[] Split(this string str, string exp)
        {
            List<string> list = new List<string>();
            int s_index = 0;
            int end_index = 0;
            while (true)
            {
                s_index = str.IndexOf(exp, s_index);
                if (s_index == -1)
                {
                    if (end_index < str.Length)
                    {
                        list.Add(str.Substring(end_index, str.Length - end_index));
                    }
                    break;
                }
                list.Add(str.Substring(end_index, s_index - end_index));
                end_index = s_index + exp.Length;
                s_index++;
            }
            return list.ToArray();
        }
        public static string[] Split(this string str, string[] exps)
        {
            List<string> list = new List<string>();
            int start_index = 0;
            int buff = 0;
            int i = 0;
            Dictionary<int, int> matches = new Dictionary<int, int>();
            while (true)
            {
                for (i = 0; i < exps.Length; i++)
                {
                    buff = str.IndexOf(exps[i], start_index);
                    if (buff != -1)
                    {
                        matches.Add(i, buff);
                    }
                }
                if (matches.Count == 0)
                {
                    list.Add(str.Substring(start_index, str.Length - start_index));
                    break;
                }
                matches = matches.OrderBy(x => x.Value).ToDictionary(x=>x.Key,y=>y.Value);
                list.Add(str.Substring(start_index, matches.ElementAt(0).Value - start_index));
                start_index = matches.ElementAt(0).Value + exps[matches.ElementAt(0).Key].Length;
                matches.Clear();
            }
            return list.ToArray();
        }
        public static string[] ToStringArray(this CaptureCollection col)
        {
            List<string> list = new List<string>();
            for (int i = 0; i < col.Count; i++)
            {
                if (!list.Contains(col[i].Value))
                    list.Add(col[i].Value);
            }
            return list.ToArray();
        }
        public static int Add(string str)
        {
            Match m = Regex.Match(str, @"//(?<delimiter>.)\n(?<secgroup>\d(\k<delimiter>\d)*)*");
            Match m2 = Regex.Match(str, @"//(\[(?<delimiter>[^\[\]0-9]+)\])+\n(?<secgroup>(\d(?<delimiter>[^\[\]0-9]+)*)*)");
            string[] mass = m.Success ? m.Groups["secgroup"].Value.Split(m.Groups["delimiter"].Value) : m2.Success ? m2.Groups["secgroup"].Value.Split(m2.Groups["delimiter"].Captures.ToStringArray()) : str.Split(',', '\n');
            int[] mass_i = new int[mass.Length];
            int summ = 0;
            List<int> negatives = new List<int>();
            for (int i = 0; i < mass_i.Length; i++)
            {
                if (mass[i].Length == 0)
                    return 0;
                Int32.TryParse(mass[i], out mass_i[i]);
                if (mass_i[i] < 0)
                    negatives.Add(mass_i[i]);
                if (mass_i[i] > 1000)
                    continue;
                else
                    summ += mass_i[i];
            }
            if (negatives.Count > 1)
                throw new NegativeNumnerException(negatives);
            return summ;
        }
        public static void Main(string[] args)
        {

        }
    }
}

