using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataMunging
{
    public class DataHolder
    {
        public string Identifier { get; }
        public int FirstValue { get; }
        public int SecondValue { get; }

        public int Difference
        {
            get
            {
                return FirstValue - SecondValue;
            }
        }

        public DataHolder(string identifier, int firstValue, int secondValue)
        {
            if (ReferenceEquals(identifier, null))
            {
                throw new ArgumentNullException(nameof(identifier), "Identifier should not be null");
            }

            Identifier = identifier;
            FirstValue = firstValue;
            SecondValue = secondValue;
        }
    }
}
