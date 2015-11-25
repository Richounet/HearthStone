package Modele.Plateau;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public class PlateauJeu
{
    private PlateauJoueur[] plateauJoueur;

    public PlateauJeu() 
    {
        this.plateauJoueur = new PlateauJoueur[2];
    }   

    public PlateauJoueur getPlateauJoueur(int i) 
    {
        return plateauJoueur[i];
    }   
}