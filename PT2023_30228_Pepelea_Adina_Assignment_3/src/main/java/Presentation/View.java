package Presentation;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * Aceasta clasa se ocupa de realizarea ferestrei principale.
 */

public class View extends JFrame{

    public JFrame frame;
    private JLabel labelTitlu;
    private JLabel table;
    private JButton butClient;
    private JButton butProdus;
    private JButton butOrder;

    /**
     * Create the application.
     */
    public View() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * Contine 3 butoane.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        frame.setBounds(100, 100, 646, 471);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        labelTitlu = new JLabel("ORDERS MANAGEMENT");
        labelTitlu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelTitlu.setBounds(207, 22, 193, 49);
        frame.getContentPane().add(labelTitlu);

        table = new JLabel("TABELS:");
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setBounds(255, 81, 58, 33);
        frame.getContentPane().add(table);

        butClient = new JButton("CLIENTS");
        butClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        butClient.setBounds(230, 135, 108, 33);
        frame.getContentPane().add(butClient);

        butProdus = new JButton("PRODUCTS");
        butProdus.setFont(new Font("Tahoma", Font.PLAIN, 15));
        butProdus.setBounds(230, 191, 108, 33);
        frame.getContentPane().add(butProdus);

        butOrder = new JButton("ORDERS");
        butOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        butOrder.setBounds(230, 249, 108, 33);
        frame.getContentPane().add(butOrder);

        frame.setVisible(true);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul clientShowTable, prin care va deschide fereastra noua pentru
     * clienti.
     * @param actionListener
     */
    public void clientShowTableListener(ActionListener actionListener)
    {
        this.butClient.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul productShowTable, prin care va deschide fereastra noua pentru
     * produse.
     * @param actionListener
     */
    public void productShowTableListener(ActionListener actionListener)
    {
        this.butProdus.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul orderShowTable, prin care va deschide ferastra noua pentru
     * comenzi.
     * @param actionListener
     */
    public void orderShowTableListener(ActionListener actionListener)
    {
        this.butOrder.addActionListener(actionListener);
    }
}

