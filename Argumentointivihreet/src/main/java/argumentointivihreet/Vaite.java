package argumentointivihreet;

import java.util.Objects;

public class Vaite {

    private String vaite;
    private String puhuja;
    private String virhe;

    public Vaite(String vaite, String puhuja, String virhe) {
        this.vaite = vaite;
        this.puhuja = puhuja;
        this.virhe = virhe;
    }

    public String getPuhuja() {
        return puhuja;
    }

    public void setPuhuja(String puhuja) {
        this.puhuja = puhuja;
    }

    
    
    public String getVaite() {
        return vaite;
    }

    public void setVaite(String vaite) {
        this.vaite = vaite;
    }

    public String getVirhe() {
        return virhe;
    }

    public void setVirhe(String virhe) {
        this.virhe = virhe;
    }
    

    public boolean tarkistaVastaus(String vastaus) {

        if (this.virhe.equals(vastaus)) {
            return true;
        }

        return false;
    }

}
