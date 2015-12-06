package Modele.Joueur;

import Modele.Carte.Carte;
import Modele.Phase.PhaseType;
import Modele.Plateau.PlateauJeu;
import Modele.Plateau.PlateauJoueur;
import Utilitaire.MyObservable;
import java.util.Observable;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class Joueur extends MyObservable implements Cloneable
{
    protected String nom;
    protected int pv;
    protected int ressource;

    public Joueur(String nom, int pv) 
    {
        this.nom = nom;
        this.pv = pv;
        this.ressource = 0;
        
        Notify();
    }

    public String getNom() 
    {
        return nom;
    }

    public int getPv() 
    {
        return pv;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
        Notify();
    }

    public void setPv(int pv) 
    {
        this.pv = pv;
        Notify();
    }
    
    public int getRessource()
    {
        return ressource;
    }

    public void setRessource(int ressource)
    {
        this.ressource = ressource;
        Notify();
    }
    
    public Carte GetCoup(PlateauJoueur p, PhaseType phase)
    {
        return null;
    }

    public Object clone() throws CloneNotSupportedException
    {
        Joueur j = new Joueur(this.nom, this.pv);
        return (Object)j;
    }
}
