package Modele.Joueur;

import Modele.Carte.Carte;
import Modele.Phase.PhaseType;
import Modele.Plateau.PlateauJeu;
import Modele.Plateau.PlateauJoueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class JoueurIA extends Joueur
{
    public JoueurIA(String nom, int pv)
    {
        super(nom, pv);
    }
    
    @Override
    public Carte GetCoup(PlateauJoueur p, PhaseType phase)
    {
        return null;
    }
}
