
package argumentointivihreet.kali.kuuntelija;

import argumentointivihreet.logiikka.Peli;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 */
public class AloitusKuuntelija implements ActionListener {
    private CardLayout cl;
    private JPanel panel;
    private Peli peli;
    private JTextField nimi;

    public AloitusKuuntelija(CardLayout cl, JPanel panel, Peli peli, JTextField nimi) {
        this.cl = cl;
        this.panel = panel;
        this.peli = peli;
        this.nimi = nimi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.peli.asetaPelaajanNimi(nimi.getText());
        cl.show(panel, "peli");
    }
    
    public void uusiPeli(Peli peli) {
        this.peli = peli;
    }
    
}
