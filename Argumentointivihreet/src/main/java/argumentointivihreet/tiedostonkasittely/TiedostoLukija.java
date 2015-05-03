package argumentointivihreet.tiedostonkasittely;

import argumentointivihreet.data.Vaite;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Luokka tarjoaa metodit väitteiden ja niihin liittyvien argumentointivirheiden
 * lukemiseen CSV-tiedostosta
 *
 */
public class TiedostoLukija {

    CSVReader lukija;
    private File tiedosto;
    private ArrayList<Vaite> vaitteet;

    public TiedostoLukija(File tiedosto) throws FileNotFoundException, IOException {
        this.lukija = new CSVReader(new FileReader(tiedosto));
        this.tiedosto = tiedosto;
        this.vaitteet = new ArrayList<>();
        lueVaitteet();
    }

    public ArrayList<Vaite> getVaitteet() throws IOException {
        return this.vaitteet;
    }

    private void lueVaitteet() throws IOException {
        String[] rivi;

        while ((rivi = this.lukija.readNext()) != null) {
            vaitteet.add(new Vaite(rivi[0], rivi[1], rivi[2]));
        }
    }

    public ArrayList<String> getVirheet() {
        ArrayList<String> virheet = lueVirheet();

        return virheet;
    }

    private ArrayList<String> lueVirheet() {
        ArrayList<String> virheet = new ArrayList<>();
        for (Vaite vaite : this.vaitteet) {
            if (!(virheet.contains(vaite.getVirhe()))) {
                virheet.add(vaite.getVirhe());
            }
        }
        return virheet;
    }

}
