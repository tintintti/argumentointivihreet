
package argumentointivihreet.tiedostonkasittely;

import argumentointivihreet.data.Pelaaja;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Luokka tarjoaa metodin Highscore-listan kirjoittamiseen 
 * 
 */

public class HighScoreKirjoittaja {
    private CSVWriter kirjoitin;

    public HighScoreKirjoittaja(File tiedosto) throws IOException {
        this.kirjoitin = new CSVWriter(new FileWriter(tiedosto));
    }
    
    /**
     * 
     * Metodi järjestää pelaajien tiedot sisältävän listan pelaajien pisteiden mukaan järjestykseen 
     * ja kirjoittaa listan CSV-tiedostoon
     * 
     * @param pelaajat Lista pelaajista, jotka ovat pelanneet peliä
     * @throws IOException 
     */
    public void kirjoita(ArrayList<Pelaaja> pelaajat) throws IOException {
        
        Collections.sort(pelaajat);
        ArrayList<String[]> score = new ArrayList<>();
        
        for (Pelaaja p : pelaajat) {
            String[] lisattava = new String[2];
            
            lisattava[0] = p.getNimi();
            lisattava[1] = "" + p.getPisteet();
            score.add(lisattava);
        }
        
        kirjoitin.writeAll(score);
        kirjoitin.close();
        
    }
    
    
    
}
