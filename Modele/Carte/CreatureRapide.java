package Modele.Carte;

import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class CreatureRapide extends Creature
{
    public CreatureRapide(String nom, int coutRessource, int att, int def)
    {
        super(nom, coutRessource, att, def);
        setEtat(EtatCreature.Normal);
    }

    @Override
    public void TriggerInvocation(Joueur j)
    {
        setEtat(EtatCreature.Normal);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        CreatureRapide c = new CreatureRapide(nom, coutRessource, attaque, defense);
        c.setEtat(EtatCreature.Normal);
        return (Object)c;
    }
}