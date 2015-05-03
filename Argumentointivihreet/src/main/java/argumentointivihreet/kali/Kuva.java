package argumentointivihreet.kali;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 */
public class Kuva extends JPanel {

    private String nimi;
    private int suunSijainti;
    private int suunta;

    public Kuva(String nimi) {
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(128, 140));
        this.nimi = nimi;
        suunSijainti = 0;
        suunta = 5;

        Timer timer = new Timer(150, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                suunSijainti += suunta;
                if (suunta == 5) {
                    suunta = -5;
                } else {
                    suunta = 5;
                }
                repaint();
            }
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        try {
            BufferedImage paa = ImageIO.read(new File("kuvat/" + this.nimi + "_paa.png"));
            BufferedImage suu = ImageIO.read(new File("kuvat/" + this.nimi + "_suu.png"));
            graphics.drawImage(paa, 0, 0, this);
            graphics.drawImage(suu, 0, suunSijainti, this);
        } catch (IOException ex) {

        }

    }

}
