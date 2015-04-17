package argumentointivihreet.kali;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public ValikkoKuuntelija(JPanel panel, JButton pelaa, JButton hs, JButton lopeta, CardLayout cl) {
        this.pelaa = pelaa;
        this.hs = hs;
        this.lopeta = lopeta;
        this.cl = cl;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == lopeta) {
            System.exit(0);
        }
        if (ae.getSource() == hs) {
            cl.show(panel, "hs");
        }
        if(ae.getSource() == pelaa) {
            cl.show(panel, "peli");
        }
    }
    
}
