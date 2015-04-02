package argumentointivihreet.kali;

import argumentointivihreet.Pelaaja;
import argumentointivihreet.logiikka.Peli;
import argumentointivihreet.Vaite;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TekstiKali {

    private Peli peli;
    private Scanner lukija;

    public TekstiKali() throws IOException {
        this.lukija = new Scanner(System.in);
        this.peli = new Peli(new File("vihreet.csv"), new File("highscore.csv"));
    }

    public void kaynnista() {
        while (true) {
            System.out.println("1. Pelaa");
            System.out.println("2. Tarkastele highscore-listaa");
            System.out.println("3. Lopeta");
            System.out.print(">");

            String syote = lukija.nextLine();
            
            if (!(syote.equals("1") || syote.equals("2") || syote.equals("3"))) {
                continue;
            }
            
            int komento = Integer.parseInt(syote);

            if (komento == 1) {
                try {
                    pelaa();
                } catch (NumberFormatException | IOException ex) {
                    System.out.println("Virhe käynnistettäessä peliä.");;
                }
            } else if (komento == 2) {
                try {

                    ArrayList<Pelaaja> hs = peli.naytaHS();
                    System.out.println("");
                    System.out.println("-------HIGHSCORE-------");
                    for (Pelaaja pelaaja : hs) {
                        System.out.println(hs.indexOf(pelaaja) + 1 + ". "
                                + pelaaja.getNimi() + " - " + pelaaja.getPisteet() + " pistettä");
                    }
                    System.out.println("-----------------------");
                    System.out.println("");
                } catch (IOException ex) {
                    System.out.println("Virhe lukiessa highscore-listaa.");
                }
            } else if (komento == 3) {
                break;
            }
        }
    }

    private void pelaa() throws NumberFormatException, IOException {
        this.peli = new Peli(new File("vihreet.csv"), new File("highscore.csv"));
        System.out.println("Anna nimimerkki:");

        String nimi = lukija.nextLine();

        peli.getPelaaja().setNimi(nimi);

        System.out.println("Tunnista argumentointivirhe:");

        while (true) {
            Vaite vaite = peli.annaVaite();

            if (vaite == null) {
                try {
                    peli.paivitaHS();
                } catch (IOException ex) {
                    System.out.println("Virhe päivitettäessä highscore-listaa.");
                }
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
                System.out.println(peli.getPelaaja().getPisteet() + " oikein!");
            }
        }

        System.out.println("Pisteet: " + peli.getPelaaja().getPisteet() + "/" + peli.getVaitteet().size());
    }

}
