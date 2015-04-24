
package argumentointivihreet.kali.kuuntelija;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class TakaisinKuuntelija implements ActionListener{
    private CardLayout cl;
    private JPanel panel;

    public TakaisinKuuntelija(CardLayout cl, JPanel panel) {
        this.cl = cl;
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        cl.show(panel, "valikko");
    }
    
}
