
package argumentointivihreet.logiikka;

import argumentointivihreet.data.Pelaaja;
import argumentointivihreet.tiedostonkasittely.HighScoreKirjoittaja;
import argumentointivihreet.tiedostonkasittely.HighScoreLukija;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Luokka tarjoaan metodit Highscore-tiedoston lukemiseen ja päivittämiseen.
 * 
 */

public class HighScore {
    private File tiedosto;
    private HighScoreKirjoittaja kirjoittaja;
    private HighScoreLukija lukija;

    public HighScore(File tiedosto) throws IOException {
        this.tiedosto = tiedosto;
    }
    
    /**
     * 
     * Metodi päivittää higscore-tiedostoon annetun pelaajan pisteet
     * 
     * @see argumentointivihreet.tiedostonkasittely.HighScoreKirjoittaja#kirjoita(ArrayList<Pelaaja>) 
     * 
     * @param lisattava Highscore-listalle lisättävä pelaaja
     * @throws IOException 
     */
    public void paivitaHS(Pelaaja lisattava) throws IOException {
        ArrayList<Pelaaja> highscore = this.lueHS();

        highscore.add(lisattava);

        this.kirjoittaja = new HighScoreKirjoittaja(tiedosto);
        kirjoittaja.kirjoita(highscore);
    }
    
    /**
     * 
     * Metodi lukee tiedostosta Highscore-listan
     * 
     * @see argumentointivihreet.tiedostonkasittely.HighScoreLukija#lueHighScore() 
     * 
     * @return Highscore-lista
     * @throws IOException 
     */
    public ArrayList<Pelaaja> lueHS() throws IOException {
        this.lukija = new HighScoreLukija(tiedosto);
        return lukija.lueHighScore();
    }
    
}