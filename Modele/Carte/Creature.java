package Modele.Carte;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Creature extends Carte
{
    private int attaque;
    private int defense;
    
    public Creature(String nom, int coutRessource, int att, int def)
    {
        super(nom, coutRessource);
        this.attaque = att;
        this.defense = def;
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
}
