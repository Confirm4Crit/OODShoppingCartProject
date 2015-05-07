/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.gui;
import cop4331.model.*;
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
import javax.swing.BorderFactory;
/**
 * A UI interface class that provides interface for user of the system to enter profile information.
 * @author Manisha
 */
public class UserProfileUI extends JFrame{
    private JFrame UPFrame;
    private JPanel UPPanel;
    private JPanel mainPanel;
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
    
    private JButton btnSaveProfile;
    private JButton btnUpdateProfile;
    private JButton btnContinue;
    
    private boolean isSeller;
    /**
     * Constructor for UserProfileUI
     * @param newUser <? exteds UsersofSystem>
     * @param userType either "B" for buyer or "S for seller
     * 
     */
    public  UserProfileUI(UsersofSystem newUser, String userType)
    {
        //UsersofSystem newUser = new Seller(Integer.getInteger(TxtUserID.getText().trim()).intValue());
         newUser.setUserID(new Random()
            .nextInt(Integer.MAX_VALUE) + 1);
         
         UserDBHandler userDB = new UserDBHandler();
         /*
         char[] pwd = password.getPassword();
                String passwrd = new String(pwd);
          */
       lblUserID = new JLabel("User ID: ");
        
        lblUName = new JLabel("User Name: ");
        lblPWD= new JLabel("Password: ");
        lblFName= new JLabel("Name: ");
        //lblLName= new JLabel("Last Name: ");
        lblUAddress= new JLabel("Address: ");
        lblUCity= new JLabel("City: ");
        lblUState= new JLabel("State: ");
        lblUZip= new JLabel("Zip Code: ");
        lblUPhone= new JLabel("Phone: ");
        lblUEmail= new JLabel("Email: ");
        
        TxtUserID = new JTextField("", 15);
        TxtUserID.setEnabled(false);
        TxtUName = new JTextField("", 15);
        TxtUName= new JTextField("", 15);
        TxtPWD= new JTextField("", 15);
        TxtFName= new JTextField("", 15);
        //TxtLName= new JTextField("", 15);
        TxtUAddress= new JTextField("", 15);
        TxtUCity= new JTextField("", 15);
        TxtUState= new JTextField("", 15);
        TxtUZip= new JTextField("", 15);
        TxtUPhone= new JTextField("", 15);
        TxtUEmail= new JTextField("", 15);
        
        btnSaveProfile = new JButton("Save Profile");
        btnUpdateProfile= new JButton("Update Profile");
        btnContinue= new JButton("Continue");
        
         mainPanel= new JPanel(new BorderLayout());
        btnPanel= new JPanel(new FlowLayout());
        UPPanel= new JPanel(new GridLayout(11, 2));


        UPPanel.add(lblUserID );
         UPPanel.add(TxtUserID);
         UPPanel.add(lblUName);
         UPPanel.add(TxtUName);
        UPPanel.add(lblPWD);
        UPPanel.add(TxtPWD);
        UPPanel.add(lblFName);
         UPPanel.add(TxtFName);
        //UPPanel.add(lblLName);
        //UPPanel.add(TxtLName);
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
        JFrame frame = new JFrame("User Profile");
    UPPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    
         
   TxtUserID.setText(Integer.toString(newUser.getUserID()));
    
    //btnPanel.setPreferredSize(new Dimension(40,40));
    btnPanel.add(btnSaveProfile);
    btnSaveProfile.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               //UserProfileUI userprofile = new  UserProfileUI();
                 getTxtFieldData(newUser);
         
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot create an empty record");
               return;
            }
            newUser.registerNewUser(userType);
            // newUser.create()
           //***********// userDB.create(p);
            JOptionPane.showMessageDialog(null,"New RECORD created successfully.");
//////////////            if (userDB.create(p) != null)
//////////////               JOptionPane.showMessageDialog(null,
//////////////               "New person created successfully.");
               
            }
         });
    btnPanel.add(btnUpdateProfile);
    btnUpdateProfile.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               //UserProfileUI userprofile = new  UserProfileUI();
                 getTxtFieldData(newUser);
         
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot create an empty record");
               return;
            }
            newUser.updateUserProfile(Integer.parseInt(TxtUserID.getText()));
           //***********// userDB.create(p);
            JOptionPane.showMessageDialog(null,"Record Updated!");
