package Vue;

import Controleur.Controleur;
import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Plateau.Partie;
import Modele.Plateau.PlateauJoueur;
import java.util.Observable;
import java.util.Observer;
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
        joueur2 = new Joueur("Vincent", 10);
        partie = new Partie(joueur1, joueur2);
        controleur = new Controleur(partie);

        J1Main = new VueCarte[]
        {
            J1Main1, J1Main2, J1Main3, J1Main4
        };
        J2Main = new VueCarte[]
        {
            J2Main1, J2Main2, J2Main3, J2Main4
        };
        J1Terrain = new VueCarte[]
        {
            J1Terrain1, J1Terrain2, J1Terrain3, J1Terrain4
        };
        J2Terrain = new VueCarte[]
        {
            J2Terrain1, J2Terrain2, J2Terrain3, J2Terrain4
        };
        J1Combat = new VueCarte[]
        {
            J1Combat1, J1Combat2, J1Combat3, J1Combat4
        };
        J2Combat = new VueCarte[]
        {
            J2Combat1, J2Combat2, J2Combat3, J2Combat4
        };

        PlateauJoueur[] plat = partie.GetPlateaux();
        plat[0].addObserver(this);
        plat[1].addObserver(this);
        plat[0].Notify();
        plat[1].Notify();
        
        VueCarte.controleur = controleur;
        UpdateInfosJoueurs();
    }

    public void UpdateInfosJoueurs()
    {
        // Mise à jour de la vue
        J1NomLabel.setText(joueur1.getNom());
        J2NomLabel.setText(joueur2.getNom());
        J1PVLabel.setText(Integer.toString(joueur1.getPv()));
        J1PVLabel.setText(Integer.toString(joueur2.getPv()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        JFramePanel = new javax.swing.JPanel();
        J2Panel = new javax.swing.JPanel();
        J2PVLabel = new javax.swing.JLabel();
        J2NomLabel = new javax.swing.JLabel();
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
        ActionPanel = new javax.swing.JPanel();
        ActionButton = new javax.swing.JButton();

        jPanel8.setPreferredSize(new java.awt.Dimension(667, 88));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HearthStone");
        setMinimumSize(new java.awt.Dimension(1010, 743));

        JFramePanel.setBackground(new java.awt.Color(255, 255, 255));

        J2Panel.setBackground(new java.awt.Color(232, 247, 255));
        J2Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J2Panel.setPreferredSize(new java.awt.Dimension(667, 80));

        J2PVLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        J2PVLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J2PVLabel.setText("10 PV");

        J2NomLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        J2NomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J2NomLabel.setText("Axel");

        javax.swing.GroupLayout J2PanelLayout = new javax.swing.GroupLayout(J2Panel);
        J2Panel.setLayout(J2PanelLayout);
        J2PanelLayout.setHorizontalGroup(
            J2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, J2PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(J2NomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(J2PVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        J2PanelLayout.setVerticalGroup(
            J2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, J2PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(J2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(J2PVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J2NomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        J2RessourcePanel.setBackground(new java.awt.Color(232, 247, 255));
        J2RessourcePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J2RessourcePanel.setMinimumSize(new java.awt.Dimension(325, 80));
        J2RessourcePanel.setPreferredSize(new java.awt.Dimension(325, 80));

        J2RessourceLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        J2RessourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J2RessourceLabel.setText("Ressources: 0 / 0");

        javax.swing.GroupLayout J2RessourcePanelLayout = new javax.swing.GroupLayout(J2RessourcePanel);
        J2RessourcePanel.setLayout(J2RessourcePanelLayout);
        J2RessourcePanelLayout.setHorizontalGroup(
            J2RessourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J2RessourcePanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(J2RessourceLabel)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        J2RessourcePanelLayout.setVerticalGroup(
            J2RessourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, J2RessourcePanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(J2RessourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        J1Panel.setBackground(new java.awt.Color(232, 247, 255));
        J1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        J1Panel.setPreferredSize(new java.awt.Dimension(667, 80));

        J1NomLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        J1NomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J1NomLabel.setText("Vincent");

        J1PVLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        J1PVLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J1PVLabel.setText("10 PV");

        javax.swing.GroupLayout J1PanelLayout = new javax.swing.GroupLayout(J1Panel);
        J1Panel.setLayout(J1PanelLayout);
        J1PanelLayout.setHorizontalGroup(
            J1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J1PanelLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(J1NomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(J1PVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        J1PanelLayout.setVerticalGroup(
            J1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J1PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(J1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(J1PVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J1NomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        PlateauPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        PlateauPanel.setMinimumSize(new java.awt.Dimension(667, 532));
        PlateauPanel.setLayout(new java.awt.GridLayout(2, 0, 0, 1));

        J2PlateauPanel.setBackground(new java.awt.Color(255, 255, 255));
        J2PlateauPanel.setLayout(new java.awt.GridLayout(3, 4, 2, 2));

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
        J1PlateauPanel.setLayout(new java.awt.GridLayout(3, 4, 2, 2));

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

        J1RessourceLabel.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        J1RessourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        J1RessourceLabel.setText("Ressources: 0 / 0");

        javax.swing.GroupLayout J1RessourcePanelLayout = new javax.swing.GroupLayout(J1RessourcePanel);
        J1RessourcePanel.setLayout(J1RessourcePanelLayout);
        J1RessourcePanelLayout.setHorizontalGroup(
            J1RessourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, J1RessourcePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(J1RessourceLabel)
                .addGap(82, 82, 82))
        );
        J1RessourcePanelLayout.setVerticalGroup(
            J1RessourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J1RessourcePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(J1RessourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InformationPanel.setBackground(new java.awt.Color(232, 247, 255));
        InformationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        InformationPanel.setPreferredSize(new java.awt.Dimension(667, 88));

        javax.swing.GroupLayout InformationPanelLayout = new javax.swing.GroupLayout(InformationPanel);
        InformationPanel.setLayout(InformationPanelLayout);
        InformationPanelLayout.setHorizontalGroup(
            InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        InformationPanelLayout.setVerticalGroup(
            InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        ActionPanel.setBackground(new java.awt.Color(232, 247, 255));
        ActionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 131, 120)));
        ActionPanel.setMinimumSize(new java.awt.Dimension(325, 80));
        ActionPanel.setPreferredSize(new java.awt.Dimension(325, 80));

        ActionButton.setBackground(new java.awt.Color(238, 233, 233));
        ActionButton.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        ActionButton.setText("Finir le tour !");
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ActionPanelLayout = new javax.swing.GroupLayout(ActionPanel);
        ActionPanel.setLayout(ActionPanelLayout);
        ActionPanelLayout.setHorizontalGroup(
            ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ActionPanelLayout.setVerticalGroup(
            ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JFramePanelLayout = new javax.swing.GroupLayout(JFramePanel);
        JFramePanel.setLayout(JFramePanelLayout);
        JFramePanelLayout.setHorizontalGroup(
            JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(J1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlateauPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(J2RessourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ActionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(J1RessourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JFramePanelLayout.setVerticalGroup(
            JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(J2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J2RessourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JFramePanelLayout.createSequentialGroup()
                        .addComponent(InformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PlateauPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(J1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J1RessourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            public void run()
            {
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
    private javax.swing.JPanel PlateauPanel;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg)
    {
        PlateauJoueur plateau = (PlateauJoueur) o;
        if (plateau.getJ().getNom().equals(joueur1.getNom()))
        {
            int i;
            Carte c;
            for (i = 0; i < 4; i++)
            {
                c = plateau.getMain(i);
                J1Main[i].SetCarte(c);
                c = plateau.getTerrain(i);
                J1Terrain[i].SetCarte(c);
                c = plateau.getLigneCombat(i);
                J1Combat[i].SetCarte(c);
            }
        } 
        else
        {
            int i;
            Carte c;
            for (i = 0; i < 4; i++)
            {
                c = plateau.getMain(i);
                J2Main[i].SetCarte(c);
                c = plateau.getTerrain(i);
                J2Terrain[i].SetCarte(c);
                c = plateau.getLigneCombat(i);
                J2Combat[i].SetCarte(c);
            }
        }

        this.repaint();
        this.pack();
    }
}
