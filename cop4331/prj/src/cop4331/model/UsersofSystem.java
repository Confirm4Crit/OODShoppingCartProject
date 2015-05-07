/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.model;
import cop4331.gui.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static cop4331.model.ShoppingCartSystem.query;

/**
 * A model class that holds user profile info.
 * It has template method registerNewUser to register new seller or new buyer.
 * @author Manisha
 */
public abstract class UsersofSystem {
    protected String userName;
    protected String password;
    protected String name;
    protected String address;
    protected String city;
    protected String state;
    protected String zipcode;
    protected String phone;
    protected String email;
    protected int userID;
    protected String userType;
    
    /**
      * This is a template method used to register seller or buyer
      * @param s The user type "S" for seller or "B" for buyer.
      */
     public final void registerNewUser(String s){
            query = "INSERT INTO USERS (USERID, NAME, USERNAME, PASSWORD, ADDRESS,CITY, ZIPCODE, STATE, PHONE, EMAIL, USERTYPE) "
                  + "VALUES (" + getUserID() + ",'" +   getName() + "','" +   getUserName()
                  + "','" +   getPassword() + "','" +   getAddress()+ "','" +   getCity()
                  + "','" +   getZip()+ "','" +   getState()+ "','" +   getPhone() 
                  + "','" +   getEmail()+"','" + s +"')";

                ShoppingCartSystem.getInstance().addUpdateSellerOrBuyer(query);
                
            query = "INSERT INTO SELLER (USERID, PROFIT, TOTAL_INV_PRICE, TOTAL_SELL_PRICE) VALUES (" + getUserID() + ", 0 ,0, 0)";
            ShoppingCartSystem.getInstance().addUpdateSellerOrBuyer(query);

    }
    
    //***********************************************************************************//
//    public final void loginVerifiCation(String uNm, String PWD){
//        
//        if(login(uNm, PWD))
//            System.out.println("Login Verified");
//        else
//            System.out.println("Login Failed!!");
//            
//        
//    }
//   
//     public  boolean login(String uNm, String PWD){
//        if((this.userName).equals(uNm) && (this.password).equals(PWD))
//            return true;
//        else
//            return false;
//            
//    }
     //**********************************************************////////////////////
    /**
     * This method updates uer profile info.
     * @param id the userid.
     */
     public final void updateUserProfile(int id){
////////////////         try {
////////////////          String url="jdbc:derby://localhost:1527/myDB";
////////////////            String username ="manisha";
////////////////            String password = "manisha";
////////////////            Connection con = DriverManager.getConnection(url,username,password);
//           // Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=manisha;pass=manisha");
//            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
//                                    ResultSet.CONCUR_READ_ONLY);
         
          query = "Update USERS set NAME ='" +  getName() + "', set USERNAME ='" + getUserName() +"',set PASSWORD ='" + getPassword()+ "',set ADDRESS ='" + getCity() +"', set CITY ='" 
                  + getCity() +"', set ZIPCODE ='" + getZip() +"',set STATE ='" + getState()+ "',set PHONE ='" +  getPhone() +"', set EMAIL='" + getEmail()+"' where USERID=" + id ;
              ShoppingCartSystem.getInstance().addUpdateSellerOrBuyer(query);   
          //String insertNewUserSQL = "INSERT INTO USERS  VALUES (?, ?, ?, ?, ?, ?, ?)";
//////////////          PreparedStatement pstmt1 = con.prepareStatement(query);
           //rs1 = s.executeQuery(query);
////////////////          int count = pstmt1.executeUpdate();
          
          
         
////////////      } catch (SQLException ex) {
////////////
////////////         ex.printStackTrace();
////////////      }
      
        
    }
     
     
   /**
    * the method that displays string representation of user profile info.
    * @return String the formated user profilr info.
    */
     public final String toString() {
        String str = "User Name:" + getName() + "  Address =" + getAddress() + "  City =" + getCity() + "  City =" + getState()
                    + "  Zip Code =" + getZip() + "  Phone =" + getPhone()+ "  Email =" + getEmail();
        System.out.println(str);
        return str;
    }

     //public abstract void updateUserProfile();
     
      public abstract String getUserName();
      public abstract String getPassword();
      public abstract String getName();
      public abstract String getAddress();
      public abstract String getCity();
      public abstract String getState();
      public abstract String getZip();
      public abstract String getPhone();
      public abstract String getEmail();
      public abstract int getUserID();
      public abstract String getUserType();
      
      
      
     public abstract void setUserName(String uNm);
      public abstract void setPassword(String PWD);
      public abstract void setName(String name);
      public abstract void setAddress(String Address);
      public abstract void setCity(String city);
      public abstract void setState(String state);
      public abstract void setZip(String zip);
      public abstract void setPhone(String phone);
      public abstract void setEmail(String email);
       public abstract void setUserID(int UID);
      public abstract void setUserType();
}
