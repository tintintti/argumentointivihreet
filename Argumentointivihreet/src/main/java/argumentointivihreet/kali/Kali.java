package argumentointivihreet.kali;

import argumentointivihreet.data.Pelaaja;
import argumentointivihreet.data.Vaite;
import argumentointivihreet.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 */
public class Kali implements Runnable {

    private Peli peli;
    private JFrame frame;

    public Kali(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Argumentaatiovihreet");
        frame.setPreferredSize(new Dimension(450, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (IOException ex) {
            System.out.println("ei toimi :(");;
        }

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) throws IOException {
        JPanel panel = new JPanel();
        CardLayout cl = new CardLayout();
        panel.setLayout(cl);

        JPanel valikkoNakyma = new JPanel();
        JPanel peliNakyma = new JPanel();
        JPanel hsNakyma = new JPanel();
        JPanel loppu = new JPanel();
        JPanel annaNimi = new JPanel();

        luoHsNakyma(hsNakyma, cl, panel);
        luoValikkoNakyma(valikkoNakyma, cl, panel);
        luoPeliNakyma(peliNakyma, cl, panel);

        panel.add(valikkoNakyma, "valikko");
        panel.add(peliNakyma, "peli");
        panel.add(hsNakyma, "hs");
        panel.add(loppu, "loppu");
        panel.add(annaNimi, "nimi");

        cl.show(panel, "valikko");

        container.add(panel);
    }

    private void luoValikkoNakyma(JPanel valikkoNakyma, CardLayout cl, JPanel panel) {
        valikkoNakyma.setLayout(new GridLayout(3, 1));

        JButton pelaa = new JButton("Pelaa");
        JButton hs = new JButton("Highscore");
        JButton lopeta = new JButton("Lopeta");

        ValikkoKuuntelija kuuntelija = new ValikkoKuuntelija(panel, pelaa, hs, lopeta, cl);

        pelaa.addActionListener(kuuntelija);
        hs.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);

        valikkoNakyma.add(pelaa);
        valikkoNakyma.add(hs);
        valikkoNakyma.add(lopeta);
    }

    private void luoHsNakyma(JPanel hsNakyma, CardLayout cl, JPanel panel) throws IOException {
        JTextArea hsLista = new JTextArea(30, 30);
        hsLista.setEditable(false);

        ArrayList<Pelaaja> score = peli.naytaHS();
        String hsMerkkijonona = "-------HIGHSCORE-------\n\n";

        for (Pelaaja p : score) {
            hsMerkkijonona += score.indexOf(p) + 1 + ". " + p.getNimi() + " " + p.getPisteet() + " pistettä\n";
        }
        hsLista.append(hsMerkkijonona);

        JButton takaisin = new JButton("Takaisin valikkoon");
        takaisin.addActionListener(new HSKuuntelija(cl, panel));

        hsNakyma.add(hsLista);
        hsNakyma.add(takaisin, BorderLayout.SOUTH);
    }

    // WIP! Pelinäkymään tulee näkyiin vasta yksi väite ilman mitään toiminnallisuutta
    private void luoPeliNakyma(JPanel peliNakyma, CardLayout cl, JPanel panel) throws IOException {
        JTextArea vaite = new JTextArea(25, 35);
        vaite.setEditable(false);
        vaite.setLineWrap(true);
        vaite.setWrapStyleWord(true);

        JPanel vastausVaihtoehdot = new JPanel();
        vastausVaihtoehdot.setLayout(new GridLayout(4, 1));

        Vaite v = peli.annaVaite();

        System.out.println(v.getVaite());
        vaite.append(v.getVaite());

        ArrayList<String> vaihtoehdot = peli.arvoVaihtoehdot(v);

        for (String vaiht : vaihtoehdot) {
            JButton nappi = new JButton(vaiht);
            vastausVaihtoehdot.add(nappi);
            System.out.println(vaiht);
        }

        peliNakyma.add(vaite);
        peliNakyma.add(vastausVaihtoehdot, BorderLayout.SOUTH);
    }

}
