package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Phase.PhaseType;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class PlateauJeu
{
    private PlateauJoueur[] plateauJoueur;
    private PhaseType phaseActuelle;
    private int plateauActuel;

    public PlateauJeu(Joueur j1, Joueur j2) 
    {
        this.plateauJoueur = new PlateauJoueur[2];
        this.plateauJoueur[0] = new PlateauJoueur(j1);
        this.plateauJoueur[1] = new PlateauJoueur(j2);
        this.plateauActuel = 0;
        this.phaseActuelle = PhaseType.PhaseDefense;
    }   

    public PlateauJoueur getPlateauJoueur(int i) 
    {
        return plateauJoueur[i];
    }
    
    public void JouerCoup(Carte c)
    {
        if (phaseActuelle == PhaseType.PhaseDefense)
        {
            
        }
        else if (phaseActuelle == PhaseType.PhaseInvocation)
        {
            
        }
        else if (phaseActuelle == PhaseType.PhaseAttaque)
        {
            
        }
    }
    
    public void NextPhase()
    {
        if (phaseActuelle == PhaseType.PhaseAttaque)
        {
            phaseActuelle = PhaseType.PhaseDefense;
            plateauActuel++;
            if (plateauActuel == 2)
                plateauActuel = 0;
        }
        else
            phaseActuelle = PhaseType.values()[phaseActuelle.ordinal() + 1];
    }
}