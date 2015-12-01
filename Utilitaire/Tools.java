package Utilitaire;

import Modele.Carte.Carte;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class Tools
{
    public static int Random(int min, int max)
    {
        return min + (int)(Math.random() * ((max - min) + 1)); 
    }
    
    public static void RemoveFromArray(Carte[] array, Carte c)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i] == c)
            {
                array[i] = null;
                break;
            }
    }
}
