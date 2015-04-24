
package argumentointivihreet.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AjastinTest {
    private Ajastin ajastin;
    
    public AjastinTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.ajastin = new Ajastin();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaAjaksi30Sek() {
        assertEquals(30, this.ajastin.getAika());
    }
    
    @Test
    public void laskuriPalauttaaOikeanAjanKunSeOnJuuriKaynnistetty() {
        ajastin.start();
        assertEquals(30, ajastin.getAika());
    }
    
    @Test
    public void laskuriPalauttaaOikeanArvonKunSeOnKaynytHetken() throws InterruptedException {
        ajastin.start();
        Thread.sleep(5001);
        assertEquals(25, ajastin.getAika());
    }
}
