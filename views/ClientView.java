package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;



public class ClientView extends JFrame{

    private JTextField idTextField;
    private JTextField numeTextField;
    private JTextField adresaTextField;
    private JButton adaugaClientButton;
    private JButton editeazaClientButton;
    private JButton stergeClientButton;
    private JButton veziClientiiButton;
    private JLabel lblNewLabel,idLabel,numeLabel,adresaLabel;

    public ClientView() {

        this.setBounds(100, 100, 505, 520);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        lblNewLabel = new JLabel("CLIENTS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(193, 46, 132, 31);
        this.getContentPane().add(lblNewLabel);

        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabel.setBounds(94, 120, 46, 14);
        this.getContentPane().add(idLabel);

        numeLabel = new JLabel("NUME");
        numeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numeLabel.setBounds(94, 145, 46, 14);
        this.getContentPane().add(numeLabel);

        adresaLabel = new JLabel("ADRESA");
        adresaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        adresaLabel.setBounds(94, 170, 71, 14);
        this.getContentPane().add(adresaLabel);

        idTextField = new JTextField();
        idTextField.setBounds(270, 120, 162, 20);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        numeTextField = new JTextField();
        numeTextField.setBounds(270, 145, 162, 20);
        this.getContentPane().add(numeTextField);
        numeTextField.setColumns(10);

        adresaTextField = new JTextField();
        adresaTextField.setBounds(270, 170, 162, 20);
        this.getContentPane().add(adresaTextField);
        adresaTextField.setColumns(10);

        adaugaClientButton = new JButton("ADAUGA CLIENT");
        adaugaClientButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        adaugaClientButton.setBounds(140, 257, 185, 23);
        this.getContentPane().add(adaugaClientButton);

        editeazaClientButton = new JButton("EDITEAZA CLIENT");
        editeazaClientButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editeazaClientButton.setBounds(140, 300, 185, 23);
        this.getContentPane().add(editeazaClientButton);

        stergeClientButton = new JButton("STERGE CLIENT");
        stergeClientButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        stergeClientButton.setBounds(140, 348, 185, 23);
        this.getContentPane().add(stergeClientButton);

        veziClientiiButton = new JButton("VEZI CLIENTII");
        veziClientiiButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        veziClientiiButton.setBounds(140, 394, 185, 23);
        this.getContentPane().add(veziClientiiButton);

        this.setVisible(true);
    }

    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    public String getNumeTextField() {
        return numeTextField.getText();
    }

    public String getAdresaTextField() {
        return adresaTextField.getText();
    }

    public void addAdaugaClientListener(ActionListener action){adaugaClientButton.addActionListener(action);}
    public void addStergeClientListener(ActionListener action){stergeClientButton.addActionListener(action);}
    public void addEditeazaClientListener(ActionListener action){editeazaClientButton.addActionListener(action);}
    public void addVeziClientiiListener(ActionListener action){veziClientiiButton.addActionListener(action);}

}
