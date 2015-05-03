package argumentointivihreet;

import argumentointivihreet.kali.GraafinenKali;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        GraafinenKali kali = new GraafinenKali();
        SwingUtilities.invokeLater(kali);

    }
}
