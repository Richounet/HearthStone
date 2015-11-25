package Modele.Carte;

import Utilitaire.Tools;
import java.util.ArrayList;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Deck
{
    private static ArrayList<Carte> deck;
    
    public static void InitDeck()
    {
        deck.add(new Creature("Dragon", 4, 4, 6));
        deck.add(new Creature("Gobelin", 1, 0, 1));
        deck.add(new Creature("Orc", 3, 3, 5));
        deck.add(new Creature("Soldat", 2, 2, 2));
        deck.add(new Creature("Elfe", 3, 3, 5));
        deck.add(new Creature("Nazgul", 5, 5, 5));
        deck.add(new Creature("Bilbo", 6, 6, 6));
        deck.add(new Creature("Balrog", 10, 10, 6));
    }
    
    public static Carte GetRandomCarte()
    {
        return deck.get(Tools.Random(0, deck.size()));
    }
}