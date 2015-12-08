namespace Lab2.DataMunging
{
    using System;

    public class WeatherInfoRecord : IEntityWithSpread
    {
        public int Day { get; set; }
        public int MaxTemperature { get; set; }
        public int MinTemperature { get; set; }
        public int Spread
        {
            get
            {
                return Math.Abs(MaxTemperature - MinTemperature);
            }
        }

        public WeatherInfoRecord(string day, string maxTemp, string minTemp)
        {
            this.Day = int.Parse(day);
            this.MaxTemperature = Parser.ParseInt(maxTemp);
            this.MinTemperature = Parser.ParseInt(minTemp);
        }

        public override string ToString()
        {
            return $"Day: {Day}, Max Temperature: {MaxTemperature}, Min Temperature: {MinTemperature}";
        }
    }
}