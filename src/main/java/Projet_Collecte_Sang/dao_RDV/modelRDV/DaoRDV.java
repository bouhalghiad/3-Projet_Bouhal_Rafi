package Projet_Collecte_Sang.dao_RDV.modelRDV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoRDV implements IRDV {
    private static Connection conn = null;
    private static DaoRDV instanceDao = null;

    // MySQL
    // private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String NOM_BD = "collectesang";
    private static final String URL_BD = "jdbc:mysql://localhost/" + NOM_BD;
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String SUPPRIMER = "DELETE FROM rdv WHERE ID_RDV=?";
    private static final String GET_ALL = "SELECT * FROM rdv ORDER BY ID_RDV";
    private static final String GET_BY_ID = "SELECT * FROM rdv WHERE ID_RDV=?";
    private static final String GET_BY_CHAMPS = "SELECT * FROM rdv WHERE ";
    private static final String ENREGISTRER = "INSERT INTO rdv VALUES(0,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE rdv SET ID_DONNEUR=?,ID_UTILISATEUREUR=?,DATE_RDV=?,HEURE=?,ETAT=? WHERE ID_RDV=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoRDV() {
    };

    public static synchronized DaoRDV getLivreDao() {
        try {
            if (instanceDao == null) {
                instanceDao = new DaoRDV();
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
    public String MdlRDV_Enregistrer(RDV rdv) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, rdv.getDonneur());
            stmt.setInt(2, rdv.getUtilisateur());
            stmt.setString(3, rdv.getDate());
            stmt.setInt(4, rdv.getHeure());
            stmt.setString(5, rdv.getEtat());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                rdv.setId(rs.getInt(1));
            }
            return "Le Rendez-Vous est bien enregistré ";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<RDV> MdlRDV_GetAll() {
        PreparedStatement stmt = null;
        List<RDV> listeRDV = new ArrayList<RDV>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RDV rdv = new RDV();
                rdv.setId(rs.getInt(1));
                rdv.setDonneur(rs.getInt(2));
                rdv.setUtilisateur(rs.getInt(3));
                rdv.setDate(rs.getString(4));
                rdv.setHeure(rs.getInt(5));
                rdv.setEtat(rs.getString(6));

                listeRDV.add(rdv);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // Mdldonneur_Fermer(conn);
        }

        return listeRDV;
    }

    @Override
    public RDV MdlRDV_GetByID(int id) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                RDV rdv = new RDV();
                rdv.setId(rs.getInt(1));
                rdv.setDonneur(rs.getInt(2));
                rdv.setUtilisateur(rs.getInt(3));
                rdv.setDate(rs.getString(4));
                rdv.setHeure(rs.getInt(5));
                rdv.setEtat(rs.getString(6));
                return rdv;
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
    public List<RDV> MdlRDV_GetByChamps(String champs, String valeur) {
        PreparedStatement stmt = null;
        List<RDV> listeRDV = new ArrayList<RDV>();

        try {
            stmt = conn.prepareStatement(GET_BY_CHAMPS + champs + "=?");
            stmt.setString(1, valeur);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RDV rdv = new RDV();
                rdv.setId(rs.getInt(1));
                rdv.setDonneur(rs.getInt(2));
                rdv.setUtilisateur(rs.getInt(3));
                rdv.setDate(rs.getString(4));
                rdv.setHeure(rs.getInt(5));
                rdv.setEtat(rs.getString(6));
                listeRDV.add(rdv);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            // Mdldonneur_Fermer(conn);
        }

        return listeRDV;
    }

    @Override
    public int MdlRDV_Modifier(RDV rdv) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setInt(1, rdv.getDonneur());
            stmt.setInt(2, rdv.getUtilisateur());
            stmt.setString(3, rdv.getDate());
            stmt.setInt(4, rdv.getHeure());
            stmt.setString(5, rdv.getEtat());
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
    public int MdlRDV_Supprimer(int id) {
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
    public int MdlRDV_EnregistrerParRequete(String strSql, String valeur) {
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
