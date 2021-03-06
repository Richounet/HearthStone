package Modele.Carte;

import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public abstract class Carte implements Cloneable
{
    protected String nom;
    protected int coutRessource;

    public Carte(String nom, int coutRessource)
    {
        this.nom = nom;
        this.coutRessource = coutRessource;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public int getCoutRessource()
    {
        return coutRessource;
    }

    public void setCoutRessource(int coutRessource)
    {
        this.coutRessource = coutRessource;
    } 
    
    public abstract int getAttaque();

    public abstract void setAttaque(int attaque);

    public abstract int getDefense();

    public abstract void setDefense(int defense);

    public abstract EtatCreature getEtat();

    public abstract void setEtat(EtatCreature etat);
    
    public abstract void TriggerInvocation(Joueur j);
    
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }    
}
