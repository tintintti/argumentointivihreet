package argumentointivihreet.kali.kuuntelija;

import argumentointivihreet.kali.PaivitettavaNakyma;
import argumentointivihreet.logiikka.Peli;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * Luokka kuuntelee valikkonäkymän nappeja ja vaihtaa CardLayoutin näkymää sen mukaan
 * mitä napeista painetaan
 *
 */
public class ValikkoKuuntelija implements ActionListener {

    private JButton pelaa;
    private JButton hs;
    private JButton lopeta;
    private CardLayout cl;
    private JPanel panel;
    private Peli peli;
    private PaivitettavaNakyma hsNakyma;
    private PaivitettavaNakyma peliNakyma;
    private PaivitettavaNakyma alku;

    public ValikkoKuuntelija(Peli peli, JPanel panel, JButton pelaa, JButton hs, JButton lopeta, 
                             CardLayout cl, PaivitettavaNakyma hsNakyma, PaivitettavaNakyma peliNakyma, PaivitettavaNakyma alku) {
        this.pelaa = pelaa;
        this.hs = hs;
        this.lopeta = lopeta;
        this.cl = cl;
        this.panel = panel;
        this.hsNakyma = hsNakyma;
        this.peliNakyma = peliNakyma;
        this.alku = alku;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == lopeta) {
            System.exit(0);
        }
        if (ae.getSource() == hs) {
            this.hsNakyma.paivitaNakyma();
            cl.show(panel, "hs");
        }
        if(ae.getSource() == pelaa) {
            try {
                this.peli = new Peli(new File("vihreet.csv"), new File("highscore.csv"));
                
                alku.setPeli(peli);
                peliNakyma.setPeli(peli);
                
                alku.paivitaNakyma();
                peliNakyma.paivitaNakyma();
                
            } catch (IOException ex) {
                System.out.println("Peliä ei voitu käynnistää");
            }
            
            cl.show(panel, "aloitus");
        }
    }
    
}
