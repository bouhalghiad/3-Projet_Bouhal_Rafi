package Projet_Collecte_Sang.dao_LieuCollecte.controleurLieuCollecte;

import java.util.List;

import Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte.*;

public interface IActionsLieuCollecte {
    // Create
    public String CtrLieuCollecte_Enregistrer(LieuCollecte lieu);
    public int CtrLieuCollecte_EnregistrerParRequete(String strSql,String valeur);
    
    // // Read
     public List<LieuCollecte> CtrLieuCollecte_GetAll();

     public LieuCollecte CtrLieuCollecte_GetById(int id);

    public List<LieuCollecte> CtrLieuCollecte_GetByChamps(String champs,String valeur);

    // // Update
    public int CtrLieuCollecte_Modifier(LieuCollecte lieu);

    // // Delete
     public int CtrLieuCollecte_Enlever(int id); 
}
