package Projet_Collecte_Sang.dao_LieuCollecte.controleurLieuCollecte;

import java.util.List;

import Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte.LieuCollecte;
import Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte.DaoLieuCollecte;


public class ControleurLieuCollecte implements IActionsLieuCollecte {

    private static ControleurLieuCollecte CtrLieuCollecte_Instance = null;
    private static DaoLieuCollecte Dao_Instance = null;
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    private ControleurLieuCollecte(){}

    public static synchronized ControleurLieuCollecte getControleurLieuCollecte() {
        try {
            if (CtrLieuCollecte_Instance == null) {
                CtrLieuCollecte_Instance = new ControleurLieuCollecte();
                Dao_Instance = DaoLieuCollecte.getLivreDao();
            }
            return CtrLieuCollecte_Instance;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<LieuCollecte> CtrLieuCollecte_GetAll() {
        return Dao_Instance.MdlLieuCollecte_GetAll();
    }

    @Override
    public String CtrLieuCollecte_Enregistrer(LieuCollecte lieu) {
        String message = null;
        message = Dao_Instance.MdlLieuCollecte_Enregistrer(lieu);
        return message;
    }


    @Override
    public LieuCollecte CtrLieuCollecte_GetById(int id) {
        return Dao_Instance.MdlLieuCollecte_GetByID(id);
    }

    @Override
    public List<LieuCollecte> CtrLieuCollecte_GetByChamps(String champs, String valeur) {
        return Dao_Instance.MdlLieuCollecte_GetByChamps(champs, valeur);
    }

    @Override
    public int CtrLieuCollecte_Modifier(LieuCollecte lieu) {
        return Dao_Instance.MdlLieuCollecte_Modifier(lieu);
    }

    @Override
    public int CtrLieuCollecte_Enlever(int id) {
        return Dao_Instance.MdlLieuCollecte_Supprimer(id);
    }

    @Override
    public int CtrLieuCollecte_EnregistrerParRequete(String strSql, String valeur) {
        return Dao_Instance.MdlLieuCollecte_EnregistrerParRequete(strSql,valeur);
    }
    

    

}
