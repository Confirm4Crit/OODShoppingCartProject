    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package cop4331.model;

    import java.util.ArrayList;
    import cop4331.gui.*;
    /**
    *
    * @author Manisha
    */

    /**
    A decorator for an item that applies a discount.
    */
    public class DiscountedItem implements LineItem
    {
        /**
        Constructs a discounted item.
        @param item the item to be discounted
        @param discount the discount percentage
        */
        public DiscountedItem(LineItem item, double discount) 
        { 
            this.item = item; 
            this.discount = discount;
        }
        /**
         * This method returns discounted item price.
         * @return double the discounted price.
         */
        public double getPrice() 
        {
            return item.getPrice() * (1 - discount / 100); 
        }
        /**
         * This method returns string representation of the discounted item.
         * @return String the string representation of the discounted item.
         */
        public String toString()
        {
            return item.toString() + " (Discount " + discount
            + "%)";
        } 
        /**
         * This method returns the description of the discounted item.
         * @return String The description of the discounted item.
         */

        public String getDescription(){
            return "Discounted (" + getDiscount() + " %): " + item.getDescription().trim();
        }

        /**
         * This method returns the available of the discounted item.
         * @return 
         */

        public int getAvailableQty(){
            return item.getAvailableQty();

        }
        /**
         * This method helps in getting the queries required to update the inventory/stock of the discounted item.
         * This method is used by shopping cart to create update queries.
         * @param queries The ArrayList that holds update query
         * @param orderedQty This holds order quantity.
         */
        public void getUpdateInventoryQueries( ArrayList<String> queries, int orderedQty ){
          item.getUpdateInventoryQueries(queries, orderedQty );    
        }
        /**
         * This method returns the product ID of the discounted item.
         * @return int the product ID.
         */
        public int getProductId()
        {
          return item.getProductId();
        }
        /**
         * This method returns the sellerID of the discounted item.
         * @return int the seller ID.
         */
        public int getSellerId()
        {
          return item.getSellerId();
        }
        /**
         * This method returns the Invoice Price of the discounted item.
         * @return double The invoice price of discounted item.
         */
        public double getInvoicePrice(){
            return item.getInvoicePrice();

        }
        /**
         * This method returns the category of the discounted item.
         * @return String The category of discounted Item
         */
        public String getCategory(){
            return item.getCategory();

        }
        /**
         * This method returns the Discount of the discounted item.
         * @return double The discount.
         */
        public double getDiscount(){
            return discount;

        }

        private LineItem item;
        private double discount;
    }

