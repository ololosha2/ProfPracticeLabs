using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace DataMunging
{
    public class DataMunger
    {
        public static DataHolder CalculateMinimalSpreadRow(
            string fileName,
            string identifierPattern,
            int firstValueColumnIndex,
            int secondValueColumnIndex)
        {
            List<string> rowList = new List<string>();

            using (TextReader sr = new StreamReader(fileName))
            {
                string line;

                while ((line = sr.ReadLine()) != null)
                {
                    rowList.Add(line);
                }
            }

            IEnumerable<DataHolder> holders = rowList
                .Where(e => Regex.IsMatch(e, @"^\s*(\d)+"))
                .Select(e =>
                {
                    string name = "";
                    int firstValue = 0;
                    int secondValue = 0;

                    Regex namePattern = new Regex(identifierPattern);
                    Regex numberPattern = new Regex(@"(\d)+");
                    IEnumerable<int> matches = numberPattern.Matches(e).Cast<Match>().Select(m => int.Parse(m.Value));

                    name = namePattern.Match(e).Value;
                    firstValue = matches.ElementAt(firstValueColumnIndex);
                    secondValue = matches.ElementAt(secondValueColumnIndex);

                    return new DataHolder(name, firstValue, secondValue);
                });

            DataHolder minimalSpreadData = holders.Aggregate((a, b) => a.Difference < b.Difference ? a : b);

            return minimalSpreadData;
        }
    }
}
