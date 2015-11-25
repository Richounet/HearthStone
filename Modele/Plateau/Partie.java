package Modele.Plateau;

import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Partie
{
    private PlateauJeu plateau;

    public Partie(Joueur j1, Joueur j2)
    {
        plateau = new PlateauJeu(j1, j2);
    }
    
    public void JouerCoup()
    {
        plateau.JouerCoup(null);
    }
    
    public void NextPhase()
    {
        plateau.NextPhase();
    }
}