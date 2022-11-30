package Projet_Collecte_Sang.dao_RDV.modelRDV;

import java.util.List;

public interface IRDV {

    // Pour le CRUD - Create Read Update Delete

    // Create
    public String MdlRDV_Enregistrer(RDV lieu);

    public int MdlRDV_EnregistrerParRequete(String strSql, String valeur);

    // Read
    public List<RDV> MdlRDV_GetAll();

    public RDV MdlRDV_GetByID(int id);

    public List<RDV> MdlRDV_GetByChamps(String champs, String valeur);

    // Update
    public int MdlRDV_Modifier(RDV lieu);

    // Delete
    public int MdlRDV_Supprimer(int id);

}
