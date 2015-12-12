package major;
import java.util.Comparator;

public class DataComparator implements Comparator<Data> {

    @Override
    public int compare(Data obj1, Data obj2) {
        return obj1.getSpread() - obj2.getSpread();
    }
}
