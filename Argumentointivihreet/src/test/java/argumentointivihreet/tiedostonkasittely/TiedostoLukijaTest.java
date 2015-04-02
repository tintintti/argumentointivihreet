
package argumentointivihreet.tiedostonkasittely;

import argumentointivihreet.Vaite;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostoLukijaTest {
    private TiedostoLukija lukija;
    
    public TiedostoLukijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        lukija = new TiedostoLukija(new File("testiVihreet.csv"));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getVaitteetPalauttaaOikeanPituisenListan() throws IOException {
        ArrayList<Vaite> vaitteet = lukija.getVaitteet();
        assertEquals(9, vaitteet.size());
    }
    
    @Test
    public void getVirheetPalauttaaOikeanPituisenListan() {
        ArrayList<String> virheet = lukija.getVirheet();
        assertEquals(6, virheet.size());
    }
    
}
