
package argumentointivihreet;

public class Pelaaja implements Comparable<Pelaaja>{
    private String nimi;
    private int pisteet;

    public Pelaaja(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteet = pisteet;
    }
    
    public Pelaaja() {
        this("",0);
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
    
    public void lisaaPiste() {
        this.pisteet++;
    }

    @Override
    public int compareTo(Pelaaja verrattava) {
        return verrattava.pisteet - this.pisteet;
    }

    @Override
    public String toString() {
        return "Pelaaja{" + "nimi=" + nimi + ", pisteet=" + pisteet + '}';
    }
    
}
