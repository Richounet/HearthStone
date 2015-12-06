
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
    
    public JoueurMonteCarlo(String nom, int pv) {
        super(nom, pv);
    }
    
    public JoueurMonteCarlo(String nom, int pv, FenetrePalette fenetre) {
        super(nom, pv);
        this.fenetre = fenetre;
    }

    public void Monte_Carlo()
    { 
        jeu = new ArrayList<>();
        for(int i=0; i<1; i++)
        {
            try {
                System.out.println("Partie Actuelle | Phase : " + fenetre.getPartie().GetPhaseActuelle() + " | " + fenetre.getPartie().getJoueurs(0).getClass() + " - " + fenetre.getPartie().getJoueurs(1).getClass());
                jeu.add((Partie)fenetre.getPartie().clone());
                
                System.out.println("Clonage | Avant changement de joueurs | Phase : " + jeu.get(i).GetPhaseActuelle() + " | " + jeu.get(i).getJoueurs(0).getClass() + " - " + jeu.get(i).getJoueurs(1).getClass());
                
                jeu.get(i).setAleatoireMonteCarlo(0, jeu.get(i).getJoueurs(0).getNom(), jeu.get(i).getJoueurs(0).getPv());
                jeu.get(i).setAleatoireMonteCarlo(1, jeu.get(i).getJoueurs(1).getNom(), jeu.get(i).getJoueurs(1).getPv());
                
                System.out.println("Clonage | Après changement de joueurs | Phase : " + jeu.get(i).GetPhaseActuelle() + " | " + jeu.get(i).getJoueurs(0).getClass() + " - " + jeu.get(i).getJoueurs(1).getClass());
                
            } catch (CloneNotSupportedException ex) {
                System.out.println("Erreur lors du clonage.");
            }            
        }
        System.out.println("\n\n");
    }
            
    @Override
    public Carte GetCoup(PlateauJoueur p, PhaseType phase)
    {
        Monte_Carlo();
        return null;
    }
}
