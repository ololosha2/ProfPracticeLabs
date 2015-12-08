namespace Lab2.DataMunging
{
    using System;

    public class FootballTeamResult : IEntityWithSpread
    {
        public string Name { get; set; }
        public int GoalsFor { get; set; }
        public int GoalsAgainst { get; set; }
        public int Spread
        {
            get
            {
                return Math.Abs(GoalsFor - GoalsAgainst);
            }
        }

        public FootballTeamResult(string name, string goalsFor, string goalsAgainst)
        {
            Name = name;
            GoalsFor = Parser.ParseInt(goalsFor);
            GoalsAgainst = Parser.ParseInt(goalsAgainst);
        }

        public override string ToString()
        {
            return $"Team: {Name}, Goals for: {GoalsFor}, Goals against: {GoalsAgainst}";
        }
    }
}