/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.*;
import cop4331.model.*;
import javax.swing.BorderFactory;
//import static cop4331.model.ShoppingCartSystem.query;

/**
* This UI class gives interface for user(buyer) to enter his credit card details 
* and then checkout.
* @author Manisha
*/
public class CheckOutUI extends JFrame
{
    /**
    *
    * @author Manisha
    */

    private JFrame UPFrame;
    private JPanel UPPanel;
    private JPanel mainPanel;
    private JPanel creditCardPanel;
    private JPanel btnPanel;
    private JLabel lblUName;
    private JLabel lblPWD;
    private JLabel lblFName;
    //private JLabel lblLName;
    private JLabel lblUAddress;
    private JLabel lblUCity;
    private JLabel lblUState;
    private JLabel lblUZip;
    private JLabel lblUPhone;
    private JLabel lblUEmail;
    private JLabel lblUserID;

    private JTextField TxtUName;
    private JTextField TxtPWD;
    private JTextField TxtFName;
    //private JTextField TxtLName;
    private JTextField TxtUAddress;
    private JTextField TxtUCity;
    private JTextField TxtUState;
    private JTextField TxtUZip;
    private JTextField TxtUPhone;
    private JTextField TxtUEmail;
    private JTextField TxtUserID;
    private JLabel lblCCNo;
    private JLabel lblCHolder;
    private JLabel lblCType;
    private JLabel lblValid;
    private JLabel lblCVV;

    private JTextField TxtCCNo;
    private JTextField TxtCHolder;
    private JTextField TxtCType;
    private JTextField TxtValid;
    private JTextField TxtCVV;

    private JButton btnEdit;
    private JButton btnSave;
    private JButton btnContinue;
    /**
     * Constructor for CheckOutUI.
     * @param buyer The object of Buyer who logged into the system.
     */
    public  CheckOutUI(Buyer buyer)//(UsersofSystem newUser, String userType)
    {

        lblFName= new JLabel("Name: ");
        lblUAddress= new JLabel("Address: ");
        lblUCity= new JLabel("City: ");
        lblUState= new JLabel("State: ");
        lblUZip= new JLabel("Zip Code: ");
        lblUPhone= new JLabel("Phone: ");
        lblUEmail= new JLabel("Email: ");

        TxtFName= new JTextField("", 15);
        TxtFName.setText(buyer.getUserName());
        TxtUAddress= new JTextField("", 15);
        TxtUAddress.setText(buyer.getAddress());
        TxtUCity= new JTextField("", 15);
        TxtUCity.setText(buyer.getCity());
        TxtUState= new JTextField("", 15);
        TxtUState.setText(buyer.getState());
        TxtUZip= new JTextField("", 15);
        TxtUZip.setText(buyer.getZip());
        TxtUPhone= new JTextField("", 15);
        TxtUPhone.setText(buyer.getPhone());
        TxtUEmail= new JTextField("", 15);
        TxtUEmail.setText(buyer.getEmail());

        lblCCNo= new JLabel("Credit Card Number: ");
        lblCHolder= new JLabel("Card Holder's Name: ");
        lblCType= new JLabel("Credit Card Type: ");
        lblValid= new JLabel("Valid Till: ");
        lblCVV= new JLabel("CVV Code: ");

        TxtCCNo= new JTextField("", 15);
        TxtCHolder= new JTextField("", 15);
        TxtCType= new JTextField("", 15);
        TxtValid= new JTextField("", 15);
        TxtCVV= new JTextField("", 15);

        btnEdit = new JButton("Edit");
        btnSave= new JButton("Save");
        btnContinue= new JButton("Checkout");

        mainPanel= new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder("Checkout"));
        //    UPPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //    creditCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //    btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        btnPanel= new JPanel(new FlowLayout());
        UPPanel= new JPanel(new GridLayout(8, 2));
        creditCardPanel =  new JPanel(new GridLayout(5, 2));

