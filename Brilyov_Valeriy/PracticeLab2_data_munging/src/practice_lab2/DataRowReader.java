package practice_lab2;

/**
 * Created by Valeriy on 8/12/2015.
 */
public class DataRowReader {
    public String[] getParameters(String data) {
        String[] params = (data.trim()).split("[-\\* ]+");

        if(params.length < 3) return null;
        return params;
    }
}
