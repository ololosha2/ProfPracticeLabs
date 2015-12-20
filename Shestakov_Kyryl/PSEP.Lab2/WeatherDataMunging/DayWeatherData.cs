using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WeatherDataMunging
{
    public class DayWeatherData
    {
        public int DayNumber { get; }
        public int MaximumTemperature { get; }
        public int MinimumTemperature { get; }

        public int TemperatureSpread
        {
            get
            {
                return MaximumTemperature - MinimumTemperature;
            }
        }

        public DayWeatherData(int dayNumber, int maxTemperature, int minTemperature)
        {
            if (dayNumber < 1 || dayNumber > 31)
            {
                throw new ArgumentOutOfRangeException(nameof(dayNumber), "There are no such days");
            }

            if (minTemperature > maxTemperature)
            {
                throw new ArgumentOutOfRangeException(nameof(minTemperature), "Minimum temperature cannot be greater than maximum temperature");
            }

            DayNumber = dayNumber;
            MaximumTemperature = maxTemperature;
            MinimumTemperature = minTemperature;
        }
    }
}
