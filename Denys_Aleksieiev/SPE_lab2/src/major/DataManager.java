package major;

import java.io.IOException;
import java.util.Comparator;

public class DataManager<T> {
	    private final DataReader<T> reader;
	    private Comparator<T> comparator;

	    public DataManager(DataReader<T> reader, Comparator<T> comparator) {
	        this.reader = reader;
	        this.comparator = comparator;
	    }

	    public void printSpreads(String filename) throws IOException {
	        final Object[] points = reader.read(filename).sorted(comparator).toArray();
	        System.out.println("the smallest " + points[0]);
	        System.out.println("the largest " + points[points.length - 1]);
	    }
}
