
package argumentointivihreet.kali;

import argumentointivihreet.kali.kuuntelija.TakaisinKuuntelija;
import argumentointivihreet.logiikka.Peli;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 */
public class LoppuNakyma extends JPanel implements PaivitettavaNakyma {
    private CardLayout cl;
    private JPanel panel;
    private Peli peli;
    private int pisteet;
    private PaivitettavaNakyma hs;
    
    public LoppuNakyma(CardLayout cl, JPanel panel, Peli peli, PaivitettavaNakyma hs) {
        this.cl = cl;
        this.panel = panel;
        this.peli = peli;
        this.hs = hs;
        
        pisteet = 0;
        luoKomponentit();
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
    
    private void luoKomponentit() {
        JLabel teksti = new JLabel("Sait yhteensä " + this.pisteet + " pistettä!");
        JButton takaisin = new JButton("Takaisin valikkoon");
        
        takaisin.addActionListener(new TakaisinKuuntelija(cl, panel));
        
        this.add(teksti);
        this.add(takaisin);
    }

    public void setPeli(Peli peli) {
        this.peli = peli;
    }
    
    @Override
    public void paivitaNakyma() {
        
        this.pisteet = this.peli.getPelaaja().getPisteet();
        this.removeAll();
        this.luoKomponentit();
    }
    
}
