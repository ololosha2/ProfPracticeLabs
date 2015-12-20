import org.junit.Test;
import static junit.framework.Assert.*;

public class myTest {
    @Test
    public void testCalA() throws Exception {
       main P = new main();
        String n =  P.outSmallestSpread("D:\\Downloads\\football.dat");

        assertEquals("Aston_Villa", n);
        assertEquals("14", P.outSmallestSpread("D:\\Downloads\\weather.dat"));
    }
}