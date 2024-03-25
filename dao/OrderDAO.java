package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import models.Order;
import models.Stock;



public class OrderDAO extends AbstractDAO<Order> {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO orders (ido,idc,idp,quantity,price)"
            + " VALUES (?,?,?,?,?)";
    private final static String findStatementString = "SELECT quantity FROM stocks,products where stocks.idp = products.idp and stocks.idp=?";
    private final static String findStatementString2 = "SELECT price FROM products where idp=?";
    private final static String updateStatementString = "UPDATE stocks" + " SET quantity = ? "+ " where idp = ?";

    public static int findById(int idp) {
        int toReturn = 0;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, idp);
            rs = findStatement.executeQuery();
            rs.next();

            toReturn = rs.getInt("quantity");

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * metoda care cauta pretul unui produs dupa id-ul acestuia
     * @param idp
     * @return
     */
    public static double findPrice(int idp) {
        double toReturn = 0;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString2);
            findStatement.setLong(1, idp);
            rs = findStatement.executeQuery();
            rs.next();

            toReturn = rs.getInt("price");

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findPrice " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * metoda care insereaza o comanda in tabelul de Orders
     * @param order
     * @return
     */

    public static int insert(Order order) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, order.getIdo());
            insertStatement.setInt(2, order.getIdc());
            insertStatement.setInt(3, order.getIdp());
            insertStatement.setInt(4, order.getQuantity());
            insertStatement.setDouble(5, order.getPrice());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * metoda care face update la stock dupa fiecare comanda plasata
     * @param stock
     * @return
     */

    public static int update(Stock stock) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;
        int updatedId = -1;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, stock.getQuantity());
            updateStatement.setInt(2, stock.getIdProduct());
            updateStatement.executeUpdate();

            ResultSet rs = updateStatement.getGeneratedKeys();
            if (rs.next()) {
                updatedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "StockDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return updatedId;
    }
}
