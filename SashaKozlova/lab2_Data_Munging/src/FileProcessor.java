import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;


public class FileProcessor {

    public LinkedList<LinkedList<String>> readFromFile(String fileName) {


        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        StringBuilder sb = new StringBuilder();

        //read info from file
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                LinkedList<String> array = new LinkedList<>();

                //deleting all delimiters
                for (String retval: line.split(" ")){
                    if(!retval.equals("")) {
                        array.add(retval);
                    }
                }

                result.add(array);
                line = br.readLine();
            }
            result.removeFirst();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        return result;
    }
}
