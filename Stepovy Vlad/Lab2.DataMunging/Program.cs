namespace Lab2.DataMunging
{
    using System;
    using System.Linq;
    using System.Text.RegularExpressions;

    class Program
    {
        static void Main(string[] args)
        {
            // Part 1
            var matches = Parser.FindMatchesFromFileByRegex("../../weather.dat",
                new Regex(@".*  (\d{1,2})  (\d{1,3}\**) +(\d{1,3}\**)", RegexOptions.IgnoreCase), minGroupCount: 3);
            var weatherData = matches.Select(match => new WeatherInfoRecord(match.Groups[1].Value, match.Groups[2].Value, match.Groups[3].Value));
            Console.WriteLine(DataManager.FindSmallestSpread(weatherData));

            // Part 2
            matches = Parser.FindMatchesFromFileByRegex("../../football.dat",
               new Regex(@".*\. (\w+) +\d+ +\d+ +\d+ +\d+ +(\d+) +- +(\d+)", RegexOptions.IgnoreCase), minGroupCount: 3);
            var footballData = matches.Select(match => new FootballTeamResult(match.Groups[1].Value, match.Groups[2].Value, match.Groups[3].Value));
            Console.WriteLine(DataManager.FindSmallestSpread(footballData));

            Console.ReadLine();
        }
    }
}