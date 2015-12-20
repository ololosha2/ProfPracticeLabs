
public class Program {

    int res = 0;
    StringBuffer exc;
    String[] num ;



    public int add(String numbers)
    {

        res = 0;
        exc = new StringBuffer();
        num = new String[1000];
        numbers = numbers.replaceAll("[^-?\\d]", " ").trim().replace("  "," ");

        num = numbers.split(" ");

        for(String s: num)
        if(!s.equals(""))
        if(Integer.parseInt(s)>0)
         res+=Integer.parseInt(s);
        else
        exc.append(s);
        System.out.println("Exception : " + exc.toString());
        System.out.println(res);

        return res;
    }

    public static void main(String[] args) {
        Program P = new Program();

     // P.add("ab-6s123nab;am1m-33n-66a2", ';');
      P.add("swk-5and11ajw22;ywqo6");
    }
}
