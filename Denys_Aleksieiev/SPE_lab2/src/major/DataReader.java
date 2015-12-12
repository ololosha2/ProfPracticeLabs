package major;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

public class DataReader<T> {
    private final Function<String, T> mapper;

    public DataReader(Function<String, T> mapper) {
        this.mapper = mapper;
    }

    public Stream<T> read(String filename) throws IOException {
        final FileReader rf = new FileReader(filename);
        final BufferedReader br = new BufferedReader(rf);

        final Stream<String> cleanedLines = br.lines().map(l -> l.trim().replaceAll("\\*", ""));
        final Stream<String> filteredLines = cleanedLines.filter(l -> l.length() > 0 && Character.isDigit(l.charAt(0)));
        return filteredLines.map(mapper);
    }
}
