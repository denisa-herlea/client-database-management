package controllers;

import connection.ConnectionFactory;
import dao.ProductDAO;
import models.Product;
import views.ProductView;

import javax.swing.*;
import java.awt.*;
import java.sql.*;



public class ProductController {
    private ProductView productView;
    public JFrame myFrame = new JFrame();

    /**
     *  metode care realizeaza afisarea tabelului produse, realizeaza inserarea, stergerea sau editarea unui produs
     * @param productView
     */
    public ProductController(ProductView productView){
        this.productView=productView;

        this.productView.addVeziProduseListener(e->{

            String q = "Select * from products";
            ResultSet rs = null;
            JTable table=new JTable();
            JPanel fereastra = new JPanel();
            PreparedStatement prepStmt = null;
            ProductDAO productDAO=new ProductDAO();
            Connection dbConnection = ConnectionFactory.getConnection();
            try {
                prepStmt = dbConnection.prepareStatement(q);
                rs = prepStmt.executeQuery();
                table = new JTable(productDAO.createHeaderAndPopulate(rs));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JScrollPane jsp = new JScrollPane(table);
            myFrame.getContentPane().add(jsp);

            fereastra.setLayout(new BorderLayout());
            fereastra.add(jsp);


            myFrame.setContentPane(fereastra);
            myFrame.setTitle("products");

            myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myFrame.setSize(600, 400);
            myFrame.setVisible(true);

        });

        this.productView.addAdaugaProdusListener(e->{

            int idp= productView.getIdTextField();
            String nume=productView.getNumeTextField();
            double price= productView.getPretTextField();
            Product product=new Product(idp,nume,price);
            ProductDAO.insert(product);
        });

        this.productView.addEditeazaProdusListener(e->{

            int idp= productView.getIdTextField();
            String nume=productView.getNumeTextField();
            double price= productView.getPretTextField();
            Product product=new Product(idp,nume,price);
            ProductDAO.update(product);

        });

        this.productView.addStergeProdusListener(e->{

            int idp= productView.getIdTextField();
            String nume=productView.getNumeTextField();
            double price=0;
            Product product=new Product(idp,nume,price);
            ProductDAO.delete(product);
        });
    }

}
