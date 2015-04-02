
package argumentointivihreet.tiedostonkasittely;

import argumentointivihreet.Pelaaja;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class HighScoreKirjoittaja {
    private CSVWriter kirjoitin;

    public HighScoreKirjoittaja(File tiedosto) throws IOException {
        this.kirjoitin = new CSVWriter(new FileWriter(tiedosto));
    }
    
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
