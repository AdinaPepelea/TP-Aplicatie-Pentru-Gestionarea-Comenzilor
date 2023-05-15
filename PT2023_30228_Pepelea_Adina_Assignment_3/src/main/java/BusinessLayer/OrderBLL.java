package BusinessLayer;
import DataAccessLayer.OrderDAO;
import Model.Order;

import java.sql.SQLException;
import java.util.List;
/**
 * In aceasta clasa sunt apelate metodele din clasa OrderDAO pt inserare, stergere si afisare.
 */

public class OrderBLL {
    public void insertOrder(Order order) {
        OrderDAO.insert(order);
    }

    public void deleteOrder(int idOrder) {
        OrderDAO.delete(idOrder);
    }

    public List<Order> showAll() throws SQLException {
        return OrderDAO.viewAll();
    }
}
