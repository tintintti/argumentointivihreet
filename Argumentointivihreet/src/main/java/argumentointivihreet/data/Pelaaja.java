package argumentointivihreet.data;

/**
 *
 * Luokkaan tallennetaan pelaajan nimimerkin ja pistetilanteen, ja se tarjoaa
 * metodit pisteiden lisäämiseen pelaajalle
 *
 */
public class Pelaaja implements Comparable<Pelaaja> {

    private String nimi;
    private int pisteet;

    public Pelaaja(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteet = pisteet;
    }

    public Pelaaja() {
        this("", 0);
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

    /**
     *
     * Metodi lisää yhden pisteen pelaajalle
     *
     */
    public void lisaaPiste() {
        this.pisteet++;
    }

    /**
     *
     * Metodi lisää pyydetyn määrän pisteitä pelaajalle
     *
     * @param maara Lisättävien pisteiden määrä
     *
     */
    public void lisaaPisteita(int maara) {
        this.pisteet += maara;
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
