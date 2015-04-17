
package argumentointivihreet.tiedostonkasittely;

import argumentointivihreet.data.Pelaaja;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Luokka tarjoaa metodin Highscore-listan lukemiseen
 */
public class HighScoreLukija {
    private CSVReader lukija;

    public HighScoreLukija(File tiedosto) throws FileNotFoundException {
        this.lukija = new CSVReader(new FileReader(tiedosto));
    }
    
    /**
     * Metodi lukee Highscore-listan CSV-tiedostosta
     * 
     * @return Highscore-lista
     * @throws IOException 
     */
    public ArrayList<Pelaaja> lueHighScore() throws IOException {
        ArrayList<Pelaaja> pelaajat = new ArrayList<>();
        String[] rivi;
        
        while ((rivi = this.lukija.readNext()) != null) {
            pelaajat.add(new Pelaaja(rivi[0], Integer.parseInt(rivi[1])));
        }
        
        return pelaajat;
    } 
    
}
