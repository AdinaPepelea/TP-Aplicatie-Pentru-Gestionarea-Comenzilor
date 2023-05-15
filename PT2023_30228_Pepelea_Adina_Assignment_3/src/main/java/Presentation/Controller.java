package Presentation;


import DataAccessLayer.ClientDAO;
import Model.Client;
import Model.Order;
import Model.Product;
import BusinessLayer.ClientBLL;
import BusinessLayer.OrderBLL;
import BusinessLayer.ProductBLL;
import ShowData.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Acesta clasa implementeaza ActionListener pentru toate butoanele din interfata grafica.
 */

public class Controller {
    private View view;
    private ViewClient viewClient = new ViewClient();
    private ViewProduct viewProduct = new ViewProduct();
    private ViewOrder viewOrder = new ViewOrder();

    public Controller(View view) {
        this.view = view;
        //Pentru interfata clientilor
        this.view.clientShowTableListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ViewClient viewClient = new ViewClient();
                view.setVisible(false);
                viewClient.frame.setVisible(true);

                //Adaugarea unul client in baza de date
                viewClient.addClientListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String idInput = "", ageInput = "";
                        int idC, ageC;
                        idInput = viewClient.getUserIdClient();
                        idC = Integer.parseInt(idInput);
                        ageInput = viewClient.getAgeClient();
                        ageC = Integer.parseInt(ageInput);
                        Client client = new Client(idC, viewClient.getNameClient(), viewClient.getAddressClient(), viewClient.getEmailClient(), ageC);
                        ClientBLL clientBLL = new ClientBLL();
                        clientBLL.insertClient(client);
                    }
                });

                //Actualizarea unui client din baza de date
                viewClient.updateClientListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String ageInput = "", nameInput = "";
                        int ageC;
                        ageInput = viewClient.getAgeClient();
                        ageC = Integer.parseInt(ageInput);
                        nameInput = viewClient.getNameClient();
                        ClientBLL clientBLL = new ClientBLL();
                        clientBLL.updateClient(nameInput, ageC);
                    }
                });

                //Stergerea unui client din baza de date
                viewClient.deleteClientListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nameInput = "";
                        nameInput = viewClient.getNameClient();
                        ClientBLL clientBLL = new ClientBLL();
                        clientBLL.deleteClient(nameInput);
                    }
                });

                //Afisarea clientilor din baza de date
                viewClient.ShowClientTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ClientBLL clientBLL=new ClientBLL();
                        List<Client> clienti= null;
                        try {
                            clienti = clientBLL.showAll();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Table<Client> tabel=new Table<Client>(clienti);
                        } catch (IllegalAccessException | NoSuchFieldException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                //Inapoi la pagina principala
                viewClient.BackClientButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewClient.frame.setVisible(false);
                        view.frame.setVisible(true);
                    }
                });
            }
        });

        //Pentru interfata produselor
        this.viewProduct=viewProduct;
        this.view.productShowTableListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewProduct viewProduct=new ViewProduct();
                view.setVisible(false);
                viewProduct.frame.setVisible(true);

                //Adaugarea unui produs in baza de date
                viewProduct.addProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Product produs=new Product(viewProduct.getUserIdProduct(), viewProduct.getNameProduct(), viewProduct.getStocProduct(), viewProduct.getPriceProduct());
                        ProductBLL productBLL=new ProductBLL();
                        productBLL.insertProduct(produs);
                    }
                });

                //Actualizarea unui produs din baza de date
                viewProduct.updateProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL=new ProductBLL();
                        productBLL.updateProduct(viewProduct.getNameProduct(),viewProduct.getStocProduct());
                    }
                });

                //Stergerea unui produs din baza de date
                viewProduct.deleteProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL=new ProductBLL();
                        productBLL.deleteProduct(viewProduct.getNameProduct());
                    }
                });

                //Afisarea produselor din baza de date
                viewProduct.ShowProductTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL=new ProductBLL();
                        List<Product> produse= null;
                        try {
                            produse = productBLL.showAll();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Table<Product> tabel=new Table<Product>(produse);
                        } catch (IllegalAccessException | NoSuchFieldException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                //Inapoi la pagina principala
                viewProduct.BackProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewProduct.frame.setVisible(false);
                        view.frame.setVisible(true);
                    }
                });

            }
        });

        //Pentru interfata comenzilor
        this.viewOrder=viewOrder;
        this.view.orderShowTableListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewOrder viewOrder=new ViewOrder();
                view.setVisible(false);
                viewOrder.frame.setVisible(true);
                viewOrder.comboIdClient();
                viewOrder.comboIDProduct();

                //Adaugarea unei comenzi in baza de date
                viewOrder.addOrderListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ProductBLL productBLL=new ProductBLL();
                        OrderBLL orderBLL=new OrderBLL();

                        int stocCurent=productBLL.getStocCurent(viewOrder.getIdProductOrder());
                        int cantitateIntrodusa=viewOrder.getQuantityOrderInput();

                        if(stocCurent<cantitateIntrodusa)
                        {
                            JOptionPane.showMessageDialog(viewOrder, "Stoc insuficient!");
                        }
                        else
                        {
                            int stocNou=stocCurent-cantitateIntrodusa;
                            productBLL.updateStocProduct(stocNou, viewOrder.getIdProductOrder());
                            Order comanda=new Order(viewOrder.getIdOrderInput(),viewOrder.getQuantityOrderInput(), viewOrder.getIdClientOrder(), viewOrder.getIdProductOrder());
                            orderBLL.insertOrder(comanda);
                        }
                    }
                });

                //Stergerea unei comenzi din baza de date
                viewOrder.deleteOrderListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OrderBLL orderBLL=new OrderBLL();
                        orderBLL.deleteOrder(viewOrder.getIdOrderInput());
                    }
                });

                //Afisarea comenzilor din baza de date
                viewOrder.ShowOrderTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OrderBLL orderBLL=new OrderBLL();
                        List<Order> comenzi= null;
                        try {
                            comenzi = orderBLL.showAll();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Table<Order> tabel=new Table<Order>(comenzi);
                        } catch (IllegalAccessException | NoSuchFieldException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                //Inapoi la pagina principala
                viewOrder.BackOrderListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewOrder.frame.setVisible(false);
                        view.frame.setVisible(true);
                    }
                });
            }
        });
    }
}
