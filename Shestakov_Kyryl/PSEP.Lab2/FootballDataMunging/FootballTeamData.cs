using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FootballDataMunging
{
    public class FootballTeamData
    {
        public string Name { get; }
        public int For { get; }
        public int Against { get; }
        public int GoalSpread
        {
            get
            {
                return For - Against;
            }
        }

        public FootballTeamData(string name, int @for, int against)
        {
            if (ReferenceEquals(name, null))
            {
                throw new ArgumentNullException(nameof(name), "Name should not be null");
            }

            if (@for < 0)
            {
                throw new ArgumentException("Number of goals cannot be negative", nameof(@for));
            }

            if (against < 0)
            {
                throw new ArgumentException("Number of goals cannot be negative", nameof(against));
            }

            Name = name;
            For = @for;
            Against = against;
        }
    }
}
