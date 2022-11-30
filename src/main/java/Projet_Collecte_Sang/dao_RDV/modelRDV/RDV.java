package Projet_Collecte_Sang.dao_RDV.modelRDV;

public class RDV {
    private int id;
    private int donneur;
    private int utilisateur;
    private String date = "";
    private int heure;
    private String etat = "";

    public RDV() {
    }

    public RDV(int id, int donneur, int utilisateur, String date, int heure, String etat) {
        this.setId(id);
        this.setDonneur(donneur);
        this.setUtilisateur(utilisateur);
        this.setDate(date);
        this.setHeure(heure);
        this.setEtat(etat);
    }

    public RDV(int donneur, int utilisateur, String date, int heure, String etat) {
        this.setDonneur(donneur);
        this.setUtilisateur(utilisateur);
        this.setDate(date);
        this.setHeure(heure);
        this.setEtat(etat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonneur() {
        return donneur;
    }

    public void setDonneur(int donneur) {
        this.donneur = donneur;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

}
