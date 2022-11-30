package Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte;

public class LieuCollecte {
    private int id;
    private String nom = "";
    private String addresse = "";
    private String typelieu = "";

    public LieuCollecte() {
    }

    public LieuCollecte(int id, String nom, String addresse, String typelieu) {
        this.setId(id);
        this.setNom(nom);
        this.setAddresse(addresse);
        this.setTypelieu(typelieu);
    }

    public LieuCollecte(String nom, String addresse, String typelieu) {        
        this.setNom(nom);
        this.setAddresse(addresse);
        this.setTypelieu(typelieu);
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTypelieu() {
        return typelieu;
    }

    public void setTypelieu(String typelieu) {
        this.typelieu = typelieu;
    }

}
