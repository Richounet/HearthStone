package Modele.Carte;

import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Creature extends Carte
{
    protected int attaque;
    protected int defense;
    protected EtatCreature etat;
    
    public Creature(String nom, int coutRessource, int att, int def)
    {
        super(nom, coutRessource);
        this.attaque = att;
        this.defense = def;
        this.etat = EtatCreature.Normal;
    }
    
    @Override
    public int getAttaque()
    {
        return attaque;
    }

    @Override
    public void setAttaque(int attaque)
    {
        this.attaque = attaque;
    }

    @Override
    public int getDefense()
    {
        return defense;
    }

    @Override
    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    @Override
    public EtatCreature getEtat()
    {
        return etat;
    }

    @Override
    public void setEtat(EtatCreature etat)
    {
        this.etat = etat;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Creature c = new Creature(nom, coutRessource, attaque, defense);
        c.setEtat(etat);
        return (Object)c;
    }

    @Override
    public void TriggerInvocation(Joueur j)
    {
        setEtat(EtatCreature.Fatigue);
    }
}
