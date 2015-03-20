package argumentointivihreet.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    private ArrayList<Vaite> vaitteet;
    private ArrayList<String> virheet;
    private Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String virhe1 = "eka virhe";
        Vaite vaite1 = new Vaite("eka väite", virhe1);
        String virhe2 = "toka virhe";
        Vaite vaite2 = new Vaite("toka väite", virhe2);
        Vaite vaite3 = new Vaite("kolmas vaite", virhe1);

        String virhe3 = "kolmas virhe";
        String virhe4 = "neljäs virhe";
        String virhe5 = "viides virhe";

        this.virheet = new ArrayList<>();
        this.vaitteet = new ArrayList<>();

        this.virheet.add(virhe1);
        this.virheet.add(virhe2);
        this.virheet.add(virhe3);
        this.virheet.add(virhe4);
        this.virheet.add(virhe5);

        this.vaitteet.add(vaite1);
        this.vaitteet.add(vaite2);
        this.vaitteet.add(vaite3);

        this.peli = new Peli(this.vaitteet, this.virheet);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void vastaaPalauttaaTrueKunVastausOikein() {

        Vaite vaite = this.vaitteet.get(0);
        boolean vastaus = this.peli.vastaa(vaite, vaite.getVirhe());

        assertEquals(true, vastaus);
    }

    @Test
    public void vastaaPalauttaaFalseKunVastausVaarin() {
        Vaite vaite = this.vaitteet.get(0);
        boolean vastaus = this.peli.vastaa(vaite, this.virheet.get(4));

        assertEquals(false, vastaus);
    }

    @Test
    public void arvoVaihtoehdotSisaltaaOikeanVastauksen() {
        Vaite vaite = this.vaitteet.get(0);
        ArrayList<String> vaihtoehdot = this.peli.arvoVaihtoehdot(vaite);

        assertEquals(true, vaihtoehdot.contains(vaite.getVirhe()));
    }

    @Test
    public void arvoVaihtoehdotPalauttaaNeljaVirhetta() {
        Vaite vaite = this.vaitteet.get(0);
        ArrayList<String> vaihtoehdot = this.peli.arvoVaihtoehdot(vaite);
        
        assertEquals(4, vaihtoehdot.size());
    }
    
    

    @Test
    public void annaVaitePalauttaaVaitteen() {
        Vaite vaite = this.peli.annaVaite();

        assertNotNull(vaite);
    }

    @Test
    public void annaVaitePalauttaaEriKerroillaEriVaitteet() {
        Vaite v1 = this.peli.annaVaite();
        Vaite v2 = this.peli.annaVaite();

        assertNotEquals(v1, v2);
    }
    
    @Test
    public void annaVaitePalauttaaNullKunKaikkiVaitteetOnPalautettuKerran() {
        for (int i = 0; i < this.vaitteet.size(); i++) {
            this.peli.annaVaite();
        }
        assertNull(this.peli.annaVaite());
    }

}
