import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FootballFileProcessor {

    public String processFile(LinkedList<LinkedList<String>> data) {
        String name = "";
        int min = Integer.MAX_VALUE;
        data.remove(17);
        //parsing file
        for(LinkedList<String> list : data) {
            if(list.size() != 0) {
                int temp = Math.abs(Integer.parseInt(list.get(8).replaceAll("\\D+", "")) -
                        Integer.parseInt(list.get(6).replaceAll("\\D+", "")));
                if(temp < min) {
                    min = temp;
                    //correct answer
                    name = list.get(1);
                }
            }
        }

        return name;
    }
}
