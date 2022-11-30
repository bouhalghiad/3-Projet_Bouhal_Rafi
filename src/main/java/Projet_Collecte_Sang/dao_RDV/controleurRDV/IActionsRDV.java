package Projet_Collecte_Sang.dao_RDV.controleurRDV;

import java.util.List;

import Projet_Collecte_Sang.dao_RDV.modelRDV.*;

public interface IActionsRDV {
    // Create
    public String CtrRDV_Enregistrer(RDV rdv);

    public int CtrRDV_EnregistrerParRequete(String strSql, String valeur);

    // // Read
    public List<RDV> CtrRDV_GetAll();

    public RDV CtrRDV_GetById(int id);

    public List<RDV> CtrRDV_GetByChamps(String champs, String valeur);

    // // Update
    public int CtrRDV_Modifier(RDV rdv);

    // // Delete
    public int CtrRDV_Enlever(int id);
}
