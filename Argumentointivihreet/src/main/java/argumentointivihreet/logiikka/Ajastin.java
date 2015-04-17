package argumentointivihreet.logiikka;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Luokka tarjoaa metodit ajastimelle, jonka mukaan pelaaja voi saada lisäpisteitä
 * nopeasta vastaamisesta
 * 
 */
public class Ajastin extends Thread {

    private int aika;

    public Ajastin() {
        this.aika = 10;
    }

    public int getAika() {
        return aika;
    }

    /**
     * Metodi resetoi laskurin takaisin alkuperäiseen arvoon
     */
    public void resetoi() {
        this.aika = 10;
    }
    
    @Override
    public void run() {
        kaynnista();
    }

    /**
     * Metodi aloittaa laskemisen laskurin alkuperäisesta arvosta alaspäin nollaan asti sekunnin välein
     */
    public void kaynnista() {
        while (aika > 0) {
            try {
                Thread.sleep(1000);
                aika--;
            } catch (InterruptedException ex) {
                Logger.getLogger(Ajastin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
