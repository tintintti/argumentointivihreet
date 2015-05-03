package argumentointivihreet.kali;

import argumentointivihreet.data.Vaite;
import argumentointivihreet.kali.kuuntelija.VastausKuuntelija;
import argumentointivihreet.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Luokka luo pelinäkymän sekä tarjoaa metodin näkymän päivittämiseen
 */
public class PeliNakyma extends JPanel implements PaivitettavaNakyma {

    private CardLayout cl;
    private JPanel parent;
    private PaivitettavaNakyma loppu;
    private Peli peli;

    public PeliNakyma(CardLayout cl, JPanel parent, PaivitettavaNakyma loppu, Peli peli) {

        this.cl = cl;
        this.parent = parent;
        this.loppu = loppu;
        this.peli = peli;

        try {
            luoKomponentit();
        } catch (IOException ex) {
            System.out.println("Pelinäkymän luonti epäonnistui :(");
        }
    }

    private void luoKomponentit() throws IOException {

        CardLayout peliCL = new CardLayout();
        this.setLayout(peliCL);

        for (int i = 0; i < peli.vaitteidenLkm(); i++) {
            JPanel kysymysNakyma = new JPanel();
            kysymysNakyma.setBackground(Color.WHITE);

            luoKysymysNakyma(kysymysNakyma, peliCL);
            this.add(kysymysNakyma, "k" + i);
        }

        peliCL.show(this, "k0");
    }

    private void luoKysymysNakyma(JPanel kysymysNakyma, CardLayout peliCL) throws IOException {

        JTextArea vaite = new JTextArea(25, 35);
        vaite.setEditable(false);
        vaite.setLineWrap(true);
        vaite.setWrapStyleWord(true);

        JPanel vastausVaihtoehdot = new JPanel();
        vastausVaihtoehdot.setLayout(new GridLayout(4, 1));

        Vaite v = peli.annaVaite();

        vaite.append(v.getVaite());

        ArrayList<Vaite> vaitteet = peli.getVaitteet();
        boolean vika = false;

        if (v.equals(vaitteet.get(vaitteet.size() - 1))) {
            vika = true;
        }

        ArrayList<String> vaihtoehdot = peli.arvoVaihtoehdot(v);

        for (String vaiht : vaihtoehdot) {
            JButton nappi = new JButton(vaiht);

            nappi.addActionListener(new VastausKuuntelija(peliCL, cl, this, parent, this.peli, v, vaiht, vika, loppu));
            vastausVaihtoehdot.add(nappi);
        }

        Kuva kuva = new Kuva(v.getPuhuja());

        kysymysNakyma.add(kuva, BorderLayout.WEST);

        kysymysNakyma.add(vaite);
        kysymysNakyma.add(vastausVaihtoehdot, BorderLayout.SOUTH);
    }
    
    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void paivitaNakyma() {
        this.removeAll();
        try {
            this.luoKomponentit();
        } catch (IOException ex) {
            System.out.println("Pelinäkymää ei voitu päivittää :(");
        }
    }
}
