
package argumentointivihreet.kali;

import argumentointivihreet.logiikka.Peli;
import argumentointivihreet.logiikka.Vaite;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TekstiKali {
    private Peli peli;
    private Scanner lukija;
    
    public TekstiKali() throws IOException {
        
        this.peli = new Peli(new File("vihreet.csv"));
        this.lukija = new Scanner(System.in);
    }
    
    public void kaynnista() {
        System.out.println("Tunnista argumentointivirhe:");
        
        while(true) {
            Vaite vaite = peli.annaVaite();
            
            if(vaite == null) {
                break;
            }
            
            System.out.println(vaite.getVaite());
            System.out.println("Valitse oikea argumentointivirhe:");
            
            ArrayList<String> vaihtoehdot = peli.arvoVaihtoehdot(vaite);
            
            for (int i = 0; i < vaihtoehdot.size(); i++) {
                System.out.println(i + ": " + vaihtoehdot.get(i));
            }
            System.out.print("> ");
            int vastaus = Integer.parseInt(lukija.nextLine());
            if (peli.vastaa(vaite, vaihtoehdot.get(vastaus))) {
                System.out.println("oikein!");
            }
        }
        
    }
    
}
