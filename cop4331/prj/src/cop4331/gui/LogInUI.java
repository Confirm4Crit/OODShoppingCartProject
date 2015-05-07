/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package cop4331.gui;
import cop4331.model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
 //import static cop4331.model.ShoppingCartSystem.;
/**
* A UserInterface Class for Login Functionality  
* @author Manisha
*/
public class LogInUI 
{
    private JTextField username;
    private JPasswordField password;
    private JLabel usernamelabel;
    private JLabel passwordlabel;
    private JPanel loginUNPanel;
    private JPanel btnPanel;
    private JPanel mainPanel;
    private JButton btnLogin;
    private JButton btnNewSeller;
    private JButton btnNewBuyer;
    private JButton btnCancel;
    /**
     * Constructor that creates login User Interface
     * using JtextFields, JLabel and JButtons.
     */
    public LogInUI()
    {
        username = new JTextField("", 15);
        username.setSize(5, 2);
        password = new JPasswordField("",15);
        usernamelabel= new JLabel("Username:");
        usernamelabel.setPreferredSize(new Dimension(150,40));
        passwordlabel= new JLabel("Password:");
        passwordlabel.setPreferredSize(new Dimension(150,40));
        loginUNPanel = new JPanel(new GridLayout(2, 2));
        btnPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        mainPanel= new JPanel(new BorderLayout());
        username.setBounds(15, 15, 155, 55);
        username.setPreferredSize(new Dimension(155,25));
        password.setPreferredSize(new Dimension(155,25));

        loginUNPanel.add(usernamelabel);
        loginUNPanel.add(username);
        loginUNPanel.add(passwordlabel);
        loginUNPanel.add(password);


        btnLogin = new JButton("Login");
        
        //anonymous class
        btnLogin.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {

                char[] pwd = password.getPassword();
                String passwrd = new String(pwd);
                String uname = username.getText();

               // query = "SELECT * from USERS";
                String usertype = ShoppingCartSystem.getInstance().loginVerify(uname, passwrd);
                if(usertype.equals("N"))
                {
                    username.setText("");
                    password.setText("");
                }
                else
                if(usertype.equals("S"))
                {
                    Seller sellerUser = new Seller(uname, passwrd);
                    SellerProductPage sellersproductpage = new  SellerProductPage(sellerUser);
                }
                else
                if(usertype.equals("B"))
                {
                    Buyer buyerUser = new Buyer(uname, passwrd);
                    ProductCatalogUI browseCatalog = new  ProductCatalogUI(buyerUser);
                } 

            }
        });

        btnNewSeller = new JButton("New Seller");
        btnNewSeller.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                UsersofSystem sellerUser = new Seller();
                String s ="S";
                UserProfileUI userprofile = new  UserProfileUI(sellerUser, s);
            }
        });
        btnNewBuyer = new JButton("New Buyer");
        btnNewBuyer.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                UsersofSystem buyerUser = new Buyer();
                String s ="B";
                UserProfileUI userprofile = new  UserProfileUI(buyerUser, s);
            }
        });

        btnCancel = new JButton("Cancel");
        btnPanel.add(btnLogin);
        btnPanel.add(btnNewSeller);
        btnPanel.add(btnNewBuyer);
        btnPanel.add(btnCancel);
        mainPanel.add(loginUNPanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel,BorderLayout.SOUTH );

        mainPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        loginUNPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JFrame frame = new JFrame("Shopping Cart Application");
        frame.setSize(450, 200);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnCancel.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                frame.dispose();
            }
        });
    }
    /**
     * This method gets data from textfield into the UsersofSystem object.
     * @param p This is a UserOfSystem object.
     */
    private void getTxtFieldData(UsersofSystem p) 
    {
        p.setUserName(username.getText());
        p.setPassword(password.getPassword().toString());
    }
   /**
   * This is the main method which makes use of LogInUI() constructor.
   * @param args Unused.
   * 
   */
    public static void main(String[] args) 
    {
        LogInUI myUI = new LogInUI();
    }

}


