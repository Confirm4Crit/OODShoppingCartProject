
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
 * This is a model class that holds shopping cart information. and gives the required functionality for shopping cart.
 * @author Manisha
 */
public class ShoppingCart
{

    private ArrayList<LineItem> ItemsToBuy;
    int cartID;
    ArrayList<Integer> orderQty;
    Order order;
    private ArrayList<String> updateInventoryQueries;
    /**
     * Constructor for shopping cart that creates shopping cart object.
     */
    public  ShoppingCart()
    {
        ItemsToBuy = new ArrayList<LineItem>();
        cartID = new Random().nextInt(Integer.MAX_VALUE) + 1;
        order = null;
        orderQty = new ArrayList<Integer> ();
        updateInventoryQueries = new ArrayList<String>();

    }
    /**
     * adds the Line item to shopping cart with the given quantity.
     * @param item the Line Item to be added
     * @param quantity the quantity of corresponding Line Item.
     */
    public void addItemToCart(LineItem item, int quantity){
        ItemsToBuy.add(item);
        orderQty.add(quantity);
    }
    /**
     * Updates quantity of the Line Item at specified index in the ItemsToBuy list.
     * @param index The index in the list.
     * @param quantity the quantity of item at specified index.
     * precondition ItemsToBuy.size()greater than 0
     * postcondition ItemsToBuy.get(index)= quantity 
     */
    public void updateQuantityAtIndex(int index, int quantity)
    {
        if(quantity > 0)
        {
            orderQty.set(index, quantity);
        }
        else
        {
            orderQty.remove(index);
            ItemsToBuy.remove(index);
        }
    }
    /**
     * 
     * @param Item 
     */
//    public void deleteItemFromCart(LineItem Item){
//
//    }
//    public void updateCart(){
//
//    }
    /**
     * Calculates price for every LineItem in the shopping cart list itemsToBuy.
     * @return list of calculated Price For Each Item.
     * precondition ItemsToBuy.size()greater than 0
     * postcondition arrayList of calculated Price For Each Item is ready for use.
     */
    public ArrayList<Double> calculateUnitPrice(){
        int j =0;
        ArrayList<Double> calculatedPriceForEachItem = new ArrayList<Double>();
            for(LineItem i:ItemsToBuy)
            {
                calculatedPriceForEachItem.add(j, i.getPrice()* orderQty.get(j));
                j++;
            }
        return calculatedPriceForEachItem;

    }
    /**
     * calculates of total shopping cart price.
     * @return double the total price of all items in shopping cart.
     * precondition ItemsToBuy.size() greater than 0
     */
    public double calculateTotal(){
        double total = 0.0;

        ArrayList<Double> PriceForEachItem =calculateUnitPrice();
        for(int i = 0; i < PriceForEachItem.size(); i++)
        {
            total = total + PriceForEachItem.get(i);

        }

        return total;
    }
    /**
     * creates the order for buyer.
     * @return Order object.
     */
    public Order createOrder()
    {
        order = new Order(cartID, ItemsToBuy);
        return order;
    }

    
    /**
     * Gets the list of items to purchase.
     * @return ArrayList of LineItem the list of items to buy.
     * 
     */
    public ArrayList<LineItem> getItemsToBuy()
    {
        return ItemsToBuy;
    }
    /**
     * Gets the list of quantities of items to purchase.
     * @return ArrayList of LineItem the list of quantities of items to buy.
     * 
     */
    public ArrayList<Integer> getQuantity()
    {
        return orderQty;
    }       
    /**
     * Gets queries needed to update the inventories/stocks of items after items are purchased.
     * @return ArrayList of update queries for adjusting stock/inventories of Line Items bought.
     */
    public ArrayList<String> getUpdateInventoryQueries()
    {
        if( updateInventoryQueries.size() > 0)
        {
            updateInventoryQueries.clear();
        }

        int j = 0;
        for(LineItem item:ItemsToBuy)
        {
            item.getUpdateInventoryQueries(updateInventoryQueries, orderQty.get(j));
            j++;
        }
        return updateInventoryQueries;
    }
    /**
     * Gets queries for updating seller revenue.
     * @return ArrayList of queries to adjust revenue.
     */
    public ArrayList<String> getUpdateSellerRevenueQueries()
    {
        ArrayList<String> updateSellerInventoryQueries = new ArrayList<String>();
        ArrayList<Integer> sellerIds = new ArrayList<Integer>();

        for(LineItem item:ItemsToBuy)
        {
            int sellerId = item.getSellerId();
            boolean found = false;
            for(Integer id:sellerIds)
            {
                if(id == sellerId)
                {
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                sellerIds.add(sellerId);
            }
        }


        for(Integer id:sellerIds)
        {
            double totalSellPrice = 0;
            double totalInvPrice = 0;
            double profit =0;
            int j = 0;
            for(LineItem item:ItemsToBuy)
            {
                if( id == item.getSellerId() )
                {
                    totalSellPrice += (item.getPrice() * orderQty.get(j));
                    totalInvPrice += (item.getInvoicePrice() * orderQty.get(j));
                    profit = totalSellPrice - totalInvPrice;
                }
                j++;
            }

            String query = "UPDATE SELLER SET PROFIT = PROFIT + " + Double.toString(profit)
            + " WHERE USERID = " + id;
            updateSellerInventoryQueries.add(query);
            query = "UPDATE SELLER SET TOTAL_INV_PRICE = TOTAL_INV_PRICE + " + Double.toString(totalInvPrice)
            + " WHERE USERID = " + id;
            updateSellerInventoryQueries.add(query);
            query = "UPDATE SELLER SET TOTAL_SELL_PRICE = TOTAL_SELL_PRICE + " + Double.toString(totalSellPrice)
            + " WHERE USERID = " + id;
            updateSellerInventoryQueries.add(query);
        }

        return updateSellerInventoryQueries;        
    }
    
}