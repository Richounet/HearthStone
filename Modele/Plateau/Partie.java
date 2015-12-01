package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Phase.PhaseType;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Partie
{
    private Joueur[] joueurs;
    private PlateauJeu plateau;
    public static int numeroTour;

    public Partie(Joueur j1, Joueur j2)
    {
        joueurs = new Joueur[] { j1, j2 };
        plateau = new PlateauJeu(j1, j2);
        numeroTour = 0;
    }
    
    public void JouerCoup(Carte c)
    {
        plateau.JouerCoup(c);
    }
    
    public void NextPhase()
    {
        numeroTour += plateau.NextPhase();
    }
    
    public PhaseType GetPhaseActuelle()
    {
        return plateau.GetPhaseActuelle();
    }
    
    public Carte FindCarteOnPlateau(int tableau, int index)
    {
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
}