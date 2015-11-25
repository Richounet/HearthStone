package Modele.Carte;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL    P1306459
 */

public abstract class Carte
{
    private String nom;
    private int coutRessource;

    public Carte(String nom, int coutRessource)
    {
        this.nom = nom;
        this.coutRessource = coutRessource;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public int getCoutRessource()
    {
        return coutRessource;
    }

    public void setCoutRessource(int coutRessource)
    {
        this.coutRessource = coutRessource;
    } 
}
