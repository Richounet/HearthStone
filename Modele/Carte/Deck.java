package Modele.Carte;

import Utilitaire.Tools;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Deck
{
    private static ArrayList<Carte> deck;
    
    public static void InitDeck()
    {
        deck = new ArrayList<>();
        deck.add(new Creature("Dragon", 4, 9, 6));
        deck.add(new Creature("Gobelin", 1, 1, 1));
        deck.add(new Creature("Orc", 3, 2, 0));
        deck.add(new Creature("Soldat", 2, 2, 2));
        deck.add(new Creature("Elfe", 3, 5, 5));
        deck.add(new Creature("Nazgul", 10, 8, 5));
        deck.add(new Creature("Bilbon", 6, 2, 6));
        deck.add(new Creature("Balrog", 10, 10, 6));
        deck.add(new CreatureRapide("Araignee", 1, 1, 2));
        deck.add(new CreatureRapide("Loup", 4, 4, 3));
        deck.add(new CreatureEffetVie("Groot", 1, 0, 4, 6));
        deck.add(new CreatureEffetVie("Sorciere", 1, 3, 4, 2));
        deck.add(new CreatureEffetVie("Mage", 1, 2, 2, 4));
    }
    
    public static Carte GetRandomCarte()
    {
        Carte ret = deck.get(Tools.Random(0, deck.size() - 1));
        try
        {
            return (Carte)ret.clone();
        } catch (CloneNotSupportedException ex)
        {
            Logger.getLogger(Deck.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Carte FindCardByName(String s)
    {
        for (int i = 0; i < deck.size(); i++)
            if (deck.get(i).getNom().equals(s))
                try {
                    return (Carte) deck.get(i).clone();
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Deck.class.getName()).log(Level.SEVERE, null, ex);
                }
        return null;
    }
}