
package argumentointivihreet.kali;

import argumentointivihreet.kali.kuuntelija.AloitusKuuntelija;
import argumentointivihreet.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
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
        JLabel annaNimi = new JLabel("Anna nimimerkki:");
        JTextField nimi = new JTextField(10);
        JButton pelaa = new JButton("Aloita!");

        pelaa.addActionListener(new AloitusKuuntelija(cl, parent, peli, nimi));

        this.add(annaNimi, BorderLayout.NORTH);
        this.add(nimi, BorderLayout.CENTER);
        this.add(pelaa, BorderLayout.SOUTH);
    }

    public void setPeli(Peli peli) {
        this.peli = peli;
    }
    
    @Override
    public void paivitaNakyma() {
        this.removeAll();
        this.luoKomponentit();
    }
    
}
