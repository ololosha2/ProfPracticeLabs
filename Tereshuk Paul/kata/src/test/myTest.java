import org.junit.Test;
import static junit.framework.Assert.*;

public class myTest {
    @Test
    public void testCalA() throws Exception {
        Program P = new Program();
        int n = P.add("ab-6s123nab;am1m-33n-66a2");

        assertEquals(126, n);
        assertEquals(15,P.add("2jagdaj12&($@-1uio1sf"));
        assertEquals(6,P.add("ajdgla^ual4kafga-1222jljad2jlg"));
    }
}