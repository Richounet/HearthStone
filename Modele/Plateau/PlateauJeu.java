package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Carte.EtatCreature;
import Modele.Joueur.Joueur;
import Modele.Phase.PhaseType;
import Utilitaire.MyObservable;
import Utilitaire.Tools;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class PlateauJeu extends MyObservable implements Cloneable
{
    private PlateauJoueur[] plateauJoueur;
    private PhaseType phaseActuelle;
    private int plateauActuel;
    private Partie partie;

    public PlateauJeu(Joueur j1, Joueur j2, Partie p) 
    {
        this.plateauJoueur = new PlateauJoueur[2];
        this.plateauJoueur[0] = new PlateauJoueur(j1);
        this.plateauJoueur[1] = new PlateauJoueur(j2);
        this.plateauActuel = 0;
        this.partie = p;
        this.phaseActuelle = PhaseType.PhaseDefense;
        
        Notify();
    }   
    
    public void JouerCoup(Carte c)
    {
        if (phaseActuelle == PhaseType.PhaseDefense)
        {
            if(c != null)
            {
                // Joue le match attaquant/defenseur si il y a des attaquants
                Carte att = GetProchaineCarteAttaquante();
                if (att != null)
                {
                    Carte[] ret = plateauJoueur[plateauActuel].TryDefend(c, att);
                    DestroyMyCarte(ret[0]);
                    DestroyEnemyCarte(ret[1]);
                }
            }
        }
        else if (phaseActuelle == PhaseType.PhaseInvocation)
        {
            // Essaie d'invoquer la carte selectionnée
            plateauJoueur[plateauActuel].TryInvoc(c);
        }
        else if (phaseActuelle == PhaseType.PhaseAttaque)
        {
            // Essaie de placer la carte selectionnée en ligne de combat
            plateauJoueur[plateauActuel].TryAttack(c);
        }
    }
    
    public void JouerCoupIA()
    {
        Carte c = plateauJoueur[plateauActuel].getJ().GetCoup(plateauJoueur[plateauActuel], phaseActuelle);
        JouerCoup(c);
    }
    
    public int NextPhase()
    {
        // Passage à defense, début d'un tour
        if (phaseActuelle == PhaseType.PhaseAttaque)
        {
            // On enleve la fatigue des créatures qui ont attaqué au tour précédent
            phaseActuelle = PhaseType.PhaseDefense;
            
            plateauActuel++;
            if (plateauActuel == 2)
                plateauActuel = 0;
            if (plateauActuel == 0)
                return 1;
        }
        // Passage à invocation
        else if (phaseActuelle == PhaseType.PhaseDefense)
        {
            FinishDefensePhase();
            // Reset de l'état des cartes a la phase d'invoc
            plateauJoueur[plateauActuel].EnleveFatigueCreatures();
            
            phaseActuelle = PhaseType.values()[phaseActuelle.ordinal() + 1];
            plateauJoueur[plateauActuel].TryTirerCarte();
            plateauJoueur[plateauActuel].ChargeRessources(partie.numeroTour);
        }
        // Passage à attaque
        else if (phaseActuelle == PhaseType.PhaseInvocation)
        {
            plateauJoueur[plateauActuel].DechargeRessources();
            phaseActuelle = PhaseType.values()[phaseActuelle.ordinal() + 1];
        }
        
        return 0;
    }
    
    private void FinishDefensePhase()
    {
        Carte att = GetProchaineCarteAttaquante();
        while (att != null)
        {
            Carte[] ret = plateauJoueur[plateauActuel].TryDefend(null, att);
            DestroyMyCarte(ret[0]);
            DestroyEnemyCarte(ret[1]);
            att = GetProchaineCarteAttaquante();
        }
    }
    
    private Carte GetProchaineCarteAttaquante()
    {
        // Selectionne le plateau adverse
        int index = 0;
        if (plateauActuel == 0)
            index = 1;
        
        for (int i = 0; i < 4; i++)
            // Enleve le prochain attaquant de la ligne de combat adverse et le retourne
            if (plateauJoueur[index].getLigneCombat(i) != null)
            {
                Carte c = plateauJoueur[index].getLigneCombat(i);
                plateauJoueur[index].RemoveAttaquant(i);
                return c;
            }
        return null;
    }
    
    private void DestroyMyCarte(Carte c)
    {
        if (c != null)
            Tools.RemoveFromArray(plateauJoueur[plateauActuel].getTerrain(), c);
        
        Notify();
    }
    
    private void DestroyEnemyCarte(Carte c)
    {
        int p = 0;
        if (plateauActuel == 0)
            p = 1;
        if (c != null)
            Tools.RemoveFromArray(plateauJoueur[p].getTerrain(), c);
        
        Notify();
    }
    
    public PhaseType GetPhaseActuelle()
    {
        return phaseActuelle;
    }
    
    public PlateauJoueur[] GetPlateaux()
    {
        return plateauJoueur;
    }
    
    public PlateauJoueur GetPlateauActuel()
    {
        return plateauJoueur[plateauActuel];
    }
    
    public int GetIndexPlateauActuel()
    {
        return plateauActuel;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException 
    {
        PlateauJeu p = new PlateauJeu((Joueur)this.partie.getJoueurs(0).clone(), (Joueur)this.partie.getJoueurs(1).clone(), (Partie)this.partie.clone());
        p.plateauJoueur[0] = (PlateauJoueur)this.plateauJoueur[0].clone();
        p.plateauJoueur[1] = (PlateauJoueur)this.plateauJoueur[1].clone();
        return (Object)p;
    }  
}
