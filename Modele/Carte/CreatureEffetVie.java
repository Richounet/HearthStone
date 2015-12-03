package Modele.Carte;

import Modele.Joueur.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class CreatureEffetVie extends Creature
{
    protected int bonusVie;
    
    public CreatureEffetVie(String nom, int coutRessource, int att, int def, int bonusVie)
    {
        super(nom, coutRessource, att, def);
    }

    @Override
    public void TriggerInvocation(Joueur j)
    {
        super.TriggerInvocation(j);
        j.setPv(j.getPv() + bonusVie);
    }
}
