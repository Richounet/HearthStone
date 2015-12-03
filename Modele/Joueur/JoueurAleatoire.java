package Modele.Joueur;

import Modele.Carte.Carte;
import Modele.Carte.EtatCreature;
import Modele.Phase.PhaseType;
import Modele.Plateau.PlateauJeu;
import Modele.Plateau.PlateauJoueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class JoueurAleatoire extends JoueurIA
{
    public JoueurAleatoire(String nom, int pv)
    {
        super(nom, pv);
    }
    
    @Override
    public Carte GetCoup(PlateauJoueur p, PhaseType phase)
    {
        if (phase == PhaseType.PhaseAttaque)
        {
            for (int i = 0; i < 4; i++)
                if (p.getTerrain(i) != null && p.getTerrain(i).getEtat() != EtatCreature.Fatigue)
                    return p.getTerrain(i);
        }
        if (phase == PhaseType.PhaseDefense)
        {
            for (int i = 0; i < 4; i++)
                if (p.getTerrain(i) != null && p.getTerrain(i).getEtat() != EtatCreature.Fatigue)
                    return p.getTerrain(i);
        }
        if (phase == PhaseType.PhaseInvocation)
        {
            for (int i = 0; i < 4; i++)
                if (p.getMain(i) != null && ressource >= p.getMain(i).getCoutRessource()) 
                    return p.getMain(i);
        }
        
        return null;
    }
}