package Presentation;
import Connection.ConnectionFactory;
import Model.Client;
import Model.Product;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Acesta clasa se ocupa de realizarea ferestrei pentru operatiile cu client.
 */

public class ViewOrder extends JFrame{

    public JFrame frame;
    private JTextField idText;
    private JTextField quantityText;
    private JLabel idOrder;
    private JLabel idClient;
    private JLabel idProduct;
    private JLabel quantity;
    private JComboBox idCli;
    private JComboBox idProd;
    private JButton addOrder;
    private JButton deleteOrder;
    private JButton inapoi;
    private JButton showTableOrder;
    /**
     * Create the application.
     */
    public ViewOrder() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * Contine 4 butoane.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 646, 471);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        idOrder = new JLabel("ID ORDER:");
        idOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idOrder.setBounds(10, 14, 127, 28);
        frame.getContentPane().add(idOrder);

        idClient = new JLabel("ID CLIENT:");
        idClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idClient.setBounds(10, 52, 127, 28);
        frame.getContentPane().add(idClient);

        idProduct = new JLabel("ID PRODUCT:");
        idProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idProduct.setBounds(10, 90, 127, 28);
        frame.getContentPane().add(idProduct);

        quantity = new JLabel("QUANTITY:");
        quantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        quantity.setBounds(10, 128, 127, 28);
        frame.getContentPane().add(quantity);

        idText = new JTextField();
        idText.setColumns(10);
        idText.setBounds(126, 17, 139, 28);
        frame.getContentPane().add(idText);

        quantityText = new JTextField();
        quantityText.setColumns(10);
        quantityText.setBounds(126, 131, 139, 28);
        frame.getContentPane().add(quantityText);

        idCli = new JComboBox<Client>();
        idCli.setBounds(126, 58, 139, 28);
        frame.getContentPane().add(idCli);

        idProd = new JComboBox<Product>();
        idProd.setBounds(126, 96, 139, 28);
        frame.getContentPane().add(idProd);

        addOrder = new JButton("ADD ORDER");
        addOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addOrder.setBounds(299, 14, 157, 46);
        frame.getContentPane().add(addOrder);

        deleteOrder = new JButton("DELETE ORDER");
        deleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deleteOrder.setBounds(465, 14, 157, 46);
        frame.getContentPane().add(deleteOrder);

        inapoi = new JButton("BACK");
        inapoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inapoi.setBounds(299, 96, 157, 46);
        frame.getContentPane().add(inapoi);

        showTableOrder = new JButton("SHOW TABLE");
        showTableOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showTableOrder.setBounds(465, 96, 157, 46);
        frame.getContentPane().add(showTableOrder);
        frame.setVisible(false);
        this.setVisible(false);
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru idOrderInput si il converteste in int.
     * @return
     */
    public int getIdOrderInput()
    {
        String idString="";
        int idInt;
        idString=idText.getText();
        idInt=Integer.parseInt(idString);
        return idInt;
    }

    /**
     * Aceasta metoda returneaza id-ul clientilor existenti.
     * @return
     */
    public int getIdClientOrder()
    {
        return (int) idCli.getSelectedItem();
    }

    /**
     * Acteasta metoda returneaza id-ul produselor existente.
     * @return
     */
    public int getIdProductOrder() {
        return (int) idProd.getSelectedItem();
    }

    /**
     * Aceasta metoda contine ComboBox-ul facut pentru id-ul clientilor existenti in baza de date.
     */
    public void comboIdClient()
    {
        try{
            Connection connection=ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT ID FROM client");
            while(rs.next())
            {
                idCli.addItem(rs.getInt(1));
            }
            connection.close();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Couldn't connect to db","Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Aceasta metoda contine ComboBox-ul facut pentru id-ul prosduselor existente in baza de date.
     */
    public void comboIDProduct()
    {
        try{
            Connection connection= ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT idProduct FROM product");
            while(rs.next())
            {
                idProd.addItem(rs.getInt(1));
            }
            connection.close();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Couldn't connect to db","Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru QuantityOrderInput si il converteste in int.
     * @return
     */
    public int getQuantityOrderInput()
    {
        String cantitate="";
        int cantitateOrder;
        cantitate=this.quantityText.getText();
        cantitateOrder=Integer.parseInt(cantitate);
        return  cantitateOrder;
    }

    /**
     * ceasta metoda adauga ActionListener pe butonul addOrder, prin care va adauga comanda in tabel.
     * @param actionListener
     */
    public void addOrderListener(ActionListener actionListener)
    {
        this.addOrder.addActionListener(actionListener);
    }

    /**
     * ceasta metoda adauga ActionListener pe butonul deleteOrder, prin care va sterge comanda din tabel.
     * @param actionListener
     */
    public void deleteOrderListener(ActionListener actionListener)
    {
        this.deleteOrder.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul ShowOrderTable, prin care va deschide o fereastra noua,
     * cu tabelul din baza de date in care se afla comenzile.
     * @param actionListener
     */
    public void ShowOrderTableListener(ActionListener actionListener)
    {
        this.showTableOrder.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul BackOrderButton, prin care va merge inapoi la pagina principala.
     * @param actionListener
     */
    public void BackOrderListener(ActionListener actionListener)
    {
        this.inapoi.addActionListener(actionListener);
    }
}

