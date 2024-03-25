package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;





public class ProductView extends JFrame{

    private JTextField idTextField;
    private JTextField numeTextField;
    private JTextField pretTextField;
    private JButton adaugaProdusButton;
    private JButton editeazaProdusButton;
    private JButton stergeProdusButton;
    private JButton veziProduseButton;
    private JLabel lblNewLabel,idLabel,numeLabel,pretLabel;

    public ProductView() {

        this.setBounds(100, 100, 505, 520);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        lblNewLabel = new JLabel("PRODUCTS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(193, 46, 132, 31);
        this.getContentPane().add(lblNewLabel);

        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabel.setBounds(94, 120, 46, 14);
        this.getContentPane().add(idLabel);

        numeLabel = new JLabel("NUME PRODUS");
        numeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numeLabel.setBounds(94, 145, 120, 14);
        this.getContentPane().add(numeLabel);

        pretLabel = new JLabel("PRET");
        pretLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pretLabel.setBounds(94, 170, 71, 14);
        this.getContentPane().add(pretLabel);

        idTextField = new JTextField();
        idTextField.setBounds(270, 120, 162, 20);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        numeTextField = new JTextField();
        numeTextField.setBounds(270, 145, 162, 20);
        this.getContentPane().add(numeTextField);
        numeTextField.setColumns(10);

        pretTextField = new JTextField();
        pretTextField.setBounds(270, 170, 162, 20);
        this.getContentPane().add( pretTextField);
        pretTextField.setColumns(10);

        adaugaProdusButton = new JButton("ADAUGA PRODUS");
        adaugaProdusButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        adaugaProdusButton.setBounds(140, 257, 185, 23);
        this.getContentPane().add(adaugaProdusButton);

        editeazaProdusButton = new JButton("EDITEAZA PRODUS");
        editeazaProdusButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editeazaProdusButton.setBounds(140, 300, 185, 23);
        this.getContentPane().add(editeazaProdusButton);

        stergeProdusButton = new JButton("STERGE PRODUS");
        stergeProdusButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        stergeProdusButton.setBounds(140, 348, 185, 23);
        this.getContentPane().add(stergeProdusButton);

        veziProduseButton = new JButton("VEZI PRODUSELE");
        veziProduseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        veziProduseButton.setBounds(140, 394, 185, 23);
        this.getContentPane().add( veziProduseButton);

        this.setVisible(true);
    }

    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    public String getNumeTextField() {
        return numeTextField.getText();
    }

    public double getPretTextField() {
        return Double.parseDouble(pretTextField.getText());
    }

    public void addAdaugaProdusListener(ActionListener action){adaugaProdusButton.addActionListener(action);}
    public void addStergeProdusListener(ActionListener action){stergeProdusButton.addActionListener(action);}
    public void addEditeazaProdusListener(ActionListener action){editeazaProdusButton.addActionListener(action);}
    public void addVeziProduseListener(ActionListener action){veziProduseButton.addActionListener(action);}

}
