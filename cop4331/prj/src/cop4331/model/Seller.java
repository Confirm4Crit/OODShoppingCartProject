/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import cop4331.gui.*;
import static cop4331.model.ShoppingCartSystem.query;
import static cop4331.model.ShoppingCartSystem.rs;
import static cop4331.model.ShoppingCartSystem.s;
/**
* A class that holds seller information.
* @author Manisha
*/
public class Seller extends UsersofSystem
{

    Inventory sellerInventory;
    private double revenue;
    /**
     * Constructor with no arguments for seller.
     */
    public Seller()
    {
        revenue = 0.0;
        super.userType = "S";
    }
    /**
     * Constructor that creates seller
     * @param usernm The seller name.
     * @param password The password.
     */
    public Seller(String usernm, String password)
    {
        revenue = 0.0;
        super.userType = "S";
        query = "select * from USERS where USERNAME ='" + usernm + "'and PASSWORD = '" + password + "'";
        ShoppingCartSystem.getInstance().retrieveUser(this, query);
        sellerInventory = new Inventory(usernm);
        //***********************Iterator Pattern Check***************//
        //        for(LineItem it:sellerInventory)
        //        {
        //            
        //            System.out.println("works iterator");
        //            System.out.println(it.getDescription());
        //        }
        //***********************************************************//
    }
    public void updateProfile(){

    }
    /**
     * Returns the number of products in seller inventory.
     * @return the count of product.
     * precondition sellerInventory.size() is greater than 0
     */
    public int getProductCount()
    {
        return sellerInventory.getProductCount();
    }
    /**
     * Gets the seller inventory
     * @return  The inventory object in current seller. It has list of sellers line Item.
     */
    public Inventory getInventory()
    {
        return sellerInventory;
    }
    /**
     * A method to add new Line item to sellers inventory
     * @param item Line item to be added to seller inventory.
     * @param bundleID the bundle id
     * postcondition sellerInventory will have item added. 
     * it is not taking precondition tag
     */
    //************************previous*********************//
//    public void addNewItem(LineItem item){
//        sellerInventory.addItem(item, userName);
//    }
    //*****************************************************//
    //ADDED

    public void addNewItem(LineItem item, int bundleID)
    {

        sellerInventory.addItem(item, userName, bundleID);

        //INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_DESC, QUANTITY, INV_PRICE, SELL_PRICE, CATEGORY, USERID, BUNDLE_ID, DISCOUNT)
        // VALUES(2, 'dsfs' , 2, 3, 4, 's', 2, 0, 0)
    }

    //ADDED BUNDLE

    public void addNewBundle(Bundle inputBundle)
    {
        sellerInventory.addBundle(inputBundle);
    }

    /**
     * Intakes a int itemNumber to remove from inventory. PreCon: Item with
     * matching Item.ID in inventory. PostCon: Item removed from inventory
     *
     * @param itemNumber integer the item number
     */
    public void deleteExistingItem(int itemNumber)

    {
        sellerInventory.deleteItem(itemNumber);
    }
    //Miles 4/19

    /**
     * Intakes a LineItem item, and a bundleID, in order to update item. PreCon:
     * Item with matching Item.ID not updated. PostCon: Item updated
     *
     * @param item LineItem 
     * @param bundleID integer the bundle id
     */
    public void updateItem(LineItem item, int bundleID)
    {
        System.out.println("at seller");
        sellerInventory.updateItem(item, userName, bundleID);
    }
    //Miles 4/19
    public void calculateRevenue(){

    }
    /**
     * Gets the user name of seller
     * @return String the seller username.
     */
    public  String getUserName(){
        return super.userName;
    }
    /**
     * Gets the seller password.
     * @return String the password.
     */
    public  String getPassword(){
        return super.password;  
    }
    /**
     * Gets the seller revenue.
     * @return double the revenue.
     */
    public  double getRevenue(){
        return revenue;  
    }
    /**
     * Gets name of seller
     * @return string the name
     */
    public  String getName(){
        return super.name;  
    }
    /**
     * Gets the address of seller
     * @return String the seller address.
     */
    public  String getAddress(){
        return super.address;  
    }
    /**
     * Gets city of seller
     * @return the city
     */
    public  String getCity(){
        return super.city; 
    }
    /**
     * Gets state of seller
     * @return the state
     */
    public  String getState(){
        return super.state;  
    }
    /**
     * Gets zip code of seller
     * @return the zip code.
     */
    public  String getZip(){
        return super.zipcode; 
    }
    /**
     * Gets phone number of seller.
     * @return the phone number.
     */
    public  String getPhone(){
        return super.phone; 
    }
    /**
     * Gets email of seller.
     * @return the email id.
     */
    public  String getEmail(){
        return super.email; 
    }
    /**
     * Gets the userid of seller.
     * @return the user id.
     */
    public int getUserID(){
        return super.userID;
    }
    /**
     * Gets user type of seller
     * @return String This returns S as the buyer type.
     */
    public  String getUserType(){
        return super.userType;
    } 
    /**
     * sets user name of the seller
     * @param uNm User name of seller is set with uNm.
     */
    public  void setUserName(String uNm)
    {
        super.userName = uNm;
    }
    /**
     * sets password of the seller
     * @param PWD password of seller is set with PWD.
     */
    public  void setPassword(String PWD){
        super.password = PWD;
    }
    /**
     * sets name of the seller
     * @param name the name of seller is set with name.
     */
    public  void setName(String name){
        super.name = name;
    }
    /**
     * sets address of the seller
     * @param address the address of seller is set with address
     */
    public  void setAddress(String address){
        super.address = address;
    }
    /**
     * sets city of the seller
     * @param city the city of seller is set with city.
     */
    public  void setCity(String city){
        super.city = city;
    }
    /**
     * sets state of the seller
     * @param state The state of seller is set with state.
     */
    public  void setState(String state){
        super.state = state;
    }
    /**
     * sets zip code of the seller
     * @param zipCode the zip code of seller is set with zip code.
     */
    public  void setZip(String zipCode){
        super.zipcode = zipCode;
    }
    /**
     * sets phone of the seller
     * @param phone the phone of seller is set with phone.
     */
    public  void setPhone(String phone){
        super.phone = phone;
    }
    /**
     * sets email of the seller
     * @param email the email of seller is set with email.
     */
    public  void setEmail(String email){
        super.email = email;
    }
    /**
     * sets userID of the seller
     * @param UID the user id of seller is set with user id.
     */
    public  void setUserID(int UID){
        super.userID = UID;
    }
    /**
     * sets user type of the seller as Seller
     */
    public  void setUserType(){
        super.userType ="Seller";

    }
    /**
     * sets name of the seller
     * @param r double the revenue
     */
    public  void setRevenue(double r){
        this.revenue = r;
    }
}
