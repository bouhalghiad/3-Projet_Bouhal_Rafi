package Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte;

import java.util.List;

public interface ILieuCollecte {

    // Pour le CRUD - Create Read Update Delete

    // Create
    public String MdlLieuCollecte_Enregistrer(LieuCollecte lieu);

    public int MdlLieuCollecte_EnregistrerParRequete(String strSql, String valeur);

    // Read
    public List<LieuCollecte> MdlLieuCollecte_GetAll();

    public LieuCollecte MdlLieuCollecte_GetByID(int id);

    public List<LieuCollecte> MdlLieuCollecte_GetByChamps(String champs, String valeur);

    // Update
    public int MdlLieuCollecte_Modifier(LieuCollecte lieu);

    // Delete
    public int MdlLieuCollecte_Supprimer(int id);

}
