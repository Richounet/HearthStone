package Controleur;

import Modele.Carte.Carte;
import Modele.Phase.PhaseType;
import Modele.Plateau.Partie;
import Modele.Plateau.PlateauJoueur;
import javax.swing.JPanel;

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
    
    public void ControleSelectionCase(JPanel card)
    {
        String cardName = card.getName();
        int tableau = -1;
        int index = Integer.parseInt(cardName.substring(cardName.length() - 1)) - 1;
        int joueur = Integer.parseInt(cardName.substring(1, 2));
        if (partieEnCours.GetPhaseActuelle() == PhaseType.PhaseDefense)
            if (cardName.contains("Terrain"))
                tableau = 2;
        if (partieEnCours.GetPhaseActuelle() == PhaseType.PhaseInvocation)
            if (cardName.contains("Main"))
                tableau = 1;
        if (partieEnCours.GetPhaseActuelle() == PhaseType.PhaseAttaque)
            if (cardName.contains("Terrain"))
                tableau = 2;
        
        Carte c = partieEnCours.FindCarteOnPlateau(tableau, index, joueur);
        if (c != null)
            partieEnCours.JouerCoup(c);
    }
    
    public void ControleNextPhase()
    {
        partieEnCours.NextPhase();
    }
}