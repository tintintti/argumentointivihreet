package argumentointivihreet.data;

import java.util.Objects;

/** 
 * 
 * Luokkaan tallennetaan väite, sen sanoja sekä argumentointivirhe, joka väitteessä on
 * 
 */

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
    
    /**
     * 
    * Metodi tarkistaa onko annettu vastaus sama kuin väitteeseen liittyvä argumentointivirhe
    *
    * @param vastaus Tarkistettava vastaus
    *
    * @return true, jos vastaus on oikein, false jos vastaus on väärin
    * 
    */
    public boolean tarkistaVastaus(String vastaus) {

        if (this.virhe.equals(vastaus)) {
            return true;
        }

        return false;
    }

}
