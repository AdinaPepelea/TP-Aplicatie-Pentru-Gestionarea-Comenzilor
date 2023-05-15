package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import Connection.ConnectionFactory;
import Model.Product;

/**
 * In aceasta clasa sunt implementate metodele: adugarea, stergerea, actualizarea si afisarea tabelului Products.
 */
public class ProductDAO {
    protected static final Logger LOGGER=Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO product (idProduct, nameProduct, Stoc , Price)" + "VALUES (?,?,?,?)";
    private static final String updateStatementString = "UPDATE product SET Stoc = ? where nameProduct=?";
    private static final String deleteStatementString =" DELETE FROM product where nameProduct=?";
    private final static String viewStatementString = "SELECT * FROM product ";
    private static final String updateStocStatementString = "UPDATE product SET Stoc = ? where idProduct=?";
    private static final String getStocProdusString="SELECT * FROM product WHERE idProduct=?";

    /**
     * Aceasta metoda insereaza un produs in tabel.
     * @param produs
     */
    public static void insert(Product produs)
    {
        Connection dbConnection=ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        try{
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,produs.getIdProduct());
            insertStatement.setString(2, produs.getNameProduct());
            insertStatement.setInt(3, produs.getStoc());
            insertStatement.setInt(4, produs.getPrice());
            insertStatement.executeUpdate();

            ResultSet rs=insertStatement.getGeneratedKeys();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: insert "+ e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda actualizeaza stocul in functie de numele produsului.
     * @param nameProduct
     * @param stoc
     */
    public static void update(String nameProduct, int stoc) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, stoc);
            updateStatement.setString(2, nameProduct);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda actualizeaza stocul unui produs (cantitatea) dupa o comanda.
     * @param cantitate
     * @param idProduct
     */
    public static void updateStoc(int cantitate, int idProduct)
    {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStocStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, cantitate);
            updateStatement.setInt(2, idProduct);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda verifica stocul disponibil pentru un produs.
     * @param idProduct
     * @return
     */
    public static int  getStoc(int idProduct)
    {
        int stocInt=0;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        ResultSet rs=null;
        try {
            updateStatement = dbConnection.prepareStatement(getStocProdusString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setLong(1, idProduct);
            rs=updateStatement.executeQuery();
            rs.next();
            stocInt=rs.getInt("Stoc");

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: getStoc " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return stocInt;
    }

    /**
     * Aceasta metoda sterge un produs in functie de id.
     * @param nameProduct
     */
    public static void delete(String nameProduct) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, nameProduct);
            deleteStatement.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda returneaza o lista cu toate produsele din baza de date.
     * @return
     * @throws SQLException
     */
    public static List<Product> viewAll() throws SQLException {
        Connection connection=ConnectionFactory.getConnection();
        PreparedStatement viewStatement=null;
        viewStatement=connection.prepareStatement(viewStatementString, Statement.RETURN_GENERATED_KEYS);
        ResultSet result=null;
        result=viewStatement.executeQuery(viewStatementString);
        List<Product> listProd=new ArrayList<>();
        while(result.next())
        {
            Product p=new Product(result.getInt("idProduct"), result.getString("nameProduct"),result.getInt("stoc"), result.getInt("price"));
            listProd.add(p);
        }
        return listProd;
    }
}
