package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class VuePlateau extends JComponent {

    private VueCarte[][] cases;
    private JLabel[] labels;
    private JButton prochaineEtape;

    public VuePlateau() {
        initialisation();
    }

    public final void initialisation() {

        this.cases = new VueCarte[6][4];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                this.cases[i][j] = new VueCarte(167, 87);
                this.cases[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }

        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        String[] initLabel = {"Vincent : 10pv", "Ressource : 0 / 0", "", "Tour 1, phase 1 (défense)", "Axel : 10pv", "Ressource : 0 / 0",};
        labels = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            this.labels[i] = new JLabel(initLabel[i]);
            this.labels[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }
        this.prochaineEtape = new JButton("Phase Suivante");

        // Gestionnaire de placement
        GridBagConstraints cont = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        //cont.weightx = cont.weighty = 1.0;

        //Cases du plateau
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                cont.fill = GridBagConstraints.BOTH;
                cont.gridx = 0 + i;
                cont.gridy = 1 + j;
                cont.gridwidth = 1;
                cont.gridheight = 1;
                this.add(cases[i][j], cont);
            }
        }

        // Joueur 1 : Nom + PV
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth = 4;
        cont.gridheight = 1;
        this.add(labels[0], cont);

        // Joueur 1 : Ressource
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 5;
        cont.gridy = 0;
        cont.gridwidth = 2;
        cont.gridheight = 1;
        this.add(labels[1], cont);

        // Commentaire
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 5;
        cont.gridy = 1;
        cont.gridwidth = 2;
        cont.gridheight = 4;
        this.add(labels[2], cont);

        // Phase
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 5;
        cont.gridy = 5;
        cont.gridwidth = 2;
        cont.gridheight = 1;
        this.add(labels[3], cont);

        // Bouton prochaine étape
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 4;
        cont.gridy = 6;
        cont.gridwidth = 2;
        cont.gridheight = 1;
        this.add(prochaineEtape, cont);

        // Joueur 2 : Nom + PV
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 0;
        cont.gridy = 7;
        cont.gridwidth = 2;
        cont.gridheight = 1;
        this.add(labels[4], cont);

        // Joueur 2 : Ressources
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 5;
        cont.gridy = 7;
        cont.gridwidth = 2;
        cont.gridheight = 1;
        this.add(labels[5], cont);
    }
}
