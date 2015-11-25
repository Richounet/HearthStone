package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Partie
{
    private Joueur[] joueurs;
    private PlateauJeu plateau;
    private int numeroTour;

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
}