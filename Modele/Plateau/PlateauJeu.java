package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;
import Modele.Phase.PhaseType;
import Utilitaire.MyObservable;
import Utilitaire.Tools;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class PlateauJeu extends MyObservable
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
        
        Notify();
    }   
    
    public void JouerCoup(Carte c)
    {
        if (phaseActuelle == PhaseType.PhaseDefense)
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
    
    public int NextPhase()
    {
        // Passage à defense, début d'un tour
        if (phaseActuelle == PhaseType.PhaseAttaque)
        {
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
            
            phaseActuelle = PhaseType.values()[phaseActuelle.ordinal() + 1];
            plateauJoueur[plateauActuel].InitPlateauDebutTour();
            plateauJoueur[plateauActuel].TryTirerCarte();
            plateauJoueur[plateauActuel].ChargeRessources();
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
        Carte att = GetProchaineCarteAttaquante();;
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
                plateauJoueur[index].RemoveAttaquant(i);
                return plateauJoueur[index].getLigneCombat(i);
            }
        return null;
    }
    
    private void DestroyMyCarte(Carte c)
    {
        if (c != null)
            Tools.RemoveFromArray(plateauJoueur[plateauActuel].getTerrain(), c);
    }
    
    private void DestroyEnemyCarte(Carte c)
    {
        int p = 0;
        if (plateauActuel == 0)
            p = 1;
        if (c != null)
            Tools.RemoveFromArray(plateauJoueur[p].getTerrain(), c);
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
}