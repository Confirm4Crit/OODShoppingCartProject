/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.model;
import cop4331.gui.*;
import java.util.ArrayList;



/**
 * This is a Interface.
 * @author Manisha
 */
/**
   A line item in an invoice.
*/
public interface LineItem
{
   /**
      Gets the price of this line item.
      @return double the price
   */
   double getPrice();
   /**
      Gets the description of this line item.
      @return String the description
   */   
   String toString();
   /**
    * Gets the description of this line item.
    * @return 
    */
   public String getDescription();
   /**
    * Gets the Available Quantity/ stock of this line item.
    * @return 
    */
   public int getAvailableQty();
   /**
    * Gets the invoice price of this line item.
    * @return 
    */
   public double getInvoicePrice();
   /**
    * Gets the category of this line item.
    * @return 
    */
   public String getCategory();
   /**
    * Gets the queries needed to update inventory of this line item after  checkout.
    * @param queries This hold items to buy list
    * @param orderedQty This has order quantity of the line item.
    */
   public void getUpdateInventoryQueries( ArrayList<String> queries, int orderedQty );
   /**
    * Gets the product ID of Line item.
    * @return integer The product ID.
    */
   public int getProductId();
   /**
    * Gets the seller ID who sells this LineItem.
    * @return integer The seller ID.
    */
   public int getSellerId();
    
}

