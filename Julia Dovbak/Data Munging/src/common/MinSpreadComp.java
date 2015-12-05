package common;
import java.util.Comparator;

public class MinSpreadComp implements Comparator<DataRecord> {


	public int compare(DataRecord dr1, DataRecord dr2)
	{
		return dr1.getSpread() - dr2.getSpread();
	}
}