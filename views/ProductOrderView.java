package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;




public class ProductOrderView extends JFrame {

    private JTextField idClientTextField,idTextField,priceTextField;
    private JTextField idProductTextField,nrBucatiTextField;
    private JButton comandaButton,veziStockButton,veziComenziButton;
    private  JLabel lblNewLabel,idClientLabel,idProductLabel, bucatiLabel;

    public ProductOrderView() {

        this.setBounds(100, 100, 505, 520);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        lblNewLabel = new JLabel("PRODUCT ORDERS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(172, 59, 162, 14);
        this.getContentPane().add(lblNewLabel);

        idClientLabel = new JLabel("ID CLIENT");
        idClientLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idClientLabel.setBounds(82, 141, 89, 14);
        this.getContentPane().add(idClientLabel);

        idProductLabel = new JLabel("ID PRODUCT");
        idProductLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idProductLabel.setBounds(82, 178, 89, 14);
        this.getContentPane().add(idProductLabel);

        bucatiLabel = new JLabel("NR BUCATI");
        bucatiLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bucatiLabel.setBounds(82, 209, 107, 14);
        this.getContentPane().add(bucatiLabel);

        idClientTextField = new JTextField();
        idClientTextField.setBounds(248, 140, 86, 20);
        this.getContentPane().add(idClientTextField);
        idClientTextField.setColumns(10);

        idProductTextField = new JTextField();
        idProductTextField.setBounds(248, 171, 86, 20);
        this.getContentPane().add(idProductTextField);
        idProductTextField.setColumns(10);

        nrBucatiTextField = new JTextField();
        nrBucatiTextField.setBounds(248, 208, 86, 20);
        this.getContentPane().add(nrBucatiTextField);
        nrBucatiTextField.setColumns(10);

        comandaButton = new JButton("COMANDA");
        comandaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comandaButton.setBounds(158, 293, 147, 23);
        this.getContentPane().add(comandaButton);

        veziStockButton = new JButton("VEZI STOC");
        veziStockButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        veziStockButton.setBounds(158, 350, 147, 23);
        this.getContentPane().add(veziStockButton);

        veziComenziButton= new JButton("VEZI COMENZI");
        veziComenziButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        veziComenziButton.setBounds(158, 400, 170, 23);
        this.getContentPane().add(veziComenziButton);

        idTextField = new JTextField();
        idTextField.setBounds(248, 109, 86, 20);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

       /* priceTextField = new JTextField();
        priceTextField.setBounds(248, 239, 86, 20);
        this.getContentPane().add(priceTextField);
        priceTextField.setColumns(10);*/

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabel.setBounds(82, 112, 46, 14);
        this.getContentPane().add(idLabel);

       /* JLabel priceLabel = new JLabel("PRICE");
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        priceLabel.setBounds(82, 242, 46, 14);
        this.getContentPane().add(priceLabel);*/

        this.setVisible(true);
    }

    public int getIdClientTextField() {
        return Integer.parseInt(idClientTextField.getText());
    }

    public int getIdProductTextField() {
        return Integer.parseInt(idProductTextField.getText());
    }

    public int getNrBucatiTextField() {
        return Integer.parseInt(nrBucatiTextField.getText());
    }

    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    //public double getPriceTextField() {
    //    return Double.parseDouble(priceTextField.getText());
    //}

    public void addComandaListener(ActionListener action){comandaButton.addActionListener(action);}
    public void addvezistocListener(ActionListener action){veziStockButton.addActionListener(action);}
    public void addvezicomenziListener(ActionListener action){veziComenziButton.addActionListener(action);}

}
