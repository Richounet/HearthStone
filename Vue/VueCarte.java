package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class VueCarte extends JPanel {

    private int largeur;
    private int longueur;

    public VueCarte(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.setPreferredSize(new Dimension(this.longueur, this.largeur));
        this.setBackground(Color.orange);
    }
}
