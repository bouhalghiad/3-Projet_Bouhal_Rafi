package Projet_Collecte_Sang.dao_RDV.controleurRDV;

import java.util.List;

import Projet_Collecte_Sang.dao_RDV.modelRDV.RDV;
import Projet_Collecte_Sang.dao_RDV.modelRDV.DaoRDV;


public class ControleurRDV implements IActionsRDV {

    private static ControleurRDV CtrRDV_Instance = null;
    private static DaoRDV Dao_Instance = null;
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    private ControleurRDV(){}

    public static synchronized ControleurRDV getControleurRDV() {
        try {
            if (CtrRDV_Instance == null) {
                CtrRDV_Instance = new ControleurRDV();
                Dao_Instance = DaoRDV.getLivreDao();
            }
            return CtrRDV_Instance;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<RDV> CtrRDV_GetAll() {
        return Dao_Instance.MdlRDV_GetAll();
    }

    @Override
    public String CtrRDV_Enregistrer(RDV rdv) {
        String message = null;
        message = Dao_Instance.MdlRDV_Enregistrer(rdv);
        return message;
    }


    @Override
    public RDV CtrRDV_GetById(int id) {
        return Dao_Instance.MdlRDV_GetByID(id);
    }

    @Override
    public List<RDV> CtrRDV_GetByChamps(String champs, String valeur) {
        return Dao_Instance.MdlRDV_GetByChamps(champs, valeur);
    }

    @Override
    public int CtrRDV_Modifier(RDV rdv) {
        return Dao_Instance.MdlRDV_Modifier(rdv);
    }

    @Override
    public int CtrRDV_Enlever(int id) {
        return Dao_Instance.MdlRDV_Supprimer(id);
    }

    @Override
    public int CtrRDV_EnregistrerParRequete(String strSql, String valeur) {
        return Dao_Instance.MdlRDV_EnregistrerParRequete(strSql,valeur);
    }
    

    

}
