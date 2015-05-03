package argumentointivihreet.kali;

import argumentointivihreet.logiikka.Peli;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 */
public class GraafinenKali implements Runnable {

    private Peli peli;
    private JFrame frame;

    public GraafinenKali() {
    }

    @Override
    public void run() {
        frame = new JFrame("Argumentaatiovihreet");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (IOException ex) {
        }

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) throws IOException {
        this.peli = new Peli(new File("vihreet.csv"), new File("highscore.csv"));
        
        JPanel panel = new JPanel();
        CardLayout cl = new CardLayout();
        panel.setLayout(cl);
        
        HSNakyma hsNakyma = new HSNakyma(peli, cl, panel);
        AlkuNakyma alkuNakyma = new AlkuNakyma(peli, cl, panel);
        LoppuNakyma loppu = new LoppuNakyma(cl, panel, peli, hsNakyma);
        PeliNakyma peliNakyma = new PeliNakyma(cl, panel, loppu, peli);
        ValikkoNakyma valikkoNakyma = new ValikkoNakyma(cl, panel, peli, hsNakyma, alkuNakyma, peliNakyma);


        panel.add(valikkoNakyma, "valikko");
        panel.add(peliNakyma, "peli");
        panel.add(hsNakyma, "hs");
        panel.add(loppu, "loppu");
        panel.add(alkuNakyma, "aloitus");

        cl.show(panel, "valikko");

        container.add(panel);
    }


}
