package Model;

/**
 * Aceasta clasa reprezinta tabelul Order din baza de date cu atributele: idOrder, idClient, idProduct si quantity.
 */
public class Order {
    private int idOrder;
    private int idClient;
    private int idProduct;
    private int quantity;

    /**
     * Constructorul initializeaza obiecte noi.
     * @param idOrder
     * @param idClient
     * @param idProduct
     * @param quantity
     */
    public Order(int idOrder, int idClient, int idProduct, int quantity) {
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    /**
     * Metoda get pentru idOrder.
     * @return
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * Metoda set pentru idOrder.
     * @param idOrder
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * Metoda get pentru idClient.
     * @return
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Metoda set pentru idClient.
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Metoda get pentru idProduct.
     * @return
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Metoda set pentru idProduct.
     * @param idProduct
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Metoda get pentru quantity.
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Metoda set pentru quantity.
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Metoda toString.
     * @return
     */
    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idClient=" + idClient +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                '}';
    }
}
