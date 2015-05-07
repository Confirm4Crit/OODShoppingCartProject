/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.model;
import cop4331.gui.*;
import java.util.ArrayList;

/**
 * A class that holds Product information.Product is a Line Item.
 * @author Manisha
 */

public class Product implements LineItem
{
    private final int productId;    
   private  String description;
   private double price;
   private int availableQty;
   private double invoicePrice;
   private String category;
    private final int sellerId;
   /**
    * Constructor that constructs a product.
    * @param prodId The product ID
    * @param description The product description.
    * @param price The product price.
    * @param availableQty The stock of this product.
    * @param invoicePrice The invoice price for this product.
    * @param category The category of this product.
    * @param sellerId The Id of the seller who is currently logged into the system and sells this product.
    */
   public Product(int prodId, String description, double price,   int availableQty, double invoicePrice, String category, int sellerId)
   {
      this.productId = prodId;
      this.description = description;
      this.price = price;
      this.availableQty = availableQty;
      this.category = category;
      this.invoicePrice = invoicePrice;
      this.sellerId = sellerId;
   }
   /**
    * Gets the product price.
    * @return the product price.
    */
    @Override
   public double getPrice() { return price; }
   /**
    * Returns the product information.
    * @return the string description of this product.
    */
    @Override
   public String toString() { 
       String desc = description +" "+ Double.toString(price) +" "+Integer.toString(availableQty)+ " "+Double.toString(invoicePrice) + " " + category;
       return desc; 
   }
   /**
    * Gets the product available quantity.
    * @return the product available quantity.
    */
    @Override
   public int getAvailableQty() { return availableQty; }
   
   /**
    * Gets the product Invoice price.
    * @return the product Invoice price.
    */
    @Override
   public double getInvoicePrice() { return invoicePrice; }
   
   /**
    * Gets the product description.
    * @return the product description.
    */
    @Override
   public String getDescription(){
       return description;
   }
   /**
    * Gets the product category.
    * @return the product category.
    */ 
    @Override
   public String getCategory(){
       return category;
   }
   /**
    * Gets the product productId.
    * @return the product productId.
    */
    @Override
   public int getProductId()
   {
       return productId;
   }
   /**
    * Gets the product SellerId who is selling this product.
    * @return the product SellerId who is selling this product.
    */
    @Override
   public int getSellerId()
   {
       return sellerId;
   }
      
   /**
        * This method is used to get queries to update inventory after checkout.
        * @param queries This is the first parameter that has queries in string ArrayList.
        * @param orderedQty This is the second integer parameter that has order quantity.
        */
    @Override
    public void getUpdateInventoryQueries( ArrayList<String> queries, int orderedQty ){
        String query1 = "UPDATE PRODUCT SET QUANTITY = ";
        String query2 = " WHERE PRODUCT_ID = ";
        int finalQty = getAvailableQty() - orderedQty;
        queries.add(query1 + finalQty + query2 + Integer.toString(getProductId()));
    }

   
}
