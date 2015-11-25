package Controleur;

import Modele.Carte.Carte;
import Modele.Plateau.Partie;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Controleur
{
    private Partie partieEnCours;
    
    public Controleur(Partie p)
    {
        this.partieEnCours = p;
    }
    
    public void ControleSelectionCase()
    {
        Carte c = null;
        partieEnCours.JouerCoup(c);
    }
    
    public void ControleNextPhase()
    {
        partieEnCours.NextPhase();
    }
}
