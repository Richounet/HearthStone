package Main;

import Modele.Carte.Deck;
import Vue.FenetrePalette;
import Vue.VueCarte;

public class Main 
{
    public static void main(String[] args) 
    {
        Deck.InitDeck();

        FenetrePalette fenetre = new FenetrePalette();
        fenetre.setVisible(true);        
        fenetre.setLocationRelativeTo(null);
    }
}