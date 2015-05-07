    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package cop4331.model;


    /**
    *
    * @author Manisha
    */
    import java.util.*;
    import cop4331.gui.*;
    /**
        A bundle of line items that is again a line item.
    * 
    */
    public class Bundle implements LineItem
    {
        /**
        Constructs a bundle with no items.
        */
        public Bundle() { items = new ArrayList<LineItem>(); }

        /**
        Adds an item to the bundle.
        @param item the item to add
        */
        public void add(LineItem item) { items.add(item); }

        /**
        * returns price of the LineItem
        * @return double the price
        */

        public double getPrice()
        {
            double price = 0;

            for (LineItem item : items)
             price += item.getPrice();
            return price;
        }
        /**
        * gets the description of all items in bundle
        * @return string this item's description
        */
        public String toString()
        {
            String description = "Bundle: ";
            for (int i = 0; i < items.size(); i++)
            {
                if (i > 0) description += ", ";
                    description += items.get(i).toString();

        }
        return description;
        }
        /**
        * This method is used to get the product ID
        * @return integer the product id
        */
        public int getProductId()
        {
            return -1;
        }
        /**
        * This method returns the seller ID who sells this item
        * @return seller ID an integer value
        */
        public int getSellerId()
        {
            return items.get(0).getSellerId();
        }

        
        /**
        * This method is used to get description of bundle as a product
        * @return string the description of all items in bundle
        * precondition item.size greater than 0
        */
        public String getDescription()
        {
            String description = "Bundle: ";
            for (int i = 0; i < items.size(); i++)
            {
                if (i > 0) description += ", ";
                description += items.get(i).getDescription().trim();
            }
            return description;
        }
        /**
        * This method is used to get queries to update inventory after checkout.
        * @param queries This is the first parameter that has queries in string ArrayList.
        * @param orderedQty This is the second integer parameter that has order quantity.
        */
        public void getUpdateInventoryQueries( ArrayList<String> queries, int orderedQty )
        {

            for (int i = 0; i < items.size(); i++)
            {
              items.get(i).getUpdateInventoryQueries(queries, orderedQty );    
            }
        }
        /**
        * The method to get available stock of items in a bundle.
        * @return integer This returns available Quantity /Stock
        */
        public int getAvailableQty()
        {
            int minAvailable = Integer.MAX_VALUE;
                for (int i = 0; i < items.size(); i++)
                {
                  if(minAvailable > items.get(i).getAvailableQty())
                      minAvailable = items.get(i).getAvailableQty();

                }
            return minAvailable;
        }
        /**
        * This method returns the invoice price of a bundle.
        * @return double the invoice price of a bundle.
        */
        public double getInvoicePrice(){
            double invPrice = 0;
            for (int i = 0; i < items.size(); i++)
            {

                invPrice  = invPrice + items.get(i).getInvoicePrice();

            }
            return invPrice;
        }
        /**
        * This method returns the category of the bundle.
        * @return string that represents category.
        */
        public String getCategory()
        {
            String Category = "Category: ";
            for (int i = 0; i < items.size(); i++)
            {
                if (i > 0) Category += ", ";
                Category += items.get(i).getCategory();
            }
            return Category;
        }
        //ADDED
        /**
         * The method to get BundleID
         * @return int the BundleID
         */
        public int getBundleID()
        {
            return bundleID;
        }
//ADDED
/**
 * A method to set the bundle ID.
 * @param inputBundleID int the bundle Id of a Bundle.
 */
    public void setBundleID(int inputBundleID)
    {
        bundleID = inputBundleID;
    }
//ADDED
/**
 * Gets the LineItem at given position
 * @param inputItem the index / position.
 * @return LineItem at given index
 * precondition items.size() is greater than 0
 */
    //@precondition items.size() is greater than 0
    public LineItem getItem(int inputItem)
    {
        return items.get(inputItem);
    }
//ADDED
/**
 * Gets no of items in a bundle
 * @return int the count of items in a bundle
 * 
 */
    public int sizeOfBundle()
    {
        return items.size();
    }
//ADDED
     private int bundleID;
        private ArrayList<LineItem> items;//list of items in a bundle.
    }


