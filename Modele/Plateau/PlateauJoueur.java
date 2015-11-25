package Modele.Plateau;

import Modele.Carte.Carte;
import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class PlateauJoueur 
{
    private Joueur j;
    private Carte[] main;
    private Carte[] terrain;
    private Carte[] ligneCombat;

    public PlateauJoueur(Joueur j) 
    {
        this.j = j;
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
        return j;
    }

    public void setJ(Joueur j)
    {
        this.j = j;
    }
}