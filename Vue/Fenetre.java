package Vue;

import java.awt.Dimension;
import javax.swing.JFrame;
/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class Fenetre extends JFrame {

    private VuePlateau vuePlateau;

    public Fenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000, 700));        
        
        vuePlateau = new VuePlateau();
        this.setContentPane(vuePlateau);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
