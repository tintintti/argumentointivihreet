
package argumentointivihreet.kali;

import argumentointivihreet.data.Pelaaja;
import argumentointivihreet.kali.kuuntelija.TakaisinKuuntelija;
import argumentointivihreet.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Luokka luo näkymän, jossa näytetään Highscore-listaus sekä tarjoaa metodin näkymän päivittämiseen
 */
public class HSNakyma extends JPanel implements PaivitettavaNakyma {

    private Peli peli;
    private CardLayout cl;
    private JPanel panel;

    public HSNakyma(Peli peli, CardLayout cl, JPanel panel) throws IOException {
        this.peli = peli;
        this.cl = cl;
        this.panel = panel;
        
        luoKomponentit();
    }
    
    private void luoKomponentit() throws IOException {
        JTextArea hsLista = new JTextArea(30, 30);
        hsLista.setEditable(false);

        ArrayList<Pelaaja> score = peli.naytaHS();
        String hsMerkkijonona = "-------HIGHSCORE-------\n\n";

        for (Pelaaja p : score) {
            hsMerkkijonona += score.indexOf(p) + 1 + ". " + p.getNimi() + " " + p.getPisteet() + " pistettä\n";
        }
        hsLista.append(hsMerkkijonona);

        JButton takaisin = new JButton("Takaisin valikkoon");
        takaisin.addActionListener(new TakaisinKuuntelija(cl, panel));

        this.add(hsLista);
        this.add(takaisin, BorderLayout.SOUTH);
    }
    
    @Override
    public void paivitaNakyma() {
        this.removeAll();
        try {
            luoKomponentit();
        } catch (IOException ex) {
            System.out.println("Highscore-näkymää ei pystytty päivittämään.");
        }
    }

    @Override
    public void setPeli(Peli peli) {
        this.peli = peli;
    }
    
}