        UPPanel.add(lblFName);
        UPPanel.add(TxtFName);
        UPPanel.add(lblUAddress);
        UPPanel.add(TxtUAddress);
        UPPanel.add(lblUCity);
        UPPanel.add(TxtUCity);
        UPPanel.add(lblUState);
        UPPanel.add(TxtUState);
        UPPanel.add(lblUZip);
        UPPanel.add(TxtUZip);
        UPPanel.add(lblUPhone);
        UPPanel.add(TxtUPhone);
        UPPanel.add(lblUEmail);
        UPPanel.add(TxtUEmail);
        UPPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        creditCardPanel.add(lblCCNo);
        creditCardPanel.add(TxtCCNo);
        creditCardPanel.add(lblCHolder);
        creditCardPanel.add(TxtCHolder);
        creditCardPanel.add(lblCType);
        creditCardPanel.add(TxtCType);
        creditCardPanel.add(lblValid);
        creditCardPanel.add(TxtValid);
        creditCardPanel.add(lblCVV);
        creditCardPanel.add(TxtCVV);

        creditCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //TxtUserID.setText(Integer.toString(newUser.getUserID()));

        //btnPanel.setPreferredSize(new Dimension(40,40));
        btnPanel.add(btnEdit);
        btnEdit.addActionListener(new
        ActionListener()
        {
        public void actionPerformed(ActionEvent event)
        {
        JOptionPane.showMessageDialog(null,"New RECORD created successfully.");
        }
        });
        btnPanel.add(btnSave);
        btnSave.addActionListener(new
        ActionListener()
        {
        public void actionPerformed(ActionEvent event)
        {
        getTxtFieldData(buyer);
        buyer.saveBuyerCreditcardInfo();
        JOptionPane.showMessageDialog(null,"Record Updated!");

        }
        });
        /*
        btnSaveProfile.addActionListener(new
        ActionListener()
        {
        public void actionPerformed(ActionEvent event)
        {
        textField.setText("Hello, World!");
        }
        });
        */
        //btnPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        mainPanel.add(UPPanel, BorderLayout.NORTH);
        mainPanel.add(creditCardPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);


        JFrame frame = new JFrame("Checkout");
        frame.setSize(700, 400);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        btnPanel.add(btnContinue);
        btnContinue.addActionListener(new
        ActionListener()
        {
        public void actionPerformed(ActionEvent event)
        {
        OrderConfirmationUI orderConfirmationPage =  new OrderConfirmationUI((Buyer)buyer);
        frame.dispose();
        }
        });
    }
    /**
     * This method gets all text data into the Buyer object p.
     * @param p Buyer object.
     */
    private void getTxtFieldData(Buyer p) 
    {
        p.setName(TxtFName.getText());
        p.setAddress(TxtUAddress.getText());
        p.setCity(TxtUCity.getText());
        p.setState(TxtUState.getText());
        p.setZip(TxtUZip.getText());
        p.setPhone(TxtUPhone.getText());
        p.setEmail(TxtUEmail.getText());
        p.setcreditCardNumber(TxtCCNo.getText());
        p.setcreditCardHolder(TxtCHolder.getText());
        p.setcardType(TxtCType.getText());
        p.setvalidTill(TxtValid.getText());
        p.setcvvCode(TxtCVV.getText());
    }
    /**
     * The method to set text with user profile information available.
     * @param p UserdofSystem object 
     */
    private void setTxtFieldData(UsersofSystem p) 
    {
        TxtUserID.setText(String.valueOf(p.getUserID()));
        TxtUName.setText(p.getUserName());
        TxtPWD.setText(p.getPassword());
        TxtFName.setText(p.getName());
        TxtUAddress.setText(p.getAddress());
        TxtUCity.setText(p.getCity());
        TxtUState.setText(p.getState());
        TxtUZip.setText(p.getZip());
        TxtUPhone.setText(p.getPhone());
        TxtUEmail.setText(p.getEmail());
    }

    // private boolean isEmptyFieldData() {
    //      return (TxtUserID.getText().trim().isEmpty()
    //         && TxtUName.getText().trim().isEmpty()
    //         && TxtPWD.getText().trim().isEmpty()
    //         && TxtFName.getText().trim().isEmpty()
    //         && TxtUAddress.getText().trim().isEmpty()
    //         && TxtUCity.getText().trim().isEmpty()
    //         && TxtUState.getText().trim().isEmpty()
    //         && TxtUZip.getText().trim().isEmpty()
    //         && TxtUPhone.getText().trim().isEmpty()
    //         && TxtUEmail.getText().trim().isEmpty());

    // }

}


