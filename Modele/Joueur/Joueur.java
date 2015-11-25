package Modele.Joueur;

/**
 * @author RICHE Vincent P1203372
 * @author PARIS AXEL P1306459
 */
public class Joueur {

    private String nom;
    private int pv;

    public Joueur(String nom, int pv) {
        this.nom = nom;
        this.pv = pv;
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
