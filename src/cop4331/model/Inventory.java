/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.model;
import cop4331.gui.*;
import java.util.*;
import static cop4331.model.ShoppingCartSystem.query;

/**
* A class that holds a sellers list of Line items.
* This class implements Iterable<LineItem> interface. 
* we get iterator() method needed for iterator design pattern to work.
* @author Manisha
*/
public class Inventory implements Iterable<LineItem>
{
    Random rn = new Random();//ADDED
    private ArrayList<LineItem> itemsInInventory;
    /**
     * This is a constructor to create inventory object.
     * @param username The user name.
     */
    public Inventory(String username)
    {
        itemsInInventory = ShoppingCartSystem.getInstance().retrieveSellerInventory( username);
    }
    
//    public void addItem(LineItem item, String userName, int bundleID){
//        
//    
//    }
    //This method ADDED by Miles
    //ADDED
/**this method adds products to the 
 * @author Miles Robson //This method ADDED by Miles 
 * @param item
 * @param username
 * @param bundleID 
 */
    public void addItem(LineItem item, String username, int bundleID)
    {

        itemsInInventory.add(item);
        query = "INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_DESC, QUANTITY, INV_PRICE, SELL_PRICE, CATEGORY, USERID, BUNDLE_ID, DISCOUNT)"
                + "VALUES (" + item.getProductId() + ",'" + item.getDescription().trim() + "'," + item.getAvailableQty() + "," + item.getInvoicePrice() + "," + item.getPrice()
                + ",'" + item.getCategory() + "'," + item.getSellerId() + "," + bundleID + ",0)";

        ShoppingCartSystem.getInstance().addItem(query);

        Bundle ourBundle = new Bundle();
        ourBundle.setBundleID(rn.nextInt(Integer.MAX_VALUE) + 1);
        Product ourProduct = new Product(rn.nextInt(Integer.MAX_VALUE) + 1, "Test", 5, 5, 5, "Q", 1848099529);
        Product ourProduct2 = new Product(rn.nextInt(Integer.MAX_VALUE) + 1, "Test2", 3, 3, 3, "Q", 1848099529);
        ourBundle.add(ourProduct);
        ourBundle.add(ourProduct2);
        /*itemsInInventory.add(ourBundle);
         for (int i = 0; i < ourBundle.sizeOfBundle(); i++) {
         {

         LineItem inputItem = ourBundle.getItem(i);
         //itemsInInventory.add(inputItem);
         query = "INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_DESC, QUANTITY, INV_PRICE, SELL_PRICE, CATEGORY, USERID, BUNDLE_ID, DISCOUNT)"
         + "VALUES (" + inputItem.getProductId() + ",'" + inputItem.getDescription().trim() + "'," + inputItem.getAvailableQty() + "," + inputItem.getInvoicePrice() + "," + inputItem.getPrice()
         + ",'" + inputItem.getCategory() + "',"
         + inputItem.getSellerId() + "," + ourBundle.getBundleID() + ",0)";
         ShoppingCartSystem.getInstance().addItem(query);

         }

         }*/

    }

    //ADDED

    public void addBundle(Bundle inputBundle)
    {
        itemsInInventory.add(inputBundle);
        for (int i = 0; i < inputBundle.sizeOfBundle(); i++) {
            {

                LineItem inputItem = inputBundle.getItem(i);
                //itemsInInventory.add(inputItem);
                query = "INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_DESC, QUANTITY, INV_PRICE, SELL_PRICE, CATEGORY, USERID, BUNDLE_ID, DISCOUNT)"
                        + "VALUES (" + inputItem.getProductId() + ",'" + inputItem.getDescription().trim() + "'," + inputItem.getAvailableQty() + "," + inputItem.getInvoicePrice() + "," + inputItem.getPrice()
                        + ",'" + inputItem.getCategory() + "',"
                        + inputItem.getSellerId() + "," + inputBundle.getBundleID() + ",0)";
                ShoppingCartSystem.getInstance().addItem(query);
            }
        }
    }
	
	 /**
     * updateItem Updates an item in this inventory, and updates the item in the
     * ShoppingCartSystem Pre:Item not updated Post: Item updated
     *
     * @param item
     * @param username
     * @param bundleID
     */
    public void updateItem(LineItem item, String username, int bundleID)
    {

        //itemsInInventory.add(item);
        query = "UPDATE PRODUCT "
                + "SET PRODUCT_DESC='" + item.getDescription().trim()
                + "', QUANTITY =" + item.getAvailableQty()
                + ", INV_PRICE =" + item.getInvoicePrice()
                + ",SELL_PRICE =" + item.getPrice()
                + ",CATEGORY = '" + item.getCategory()
                + "', BUNDLE_ID =" + bundleID
                + "WHERE PRODUCT_ID = " + item.getProductId();

        ShoppingCartSystem.getInstance().updateItem(query);

    }
    //Miles 4/19

    /**
     * deleteItem Updates an item in this inventory, and updates the item in the
     * ShoppingCartSystem Pre:Item not delete size = x Post: Item delete size =
     * x -1
     *
     * @param itemNumber
     */
    public void deleteItem(int itemNumber)
    {
        query = "DELETE FROM PRODUCT "
                + "WHERE PRODUCT_ID =" + itemNumber;

        ShoppingCartSystem.getInstance().deleteItem(query);
    }
    //Miles 4/19
	
	
//    public void updateItem(LineItem item){
//
//    }
//    public void deleteItem(LineItem item){
//    }
//    public double calculateRevenue(){
//        return 0.0;
//    }
//    public void displayRevenueDtls(){
//
//        }
    /**
     * Gets product count in itemsInInventory list
     * @return integer the size 
     */
    public int getProductCount()
    {
        return itemsInInventory.size();
    }
    /**
     * Returns an iterator over elements of type LineItem.
     * @return an iterator over elements of type LineItem.
     */
    public Iterator<LineItem> iterator()
    {
        return new ProductIterator();
    }
    /**
     * inner class that helps implement the iterator design pattern by providing required methods hasNext(), next(), remove().
     */
    private class ProductIterator implements Iterator<LineItem> 
    {
        private int position;
        /**
         * constructor that sets position of iterator.
         */
        public ProductIterator() 
        {
            position = 0;
        }
        /**
         * This method returns true if iteration has more elements
         * @return boolean true if the iteration has more elements false otherwise.
         */
        @Override
        public boolean hasNext() 
        {
            if (position < itemsInInventory.size())
                return true;
            else
                return false;
        }
        /**
         * Returns the next element in the iteration.
         * @return The next element in the iteration.
         */
        @Override
        public LineItem next() 
        {
            LineItem aniObj = itemsInInventory.get(position);
            position++;
            return aniObj;
        }
        /**
         * Removes from the underlying collection the last element returned by this iterator.
         */
        @Override
        public void remove() 
        {
            itemsInInventory.remove(position);
        // throw new UnsupportedOperationException();
        }

    }


}
