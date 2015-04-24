package argumentointivihreet.logiikka;

import argumentointivihreet.data.Vaite;
import argumentointivihreet.data.Pelaaja;
import argumentointivihreet.tiedostonkasittely.TiedostoLukija;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Luokka hallinnoi Highscore-listaa ja tarjoaa metodit vastaamiseen, pelaajalle
 * pisteiden lisäämiseen, sekä väitteiden ja vastausvaihtoehtojen hakemiseen
 *
 */
public class Peli {

    private TiedostoLukija lukija;
    private ArrayList<Vaite> vaitteet;
    private ArrayList<String> virheet;
    private int monesVaite;
    private Pelaaja pelaaja;
    private HighScore hs;
    private Ajastin ajastin;

    public Peli(File argumentit, File highscore) throws IOException {
        this.lukija = new TiedostoLukija(argumentit);
        this.hs = new HighScore(highscore);

        this.vaitteet = lukija.getVaitteet();
        this.virheet = lukija.getVirheet();
        this.monesVaite = 0;
        Collections.shuffle(vaitteet);

        this.pelaaja = new Pelaaja();

        this.ajastin = new Ajastin();
    }

    public ArrayList<Vaite> getVaitteet() {
        return vaitteet;
    }

    public ArrayList<String> getVirheet() {
        return virheet;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    /**
     * Asettaa pelin pelaajalle halutun nimi
     *
     * @param nimi Pelaajalle asetettava nimi
     */
    public void asetaPelaajanNimi(String nimi) {
        this.pelaaja.setNimi(nimi);
    }

    /**
     *
     * Metodi lisää pelaajalle pisteen, mikäli pelaajan antama vastaus on oikein
     * ja mahdollisia lisäpisteitä pelaajan vastausajan mukaan
     *
     * @param vaite Väite, josta vastaus tarkistetaan
     * @param vastaus Pelaajan valitsema vastaus
     *
     * @see argumentointivihreet.data.Vaite#tarkistaVastaus(String)
     * @see argumentointivihreet.data.Pelaaja#lisaaPiste()
     * @see argumentointivihreet.data.Pelaaja#lisaaPisteita(int)
     * @see argumentointivihreet.logiikka.Ajastin
     *
     * @return true, jos vastaus on oikein, false jos väärin
     */
    public boolean vastaa(Vaite vaite, String vastaus) {
        if (vaite.tarkistaVastaus(vastaus)) {
            this.pelaaja.lisaaPiste();
            this.pelaaja.lisaaPisteita(ajastin.getAika());
            return true;
        }
        return false;
    }

    /**
     *
     * Metodi palauttaa vaitteet-listalta niin monennen väitteen, kuin mitä
     * väitteitä on palautettu ja tallentaa palautettujen väitteiden määrän
     * muuttujaan monesVaite. Vaitteet-lista sekoitetaan konstruktorissa, jotta
     * väitteiden järjestys vaihtelisi eri pelikerroilla.
     *
     * @return Järjestyksessä seuraava väite
     * @throws java.io.IOException
     */
    public Vaite annaVaite() throws IOException {

        if (monesVaite < this.vaitteet.size()) {
            this.ajastin = new Ajastin();
            this.ajastin.start();
            Vaite palautettava = this.vaitteet.get(monesVaite);
            monesVaite++;

            return palautettava;
        }

        if (!pelaaja.getNimi().isEmpty()) {
            hs.paivitaHS(pelaaja);
        }
        
        return null;
    }

    /**
     *
     * Metodi lisää vaihtoehdot-listalle ensin oikean vastausksen väitteelle,
     * sekoittaa sen jälkeen jäljelle jääneet vastausvaihtoehdot ja lisää niistä
     * kolme vaihtoehdot-listalle, sekä sekoittaa vaihtoehdot-listan
     *
     * @param vaite Väite, jolle vastausvaihtoehdot haetaan
     * @return Vaihtoehdot-lista jolla on oikea vastaus sekä kolme muuta
     * vastausvaihtoehtoa sekaisin
     */
    public ArrayList<String> arvoVaihtoehdot(Vaite vaite) {
        ArrayList<String> vaihtoehdot = new ArrayList<>();
        ArrayList<String> virheetIlmanOikeaaVastausta = new ArrayList<>(virheet);

        vaihtoehdot.add(vaite.getVirhe());
        virheetIlmanOikeaaVastausta.remove(vaite.getVirhe());

        Collections.shuffle(virheetIlmanOikeaaVastausta);

        for (int i = 0; i < 3; i++) {
            vaihtoehdot.add(virheetIlmanOikeaaVastausta.get(i));
        }

        Collections.shuffle(vaihtoehdot);

        return vaihtoehdot;
    }

    /**
     * @see argumentointivihreet.logiikka.HighScore#lueHS()
     *
     * @return Highscore-lista
     * @throws IOException
     */
    public ArrayList<Pelaaja> naytaHS() throws IOException {
        return hs.lueHS();
    }

    /**
     * @return väitteiden lukumäärä
     */
    public int vaitteidenLkm() {
        return this.vaitteet.size();
    }

}
