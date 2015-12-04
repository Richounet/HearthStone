package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Joueur.JoueurIA;
import Modele.Phase.PhaseType;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Partie implements Cloneable
{
    private Joueur[] joueurs;
    private PlateauJeu plateau;
    public static int numeroTour;
    public static boolean partieTerminee = false;

    public Partie(Joueur j1, Joueur j2)
    {
        joueurs = new Joueur[] { j1, j2 };
        plateau = new PlateauJeu(j1, j2);
        numeroTour = 1;
    }
    
    public void JouerCoup(Carte c)
    {
        if (partieTerminee)
            return;
        plateau.JouerCoup(c);
    }
    
    public void NextPhase()
    {
        if (partieTerminee)
            return;
        numeroTour += plateau.NextPhase();
        plateau.Notify();
        
        if (plateau.GetPlateauActuel().getJ() instanceof JoueurIA)
            JouerCoupIA();
        
        ControleVictoire();
    }
    
    public void ControleVictoire()
    {
        if (joueurs[0].getPv() <= 0 || joueurs[1].getPv() < 0)
        {
            partieTerminee = true;
            plateau.Notify();
        }
    }
    
    public void JouerCoupIA()
    {
        plateau.JouerCoupIA();
        NextPhase();
    }
    
    public PhaseType GetPhaseActuelle()
    {
        return plateau.GetPhaseActuelle();
    }
    
    public Carte FindCarteOnPlateau(int tableau, int index, int joueur)
    {
        // On vérifie que le joueur a cliqué sur un carte de son propre camp
        if (plateau.GetIndexPlateauActuel() != joueur - 1)
            return null;
        if (tableau == -1)
            return null;
        
        PlateauJoueur pj = plateau.GetPlateauActuel();
        if (tableau == 1)
            return pj.getMain(index);
        else if (tableau == 2)
            return pj.getTerrain(index);
        else
            return null;
    }
    
    public PlateauJoueur[] GetPlateaux()
    {
        return plateau.GetPlateaux();
    }
    
    public PlateauJeu GetPlateauJeu()
    {
        return plateau;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }   
}