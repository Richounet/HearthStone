package Modele.Carte;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Creature extends Carte
{
    private int attaque;
    private int defense;
    private EtatCreature etat;
    
    public Creature(String nom, int coutRessource, int att, int def)
    {
        super(nom, coutRessource);
        this.attaque = att;
        this.defense = def;
        this.etat = EtatCreature.Normal;
    }

    public int getAttaque()
    {
        return attaque;
    }

    public void setAttaque(int attaque)
    {
        this.attaque = attaque;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    public EtatCreature getEtat()
    {
        return etat;
    }

    public void setEtat(EtatCreature etat)
    {
        this.etat = etat;
    }
}
