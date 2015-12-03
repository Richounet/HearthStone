package Vue;

import Controleur.Controleur;
import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Joueur.JoueurAleatoire;
import Modele.Phase.PhaseType;
import Modele.Plateau.Partie;
import Modele.Plateau.PlateauJeu;
import Modele.Plateau.PlateauJoueur;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePalette extends javax.swing.JFrame implements Observer
{
    private Controleur controleur;
    private Partie partie;
    private Joueur joueur1;
    private Joueur joueur2;

    public FenetrePalette() 
    {
        initComponents();
        InitGame();
    }

    private void InitGame() 
    {
        // Variable du jeu
        joueur1 = new Joueur("Axel", 10);
        joueur2 = new JoueurAleatoire("Vincent", 10);
        partie = new Partie(joueur1, joueur2);
        controleur = new Controleur(partie);

        J1Main = new VueCarte[]{
            J1Main1, J1Main2, J1Main3, J1Main4
        };
        J2Main = new VueCarte[]{
            J2Main1, J2Main2, J2Main3, J2Main4
        };
        J1Terrain = new VueCarte[]{
            J1Terrain1, J1Terrain2, J1Terrain3, J1Terrain4
        };
        J2Terrain = new VueCarte[]{
            J2Terrain1, J2Terrain2, J2Terrain3, J2Terrain4
        };
        J1Combat = new VueCarte[]{
            J1Combat1, J1Combat2, J1Combat3, J1Combat4
        };
        J2Combat = new VueCarte[]{
            J2Combat1, J2Combat2, J2Combat3, J2Combat4
        };

        PlateauJoueur[] plat = partie.GetPlateaux();
        plat[0].addObserver(this);
        plat[1].addObserver(this);
        plat[0].Notify();
        plat[1].Notify();

        joueur1.addObserver(this);
        joueur2.addObserver(this);
        joueur1.Notify();
        joueur2.Notify();
        
        partie.GetPlateauJeu().addObserver(this);
        partie.GetPlateauJeu().Notify();
        
        VueCarte.controleur = controleur;
        UpdateInfosJoueurs();
        
        VueCarte.fenetre = this;
    }
    
    public JLabel getImageLabel()
    {
        return ImageLabel;
    }
    
    public JLabel getRessourceInformationLabel()
    {
        return RessourceInformationLabel;
    }
    
    public JLabel getAttaqueInformationLabel()
    {
        return AttaqueInformationLabel;
    }
    
    public JLabel getDefenseInformationLabel()
    {
        return DefenseInformationLabel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFramePanel = new javax.swing.JPanel();
        J2Panel = new javax.swing.JPanel();
        J2NomLabel = new javax.swing.JLabel();
        J2PVLabel = new javax.swing.JLabel();
        J2RessourcePanel = new javax.swing.JPanel();
        J2RessourceLabel = new javax.swing.JLabel();
        J1Panel = new javax.swing.JPanel();
        J1NomLabel = new javax.swing.JLabel();
        J1PVLabel = new javax.swing.JLabel();
        PlateauPanel = new javax.swing.JPanel();
        J2PlateauPanel = new javax.swing.JPanel();
        J2Main1 = new Vue.VueCarte();
        J2Main2 = new Vue.VueCarte();
        J2Main3 = new Vue.VueCarte();
        J2Main4 = new Vue.VueCarte();
        J2Terrain1 = new Vue.VueCarte();
        J2Terrain2 = new Vue.VueCarte();
        J2Terrain3 = new Vue.VueCarte();
        J2Terrain4 = new Vue.VueCarte();
        J2Combat1 = new Vue.VueCarte();
        J2Combat2 = new Vue.VueCarte();
        J2Combat3 = new Vue.VueCarte();
        J2Combat4 = new Vue.VueCarte();
        J1PlateauPanel = new javax.swing.JPanel();
        J1Combat4 = new Vue.VueCarte();
        J1Combat3 = new Vue.VueCarte();
        J1Combat2 = new Vue.VueCarte();
        J1Combat1 = new Vue.VueCarte();
        J1Terrain4 = new Vue.VueCarte();
        J1Terrain3 = new Vue.VueCarte();
        J1Terrain2 = new Vue.VueCarte();
        J1Terrain1 = new Vue.VueCarte();
        J1Main4 = new Vue.VueCarte();
        J1Main3 = new Vue.VueCarte();
        J1Main2 = new Vue.VueCarte();
        J1Main1 = new Vue.VueCarte();
        J1RessourcePanel = new javax.swing.JPanel();
        J1RessourceLabel = new javax.swing.JLabel();
        InformationPanel = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();
        ActionPanel = new javax.swing.JPanel();
        ActionButton = new javax.swing.JButton();
        PhasePanel = new javax.swing.JPanel();
        PhaseLabel = new javax.swing.JLabel();
        CardInfoPanel = new javax.swing.JPanel();
        AttaqueInformationLabel = new javax.swing.JLabel();
        DefenseInformationLabel = new javax.swing.JLabel();
        RessourceInformationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HearthStone");
        setMinimumSize(new java.awt.Dimension(1020, 667));
        setName("FenetrePalette"); // NOI18N

        JFramePanel.setBackground(new java.awt.Color(255, 255, 255));

        J2Panel.setBackground(new java.awt.Color(232, 247, 255));
        J2Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J2Panel.setMinimumSize(new java.awt.Dimension(667, 80));
        J2Panel.setPreferredSize(new java.awt.Dimension(667, 80));
        J2Panel.setLayout(new java.awt.GridLayout(1, 0));

        J2NomLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        J2NomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J2NomLabel.setText("Axel");
        J2Panel.add(J2NomLabel);

        J2PVLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        J2PVLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J2PVLabel.setText("10 PV");
        J2Panel.add(J2PVLabel);

        J2RessourcePanel.setBackground(new java.awt.Color(232, 247, 255));
        J2RessourcePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J2RessourcePanel.setMinimumSize(new java.awt.Dimension(325, 80));
        J2RessourcePanel.setPreferredSize(new java.awt.Dimension(325, 80));
        J2RessourcePanel.setLayout(new java.awt.GridLayout(1, 0));

        J2RessourceLabel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        J2RessourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J2RessourceLabel.setText("Ressources: 0 / 0");
        J2RessourcePanel.add(J2RessourceLabel);

        J1Panel.setBackground(new java.awt.Color(232, 247, 255));
        J1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J1Panel.setFocusTraversalPolicyProvider(true);
        J1Panel.setMinimumSize(new java.awt.Dimension(667, 80));
        J1Panel.setPreferredSize(new java.awt.Dimension(667, 80));
        J1Panel.setLayout(new java.awt.GridLayout(1, 0));

        J1NomLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        J1NomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J1NomLabel.setText("Vincent");
        J1Panel.add(J1NomLabel);

        J1PVLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        J1PVLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J1PVLabel.setText("10 PV");
        J1Panel.add(J1PVLabel);

        PlateauPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        PlateauPanel.setMinimumSize(new java.awt.Dimension(667, 533));
        PlateauPanel.setPreferredSize(new java.awt.Dimension(667, 533));
        PlateauPanel.setLayout(new java.awt.GridLayout(2, 0, 0, 1));

        J2PlateauPanel.setBackground(new java.awt.Color(255, 255, 255));
        J2PlateauPanel.setLayout(new java.awt.GridLayout(3, 4, 2, 3));

        J2Main1.setName("J2Main1"); // NOI18N
        J2PlateauPanel.add(J2Main1);

        J2Main2.setName("J2Main2"); // NOI18N
        J2PlateauPanel.add(J2Main2);

        J2Main3.setName("J2Main3"); // NOI18N
        J2PlateauPanel.add(J2Main3);

        J2Main4.setName("J2Main4"); // NOI18N
        J2PlateauPanel.add(J2Main4);

        J2Terrain1.setName("J2Terrain1"); // NOI18N
        J2PlateauPanel.add(J2Terrain1);

        J2Terrain2.setName("J2Terrain2"); // NOI18N
        J2PlateauPanel.add(J2Terrain2);

        J2Terrain3.setName("J2Terrain3"); // NOI18N
        J2PlateauPanel.add(J2Terrain3);

        J2Terrain4.setName("J2Terrain4"); // NOI18N
        J2PlateauPanel.add(J2Terrain4);

        J2Combat1.setName("J2Combat1"); // NOI18N
        J2PlateauPanel.add(J2Combat1);

        J2Combat2.setName("J2Combat2"); // NOI18N
        J2PlateauPanel.add(J2Combat2);

        J2Combat3.setName("J2Combat3"); // NOI18N
        J2PlateauPanel.add(J2Combat3);

        J2Combat4.setName("J2Combat4"); // NOI18N
        J2PlateauPanel.add(J2Combat4);

        PlateauPanel.add(J2PlateauPanel);

        J1PlateauPanel.setBackground(new java.awt.Color(255, 255, 255));
        J1PlateauPanel.setLayout(new java.awt.GridLayout(3, 4, 2, 3));

        J1Combat4.setName("J1Combat4"); // NOI18N
        J1PlateauPanel.add(J1Combat4);

        J1Combat3.setName("J1Combat3"); // NOI18N
        J1PlateauPanel.add(J1Combat3);

        J1Combat2.setName("J1Combat1"); // NOI18N
        J1PlateauPanel.add(J1Combat2);

        J1Combat1.setName("J1Combat1"); // NOI18N
        J1PlateauPanel.add(J1Combat1);

        J1Terrain4.setName("J1Terrain4"); // NOI18N
        J1PlateauPanel.add(J1Terrain4);

        J1Terrain3.setName("J1Terrain3"); // NOI18N
        J1PlateauPanel.add(J1Terrain3);

        J1Terrain2.setName("J1Terrain2"); // NOI18N
        J1PlateauPanel.add(J1Terrain2);

        J1Terrain1.setName("J1Terrain1"); // NOI18N
        J1PlateauPanel.add(J1Terrain1);

        J1Main4.setName("J1Main4"); // NOI18N
        J1PlateauPanel.add(J1Main4);

        J1Main3.setName("J1Main3"); // NOI18N
        J1PlateauPanel.add(J1Main3);

        J1Main2.setName("J1Main2"); // NOI18N
        J1PlateauPanel.add(J1Main2);

        J1Main1.setName("J1Main1"); // NOI18N
        J1PlateauPanel.add(J1Main1);

        PlateauPanel.add(J1PlateauPanel);

        J1RessourcePanel.setBackground(new java.awt.Color(232, 247, 255));
        J1RessourcePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J1RessourcePanel.setPreferredSize(new java.awt.Dimension(325, 80));
        J1RessourcePanel.setLayout(new java.awt.GridLayout(1, 0));

        J1RessourceLabel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        J1RessourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J1RessourceLabel.setText("Ressources: 0 / 0");
        J1RessourcePanel.add(J1RessourceLabel);

        InformationPanel.setBackground(new java.awt.Color(232, 247, 255));
        InformationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        InformationPanel.setMinimumSize(new java.awt.Dimension(327, 354));
        InformationPanel.setPreferredSize(new java.awt.Dimension(327, 354));

        ImageLabel.setMinimumSize(new java.awt.Dimension(248, 289));
        ImageLabel.setPreferredSize(new java.awt.Dimension(248, 289));
        InformationPanel.add(ImageLabel);

        ActionPanel.setBackground(new java.awt.Color(232, 247, 255));
        ActionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        ActionPanel.setMinimumSize(new java.awt.Dimension(327, 86));
        ActionPanel.setPreferredSize(new java.awt.Dimension(327, 86));
        ActionPanel.setLayout(new java.awt.GridLayout(1, 0));

        ActionButton.setBackground(new java.awt.Color(238, 233, 233));
        ActionButton.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        ActionButton.setMinimumSize(new java.awt.Dimension(260, 40));
        ActionButton.setPreferredSize(new java.awt.Dimension(260, 40));
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });
        ActionPanel.add(ActionButton);

        PhasePanel.setBackground(new java.awt.Color(232, 247, 255));
        PhasePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        PhasePanel.setMinimumSize(new java.awt.Dimension(327, 81));
        PhasePanel.setName("PhasePanel"); // NOI18N
        PhasePanel.setPreferredSize(new java.awt.Dimension(327, 81));
        PhasePanel.setLayout(new java.awt.GridLayout(1, 0));

        PhaseLabel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        PhaseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhaseLabel.setText("Tour 1, phase 2 (invocation)");
        PhaseLabel.setName("PhaseLabel"); // NOI18N
        PhasePanel.add(PhaseLabel);

        CardInfoPanel.setBackground(new java.awt.Color(232, 247, 255));
        CardInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        CardInfoPanel.setMinimumSize(new java.awt.Dimension(100, 52));
        CardInfoPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        CardInfoPanel.setSize(new java.awt.Dimension(100, 50));
        CardInfoPanel.setLayout(new java.awt.GridLayout(1, 0));

        AttaqueInformationLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        AttaqueInformationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AttaqueInformationLabel.setText("ATT : 10");
        CardInfoPanel.add(AttaqueInformationLabel);

        DefenseInformationLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DefenseInformationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DefenseInformationLabel.setText("DEF : 10");
        CardInfoPanel.add(DefenseInformationLabel);

        RessourceInformationLabel.setBackground(new java.awt.Color(232, 247, 255));
        RessourceInformationLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        RessourceInformationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RessourceInformationLabel.setText("COÛT : 10");
        CardInfoPanel.add(RessourceInformationLabel);

        javax.swing.GroupLayout JFramePanelLayout = new javax.swing.GroupLayout(JFramePanel);
        JFramePanel.setLayout(JFramePanelLayout);
        JFramePanelLayout.setHorizontalGroup(
            JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(J2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlateauPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(J2RessourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J1RessourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ActionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PhasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JFramePanelLayout.setVerticalGroup(
            JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(J2RessourcePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(J2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JFramePanelLayout.createSequentialGroup()
                        .addComponent(InformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PhasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PlateauPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(J1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J1RessourcePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButtonActionPerformed
        controleur.ControleNextPhase();
    }//GEN-LAST:event_ActionButtonActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new FenetrePalette().setVisible(true);
            }
        });
    }

    private VueCarte[] J1Main;
    private VueCarte[] J2Main;
    private VueCarte[] J1Terrain;
    private VueCarte[] J2Terrain;
    private VueCarte[] J1Combat;
    private VueCarte[] J2Combat;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActionButton;
    private javax.swing.JPanel ActionPanel;
    private javax.swing.JLabel AttaqueInformationLabel;
    private javax.swing.JPanel CardInfoPanel;
    private javax.swing.JLabel DefenseInformationLabel;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JPanel InformationPanel;
    private Vue.VueCarte J1Combat1;
    private Vue.VueCarte J1Combat2;
    private Vue.VueCarte J1Combat3;
    private Vue.VueCarte J1Combat4;
    private Vue.VueCarte J1Main1;
    private Vue.VueCarte J1Main2;
    private Vue.VueCarte J1Main3;
    private Vue.VueCarte J1Main4;
    private javax.swing.JLabel J1NomLabel;
    private javax.swing.JLabel J1PVLabel;
    private javax.swing.JPanel J1Panel;
    private javax.swing.JPanel J1PlateauPanel;
    private javax.swing.JLabel J1RessourceLabel;
    private javax.swing.JPanel J1RessourcePanel;
    private Vue.VueCarte J1Terrain1;
    private Vue.VueCarte J1Terrain2;
    private Vue.VueCarte J1Terrain3;
    private Vue.VueCarte J1Terrain4;
    private Vue.VueCarte J2Combat1;
    private Vue.VueCarte J2Combat2;
    private Vue.VueCarte J2Combat3;
    private Vue.VueCarte J2Combat4;
    private Vue.VueCarte J2Main1;
    private Vue.VueCarte J2Main2;
    private Vue.VueCarte J2Main3;
    private Vue.VueCarte J2Main4;
    private javax.swing.JLabel J2NomLabel;
    private javax.swing.JLabel J2PVLabel;
    private javax.swing.JPanel J2Panel;
    private javax.swing.JPanel J2PlateauPanel;
    private javax.swing.JLabel J2RessourceLabel;
    private javax.swing.JPanel J2RessourcePanel;
    private Vue.VueCarte J2Terrain1;
    private Vue.VueCarte J2Terrain2;
    private Vue.VueCarte J2Terrain3;
    private Vue.VueCarte J2Terrain4;
    private javax.swing.JPanel JFramePanel;
    private javax.swing.JLabel PhaseLabel;
    private javax.swing.JPanel PhasePanel;
    private javax.swing.JPanel PlateauPanel;
    private javax.swing.JLabel RessourceInformationLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) 
    {
        if (o instanceof PlateauJoueur)
            RepaintPlateau((PlateauJoueur)o);
        else if (o instanceof PlateauJeu)
        {
            UpdateInfosPlateau((PlateauJeu)o);
            RepaintPlateau(partie.GetPlateaux()[0]);
            RepaintPlateau(partie.GetPlateaux()[1]);
        }
        
        UpdateInfosJoueurs();
        this.repaint();
        this.pack();
    }
    
    private void RepaintPlateau(PlateauJoueur plateau)
    {
        if (plateau.getJ().getNom().equals(joueur1.getNom())) 
        {
            int i;
            Carte c;
            for (i = 0; i < 4; i++) 
            {
                c = plateau.getMain(i);
                J1Main[i].SetCarte(c, 0);
                c = plateau.getTerrain(i);
                J1Terrain[i].SetCarte(c, 1);
                c = plateau.getLigneCombat(i);
                J1Combat[i].SetCarte(c, 2);
            }
        } 
        else 
        {
            int i;
            Carte c;
            for (i = 0; i < 4; i++) 
            {
                c = plateau.getMain(i);
                J2Main[i].SetCarte(c, 0);
                c = plateau.getTerrain(i);
                J2Terrain[i].SetCarte(c, 1);
                c = plateau.getLigneCombat(i);
                J2Combat[i].SetCarte(c, 2);
            }
        }
    }
    
    private void UpdateInfosPlateau(PlateauJeu p)
    {
        if (p.GetPhaseActuelle() == PhaseType.PhaseInvocation)
        {
            ActionButton.setText("Phase Suivante: Attaque");
            PhaseLabel.setText("Tour " + Partie.numeroTour + ", Phase 2 [Invocation]");
        }
        else if (p.GetPhaseActuelle() == PhaseType.PhaseAttaque)
        {
            ActionButton.setText("Fin de tour");
            PhaseLabel.setText("Tour " + Partie.numeroTour + ", Phase 3 [Attaque]");
        }
        else if (p.GetPhaseActuelle() == PhaseType.PhaseDefense)
        {
            ActionButton.setText("Phase Suivante: Invocation");
            PhaseLabel.setText("Tour " + Partie.numeroTour + ", Phase 1 [Defense]");
        }
    }
    
    public void UpdateInfosJoueurs() 
    {
        if (Partie.partieTerminee == false)
        {
            // Mise à jour de la vue
            J1NomLabel.setText(joueur1.getNom());
            J2NomLabel.setText(joueur2.getNom());

            if(partie.GetPlateauJeu().GetIndexPlateauActuel() == 0)
            { 
                J1Panel.setBackground(new Color(123, 168, 200));
                J2Panel.setBackground(new Color(232,247,255));  
            }
            else
            {          
                J1Panel.setBackground(new Color(232,247,255));
                J2Panel.setBackground(new Color(123, 168, 200));
            }            
            J1PVLabel.setText(Integer.toString(joueur1.getPv()) + " PV");
            J2PVLabel.setText(Integer.toString(joueur2.getPv()) + " PV");
            J1RessourceLabel.setText("Ressource(s) : " + Integer.toString(joueur1.getRessource()) + " / " + Partie.numeroTour);
            J2RessourceLabel.setText("Ressource(s) : " + Integer.toString(joueur2.getRessource()) + " / " + Partie.numeroTour);
        }
        else
        {
            J1PVLabel.setText(Integer.toString(joueur1.getPv()) + " PV");
            J2PVLabel.setText(Integer.toString(joueur2.getPv()) + " PV");
            
            if (joueur1.getPv() <= 0)
                PhaseLabel.setText(joueur2.getNom() + " a gagné!");
            else
                PhaseLabel.setText(joueur1.getNom() + " a gagné!");
        }
    }
}
