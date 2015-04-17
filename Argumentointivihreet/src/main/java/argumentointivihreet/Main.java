package argumentointivihreet;

import argumentointivihreet.kali.Kali;
import argumentointivihreet.kali.TekstiKali;
import argumentointivihreet.logiikka.Peli;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Kali kali;
        try {
            kali = new Kali(new Peli(new File("vihreet.csv"), new File("highscore.csv")));
            SwingUtilities.invokeLater(kali);
        } catch (IOException ex) {
            System.out.println("Virhe käynnistäessä peliä :(");;
        }
        
        
//        try {
//            TekstiKali kali = new TekstiKali();
//            kali.kaynnista();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
