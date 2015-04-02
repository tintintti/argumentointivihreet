package argumentointivihreet.logiikka;

import argumentointivihreet.Vaite;
import argumentointivihreet.Pelaaja;
import argumentointivihreet.tiedostonkasittely.TiedostoLukija;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Peli {

    private TiedostoLukija lukija;
    private ArrayList<Vaite> vaitteet;
    private ArrayList<String> virheet;
    private int monesVaite;
    private Pelaaja pelaaja;
    private HighScore hs;

    public Peli(File argumentit, File highscore) throws IOException {
        this.lukija = new TiedostoLukija(argumentit);
        this.vaitteet = lukija.getVaitteet();
        this.virheet = lukija.getVirheet();
        this.monesVaite = 0;
        Collections.shuffle(vaitteet);
        this.pelaaja = new Pelaaja();
        this.hs = new HighScore(highscore);
    }

    public ArrayList<Vaite> getVaitteet() {
        return vaitteet;
    }

    public void setVaitteet(ArrayList<Vaite> vaitteet) {
        this.vaitteet = vaitteet;
    }

    public ArrayList<String> getVirheet() {
        return virheet;
    }

    public void setVirheet(ArrayList<String> virheet) {
        this.virheet = virheet;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    public boolean vastaa(Vaite vaite, String vastaus) {
        if (vaite.tarkistaVastaus(vastaus)) {
            this.pelaaja.lisaaPiste();
            return true;
        }
        return false;
    }
    
    public Vaite annaVaite() {
        
        if (monesVaite < this.vaitteet.size()) {
            Vaite palautettava = this.vaitteet.get(monesVaite);
            monesVaite++;

            return palautettava;
        }
        
        return null;
    }
    
    public ArrayList<String> arvoVaihtoehdot(Vaite v) {
        ArrayList<String> vaihtoehdot = new ArrayList<>();
        ArrayList<String> virheetIlmanOikeaaVastausta = new ArrayList<>(virheet);
        
        vaihtoehdot.add(v.getVirhe());
        virheetIlmanOikeaaVastausta.remove(v.getVirhe());
        
        Collections.shuffle(virheetIlmanOikeaaVastausta);
        
        for (int i = 0; i < 3; i++) {            
            vaihtoehdot.add(virheetIlmanOikeaaVastausta.get(i));
        }
        
        Collections.shuffle(vaihtoehdot);
        
        return vaihtoehdot;
    }

    
    public ArrayList<Pelaaja> naytaHS() throws IOException {
        return hs.lueHS();
    }
    
    public void paivitaHS() throws IOException {
        ArrayList<Pelaaja> score = hs.lueHS();
        
        score.add(pelaaja);
        hs.paivitaHS(score);
    }
    
}
