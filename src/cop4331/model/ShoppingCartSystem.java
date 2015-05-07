/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * ShoppingCartSystem is a singleton class to make sure only single object gets created
 * This class provides a way to access its only object
 * which can be accessed directly without need to instantiate the object of the class.
 * @author Manisha
 */

public class ShoppingCartSystem {

    //create an object of ShoppingCartSystem

    public static ShoppingCartSystem instance = new ShoppingCartSystem();
    Connection con;
    ////// private ArrayList<User> allSellers;
    static Object err;
    static ResultSet rs;
    static ResultSet rs1;
    static ResultSet rs2;
    static ResultSet rs3;
    static String query;
    static Statement s;
    static PreparedStatement pstmt;
//    public void connect()
//    {
//
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch (ClassNotFoundException cnfe) {
//            System.err.println("Derby driver not found.");
//        }
//        try {
//            String url="jdbc:derby://localhost:1527/myDB";
//            String username ="manisha";
//            String password = "manisha";
//            Connection con = DriverManager.getConnection(url,username,password);
//           // Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=manisha;pass=manisha");
//             s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
//                                    ResultSet.CONCUR_READ_ONLY);
//            //query = "SELECT * FROM PRODUCT";
//          
//            //rs =  s.executeQuery(query);
//           
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    //make the constructor private so that this class cannot be
    //instantiated
    /**
     * Constructor for shoppingCartSystem that initiates the database.
     */
    private ShoppingCartSystem() {
        con = null;
        initDatabase();
    }

    /**
     * returns the only object/instance available to use for singleton.
     */
     
    public static ShoppingCartSystem getInstance() {
        return instance;
    }
    
    public Seller getSeller(int USERID) {
        return null;
    }

    public Buyer getBuyer(int USERID) {
        return null;
    }

    public void setSeller() {

    }

    public void setBuyer() {

    }
    /**
     * This method connects to database.
     * @throws Exception
     */
    private void initDatabase() {
        if (con == null) {
             try {
                  Class.forName("org.apache.derby.jdbc.ClientDriver");//original
                 //***************was trying*************
                // String applicationDirPath = "C:/Users/Manisha/Documents/NetBeansProjects/COP4331/ShoppingCartProject";
                  //  System.setProperty("derby.system.home", applicationDirPath);
//                 System.setProperty("derby.system.home", 
//    System.getProperty("user.home")+".netbeans-derby");
                 //******************************************
                 
                 
//                                                            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//derby embedded driver//working embedded
                 } 
             catch(Exception e){//catch (ClassNotFoundException cnfe) {
                    System.err.println("Derby driver not found.");
                }
            try {
//                String url = "jdbc:oracle:thin:@131.91.168.91:1521:r11g";
//                String username = "mrobson3";
//                String password = "fau5096";
//                con = DriverManager.getConnection(url, username, password);
                
                
                
                String url = "jdbc:derby://localhost:1527/myDB2";//original
               String username = "manisha";//original
                String password = "manisha";//original
               con = DriverManager.getConnection(url, username, password);//original
               
               
//                con = DriverManager.getConnection("jdbc:derby:C:\\Users\\Manisha\\.netbeans-derby\\myDB2", "manisha", "manisha");  //working embedded
//                                                            con = DriverManager.getConnection("jdbc:derby:.\\myDB2", "manisha", "manisha");   // Use during submission jar is running
                s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
/**
 * This method closes database connection.
 */
    private void closeDatabaseConnection() {
        // close connecion
        con = null;
    }

//    public void updateSellerOrBuyer(String query) {
//
//    }
/**
 * This method adds or update users of the system seller or buyer into the database.
 * It uses query supplied.
 * @param query a sql query to insert or update record in a database.
 * @throws SQLException 
 */
    public void addUpdateSellerOrBuyer(String query) {

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            //rs1 = s.executeQuery(query);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/**
 * The method to retrieve user profile information and set the current user with the information retrieved using the query.
 * @param currentUser The UsersofSystem object, he may be seller or buyer.
 * @param query the sql query that retreives the user profile information for buyer or seller.
 */
    public void retrieveUser(UsersofSystem currentUser, String query) {
        try {
            rs = s.executeQuery(query);
            if (rs.next()) {
                currentUser.setName(rs.getString(2));
                currentUser.setCity(rs.getString(6));
                currentUser.setAddress(rs.getString(5));
                currentUser.setEmail(rs.getString(10));
                currentUser.setPassword(rs.getString(4));
                currentUser.setPhone(rs.getString(9));
                currentUser.setState(rs.getString(8));
                currentUser.setUserID(rs.getInt(1));
                currentUser.setZip(rs.getString(7));
                currentUser.setUserName(rs.getString(3));
//            if(currentUser.userType.equals("S"))
//            {
//                 for(LineItem it:sellerInventory)
////        {
////            System.out.println("works iterator");
////            System.out.println(it.getDescription());
////        }
//                
//            }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
/**
 * The method to retrieve all products or bundle or discounted Line Items.
 * @return the arrayList containing all Line Items.
 * @throws SQLException
 */
    public ArrayList<LineItem> retrieveAllProducts() {
        String query1 = "select * from Product";
        ArrayList<LineItem> availableProducts = new ArrayList<LineItem>();
        try {
            rs1 = s.executeQuery(query1);
            rs1.next();
            int userid = rs1.getInt(1);
            String query2 = "select DISTINCT BUNDLE_ID from PRODUCT";
            rs2 = s.executeQuery(query2);
            ArrayList<Integer> bundleNumbers = new ArrayList<Integer>();
            while (rs2.next()) {
                bundleNumbers.add(rs2.getInt(1));
            }

            for (int bundleNumber : bundleNumbers) {
                if (bundleNumber == 0) {
                    String query3 = "select PRODUCT_ID, PRODUCT_DESC, QUANTITY, "
                            + "INV_PRICE, SELL_PRICE, CATEGORY, DISCOUNT, USERID "
                            + "FROM PRODUCT WHERE BUNDLE_ID = " + bundleNumber;
                    rs3 = s.executeQuery(query3);
                    while (rs3.next()) {
                        if (rs3.getInt(7) == 0) {
                            // create a product
                            Product prod = new Product(Integer.parseInt(rs3.getString(1)), rs3.getString(2), rs3.getDouble(5), rs3.getInt(3),
                                    rs3.getDouble(4), rs3.getString(6), rs3.getInt(8));
                            availableProducts.add(prod);
                        } else {
                            // create discounted product
                            Product prod = new Product(Integer.parseInt(rs3.getString(1)), rs3.getString(2), rs3.getDouble(5), rs3.getInt(3),
                                    rs3.getDouble(4), rs3.getString(6), rs3.getInt(8));
                            DiscountedItem discProd = new DiscountedItem(prod, rs3.getInt(7));
                            availableProducts.add(discProd);
                        }
                    }
                } else // bundle number != 0
                {
                    String query3 = "select PRODUCT_ID, PRODUCT_DESC, QUANTITY, "
                            + "INV_PRICE, SELL_PRICE, CATEGORY, DISCOUNT, USERID "
                            + "FROM PRODUCT WHERE BUNDLE_ID = " + bundleNumber;
                    rs3 = s.executeQuery(query3);
                    Bundle bundle = new Bundle();
                    int discount = 0;
                    while (rs3.next()) {
                        if (rs3.getInt(7) > 0) {
                            discount = rs3.getInt(7);
                        }
                        Product prod = new Product(Integer.parseInt(rs3.getString(1)), rs3.getString(2), rs3.getDouble(5), rs3.getInt(3),
                                rs3.getDouble(4), rs3.getString(6), rs3.getInt(8));
                        bundle.add(prod);
                    }
                    if (discount > 0) {
                        DiscountedItem discBundle = new DiscountedItem(bundle, discount);
                        availableProducts.add(discBundle);
                    } else {
                        availableProducts.add(bundle);
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return availableProducts;

    }
/**
 * The method that retrieves seller revenue details
 * @param userId the Seller id
 * @return arrayList of integer that holds revenue information like profit, total invoice price, total revenue.
 * @throws SQLException
 */
    public ArrayList<Integer> retrieveSellerRevenueDetails(int userId) {
        String query1 = "select PROFIT, TOTAL_INV_PRICE, TOTAL_SELL_PRICE from SELLER where USERID = " + Integer.toString(userId) ;

        ArrayList<Integer> revenueDetails = new ArrayList<Integer>();
        try{
            rs1 = s.executeQuery(query1);
            rs1.next();
            revenueDetails.add(rs1.getInt(1));
            revenueDetails.add(rs1.getInt(2));
            revenueDetails.add(rs1.getInt(3));
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return revenueDetails;
    }
    /**
     * method to retrieve seller inventory from database
     * @param username the seller username.
     * @return ArraList with all LineItems in seller inventory
     * @throws SQLException
     */
    public ArrayList<LineItem> retrieveSellerInventory(String username) {
        String query1 = "select USERID from USERS where USERNAME ='" + username + "'";

        ArrayList<LineItem> itemsInInventory = new ArrayList<LineItem>();
        try {
            rs1 = s.executeQuery(query1);
            rs1.next();
            int userid = rs1.getInt(1);
            String query2 = "select DISTINCT BUNDLE_ID from PRODUCT where USERID = " + userid;
            rs2 = s.executeQuery(query2);
            ArrayList<Integer> bundleNumbers = new ArrayList<Integer>();
            while (rs2.next()) {
                bundleNumbers.add(rs2.getInt(1));
            }

            for (int bundleNumber : bundleNumbers) {
                if (bundleNumber == 0) {
                    String query3 = "select PRODUCT_ID, PRODUCT_DESC, QUANTITY, "
                            + "INV_PRICE, SELL_PRICE, CATEGORY, DISCOUNT, USERID "
                            + "FROM PRODUCT WHERE BUNDLE_ID = " + bundleNumber
                            + "  AND USERID = " + userid;
                    rs3 = s.executeQuery(query3);
                    while (rs3.next()) {
                        if (rs3.getInt(7) == 0) 
                        {
                            // create a product
                            Product prod = new Product(Integer.parseInt(rs3.getString(1)), rs3.getString(2), rs3.getDouble(5), rs3.getInt(3),
                                    rs3.getDouble(4), rs3.getString(6), rs3.getInt(8));
                            itemsInInventory.add(prod);
                        } else {
                            // create discounted product
                            Product prod = new Product(Integer.parseInt(rs3.getString(1)), rs3.getString(2), rs3.getDouble(5), rs3.getInt(3),
                                    rs3.getDouble(4), rs3.getString(6), rs3.getInt(8));
                            DiscountedItem discProd = new DiscountedItem(prod, rs3.getInt(7));
                            itemsInInventory.add(discProd);
                        }
                    }
                } else // bundle number != 0
                {
                    String query3 = "select PRODUCT_ID, PRODUCT_DESC, QUANTITY, "
                            + "INV_PRICE, SELL_PRICE, CATEGORY, DISCOUNT,USERID "
                            + "FROM PRODUCT WHERE BUNDLE_ID = " + bundleNumber
                            + "  AND USERID = " + userid;
                    rs3 = s.executeQuery(query3);
                    Bundle bundle = new Bundle();
                    int discount = 0;
                    while (rs3.next()) {
                        if (rs3.getInt(7) > 0) {
                            discount = rs3.getInt(7);
                        }
                        Product prod = new Product(Integer.parseInt(rs3.getString(1)), rs3.getString(2), rs3.getDouble(5), rs3.getInt(3),
                                rs3.getDouble(4), rs3.getString(6), rs3.getInt(8));
                        bundle.add(prod);
                    }
                    if (discount > 0) {
                        DiscountedItem discBundle = new DiscountedItem(bundle, discount);
                        itemsInInventory.add(discBundle);
                    } else {
                        itemsInInventory.add(bundle);
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return itemsInInventory;
        //return null;
    }
/**
 * The method to update seller inventory/stock of purchased item
 * @param shoppingCart the ShoppingCart object.
 * @throws SQLException.
 */
    public void updateInventory(ShoppingCart shoppingCart) {
        ArrayList<String> queries = shoppingCart.getUpdateInventoryQueries();
        for (String query : queries) {
            try {
                s.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
/**
 * A method to update seller inventory of purchased items.
 * @param shoppingCart the ShoppingCart object.
 * @throws SQLException.
 */
    public void updateSellerRevenue(ShoppingCart shoppingCart) {
        ArrayList<String> queries = shoppingCart.getUpdateSellerRevenueQueries();
        for (String query : queries) {
            try {
                s.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    ////ADDED 

    public void addItem(String query)
    {

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            //rs1 = s.executeQuery(query);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	
	/**
     * Intakes a query to delete an Item from the database
     *
     * @param query
     */
    public void deleteItem(String query)
    {

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            //rs1 = s.executeQuery(query);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Miles 4/19

    /**
     * Intakes a query to update an Item from the database
     *
     * @param query
     */
    public void updateItem(String query)
    {

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            //rs1 = s.executeQuery(query);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Miles 4/19
	
    
    /**
     * The method to check if the user is a valid user of the system or not
     * @param unm the username of user
     * @param pwd the password of the system.
     * @return the type of user "S" for seller and "B" for buyer.
     * @throws SQLException.
     */
    public String loginVerify(String unm, String pwd) {

        int count = 0;
        String usertype = "";
        String usernm = "";
        String passwd = "";
        boolean isFound = false;
        try {
           // PreparedStatement pstmt = con.prepareStatement(query);
            query = "SELECT * from USERS";
            rs = s.executeQuery(query);
            // count = pstmt.executeUpdate();
            while (rs.next()) {
                count = rs.getRow();

                usernm = rs.getString(3).trim();
                passwd = rs.getString(4).trim();
                usertype = rs.getString(11);
                if ((usernm.trim().equals(unm.trim())) && (passwd.trim().equals(pwd.trim()))) {
                    {
                        isFound = true;
                        break;
                    }
                }

            }

//             if(pstmt.getMetaData().equals(usertype)){
//                 usertype = "S";
//             }
//             else{
//                 usertype = "B";
//             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //if(count > 0){
        if (isFound) {
            JOptionPane.showMessageDialog(null,
                    "Login verified");

        } else {
            JOptionPane.showMessageDialog(null,
                    "Invalid Login");
            // System.exit(0);
            usertype = "N";

        }

        return usertype;
    }

}
