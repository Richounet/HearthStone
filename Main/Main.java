package Main;

import Vue.FenetrePalette;

/**
 *
 * @author Richounet
 */
public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Bienvenue dans notre jeu de cartes type \"combat de créatures\" !");
        FenetrePalette fenetre = new FenetrePalette();
        fenetre.setVisible(true);        
        fenetre.setLocationRelativeTo(null);
    }
}
