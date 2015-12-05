
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
                jeu.add((Partie)fenetre.getPartie().clone());
                jeu.get(i).setAleatoireMonteCarlo(0, jeu.get(i).getJoueurs(0).getNom(), jeu.get(i).getJoueurs(0).getPv());
                jeu.get(i).setAleatoireMonteCarlo(1, this.nom, this.pv);
            } catch (CloneNotSupportedException ex) {
                System.out.println("Erreur lors du clonage.");
            }            
        }
        
        for(int i = 0; i < 1; i++)
        {
            jeu.get(i).JouerCoupIA();
        }
        
        System.out.println(jeu.get(0).getJoueurs(0).getNom() + " : " + jeu.get(0).getJoueurs(0).getPv());
        System.out.println(jeu.get(0).getJoueurs(1).getNom() + " : " + jeu.get(0).getJoueurs(1).getPv());
    }
            
    @Override
    public Carte GetCoup(PlateauJoueur p, PhaseType phase)
    {
        Monte_Carlo();
        return null;
    }
}
