package argumentointivihreet.logiikka;

import java.util.Objects;

public class Vaite {

    private String vaite;
    private String virhe;

    public Vaite(String vaite, String virhe) {
        this.vaite = vaite;
        this.virhe = virhe;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.vaite);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaite other = (Vaite) obj;
        if (!Objects.equals(this.vaite, other.vaite)) {
            return false;
        }
        return true;
    }
    
    

    public boolean tarkistaVastaus(String vastaus) {

        if (this.virhe.equals(vastaus)) {
            return true;
        }

        return false;
    }

}
