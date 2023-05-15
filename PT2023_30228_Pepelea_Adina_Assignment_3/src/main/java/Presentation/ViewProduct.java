package Presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Acesta clasa se ocupa de realizarea ferestrei pentru operatiile cu produse.
 */

public class ViewProduct extends JFrame{

    public JFrame frame;
    private JTextField idText;
    private JTextField nameText;
    private JTextField stocText;
    private JTextField priceText;
    private JLabel id;
    private JLabel nameProduct;
    private JLabel stocProd;
    private JLabel priceProduc;
    private JButton addProd;
    private JButton updateProd;
    private JButton deleteProd;
    private JButton showTableProd;
    private JButton inapoi;

    /**
     * Create the application.
     */
    public ViewProduct() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * Contine 5 butoane.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 646, 471);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        id = new JLabel("ID PRODUCT:");
        id.setFont(new Font("Tahoma", Font.PLAIN, 15));
        id.setBounds(10, 10, 127, 28);
        frame.getContentPane().add(id);

        nameProduct = new JLabel("NAME:");
        nameProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameProduct.setBounds(10, 49, 127, 28);
        frame.getContentPane().add(nameProduct);

        stocProd = new JLabel("STOC:");
        stocProd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        stocProd.setBounds(10, 91, 127, 28);
        frame.getContentPane().add(stocProd);

        priceProduc = new JLabel("PRICE:");
        priceProduc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        priceProduc.setBounds(10, 129, 127, 28);
        frame.getContentPane().add(priceProduc);

        idText = new JTextField();
        idText.setColumns(10);
        idText.setBounds(111, 10, 139, 28);
        frame.getContentPane().add(idText);

        nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setBounds(111, 49, 139, 28);
        frame.getContentPane().add(nameText);

        stocText = new JTextField();
        stocText.setColumns(10);
        stocText.setBounds(111, 94, 139, 28);
        frame.getContentPane().add(stocText);

        priceText = new JTextField();
        priceText.setColumns(10);
        priceText.setBounds(111, 132, 139, 28);
        frame.getContentPane().add(priceText);

        addProd = new JButton("ADD PRODUCT");
        addProd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addProd.setBounds(284, 16, 157, 46);
        frame.getContentPane().add(addProd);

        updateProd = new JButton("EDIT PRODUCT");
        updateProd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        updateProd.setBounds(465, 16, 157, 46);
        frame.getContentPane().add(updateProd);

        deleteProd = new JButton("DELETE PRODUCT");
        deleteProd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deleteProd.setBounds(284, 76, 157, 46);
        frame.getContentPane().add(deleteProd);

        showTableProd = new JButton("SHOW TABLE");
        showTableProd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showTableProd.setBounds(465, 73, 157, 46);
        frame.getContentPane().add(showTableProd);

        inapoi = new JButton("BACK");
        inapoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inapoi.setBounds(372, 135, 157, 46);
        frame.getContentPane().add(inapoi);
        frame.setVisible(false);
        this.setVisible(false);
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru userIdProduct si il converteste in int.
     * @return
     */
    public int getUserIdProduct()
    {
        String idInput;
        int idP;
        idInput=this.idText.getText();
        idP=Integer.parseInt(idInput);
        return idP;
    }


    /**
     * Aceasta metoda extrage string-ul din TextField pentru nameProduct.
     * @return
     */
    public String getNameProduct()
    {
        return this.nameText.getText();
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru StocProduct si il conversteste in int.
     * @return
     */
    public int getStocProduct()
    {
        String inputStoc;
        int stocP;
        inputStoc=this.stocText.getText();
        stocP=Integer.parseInt(inputStoc);
        return stocP;
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru PriceProduct si il converteste in int.
     * @return
     */
    public int getPriceProduct()
    {
        String inputPrice;
        int pret;
        inputPrice=this.priceText.getText();
        pret=Integer.parseInt(inputPrice);
        return pret;
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul add  Product, prin care va adauga produsul in tabel.
     * @param actionListener
     */
    public void addProductListener(ActionListener actionListener)
    {
        this.addProd.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul updateProduct, prin care va actualiza produsul din tabel.
     * @param actionListener
     */
    public void updateProductListener(ActionListener actionListener)
    {
        this.updateProd.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul deleteProduct, prin care va sterge produsul din tabel.
     * @param actionListener
     */
    public void deleteProductListener(ActionListener actionListener)
    {
        this.deleteProd.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul ShowProductTable, prin care va deschide o fereastra noua,
     * cu tabelul din baza de date in care se afla produsele.
     * @param actionListener
     */
    public void ShowProductTableListener(ActionListener actionListener)
    {
        this.showTableProd.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul BackProductButton, prin care va merge inapoi la pagina principala
     * @param actionListener
     */
    public void BackProductListener(ActionListener actionListener)
    {
        this.inapoi.addActionListener(actionListener);
    }

}
