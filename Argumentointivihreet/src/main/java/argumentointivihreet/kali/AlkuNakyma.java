package argumentointivihreet.kali;

import argumentointivihreet.kali.kuuntelija.AloitusKuuntelija;
import argumentointivihreet.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Luokka luo pelin aloitusnäkymän, jossa pyydetään käyttäjältä nimimerkki ja
 * kerrotaan pelin säännöt sekä tarjoaa metodin näkymän päivittämiseen
 */
public class AlkuNakyma extends JPanel implements PaivitettavaNakyma {

    private Peli peli;
    private CardLayout cl;
    private JPanel parent;

    public AlkuNakyma(Peli peli, CardLayout cl, JPanel parent) {
        this.peli = peli;
        this.cl = cl;
        this.parent = parent;

        luoKomponentit();
    }

    private void luoKomponentit() {
        JPanel ylempi = new JPanel();
        JPanel alempi = new JPanel();

        ylempi.setPreferredSize(new Dimension(500, 250));
        alempi.setPreferredSize(new Dimension(500, 250));

        JTextArea saannot = new JTextArea(10, 30);
        saannot.setEditable(false);
        saannot.setLineWrap(true);
        saannot.setWrapStyleWord(true);

        saannot.append("Säännöt:\n\n"
                + "Valitse annettuun väitteeseen liittyvä argumentointivirhe. \n\n"
                + "Nopeasta vastaamisesta saat lisäpisteitä!\n\n"
                + "Voit pelata ilman nimimerkkiä, mutta tällöin tuloksesi ei tallennu Highscore-listalle.");

        JLabel annaNimi = new JLabel("Anna nimimerkki:");
        JTextField nimi = new JTextField(10);
        JButton pelaa = new JButton("Aloita!");

        pelaa.addActionListener(new AloitusKuuntelija(cl, parent, peli, nimi));

        ylempi.add(saannot);
        alempi.add(annaNimi);
        alempi.add(nimi, BorderLayout.SOUTH);
        alempi.add(pelaa);

        ylempi.setBackground(Color.WHITE);
        alempi.setBackground(Color.WHITE);

        this.add(ylempi, BorderLayout.NORTH);
        this.add(alempi, BorderLayout.SOUTH);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void paivitaNakyma() {
        this.removeAll();
        this.luoKomponentit();
    }

}
