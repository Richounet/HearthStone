package Modele.Joueur;

import Utilitaire.MyObservable;
import java.util.Observable;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class Joueur extends MyObservable
{
    private String nom;
    private int pv;
    private int ressource;

    public Joueur(String nom, int pv) 
    {
        this.nom = nom;
        this.pv = pv;
        this.ressource = 20;
        
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
    }
}
