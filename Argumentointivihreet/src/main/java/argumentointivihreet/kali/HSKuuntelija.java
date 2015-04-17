
package argumentointivihreet.kali;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class HSKuuntelija implements ActionListener{
    private CardLayout cl;
    private JPanel panel;

    public HSKuuntelija(CardLayout cl, JPanel panel) {
        this.cl = cl;
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        cl.show(panel, "valikko");
    }
    
}
