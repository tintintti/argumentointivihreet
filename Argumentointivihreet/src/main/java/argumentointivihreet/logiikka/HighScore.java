
package argumentointivihreet.logiikka;

import argumentointivihreet.Pelaaja;
import argumentointivihreet.tiedostonkasittely.HighScoreKirjoittaja;
import argumentointivihreet.tiedostonkasittely.HighScoreLukija;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HighScore {
    private File tiedosto;

    public HighScore(File tiedosto) throws IOException {
        this.tiedosto = tiedosto;
    }
    
    public void paivitaHS(ArrayList<Pelaaja> score) throws IOException {
        HighScoreKirjoittaja kirjoittaja = new HighScoreKirjoittaja(tiedosto);
        kirjoittaja.kirjoita(score);
    }
    
    public ArrayList<Pelaaja> lueHS() throws IOException {
        HighScoreLukija lukija = new HighScoreLukija(tiedosto);
        return lukija.lueHighScore();
    }
    
}