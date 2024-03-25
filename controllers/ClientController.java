package controllers;

import java.awt.*;
import java.sql.*;
import java.util.Vector;

import connection.ConnectionFactory;

import dao.ClientDAO;
import models.Client;
import views.ClientView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class ClientController {
    private ClientView clientView;
    public JFrame myFrame = new JFrame();

    /**
     * metode care realizeaza afisarea tabelului clienti, realizeaza inserarea, stergerea sau editarea unui client
     * @param clientView
     */
    public ClientController(ClientView clientView){
        this.clientView=clientView;

        this.clientView.addVeziClientiiListener(e->{

            String q = "Select * from clients";
            ResultSet rs = null;
            JTable table=new JTable();
            JPanel fereastra = new JPanel();
            PreparedStatement prepStmt = null;
            ClientDAO clientDAO=new ClientDAO();
            Connection dbConnection = ConnectionFactory.getConnection();
            try {
                prepStmt = dbConnection.prepareStatement(q);
                rs = prepStmt.executeQuery();
                table = new JTable(clientDAO.createHeaderAndPopulate(rs));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JScrollPane jsp = new JScrollPane(table);
            myFrame.getContentPane().add(jsp);

            fereastra.setLayout(new BorderLayout());
            fereastra.add(jsp);


            myFrame.setContentPane(fereastra);
            myFrame.setTitle("clients");

            myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myFrame.setSize(600, 400);
            myFrame.setVisible(true);

        });

        this.clientView.addAdaugaClientListener(e->{

            int idc= clientView.getIdTextField();
            String nume= clientView.getNumeTextField();
            String adresa= clientView.getAdresaTextField();
            Client client=new Client(idc,nume,adresa);
            ClientDAO.insert(client);

        });

        this.clientView.addEditeazaClientListener(e->{

            int idc= clientView.getIdTextField();
            String nume= clientView.getNumeTextField();
            String adresa= clientView.getAdresaTextField();
            Client client=new Client(idc,nume,adresa);
            ClientDAO.update(client);

        });

        this.clientView.addStergeClientListener(e->{

            int idc= clientView.getIdTextField();
            String nume= clientView.getNumeTextField();
            String adresa= clientView.getAdresaTextField();
            Client client=new Client(idc,nume,adresa);
            ClientDAO.delete(client);
        });
    }

}
