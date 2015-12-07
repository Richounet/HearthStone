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
 * @author PARIS AXEL P1306459
 */
public class JoueurMonteCarlo extends JoueurIA {

    private ArrayList<Partie> jeu;
    private ArrayList<Integer> nombreDeTours;
    private ArrayList<Carte> premierCoup;
    public static FenetrePalette fenetre;

    public JoueurMonteCarlo(String nom, int pv) {
        super(nom, pv);
    }

    // On clone la partie actuelle un certain nombre de fois
    // Pour chaque partie, on la joue jusqu'à la fin
    // On regarde le nombre minimum de tours où l'IA coresspondant à l'IA Monte-Carlo a gagné
    // On renvoie son premier coup joué
    public void Monte_Carlo() {
        jeu = new ArrayList<>();
        nombreDeTours = new ArrayList<>();
        premierCoup = new ArrayList<>();
        
        for (int i = 0; i < 1; i++) {
            try {
                jeu.add((Partie) fenetre.getPartie().clone());
                jeu.get(i).setAleatoireMonteCarlo(0, jeu.get(i).getJoueurs(0).getNom(), jeu.get(i).getJoueurs(0).getPv());
                jeu.get(i).setAleatoireMonteCarlo(1, jeu.get(i).getJoueurs(1).getNom(), jeu.get(i).getJoueurs(1).getPv());
            } catch (CloneNotSupportedException ex) {
                System.out.println("Erreur lors du clonage.");
            }
        }

        for (int i = 0; i < jeu.size(); i++) {
            jeu.get(i).SimulerPartieIA();
        }
        
    }

    @Override
    public Carte GetCoup(PlateauJoueur p, PhaseType phase) {
        Monte_Carlo();
        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        JoueurMonteCarlo j = new JoueurMonteCarlo(this.nom, this.pv);
        return (Object) j;
    }
}
