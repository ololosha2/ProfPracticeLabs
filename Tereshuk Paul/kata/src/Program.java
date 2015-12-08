
public class Program {

    boolean FLAG = false;
    int k=0,res = 0;
    StringBuffer exc = new StringBuffer();
    String[] num = new String[1000];
    StringBuffer number = null;
    StringBuffer result = new StringBuffer("");
    char prev = ' ';


    public void charProc(char ch)
    {

        if (Character.isLetter(ch)|ch=='-') {
            if (number != null) {
                if(FLAG == false) {
                    num[k] = number.toString();
                    k++;
                }
                else {
                    exc.append(number.toString());
                }
                number = null;
            }
        } else {
            if (number == null){
                if(prev=='-') {
                    FLAG = true;
                    number = new StringBuffer(Character.toString(prev));
                    number.append(Character.getNumericValue(ch));
                }
                else{
                    FLAG = false;
                    number = new StringBuffer(Character.toString(ch));
                }

            }
            else {
                number.append(Character.getNumericValue(ch));
            }
        }

        prev = ch;

    }

    public void add(String numbers,char del)
    {
        char n[]= numbers.toCharArray();
        for(int i =0;i<n.length;i++) {
            charProc(n[i]);
        }
            if(number !=null ) {
                if (FLAG == false) {
                    num[k] = number.toString();
                } else {
                    exc.append(number.toString());
                }
            }
        for(String o : num) {
            if (o != null) {
                if ( o.charAt(0) != del) {
                    res += Integer.parseInt(o);
                } else {
                    if(res>0)
                    {
                        result.append(res);
                        result.append(del);
                        res=0;
                    }
                }
            }
        }
        result.append(res);
        System.out.println("Exception : " + exc.toString());
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Program P = new Program();

       P.add("abs123nab;am1m-33n-66a2", ';');

    }
}
