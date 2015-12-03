package Vue;

import Controleur.Controleur;
import Modele.Carte.Carte;
import Modele.Carte.Creature;
import Modele.Carte.EtatCreature;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VueCarte extends javax.swing.JPanel implements MouseListener {

    public static Controleur controleur;
    public static FenetrePalette fenetre;

    public VueCarte() {
        initComponents();

        Case = new JPanel[]{
            Case_0_0, Case_0_1, Case_0_2, Case_1_0, Case_1_1, Case_1_2, Case_2_0, Case_2_1, Case_2_2
        };

        SetCarte(null);
        this.addMouseListener(this);
    }

    public VueCarte(String att, String def, String cout, String nom) {
        initComponents();

        SetCardAttack(att);
        SetCardCout(cout);
        SetCardDef(def);
        SetCardNom(nom);
    }

    public VueCarte(Carte c) {
        initComponents();

        Creature cr = (Creature) c;
        SetCardAttack(Integer.toString(cr.getAttaque()));
        SetCardCout(Integer.toString(cr.getCoutRessource()));
        SetCardDef(Integer.toString(cr.getDefense()));
        SetCardNom(cr.getNom());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Case_0_0 = new javax.swing.JPanel();
        cardName = new javax.swing.JLabel();
        Case_0_1 = new javax.swing.JPanel();
        Case_0_2 = new javax.swing.JPanel();
        cardCost = new javax.swing.JLabel();
        Case_1_0 = new javax.swing.JPanel();
        Case_1_1 = new javax.swing.JPanel();
        Case_1_2 = new javax.swing.JPanel();
        Case_2_0 = new javax.swing.JPanel();
        cardAtt = new javax.swing.JLabel();
        Case_2_1 = new javax.swing.JPanel();
        Case_2_2 = new javax.swing.JPanel();
        cardDef = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(164, 91));
        setName("Case_0_1"); // NOI18N
        setPreferredSize(new java.awt.Dimension(164, 91));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.GridLayout(3, 3, 2, 2));

        Case_0_0.setName("Case_0_0"); // NOI18N
        Case_0_0.setLayout(new java.awt.GridLayout());

        cardName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cardName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardName.setText("C1");
        cardName.setAlignmentY(0.0F);
        cardName.setName("cardName"); // NOI18N
        Case_0_0.add(cardName);

        add(Case_0_0);

        Case_0_1.setName("Case_0_1"); // NOI18N
        Case_0_1.setLayout(new java.awt.GridLayout());
        add(Case_0_1);

        Case_0_2.setName("Case_0_2"); // NOI18N
        Case_0_2.setLayout(new java.awt.GridLayout());

        cardCost.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cardCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardCost.setText("1");
        cardCost.setAlignmentY(0.0F);
        Case_0_2.add(cardCost);

        add(Case_0_2);

        Case_1_0.setName("Case_1_0"); // NOI18N
        Case_1_0.setLayout(new java.awt.GridLayout());
        add(Case_1_0);

        Case_1_1.setBackground(new java.awt.Color(204, 204, 204));
        Case_1_1.setName("Case_1_1"); // NOI18N
        Case_1_1.setLayout(new java.awt.GridLayout());
        add(Case_1_1);

        Case_1_2.setName("Case_1_2"); // NOI18N
        Case_1_2.setLayout(new java.awt.GridLayout());
        add(Case_1_2);

        Case_2_0.setName("Case_2_0"); // NOI18N
        Case_2_0.setLayout(new java.awt.GridLayout());

        cardAtt.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cardAtt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardAtt.setText("1");
        cardAtt.setAlignmentY(0.0F);
        Case_2_0.add(cardAtt);

        add(Case_2_0);

        Case_2_1.setName("Case_2_1"); // NOI18N
        Case_2_1.setLayout(new java.awt.GridLayout());
        add(Case_2_1);

        Case_2_2.setName("Case_2_2"); // NOI18N
        Case_2_2.setLayout(new java.awt.GridLayout());

        cardDef.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cardDef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardDef.setText("2");
        cardDef.setAlignmentY(0.0F);
        Case_2_2.add(cardDef);

        add(Case_2_2);
    }// </editor-fold>//GEN-END:initComponents

    public void SetCarte(Carte c) {
        if (c != null) {
            Creature cr = (Creature) c;
            SetCardAttack(Integer.toString(cr.getAttaque()));
            SetCardCout(Integer.toString(cr.getCoutRessource()));
            SetCardDef(Integer.toString(cr.getDefense()));
            SetCardNom(cr.getNom());
            ((GridLayout) this.getLayout()).setHgap(3);
            ((GridLayout) this.getLayout()).setVgap(3);

            for (int i = 0; i < 9; i++) {
                Case[i].setBackground(new Color(213, 231, 203));
            }

            if(cr.getEtat() == EtatCreature.Fatigue)
                Case[0].setBackground(new Color(255, 0, 0));
                
            Case[2].setBackground(new Color(121, 169, 205));
            Case[6].setBackground(new Color(208, 148, 155));
            Case[8].setBackground(new Color(146, 171, 131));

        } else {
            SetCardAttack("");
            SetCardCout("");
            SetCardDef("");
            SetCardNom("");
            this.setBorder(BorderFactory.createEmptyBorder());
            ((GridLayout) this.getLayout()).setHgap(0);
            ((GridLayout) this.getLayout()).setVgap(0);

            for (int i = 0; i < 9; i++) {
                Case[i].setBackground(new Color(255, 215, 219));
            }
        }
    }

    public void SetCardAttack(String txt) {
        cardAtt.setText(txt);
    }

    public void SetCardDef(String txt) {
        cardDef.setText(txt);
    }

    public void SetCardNom(String txt) {
        cardName.setText(txt);
    }

    public void SetCardCout(String txt) {
        cardCost.setText(txt);
    }

    public void GetCardNom() {
        cardName.getText();
    }

    private JPanel[] Case;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Case_0_0;
    private javax.swing.JPanel Case_0_1;
    private javax.swing.JPanel Case_0_2;
    private javax.swing.JPanel Case_1_0;
    private javax.swing.JPanel Case_1_1;
    private javax.swing.JPanel Case_1_2;
    private javax.swing.JPanel Case_2_0;
    private javax.swing.JPanel Case_2_1;
    private javax.swing.JPanel Case_2_2;
    private javax.swing.JLabel cardAtt;
    private javax.swing.JLabel cardCost;
    private javax.swing.JLabel cardDef;
    private javax.swing.JLabel cardName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        controleur.ControleSelectionCase(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        if (!this.cardName.getText().equals("")) 
        {
            URL url = getClass().getResource("/Images/" + this.cardName.getText() + ".jpg");
            if (url != null)
                fenetre.getImageLabel().setIcon(new ImageIcon(url));
            fenetre.getAttaqueInformationLabel().setText("ATT : " + this.cardAtt.getText());
            fenetre.getDefenseInformationLabel().setText("DEF : " + this.cardDef.getText());
            fenetre.getRessourceInformationLabel().setText("COÛT : " + this.cardCost.getText());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        fenetre.getImageLabel().setIcon(null);
        fenetre.getAttaqueInformationLabel().setText(null);
        fenetre.getDefenseInformationLabel().setText(null);
        fenetre.getRessourceInformationLabel().setText(null);
    }
}