//////////////            if (userDB.create(p) != null)
//////////////               JOptionPane.showMessageDialog(null,
//////////////               "New person created successfully.");
               
            }
         });
    btnPanel.add(btnContinue);
    btnContinue.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                if(userType.equals("S"))
                    //SellerProductPage InventoryPage = 
                     //new SellerProductPage((Seller)newUser);
                {
                    JOptionPane.showMessageDialog(null,"Please login again");
                    frame.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please login again");
                    frame.dispose();
                     //new ProductCatalogUI((Buyer)newUser); 
                }
                    
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
    mainPanel.add(UPPanel, BorderLayout.CENTER);
    mainPanel.add(btnPanel, BorderLayout.SOUTH);
    
     mainPanel.setBorder(BorderFactory.createTitledBorder("User Profile"));
    UPPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    
//        UPPanel.add(UPlblPanel);
//        UPPanel.add(UPtxtPanel);
        
        frame.setSize(500, 400);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//frame.pack();
        frame.setVisible(true);
//        p.setUserID(new Random()
//            .nextInt(Integer.MAX_VALUE) + 1);
    }
//    public static void main(String[] args)
//    {
//        UserProfileUI UserProfileUI = new UserProfileUI();
//        
//    }
    /**
     * A method to get text field data into the model class object UsersofSystem
     * @param p object of UsersofSystem
     */
    private void getTxtFieldData(UsersofSystem p) {

      p.setUserID(Integer.parseInt(TxtUserID.getText()));
      p.setUserName(TxtUName.getText());
      p.setPassword(TxtPWD.getText());
      p.setName(TxtFName.getText());
      //p.setEmail(TxtLName.getText());
      p.setAddress(TxtUAddress.getText());
       p.setCity(TxtUCity.getText());
      p.setState(TxtUState.getText());
      p.setZip(TxtUZip.getText());
      p.setPhone(TxtUPhone.getText());
      p.setEmail(TxtUEmail.getText());

   }
    /**
     * a method to sett text field data with object of UsersofSystem
     * @param p object of UsersofSystem
     */
   private void setTxtFieldData(UsersofSystem p) {
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
/**
 * The method to check if textField is empty
 * @return true if any of the text filed is empty false otherwise.
 */
   private boolean isEmptyFieldData() {
      return (TxtUserID.getText().trim().isEmpty()
         && TxtUName.getText().trim().isEmpty()
         && TxtPWD.getText().trim().isEmpty()
         && TxtFName.getText().trim().isEmpty()
         && TxtUAddress.getText().trim().isEmpty()
         && TxtUCity.getText().trim().isEmpty()
         && TxtUState.getText().trim().isEmpty()
         && TxtUZip.getText().trim().isEmpty()
         && TxtUPhone.getText().trim().isEmpty()
         && TxtUEmail.getText().trim().isEmpty());
   }
    
    
    
    public class UserDBHandler {
    ResultSet rs1;
      String query;
     Statement s;
     // private JdbcRowSet rs1 = null;
      public UserDBHandler(){
          //***********************************************************//
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch (ClassNotFoundException cnfe) {
//            System.err.println("Derby driver not found.");
//        }
//        try {
//            String url="jdbc:derby://localhost:1527/myDB2";
//            String username ="manisha";
//            String password = "manisha";
//            Connection con = DriverManager.getConnection(url,username,password);
//           // Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=manisha;pass=manisha");
//             s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
//                                    ResultSet.CONCUR_READ_ONLY);
             //***************************************************************//
            //////////query ="INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_DESC, QUANTITY, INV_PRICE, SELL_PRICE,CATEGORY, SELLERID)VALUES (3, 'Square Dining Table', 20, 1045.99, 1250.00, 'DINING',1)";/////////////////////////////////
            //s.execute("CREATE TABLE test (id integer primary key not null, text varchar(32))");            
            //s.execute("INSERT INTO BUYER VALUES ('" + txtid.getText() + "' , ' " + usertypecombo.getSelectedItem() + ",'"+  nametxt.getText +"')";
            //s.execute("SELECT /* FROM test");
          ////////// s.execute(query);//////////////////////////////////////////////
          ////////// JOptionPane.showMessageDialog(null, "Record Added");///////////////
             //query = "SELECT * FROM USERS";
          
           //rs1 =  s.executeQuery(query);
            
            
//           int cols = rs.getMetaData().getColumnCount();
//while(rs.next()){
//    Object[] arr = new Object[cols];
//    for(int i=0; i<cols; i++){
//      arr[i] = rs.getObject(i+1);
//      
//    }
////    ListSelectionModel selectionModel = table.getSelectionModel();
////        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        //selectionModel.addListSelectionListener(new RowListener(this));
//}
          //******************************************************************//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        //******************************************************************//
   }
    
//   public UsersofSystem create(UsersofSystem p) {
//      try {
//          String url="jdbc:derby://localhost:1527/myDB";
//            String username ="manisha";
//            String password = "manisha";
//            Connection con = DriverManager.getConnection(url,username,password);
////           // Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=manisha;pass=manisha");
////            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
////                                    ResultSet.CONCUR_READ_ONLY);
//
//          p.registerNewUser();
//          query = "INSERT INTO USERS (USERID, NAME, USERNAME, PASSWORD, ADDRESS,CITY, ZIPCODE, STATE, PHONE, EMAIL) "
//                  + "VALUES (" + p.getUserID() + " , ' " +   p.getName() + "' , ' " +   p.getUserName()
//                  + "' , ' " +   p.getPassword()+ "' , ' " +   p.getAddress()+ "' , ' " +   p.getCity()
//                  + "' , ' " +   p.getZip()+ "' , ' " +   p.getState()+ "' , ' " +   p.getPhone()
//                  + "' , ' " +   p.getEmail()+"')";
//          //String insertNewUserSQL = "INSERT INTO USERS  VALUES (?, ?, ?, ?, ?, ?, ?)";
//          PreparedStatement pstmt = con.prepareStatement(query);
//           //rs1 = s.executeQuery(query);
//          pstmt.executeUpdate();
//          
//         
//      } catch (SQLException ex) {
//
//         ex.printStackTrace();
//      }
//      return p;
//   }

   public UsersofSystem update(UsersofSystem p) {
try {
          String url="jdbc:derby://localhost:1527/myDB";
            String username ="manisha";
            String password = "manisha";
            Connection con = DriverManager.getConnection(url,username,password);
//           // Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=manisha;pass=manisha");
//            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
//                                    ResultSet.CONCUR_READ_ONLY);

         /////////////////////////////////////////// p.registerNewUser(userType);
          query = "Update USERS set NAME ='" +  p.getName() + "', set USERNAME ='" + p.getUserName() +"',set PASSWORD ='" + p.getPassword()+ "',set ADDRESS ='" + p.getCity() +"', set CITY ='" 
                  + p.getCity() +"', set ZIPCODE ='," + p.getZip() +"',set STATE ='" + p.getState()+ "',set PHONE ='" +  p.getPhone() +"', set EMAIL='" + p.getEmail()+"'";
                 
          //String insertNewUserSQL = "INSERT INTO USERS  VALUES (?, ?, ?, ?, ?, ?, ?)";
          PreparedStatement pstmt = con.prepareStatement(query);
           //rs1 = s.executeQuery(query);
          pstmt.executeUpdate();
          
         
      } catch (SQLException ex) {

         ex.printStackTrace();
      }
      return p;
   }

   public void delete() {
      try {
         rs1.moveToCurrentRow();
         rs1.deleteRow();
      } catch (SQLException ex) {
//         try {
//            rs1.rollback();
//         } catch (SQLException e) { }
         ex.printStackTrace();
      }

   }

//   public UsersofSystem moveFirst(UsersofSystem p) {
//       //if( isSeller == true)
//      
//       //else
//         // UsersofSystem p = new Buyer();
//      try {
//         rs1.first();
//         p.setUserName(rs1.getString("USERID"));
//         p.setAddress(rs1.getString("ADDRESS"));
//         p.setCity(rs1.getString("CITY"));
//         p.setEmail(rs1.getString("EMAIL"));
//         p.setPassword(rs1.getString("PASSWORD"));
//         p.setName(rs1.getString("NAME"));
//         p.setPhone(rs1.getString("PHONE"));
//         p.setState(rs1.getString("STATE"));
//         p.setUserID(rs1.getInt("USERID"));
//         p.setZip(rs1.getString("ZIPCODE"));
//         
//      } catch (SQLException ex) {
//         ex.printStackTrace();
//      }
//      return p;
//   }
//
//   public UsersofSystem moveLast(UsersofSystem p) {
//     // Person p = new Person();
//      try {
//         rs1.last();
//         p.setUserName(rs1.getString("USERID"));
//         p.setAddress(rs1.getString("ADDRESS"));
//         p.setCity(rs1.getString("CITY"));
//         p.setEmail(rs1.getString("EMAIL"));
//         p.setPassword(rs1.getString("PASSWORD"));
//         p.setName(rs1.getString("NAME"));
//         p.setPhone(rs1.getString("PHONE"));
//         p.setState(rs1.getString("STATE"));
//         p.setUserID(rs1.getInt("USERID"));
//         p.setZip(rs1.getString("ZIPCODE"));
//
//      } catch (SQLException ex) {
//         ex.printStackTrace();
//      }
//      return p;
//   }

//   public Person moveNext() {
//      Person p = new Person();
//      try {
//         if (rs1.next() == false)
//            rs1.previous();
//         p.setPersonId(rs1.getInt("personId"));
//         p.setFirstName(rs1.getString("firstName"));
//         p.setMiddleName(rs1.getString("middleName"));
//         p.setLastName(rs1.getString("lastName"));
//         p.setEmail(rs1.getString("email"));
//         p.setPhone(rs1.getString("phone"));
//
//      } catch (SQLException ex) {
//         ex.printStackTrace();
//      }
//      return p;
//   }
//
//   public Person movePrevious() {
//      Person p = new Person();
//      try {
//         if (rs1.previous() == false)
//            rs1.next();
//         p.setPersonId(rs1.getInt("personId"));
//         p.setFirstName(rs1.getString("firstName"));
//         p.setMiddleName(rs1.getString("middleName"));
//         p.setLastName(rs1.getString("lastName"));
//         p.setEmail(rs1.getString("email"));
//         p.setPhone(rs1.getString("phone"));
//
//      } catch (SQLException ex) {
//         ex.printStackTrace();
//      }
//      return p;
//   }
//
//   public Person getCurrent() {
//      Person p = new Person();
//      try {
//         rs1.moveToCurrentRow();
//         p.setPersonId(rs1.getInt("personId"));
//         p.setFirstName(rs1.getString("firstName"));
//         p.setMiddleName(rs1.getString("middleName"));
//         p.setLastName(rs1.getString("lastName"));
//         p.setEmail(rs1.getString("email"));
//         p.setPhone(rs1.getString("phone"));
//      } catch (SQLException ex) {
//         ex.printStackTrace();
//      }
//      return p;
//   }
    }
}
    
    
    
    
    
    
    
    
    
    

