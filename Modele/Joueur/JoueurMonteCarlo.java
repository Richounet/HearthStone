
package Modele.Joueur;

import Modele.Carte.Carte;
import Modele.Carte.EtatCreature;
import Modele.Phase.PhaseType;
import Modele.Plateau.Partie;
import Modele.Plateau.PlateauJoueur;
import Vue.FenetrePalette;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class JoueurMonteCarlo extends JoueurIA
{
    ArrayList<Partie> jeu;
    public static FenetrePalette fenetre;
    
    public JoueurMonteCarlo(String nom, int pv, FenetrePalette fenetre) {
        super(nom, pv);
        this.fenetre = fenetre;
    }

    @Override
    public Carte GetCoup(PlateauJoueur p, PhaseType phase)
    {
        jeu = new ArrayList<>();
        for(int i=0; i<100; i++)
        {
            try {
                jeu.add((Partie)fenetre.getPartie().clone());
            } catch (CloneNotSupportedException ex) {
                System.out.println("Erreur lors du clonage.");
            }
        }
        return null;
    }
}
