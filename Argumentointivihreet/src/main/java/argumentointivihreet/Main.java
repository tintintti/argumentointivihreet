package argumentointivihreet;

import argumentointivihreet.kali.Kali;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Kali kali = new Kali();
        SwingUtilities.invokeLater(kali);

    }
}
