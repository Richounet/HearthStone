package Utilitaire;

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
}
