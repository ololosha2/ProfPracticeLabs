namespace Lab2.DataMunging
{
    using System.Collections.Generic;
    using System.Linq;

    public class DataManager
    {
        public static IEntityWithSpread FindSmallestSpread(IEnumerable<IEntityWithSpread> data)
        {
            var sortedList = data.OrderBy(x => x.Spread);

            return sortedList.First();
        }
    }
}