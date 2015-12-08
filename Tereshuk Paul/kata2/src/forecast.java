
public class forecast {
    private String name,x,y;

    public forecast(String d, String mx, String mn)
    {
        name = d;
        x= mx;
        y = mn;

    }


    public int getSpread()
    {
        int p= Integer.valueOf(x)-Integer.valueOf(y);
        return p;
    }

    public String getName() {
        return name;
    }
}
