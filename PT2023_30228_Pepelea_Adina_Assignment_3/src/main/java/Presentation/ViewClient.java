package Presentation;
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Acesta clasa se ocupa de realizarea ferestrei pentru operatiile cu client.
 */

public class ViewClient extends JFrame{

    public JFrame frame;
    private JTextField idText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField emailText;
    private JTextField ageText;
    private JLabel idClient;
    private JLabel nameCl;
    private JLabel addressClient;
    private JLabel emailClient;
    private JLabel ageClient;
    private JButton addClient;
    private JButton updateClient;
    private JButton deleteClient;
    private JButton showTableClient;
    private JButton inapoi;

    /**
     * Create the application.
     */
    public ViewClient() {
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

        idClient = new JLabel("ID CLIENT:");
        idClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idClient.setBounds(10, 10, 127, 28);
        frame.getContentPane().add(idClient);

        nameCl = new JLabel("NAME:");
        nameCl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameCl.setBounds(10, 46, 127, 28);
        frame.getContentPane().add(nameCl);

        addressClient = new JLabel("ADDRESS:");
        addressClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addressClient.setBounds(10, 84, 127, 28);
        frame.getContentPane().add(addressClient);

        emailClient = new JLabel("EMAIL:");
        emailClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailClient.setBounds(10, 122, 127, 28);
        frame.getContentPane().add(emailClient);

        ageClient = new JLabel("AGE:");
        ageClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ageClient.setBounds(10, 160, 127, 28);
        frame.getContentPane().add(ageClient);

        idText = new JTextField();
        idText.setBounds(98, 13, 139, 28);
        frame.getContentPane().add(idText);
        idText.setColumns(10);

        nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setBounds(98, 48, 139, 28);
        frame.getContentPane().add(nameText);

        addressText = new JTextField();
        addressText.setColumns(10);
        addressText.setBounds(98, 87, 139, 28);
        frame.getContentPane().add(addressText);

        emailText = new JTextField();
        emailText.setColumns(10);
        emailText.setBounds(98, 125, 139, 28);
        frame.getContentPane().add(emailText);

        ageText = new JTextField();
        ageText.setColumns(10);
        ageText.setBounds(98, 163, 139, 28);
        frame.getContentPane().add(ageText);

        addClient = new JButton("ADD CLIENT");
        addClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addClient.setBounds(269, 16, 157, 46);
        frame.getContentPane().add(addClient);

        updateClient = new JButton("EDIT CLIENT");
        updateClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        updateClient.setBounds(448, 16, 157, 46);
        frame.getContentPane().add(updateClient);

        deleteClient = new JButton("DELETE CLIENT");
        deleteClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deleteClient.setBounds(269, 77, 157, 46);
        frame.getContentPane().add(deleteClient);

        showTableClient = new JButton("SHOW TABLE");
        showTableClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showTableClient.setBounds(448, 77, 157, 46);
        frame.getContentPane().add(showTableClient);

        inapoi = new JButton("BACK");
        inapoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inapoi.setBounds(357, 151, 157, 46);
        frame.getContentPane().add(inapoi);

        frame.setVisible(false);
        this.setVisible(false);
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru userIdClient.
     * @return
     */
    public String getUserIdClient()
    {
        return this.idText.getText();
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru nameClient.
     * @return
     */
    public String getNameClient()
    {
        return this.nameText.getText();
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru adressClient.
     * @return
     */
    public String getAddressClient()
    {
        return this.addressText.getText();
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru ageClient.
     * @return
     */
    public String getAgeClient()
    {
        return this.ageText.getText();
    }

    /**
     * Aceasta metoda extrage string-ul din TextField pentru emailClient.
     * @return
     */
    public String getEmailClient()
    {
        return this.emailText.getText();
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul addClient, prin care va adauga clientul in tabel.
     * @param actionListener
     */
    public void addClientListener(ActionListener actionListener)
    {
        this.addClient.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul updateClient, prin care va actualiza clientul din tabel.
     * @param actionListener
     */
    public void updateClientListener(ActionListener actionListener)
    {
        this.updateClient.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul deleteClient, prin care va sterge clientul din tabel.
     * @param actionListener
     */
    public void deleteClientListener(ActionListener actionListener)
    {
        this.deleteClient.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul ShowClientTable, prin care va deschide o fereastra noua,
     * cu tabelul din baza de date in care se afla clientii.
     * @param actionListener
     */
    public void ShowClientTableListener(ActionListener actionListener)
    {
        this.showTableClient.addActionListener(actionListener);
    }

    /**
     * Aceasta metoda adauga ActionListener pe butonul BackClientButton, prin care va merge inapoi la pagina principala.
      * @param actionListener
     */
    public void BackClientButtonListener(ActionListener actionListener)
    {
        this.inapoi.addActionListener(actionListener);
    }
}

