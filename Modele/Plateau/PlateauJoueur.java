package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Carte.Creature;
import Modele.Carte.Deck;
import Modele.Carte.EtatCreature;
import Modele.Joueur.Joueur;
import Utilitaire.MyObservable;
import Utilitaire.Tools;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class PlateauJoueur extends MyObservable
{
    private Joueur joueur;
    private Carte[] main;
    private Carte[] terrain;
    private Carte[] ligneCombat;

    public PlateauJoueur(Joueur j) 
    {
        this.joueur = j;
        this.main = new Carte[4];
        for (int i = 0; i < 4; i++)
            main[i] = Deck.GetRandomCarte();
        this.terrain = new Carte[4];
        this.ligneCombat = new Carte[4];
        
        Notify();
    }

    public Carte getMain(int i) 
    {
        return main[i];
    }

    public Carte getLigneCombat(int i) 
    {
        return ligneCombat[i];
    }

    public Carte getTerrain(int i) 
    {
        return terrain[i];
    }
    
    public Joueur getJ()
    {
        return joueur;
    }

    public void setJ(Joueur j)
    {
        this.joueur= j;
    }
    
    public void InitPlateauDebutTour()
    {
        // Passage de toutes les créatures du terrain en normal
        for (int j = 0; j < terrain.length; j++)
            if (terrain[j] != null)
                ((Creature)terrain[j]).setEtat(EtatCreature.Normal);
    }
    
    public void TryDefend(Carte defenseur, Carte attaquante)
    {
        
        
        Notify();
    }
    
    public void TryInvoc(Carte newCarte)
    {
        int j;
        for (j = 0; j < terrain.length; j++)
            if (terrain[j] == null)
                break;
        
        // S'il y a de la place et que le joueur a assez de ressource
        // On passe la carte de la main au terrain
        if (j < terrain.length && newCarte.getCoutRessource() <= joueur.getRessource())
        {
            terrain[j] = newCarte;
            Tools.RemoveFromArray(main, newCarte);
            joueur.setRessource(joueur.getRessource() - newCarte.getCoutRessource());
        }
        
        Notify();
    }
    
    public void TryAttack(Carte newAtt)
    {
        int j;
        for (j = 0; j < ligneCombat.length; j++)
            if (ligneCombat[j] == null)
                break;
        
        // Si le joueur a assez de place pour attaquer
        // On passe la carte du terrain a la ligne de combat
        if (j < ligneCombat.length)
        {
            ((Creature)newAtt).setEtat(EtatCreature.Fatigue);
            ligneCombat[j] = newAtt;
            Tools.RemoveFromArray(terrain, newAtt);
        }
            
        Notify();
    }
    
    public void TryTirerCarte()
    {
        for (int i = 0; i < main.length; i++)
            if (main[i] == null)
                main[i] = Deck.GetRandomCarte();
        Notify();
    }
    
    public void RemoveAttaquant(int i)
    {
        int j;
        for (j = 0; j < terrain.length; j++)
            if (terrain[j] == null)
                break;
        terrain[j] = ligneCombat[i];
        ligneCombat[i] = null;
        
        Notify();
    }
    
    public void ChargeRessources()
    {
        joueur.setRessource(Partie.numeroTour);
    }
    
    public void DechargeRessources()
    {
        joueur.setRessource(0);
    }
}