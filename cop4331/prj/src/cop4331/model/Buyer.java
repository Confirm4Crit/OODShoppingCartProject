/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.model;
import cop4331.gui.*;

import java.util.Date;
import static cop4331.model.ShoppingCartSystem.query;

/**
* A class that holds buyer information and it has
* methods to access the buyer information.
* @author Manisha
*/
public class Buyer extends UsersofSystem
{
    private String creditCardNumber;
    private String creditCardHolder;
    private String cardType;
    private String validTill;
    private String cvvCode;
    private ShoppingCart shoppingCart;
    /**
     * Empty Constructor
     */
    public Buyer()
    {

    }
    /**
     * constructor to create  Buyer object.
     * @param usernm This is the first parameter to the constructor.
     * @param password This is the second parameter to the constructor.
     */
    public Buyer(String usernm, String password)
    {

        query = "select * from USERS where USERNAME ='" + usernm + "' and PASSWORD = '" + password + "'";
        ShoppingCartSystem.getInstance().retrieveUser(this, query);
        shoppingCart = new ShoppingCart();
    }
    /**
     * 
     */
    public void updateProfile(){

    }
    
    /**
     * This method gets buyer's credit card number
     * @return String The credit card number. 
     */
    public  String getcreditCardNumber(){
        return creditCardNumber;
    }
    /**
     * This method gets buyer's card type.
     * @return String The card type.
     */
    public  String getcardType(){
        return cardType;  
    }
    /**
     * This method returns credit card holder name.
     * @return String the credit card number.
     */
    public  String getcreditCardHolder(){
        return creditCardHolder;  
    }
    /**
     * This method returns valid date.
     * @return String The valid date.
     */
    public  String getvalidTill(){
        return validTill;  
    }
    /**
     * This method gets cvvCode.
     * @return String the cvvCode.
     */
    public  String getcvvCode(){
        return cvvCode; 
    }
    /**
     * This method sets credit card number
     * @param cNo The credit card number.
     */
    public  void setcreditCardNumber(String cNo)
    {
        creditCardNumber = cNo;
    }
    /**
     * This method sets the credit card type.
     * @param cType The credit card Type.
     */
    public  void setcardType(String cType){
        cardType = cType;
    }
    /**
     * This method sets credit card holder name.
     * @param name The card holder name.
     */
    public  void setcreditCardHolder(String name){
        creditCardHolder = name;
    }
    /**
     * This method sets credit card's valid date.
     * @param validDt The valid date.
     */
    public  void setvalidTill(String validDt){
        validTill = validDt;
    }
    /**
     * This method sets cvv code.
     * @param cvv The cvv code.
     */
    public  void setcvvCode(String cvv){
        cvvCode = cvv;
    }
    /**
     * This method helps saving buyer's information into the database.
     * 
     */
    public final void saveBuyerCreditcardInfo(){
        query = "INSERT INTO BUYER (USERID, CCNO, CCHOLDER, CCTYPE, VALIDDATE,CVV) "
        + "VALUES (" + getUserID() + ",'" +   getcreditCardNumber() + "','" +   getcreditCardHolder()
        + "','" +   getcardType()+ "','" +   getvalidTill()+ "','" +   getcvvCode()
        +"')";

        ShoppingCartSystem.getInstance().addUpdateSellerOrBuyer(query);
    }
    /**
     * This method returns the buyer username.
     * @return String the username.
     */
    public  String getUserName(){
        return super.userName;
    }
    /**
     * This method returns the password.
     * @return String the password.
     */
    public  String getPassword(){
        return super.password;  
    }
    /**
     * This method returns the name of the buyer.
     * @return String This returns name of the buyer.
     */
    public  String getName(){
        return super.name;  
    }
    /**
     * This method returns the address of the buyer.
     * @return String This returns address of the buyer.
     */
    public  String getAddress(){
        return super.address;  
    }
    /**
     * This method returns the city of the buyer.
     * @return String This returns city of the buyer.
     */
    public  String getCity(){
        return super.city; 
    }
    /**
     * This method returns the state of the buyer.
     * @return String This returns state of the buyer.
     */
    public  String getState(){
    return super.state;  
    }
    /**
     * This method returns the zip code of the buyer.
     * @return String This returns zip code of the buyer.
     */
    public  String getZip(){
        return super.zipcode; 
    }
    /**
     * This method returns the phone of the buyer.
     * @return String This returns phone of the buyer.
     */
    public  String getPhone(){
        return super.phone; 
    }
    /**
     * This method returns the email of the buyer.
     * @return String This returns email of the buyer.
     */
    public  String getEmail(){
        return super.email; 
    }
    /**
     * This method returns the user Id of the buyer.
     * @return String This returns user ID of the buyer.
     */
    public int getUserID(){
        return super.userID;
    }
    /**
     * This method returns the Type of the buyer.
     * @return String This returns B as the buyer type.
     */
    public  String getUserType(){
        return super.userType;
    }
    /**
     * This method returns the name of the buyer.
     * @return String This returns name of the buyer.
     */
//    public  int getSellerID(){
//        return super.userID;
//    }
    /**
     * This method sets the user name of the buyer.
     * @param uNm The username.
     */
    public  void setUserName(String uNm)
    {
        super.userName = uNm;
    }
    /**
     * This method sets the password of the buyer.
     * @param PWD The password.
     */
    public  void setPassword(String PWD){
        super.password = PWD;
    }
    /**
     * This method sets the name of the buyer.
     * @param name The name of the buyer.
     */
    public  void setName(String name){
        super.name = name;
    }
    /**
     * This method sets the name of the buyer.
     * @param address the address of the buyer
     */
    public  void setAddress(String address){
        super.address = address;
    }
    /**
     * This method sets the name of the buyer.
     * @param city the city of buyer
     */
    public  void setCity(String city){
        super.city = city;
    }
    /**
     * This method sets the state of the buyer.
     * @param state String the state that buyer lives
     */
    public  void setState(String state){
        super.state = state;
    }
    /**
     * This method sets the zip code of the buyer.
     * @param zipCode the zip code.
     */
    public  void setZip(String zipCode){
        super.zipcode = zipCode;
    }
    /**
     * This method sets the phone of the buyer.
     * @param phone the phone number. 
     */
    public  void setPhone(String phone){
        super.phone = phone;
    }
    /**
     * This method sets the email of the buyer.
     * @param email The email of buyer.
     */
    public  void setEmail(String email){
        super.email = email;
    }
    /**
     * This method sets the userID of the buyer.
     * @param UID The user id of buyer. 
     */
    public  void setUserID(int UID){
        super.userID = UID;
    
    }
    /**
     * This method sets the name of the buyer.
     */
    public  void setUserType(){
        super.userType ="B";

    }
    /**
     * This method is used to add items to buyer's shopping cart.
     * @param item The product to be added.
     * @param quantity The quantity of product to be added.
     */
    public void addToShoppingCart(LineItem item, int quantity)
    {
        shoppingCart.addItemToCart(item, quantity);
    }
    /**
     * This method returns the shopping cart of the buyer.
     * @return shoppingCart The ShoppingCart object.
     */

    public ShoppingCart getShoppingCart()
    {
        return shoppingCart;
    }
    /**
     * This method helps buyer update quantity added.
     * @param index The index of the item in the items to buy list in shopping cart.
     * @param quantity The quantity corresponding to index of item in the list in shopping cart.
     */
    public void updateQuantityAtIndex(int index, int quantity)
    {
        shoppingCart.updateQuantityAtIndex( index,  quantity);
    }
}
