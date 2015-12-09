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
        deck.add(new Creature("Dragon", 4, 4, 6));
        deck.add(new Creature("Gobelin", 1, 1, 1));
        deck.add(new Creature("Orc", 3, 3, 5));
        deck.add(new Creature("Soldat", 2, 2, 2));
        deck.add(new Creature("Elfe", 3, 3, 5));
        deck.add(new Creature("Nazgul", 5, 5, 5));
        deck.add(new Creature("Bilbo", 6, 6, 6));
        deck.add(new Creature("Balrog", 10, 10, 6));
        deck.add(new CreatureRapide("Spider", 1, 1, 2));
        deck.add(new CreatureRapide("Groot", 1, 0, 4));
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
}