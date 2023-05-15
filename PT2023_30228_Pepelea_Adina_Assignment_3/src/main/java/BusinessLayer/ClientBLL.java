package BusinessLayer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import BusinessLayer.validators.EmailValidator;
import BusinessLayer.validators.ClientAgeValidator;
import BusinessLayer.validators.Validator;
import DataAccessLayer.ClientDAO;
import Model.Client;

/**
 * In aceasta clasa sunt apelate metodele din clasa ClientDAO pt inserare, actualizare, stergere si afisare.
 */
public class ClientBLL {
    private List<Validator<Client>> validators;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());
    }

    public void insertClient(Client client)
    {
        ClientDAO.insert(client);
    }

    public void updateClient(String Name, int age)
    {
        ClientDAO.update(Name,age);
    }

    public void deleteClient(String name)
    {
        ClientDAO.delete(name);
    }

    public List<Client> showAll() throws SQLException {
        return  ClientDAO.viewAll();
    }

}
