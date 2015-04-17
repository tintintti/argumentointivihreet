package argumentointivihreet.logiikka;

import argumentointivihreet.data.Pelaaja;
import argumentointivihreet.data.Vaite;
import java.io.File;
import java.io.IOException;
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
    public void setUp() throws IOException {

        this.peli = new Peli(new File("testiVihreet.csv"), new File("testiHighscore.csv"));

        peli.setPelaaja(new Pelaaja());
        
        this.vaitteet = peli.getVaitteet();
        this.virheet = peli.getVirheet();

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
        boolean vastaus = this.peli.vastaa(vaite, "väärä vastaus");

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
