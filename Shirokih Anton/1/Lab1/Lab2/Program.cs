using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Text.RegularExpressions;
using C = System.Console;

namespace Lab2
{
    public delegate List<Element> GetAll(StreamReader reader);
    public abstract class Element : IComparable<Element>
    {
        public int Difference { get; set; }
        protected string Line { get; set; }
        public bool Success { get; set; }
        public Element(string line)
        {
            Line = line;
        }
        public abstract string ReadProp(ref int index, bool first = false);
        public abstract int CompareTo(Element other);
    }
    public class Cell : Element
    {
        public int Day { get; set; }
        public double MaxTemp { get; set; }
        public double MinTemp { get; set; }
        public Cell(string line)
            : base(line)
        {
            int start_index = 0;
            try
            {
                Day = Int32.Parse(ReadProp(ref start_index, true));
                MaxTemp = Double.Parse(ReadProp(ref start_index));
                MinTemp = Double.Parse(ReadProp(ref start_index));
                Difference = (int)(MaxTemp - MinTemp);
                Success = true;
            }
            catch
            {
                Success = false;
            }
        }
        public override string ToString()
        {
            return "Day: " + Day + ", MaxTemp: " + MaxTemp + ", MinTemp: " + MinTemp + ", Difference: " + Difference;
        }
        public override string ReadProp(ref int index, bool first = false)
        {
            Match m = Regex.Match(Line.Substring(index), @"\s+\S+");
            if (first)
                if (m.Index != 0) throw new Exception("Uncorrect order");
            index += m.Index + m.Length;
            return m.Value;
        }
        public static List<Element> GetAll(StreamReader reader)
        {
            List<Element> list = new List<Element>();
            string str;
            Cell buffer;
            while ((str = reader.ReadLine()) != null)
            {
                buffer = new Cell(str);
                if (buffer.Success)
                    list.Add(buffer);
            }
            return list;
        }
        public override int CompareTo(Element other)
        {
            return (this.Difference > other.Difference) ? 1 : (this.Difference < other.Difference) ? -1 : 0;
        }
    }
    public class Foot : Element
    {
        public string TeamName { get; set; }
        public int GoalsFor { get; set; }
        public int GoalsAggains { get; set; }
        public Foot(string line)
            : base(line)
        {
            int index = 0;
            try
            {
                TeamName = RemoveSpaces(ReadProp(ref index, true));
                ReadProp(ref index);
                ReadProp(ref index);
                ReadProp(ref index);
                ReadProp(ref index);
                GoalsFor = Int32.Parse(ReadProp(ref index));
                ReadProp(ref index);
                GoalsAggains = Int32.Parse(ReadProp(ref index));
                Difference = GoalsFor - GoalsAggains > 0 ? GoalsFor - GoalsAggains : GoalsAggains - GoalsFor;
                Success = true;
            }
            catch
            {
                Success = false;
            }
        }
        public string RemoveSpaces(string str)
        {
            return str.Replace(" ", "");
        }
        public override int CompareTo(Element other)
        {
            int res =  (this.Difference > other.Difference) ? -1 : (this.Difference < other.Difference) ? 1 : 0;
            return res;
        }
        public override string ToString()
        {
            return "Team name: " + TeamName + ", GoalsFor: " + GoalsFor + ", GoalsAgainst: " + GoalsAggains + " Diff: " + Difference;
        }
        public override string ReadProp(ref int index, bool first = false)
        {
            Match m = null;
            if (first)
                m = Regex.Match(Line.Substring(index), @"\s+\d+\.\s+[A-Za-z_]+");
            else
                m = Regex.Match(Line.Substring(index), @"\s+\S+");
            if (first)
                if (m.Index != 0) throw new Exception("Uncorrect name format");
            index += m.Index + m.Length;
            return m.Value;
        }
        public static List<Element> GetAll(StreamReader reader)
        {
            List<Element> list = new List<Element>();
            string str;
            Foot buffer;
            while ((str = reader.ReadLine()) != null)
            {
                buffer = new Foot(str);
                if (buffer.Success)
                    list.Add(buffer);
            }
            return list;
        }
    }


    public class Program
    {
        public static string SOCCER_TABLE = @"D:\Уроки\3 курс\Проф практика\Laboratories\2\football.dat";
        public static string WEATHER_DATA_FILE = @"D:\Уроки\3 курс\Проф практика\Laboratories\2\weather.dat";
        public static void Task(string connection, string message, GetAll del)
        {
            using (StreamReader reader = new StreamReader(new FileStream(connection, FileMode.Open, FileAccess.Read)))
            {
                List<Element> list = del(reader);
                if (list.Count != 0)
                {
                    list.Sort();
                    C.WriteLine("Message: {0}\n {1} \n", message, list[0].ToString());
                }
            }
        }
        static void Main(string[] args)
        {
            Task(SOCCER_TABLE, "Some soccer", Foot.GetAll);
            Task(WEATHER_DATA_FILE, "Some weather", Cell.GetAll);
        }
    }
}
