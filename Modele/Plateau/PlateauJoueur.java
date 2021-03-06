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
public class PlateauJoueur extends MyObservable implements Cloneable
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
    
    public void EnleveFatigueCreatures()
    {
        // Passage de toutes les créatures du terrain en normal
        for (int j = 0; j < terrain.length; j++)
            if (terrain[j] != null)
                ((Creature)terrain[j]).setEtat(EtatCreature.Normal);
        
        Notify();
    }
    
    public Carte[] TryDefend(Carte defenseur, Carte attaquante)
    {
        Carte[] ret = new Carte[2];
        // Le joueur perd des pts de vie
        if (defenseur == null)
            joueur.setPv(joueur.getPv() - attaquante.getAttaque());
        // Il y a combat entre les cartes
        else
        {
            if (defenseur.getEtat() == EtatCreature.Fatigue)
            {
                joueur.setPv(joueur.getPv() - attaquante.getAttaque());   
            }
            else
            {                         
                int att1 = defenseur.getAttaque();
                int def1 = defenseur.getDefense();
                int att2 = attaquante.getAttaque();
                int def2 = attaquante.getDefense();

                boolean defDetruit = false;
                boolean attDetruit = false;

                if (att1 >= def2)
                    attDetruit = true;
                if (att2 >= def1)
                    defDetruit = true;

                if (defDetruit)
                    ret[0] = defenseur;
                if (attDetruit)
                    ret[1] = attaquante; 
            }   
        }
        
        Notify();
        
        return ret;
    }
    
    public void TryInvoc(Carte newCarte)
    {       
        if (newCarte == null)
            return;
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
            newCarte.TriggerInvocation(joueur);
            joueur.setRessource(joueur.getRessource() - newCarte.getCoutRessource());
        }
        
        Notify();
    }
    
    public void TryAttack(Carte newAtt)
    {
        if (newAtt == null)
            return;
        int j;
        for (j = 0; j < ligneCombat.length; j++)
            if (ligneCombat[j] == null)
                break;
        
        // Si le joueur a assez de place pour attaquer
        // On passe la carte du terrain a la ligne de combat
        if (j < ligneCombat.length)
        {
            ligneCombat[j] = newAtt;
            ligneCombat[j].setEtat(EtatCreature.Fatigue);
            Tools.RemoveFromArray(terrain, newAtt);
        }
            
        Notify();
    }
    
    public void TryTirerCarte()
    {
        for (int i = 0; i < main.length; i++)
            if (main[i] == null)
            {
                main[i] = Deck.GetRandomCarte();    
                break;
            }
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

    public void ChargeRessources(int nb)
    {
        joueur.setRessource(nb);
    }
    
    public void DechargeRessources()
    {
        joueur.setRessource(0);
    }
    
    public Carte[] getMain()
    {
        return main;
    }

    public void setMain(Carte[] main)
    {
        this.main = main;
    }

    public Carte[] getTerrain()
    {
        return terrain;
    }

    public void setTerrain(Carte[] terrain)
    {
        this.terrain = terrain;
    }

    public Carte[] getLigneCombat()
    {
        return ligneCombat;
    }

    public void setLigneCombat(Carte[] ligneCombat)
    {
        this.ligneCombat = ligneCombat;
    }  
    
    @Override
    public Object clone() throws CloneNotSupportedException 
    {
        PlateauJoueur p = new PlateauJoueur((Joueur)this.joueur.clone());
        return (Object)p;
    }
}