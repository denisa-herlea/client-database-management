package controllers;

import connection.ConnectionFactory;
import dao.OrderDAO;
import models.Order;
import models.Stock;
import views.ProductOrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;




public class ProductOrderController {
    private ProductOrderView productOrderView ;
    public JFrame myFrame = new JFrame();

    /**
     *  metode care realizeaza afisarea tabelului comenzi si realizeaza inserarea in aceasta tabela si editarea tabelului stock dupa fiecare comanda
     * @param productOrderView
     */

    public ProductOrderController(ProductOrderView productOrderView){
        this.productOrderView=productOrderView;


        this.productOrderView.addComandaListener(e->{

            int id= productOrderView.getIdTextField();
            int idc= productOrderView.getIdClientTextField();
            int idp= productOrderView.getIdProductTextField();
            int quantity=productOrderView.getNrBucatiTextField();

            double pretProdus=OrderDAO.findPrice(idp);
            double price=quantity*pretProdus;
            Order order= new Order(id,idc,idp,quantity,price);

            int q= OrderDAO.findById(idp);

            if(q<quantity)
                System.out.println("Nu se gasesc asa multe produse in stoc!");
            else{
                OrderDAO.insert(order);
                Stock stock=new Stock(idp,idp, q-quantity);
                OrderDAO.update(stock);
                System.out.println("Comanda plasata cu succes! Au mai ramas in stoc doar "+ (q-quantity) +" produse!");
            }
        });

        this.productOrderView.addvezistocListener(e->{

            String q = "Select * from stocks";
            ResultSet rs = null;
            PreparedStatement prepStmt = null;
            JTable table=new JTable();
            JPanel fereastra = new JPanel();
            Connection dbConnection = ConnectionFactory.getConnection();
            try {
                prepStmt = dbConnection.prepareStatement(q);
                rs = prepStmt.executeQuery();
                table = new JTable(buildTableModel(rs));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JScrollPane jsp = new JScrollPane(table);
            myFrame.getContentPane().add(jsp);

            fereastra.setLayout(new BorderLayout());
            fereastra.add(jsp);
            myFrame.setContentPane(fereastra);
            myFrame.setTitle("stock");
            myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myFrame.setSize(600, 400);
            myFrame.setVisible(true);

        });

        this.productOrderView.addvezicomenziListener(e->{
            String q = "Select * from orders";
            ResultSet rs = null;
            JTable table=new JTable();
            JPanel fereastra = new JPanel();
            PreparedStatement prepStmt = null;
            OrderDAO orderDAO =new OrderDAO();
            Connection dbConnection = ConnectionFactory.getConnection();
            try {
                prepStmt = dbConnection.prepareStatement(q);
                rs = prepStmt.executeQuery();
                table = new JTable(orderDAO.createHeaderAndPopulate(rs));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JScrollPane jsp = new JScrollPane(table);
            myFrame.getContentPane().add(jsp);

            fereastra.setLayout(new BorderLayout());
            fereastra.add(jsp);


            myFrame.setContentPane(fereastra);
            myFrame.setTitle("orders");

            myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myFrame.setSize(600, 400);
            myFrame.setVisible(true);
        });
    }


    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

}
