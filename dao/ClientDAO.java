package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import models.Client;



public class ClientDAO extends AbstractDAO<Client> {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO clients (idc,nume,adresa)"
            + " VALUES (?,?,?)";
    private final static String findStatementString = "SELECT * FROM clients where idp = ?";
    private final static String updateStatementString = "UPDATE clients" + " SET nume = ?, adresa = ?"+ " where idc = ?";
    private final static String deleteStatementString = "DELETE from clients" + " where idc = ?";


    /**
     * metoda care insereaza un client in tabelul de Clienti
     * @param client
     * @return
     */
    public static int insert(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getIdc());
            insertStatement.setString(2, client.getNume());
            insertStatement.setString(3, client.getAdresa());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * metoda care editeaza un client in tabelul de Clienti
     * @param client
     * @return
     */

    public static int update(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;
        int updatedId = -1;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, client.getNume());
            updateStatement.setString(2, client.getAdresa());
            updateStatement.setInt(3, client.getIdc());
            updateStatement.executeUpdate();

            ResultSet rs = updateStatement.getGeneratedKeys();
            if (rs.next()) {
                updatedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return updatedId;
    }

    /**
     * metoda care sterge un client in tabelul de Clienti
     * @param client
     * @return
     */

    public static int delete(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedId = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, client.getIdc());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedId;
    }

}
