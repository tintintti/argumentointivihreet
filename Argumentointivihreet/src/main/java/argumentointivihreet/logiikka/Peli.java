package argumentointivihreet.logiikka;

import java.util.ArrayList;
import java.util.Collections;

public class Peli {

    private ArrayList<Vaite> vaitteet;
    private ArrayList<String> virheet;
    private int monesVaite;

    public Peli(ArrayList<Vaite> vaitteet, ArrayList<String> virheet) {
        this.vaitteet = vaitteet;
        this.virheet = virheet;
        this.monesVaite = 0;
        Collections.shuffle(vaitteet);
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

    public boolean vastaa(Vaite vaite, String vastaus) {

        return vaite.tarkistaVastaus(vastaus);

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
        
        return vaihtoehdot;
    }

}
