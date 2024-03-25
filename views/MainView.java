package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class MainView extends JFrame {
    private JLabel titleLabel;
    private  JButton clientOperationsButton,productOperationsButton,productOrdersButton;

    public MainView() {

        this.setBounds(100, 100, 505, 590);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        titleLabel = new JLabel("ORDERS MANAGEMENT");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        titleLabel.setBounds(151, 82, 224, 14);
        this.getContentPane().add(titleLabel);

        clientOperationsButton = new JButton("CLIENT OPERATIONS");
        clientOperationsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        clientOperationsButton.setBounds(133, 178, 201, 46);
        this.getContentPane().add(clientOperationsButton);

        productOperationsButton = new JButton("PRODUCT OPERATIONS");
        productOperationsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        productOperationsButton.setBounds(133, 250, 201, 46);
        this.getContentPane().add(productOperationsButton);

        productOrdersButton = new JButton("PRODUCT ORDERS");
        productOrdersButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        productOrdersButton.setBounds(133, 333, 201, 46);
        this.getContentPane().add(productOrdersButton);

        this.setVisible(true);

    }

    public void addClientOperationListener(ActionListener action){ clientOperationsButton.addActionListener(action);}
    public void addProductOperationListener(ActionListener action){ productOperationsButton.addActionListener(action);}
    public void addProductOrdersListener(ActionListener action){ productOrdersButton.addActionListener(action);}
}