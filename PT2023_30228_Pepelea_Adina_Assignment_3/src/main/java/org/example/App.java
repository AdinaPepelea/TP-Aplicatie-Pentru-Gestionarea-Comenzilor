package org.example;

import Presentation.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Client;
import BusinessLayer.ClientBLL;
import BusinessLayer.OrderBLL;
import BusinessLayer.ProductBLL;

/**
 * Aceasta este clasa main in care se creeaza interfata.
 */
public class App
{
    public static void main( String[] args ) throws SQLException {
        View view = new View();
        view.setVisible(false);
        Controller controller = new Controller(view);
    }
}
