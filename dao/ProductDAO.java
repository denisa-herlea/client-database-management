package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import models.Product;




public class ProductDAO extends AbstractDAO<Product> {

    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO products (idp,nume,price)"
            + " VALUES (?,?,?)";
    private final static String findStatementString = "SELECT * FROM products where idp = ?";
    private final static String updateStatementString = "UPDATE products" + " SET nume = ?, price = ?"+ " where idp= ?";
    private final static String deleteStatementString = "DELETE from products" + " where idp = ?";

    /**
     * metoda care insereaza un produs in tabelul de Produse
     * @param product
     * @return
     */

    public static int insert(Product product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, product.getIdp());
            insertStatement.setString(2, product.getNume());
            insertStatement.setDouble(3, product.getPrice());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * metoda care editeaza un produs in tabelul de Produse
     * @param product
     * @return
     */

    public static int update(Product product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;
        int updatedId = -1;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1,  product.getNume());
            updateStatement.setDouble(2, product.getPrice());
            updateStatement.setInt(3, product.getIdp());
            updateStatement.executeUpdate();

            ResultSet rs = updateStatement.getGeneratedKeys();
            if (rs.next()) {
                updatedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return updatedId;
    }

    /**
     * metoda care sterge un produs in tabelul de Produse
     * @param product
     * @return
     */

    public static int delete(Product product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedId = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, product.getIdp());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedId;
    }

}
