import java.io.*;
import java.util.ArrayList;

public class main {
    private File file;
    private ArrayList<forecast> line = new ArrayList<>();


   private  ArrayList<String[]> read(String fileName) throws FileNotFoundException {

        String[] str;
        ArrayList<String[]> arr = new ArrayList<>();
        exists(fileName);

        try {

            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    if(!s.isEmpty()) {
                        while(s.trim().contains("  ")) {
                            String rep = s.replace("  ", " ").replace("-"," ");
                            s = rep;
                        }

                        str = s.trim().split(" ",9);
                        if(str[0].matches("^[0-9]{1,3}")|str[0].matches("^[0-9]{1,2}.")) {
                            arr.add(str);
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
return arr;
    }

    public void readForecast(String filename) throws IOException
    {
        ArrayList<String[]> arr =read(filename);
        if(filename.contains("weather.dat")) {
            for (String[] str : arr)
                line.add(new forecast(str[0], str[1].replaceAll("[^\\d]", ""), str[2].replaceAll("[^\\d]", "")));
        }
        else{
            for (String[] str : arr)
                line.add(new forecast(str[1], str[6].replaceAll("[^\\d]", ""), str[7].replaceAll("[^\\d]", "")));

        }
    }


    public void exists(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public void outSmallestSpread(String filepath) throws IOException
    {

        this.readForecast(filepath);
        int i=100;
        String day = null;
      for(forecast F:line)
          if(Math.abs(F.getSpread())<i) {
              i = Math.abs(F.getSpread());
              day = F.getName();
          }

        if(filepath.contains("weather.dat")) {
            System.out.println("Day with the smallest spread:" + day);
        }
        else{
            System.out.println("Team with the smallest spread:" + day);
        }

    }

    public static void main(String[] args) throws IOException{
        main M = new main();
        M.outSmallestSpread("D:\\Downloads\\football.dat");
    }
}
