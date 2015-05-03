package argumentointivihreet.kali;

import argumentointivihreet.kali.kuuntelija.ValikkoKuuntelija;
import argumentointivihreet.logiikka.Peli;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luokka luo pelin valikkonäkymän sekä tarjoaa metodin näymän päivittämiseen
 */
public class ValikkoNakyma extends JPanel implements PaivitettavaNakyma {

    private CardLayout cl;
    private JPanel parent;
    private PaivitettavaNakyma hsNakyma;
    private PaivitettavaNakyma peliNakyma;
    private PaivitettavaNakyma alku;
    private Peli peli;

    public ValikkoNakyma(CardLayout cl, JPanel parent, Peli peli, PaivitettavaNakyma hsNakyma, PaivitettavaNakyma alku, PaivitettavaNakyma peliNakyma) {
        this.alku = alku;
        this.peliNakyma = peliNakyma;
        this.cl = cl;
        this.parent = parent;
        this.hsNakyma = hsNakyma;

        luoKomponentit();
    }

    private void luoKomponentit() {

        this.setLayout(new GridLayout(3, 1));

        JButton pelaa = new JButton("Pelaa");
        JButton hs = new JButton("Highscore");
        JButton lopeta = new JButton("Lopeta");

        ValikkoKuuntelija kuuntelija = new ValikkoKuuntelija(peli, parent, pelaa, hs, lopeta, cl, hsNakyma, peliNakyma, alku);

        pelaa.addActionListener(kuuntelija);
        hs.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);

        this.add(pelaa);
        this.add(hs);
        this.add(lopeta);
    }

    @Override
    public void paivitaNakyma() {
        try {
            this.peli = new Peli(new File("vihreet.csv"), new File("highscore.csv"));
            alku.setPeli(peli);
            peliNakyma.setPeli(peli);

            alku.paivitaNakyma();
            peliNakyma.paivitaNakyma();

        } catch (IOException ex) {
            System.out.println(":((:(( " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void setPeli(Peli peli) {
        this.peli = peli;
    }

}
