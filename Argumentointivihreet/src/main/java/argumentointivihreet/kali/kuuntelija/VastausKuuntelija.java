package argumentointivihreet.kali.kuuntelija;

import argumentointivihreet.data.Vaite;
import argumentointivihreet.kali.PaivitettavaNakyma;
import argumentointivihreet.kali.PeliNakyma;
import argumentointivihreet.logiikka.Peli;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 */
public class VastausKuuntelija implements ActionListener {

    private CardLayout peliCL;
    private CardLayout cl;
    private PeliNakyma peliNakyma;
    private String vastaus;
    private Peli peli;
    private Vaite vaite;
    private boolean vika;
    private JPanel panel;
    private PaivitettavaNakyma loppu;

    public VastausKuuntelija(CardLayout peliCL, CardLayout cl, PeliNakyma peliNakyma, JPanel panel,
            Peli peli, Vaite vaite, String vastaus, boolean vika,
            PaivitettavaNakyma loppuNakyma) {
        this.peliCL = peliCL;
        this.peliNakyma = peliNakyma;
        this.peli = peli;
        this.vastaus = vastaus;
        this.vaite = vaite;
        this.vika = vika;
        this.panel = panel;
        this.cl = cl;
        this.loppu = loppuNakyma;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        peli.vastaa(this.vaite, vastaus);

        if (vika) {
            try {

                peli.annaVaite();

            } catch (IOException ex) {
                System.out.println("Väitettä ei voitu hakea.");
            }
            loppu.setPeli(peli);
            loppu.paivitaNakyma();
            try {

                peliNakyma.setPeli(new Peli(new File("vihreet.csv"), new File("highscore.csv")));

            } catch (IOException ex) {

                System.out.println("Pelinäkymää ei voitu päivittää :(");
            }
            cl.show(panel, "loppu");

        } else {
            peliCL.next(peliNakyma);
        }

    }

}
