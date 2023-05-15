package Model;

/**
 * Aceasta clasa reprezinta tabelul Product din baza de date cu atributele: idProduct, nameProduct, stoc, price.
 */
public class Product {
    private int idProduct;
    private String nameProduct;
    private int stoc;
    private int price;

    /**\
     * Contructorul initializeaza obiecte noi.
     * @param idProduct
     * @param nameProduct
     * @param stoc
     * @param price
     */
    public Product(int idProduct, String nameProduct, int stoc, int price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.stoc = stoc;
        this.price = price;
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
     * Metoda get pentru nameProduct.
     * @return
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * Metoda set pentru nameProduct.
     * @param nameProduct
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * Metoda get pentru stoc.
     * @return
     */
    public int getStoc() {
        return stoc;
    }

    /**
     * Metoda set pentru stoc.
     * @param stoc
     */
    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    /**
     * Metoda get pentru price.
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Metoda set pentru price.
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Metoda toString.
     * @return
     */
    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", stoc=" + stoc +
                ", price=" + price +
                '}';
    }
}
