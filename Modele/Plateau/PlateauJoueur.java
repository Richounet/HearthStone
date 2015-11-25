package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class PlateauJoueur 
{
    private Joueur joueur;
    private Carte[] main;
    private Carte[] terrain;
    private Carte[] ligneCombat;

    public PlateauJoueur(Joueur j) 
    {
        this.joueur = j;
        this.main = new Carte[4];
        this.terrain = new Carte[4];
        this.ligneCombat = new Carte[4];
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
    
    public void TryDefend(Carte defenseur, Carte attaquante)
    {
        
    }
    
    public void TryInvoc(Carte newCarte)
    {
        
    }
    
    public void TryAttack(Carte newAtt)
    {
        
    }
    
    public void RemoveAttaquant(int i)
    {
        int j;
        for (j = 0; j < terrain.length; j++)
            if (terrain[j] == null)
                break;
        terrain[j] = ligneCombat[i];
        ligneCombat[i] = null;
    }
}