package Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoLieuCollecte implements ILieuCollecte {
    private static Connection conn = null;
    private static DaoLieuCollecte instanceDao = null;

    // MySQL
    // private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String NOM_BD = "collectesang";
    private static final String URL_BD = "jdbc:mysql://localhost/" + NOM_BD;
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String SUPPRIMER = "DELETE FROM lieucollecte WHERE ID_LIEU=?";
    private static final String GET_ALL = "SELECT * FROM lieucollecte ORDER BY ID_LIEU";
    private static final String GET_BY_ID = "SELECT * FROM lieucollecte WHERE ID_LIEU=?";
    private static final String GET_BY_CHAMPS = "SELECT * FROM lieucollecte WHERE ";
    private static final String ENREGISTRER = "INSERT INTO lieucollecte VALUES(0,?,?,?)";
    private static final String MODIFIER = "UPDATE lieucollecte SET NOM=?,ADRESSE=?,TYPE_LIEU=? WHERE ID_LIEU=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoLieuCollecte() {
    };

    public static synchronized DaoLieuCollecte getLivreDao() {
        try {
            if (instanceDao == null) {
                instanceDao = new DaoLieuCollecte();
                conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            }
            return instanceDao;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void Mdl_Fermer(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void Mdl_Fermer(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public Connection getConn() {
        return conn;
    }

    @Override
    public String MdlLieuCollecte_Enregistrer(LieuCollecte lieu) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, lieu.getNom());
            stmt.setString(2, lieu.getAddresse());
            stmt.setString(3, lieu.getTypelieu());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                lieu.setId(rs.getInt(1));
            }
            return "Lieu de collecte est bien enregistré ";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<LieuCollecte> MdlLieuCollecte_GetAll() {
        PreparedStatement stmt = null;
        List<LieuCollecte> listeLieu = new ArrayList<LieuCollecte>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LieuCollecte lieu = new LieuCollecte();
                lieu.setId(rs.getInt(1));
                lieu.setNom(rs.getString(2));
                lieu.setAddresse(rs.getString(3));
                lieu.setTypelieu(rs.getString(4));
                listeLieu.add(lieu);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // Mdldonneur_Fermer(conn);
        }

        return listeLieu;
    }

    @Override
    public LieuCollecte MdlLieuCollecte_GetByID(int id) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                LieuCollecte lieu = new LieuCollecte();
                lieu.setId(rs.getInt(1));
                lieu.setNom(rs.getString(2));
                lieu.setAddresse(rs.getString(3));
                lieu.setTypelieu(rs.getString(4));
                return lieu;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<LieuCollecte> MdlLieuCollecte_GetByChamps(String champs, String valeur) {
        PreparedStatement stmt = null;
        List<LieuCollecte> listeLieu = new ArrayList<LieuCollecte>();

        try {
            stmt = conn.prepareStatement(GET_BY_CHAMPS + champs + "=?");
            stmt.setString(1, valeur);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LieuCollecte lieu = new LieuCollecte();
                lieu.setId(rs.getInt(1));
                lieu.setNom(rs.getString(2));
                lieu.setAddresse(rs.getString(3));
                lieu.setTypelieu(rs.getString(4));
                listeLieu.add(lieu);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // Mdldonneur_Fermer(conn);
        }

        return listeLieu;
    }

    @Override
    public int MdlLieuCollecte_Modifier(LieuCollecte lieu) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setString(1, lieu.getNom());
            stmt.setString(2, lieu.getAddresse());
            stmt.setString(3, lieu.getTypelieu());
            stmt.setInt(4, lieu.getId());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public int MdlLieuCollecte_Supprimer(int id) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setInt(1, id);

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public int MdlLieuCollecte_EnregistrerParRequete(String strSql, String valeur) {
        PreparedStatement stmt = null;
        int cle = 0;
        try {
            stmt = conn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, valeur);

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                cle = rs.getInt(1);
            }
            return cle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // MdlLivre_Fermer(conn);
        }
    }

}
