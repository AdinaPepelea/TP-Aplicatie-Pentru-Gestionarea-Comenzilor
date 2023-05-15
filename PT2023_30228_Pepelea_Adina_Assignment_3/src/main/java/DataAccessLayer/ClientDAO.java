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
import Model.Client;

/**
 * In aceasta clasa sunt implementate metodele: adugarea, stergerea, actualizarea si afisarea tabelului Clients.
 */

public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (id,name,address,email,age)"
            + " VALUES (?,?,?,?,?)";
    private static final String updateStatementString = "UPDATE client SET Age = ? where Name= ?";
    private static final String deleteStatementString = "DELETE FROM client where Name= ?";
    private static String viewStatementString = "SELECT * FROM client ";
    private final static String findStatementString = "SELECT * FROM client where id = ?";

    /**
     * Aceasta metoda returneaza clientul al carui id il dam ca parametru.
     * @param clientId
     * @return
     */
    public static Client findById(int clientId) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String address = rs.getString("address");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            toReturn = new Client(clientId, name, address, email, age);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Aceasta metoda insereaza un client in tabel.
     * @param student
     */

    public static void insert(Client student) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, student.getId());
            insertStatement.setString(2, student.getName());
            insertStatement.setString(3, student.getAddress());
            insertStatement.setString(4, student.getEmail());
            insertStatement.setInt(5, student.getAge());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda actualizeaza varsta din tabel dupa numele clientilor.
     * @param name
     * @param age
     */

    public static void update(String name, int age) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, age);
            updateStatement.setString(2, name);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda sterge clientii din tabel dupa nume.
     * @param name
     */
    public static void delete(String name) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, name);
            deleteStatement.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda returneaza lista cu toti clientii din baza de date.
     */
    public static List<Client> viewAll() throws SQLException {
        Connection connection=ConnectionFactory.getConnection();
        PreparedStatement viewStatement=null;
        viewStatement=connection.prepareStatement(viewStatementString, Statement.RETURN_GENERATED_KEYS);
        ResultSet result=null;
        result=viewStatement.executeQuery(viewStatementString);
        List<Client> listClienti=new ArrayList<>();
        while(result.next())
        {
            Client client=new Client(result.getInt("ID"), result.getString("Name"),result.getString("Address"), result.getString("Email"), result.getInt("Age"));
            listClienti.add(client);
        }
        return listClienti;
    }

}
