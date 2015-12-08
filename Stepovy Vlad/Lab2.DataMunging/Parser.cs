namespace Lab2.DataMunging
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;
    using System.Text.RegularExpressions;

    public static class Parser
    {
        public static IEnumerable<Match> FindMatchesFromFileByRegex(string filePath, Regex regEx, int minGroupCount)
        {
            string data = File.ReadAllText(filePath);
            MatchCollection matches = regEx.Matches(data);
           
            return matches.Cast<Match>().Where(match => match.Groups.Count > minGroupCount);
        }

        public static int ParseInt(string data)
        {
            if (data.Contains("*"))
            {
                data = data.Substring(0, data.IndexOf("*", StringComparison.Ordinal));
            }
            return int.Parse(data);
        }
    }
}