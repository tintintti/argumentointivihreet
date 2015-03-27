package argumentointivihreet;

import argumentointivihreet.kali.TekstiKali;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        try {
            TekstiKali kali = new TekstiKali();
            kali.kaynnista();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
