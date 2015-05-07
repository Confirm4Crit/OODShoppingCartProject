/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manisha
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItemToCart method, of class ShoppingCart.
     */
    @Test
    public void testAddItemToCart() {
        System.out.println("addItemToCart");
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        ShoppingCart instance = new ShoppingCart();
        instance.addItemToCart(item, quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        item = new Product( 865576422, "glasses", 15,   133, 10, "K", 2033513407);
        quantity = 2;
        instance.addItemToCart(item, quantity);
    }

    /**
     * Test of updateQuantityAtIndex method, of class ShoppingCart.
     */
    @Test
    public void testUpdateQuantityAtIndex() {
        System.out.println("updateQuantityAtIndex");
        
        int index = 1;
        
        ShoppingCart instance = new ShoppingCart();
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        
        instance.addItemToCart(item, quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        item = new Product( 865576422, "glasses", 15,   133, 10, "K", 2033513407);
        quantity = 1;
        instance.addItemToCart(item, quantity);
         quantity = 2;
        instance.updateQuantityAtIndex(index, quantity);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateUnitPrice method, of class ShoppingCart.
     */
    @Test
    public void testCalculateUnitPrice() {
        System.out.println("calculateUnitPrice");
        ShoppingCart instance = new ShoppingCart();
        ArrayList<Double> myResult = new ArrayList<Double>();
                myResult.add(Double.parseDouble("125.0"));
                myResult.add(Double.parseDouble("15.0"));
        ArrayList<Double> expResult = new ArrayList<Double>();
        for(int i=0; i<myResult.size(); i++)
        {
            expResult.add(i, myResult.get(i));
        }
         LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        
        instance.addItemToCart(item, quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        item = new Product( 865576422, "glasses", 15,   133, 10, "K", 2033513407);
        quantity = 1;
        instance.addItemToCart(item, quantity);
        ArrayList<Double> result = instance.calculateUnitPrice();
     
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTotal method, of class ShoppingCart.
     */
    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        ShoppingCart instance = new ShoppingCart();
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        
        instance.addItemToCart(item, quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        item = new Product( 865576422, "glasses", 15,   133, 10, "K", 2033513407);
        quantity = 1;
        instance.addItemToCart(item, quantity);
        double expResult = 140.0;
        double result = instance.calculateTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     
    /**
     * Test of getItemsToBuy method, of class ShoppingCart.
     */
    @Test
    public void testGetItemsToBuy() {
        System.out.println("getItemsToBuy");
        ShoppingCart instance = new ShoppingCart();
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
         ArrayList<LineItem> expResult = new ArrayList<LineItem>();
        instance.addItemToCart(item, quantity);
       expResult.add(item);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        item = new Product( 865576422, "glasses", 15,   133, 10, "K", 2033513407);
        quantity = 1;
        instance.addItemToCart(item, quantity);
        
        expResult.add(item);
       
        ArrayList<LineItem> result = instance.getItemsToBuy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class ShoppingCart.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ShoppingCart instance = new ShoppingCart();
        ArrayList<Integer> expResult = null;
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        expResult = new ArrayList<Integer>();
        instance.addItemToCart(item, quantity);
       expResult.add(quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        item = new Product( 865576422, "glasses", 15,   133, 10, "K", 2033513407);
        quantity = 1;
        instance.addItemToCart(item, quantity);
        
        expResult.add(quantity);
        ArrayList<Integer> result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getUpdateInventoryQueries method, of class ShoppingCart.
     */
    @Test
    public void testGetUpdateInventoryQueries() {
        System.out.println("getUpdateInventoryQueries");
        ShoppingCart instance = new ShoppingCart();
         ArrayList<String> expResult = null;
         
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        expResult = new ArrayList<String>();
        expResult.add("UPDATE PRODUCT SET QUANTITY = 28 WHERE PRODUCT_ID = 865576421");
        instance.addItemToCart(item, quantity);
        
       
        ArrayList<String> result = instance.getUpdateInventoryQueries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUpdateSellerRevenueQueries method, of class ShoppingCart.
     */
    @Test
    public void testGetUpdateSellerRevenueQueries() {
        System.out.println("getUpdateSellerRevenueQueries");
        ShoppingCart instance = new ShoppingCart();
        ArrayList<String> expResult = null;
        LineItem item = new Product( 865576421, "chair", 25,   33, 20, "L", 2033513407);
        int quantity = 5;
        expResult = new ArrayList<String>();
       
           expResult.add("UPDATE SELLER SET PROFIT = PROFIT + 25.0 WHERE USERID = 2033513407");
         
         expResult.add("UPDATE SELLER SET TOTAL_INV_PRICE = TOTAL_INV_PRICE + 100.0 WHERE USERID = 2033513407");
         
       expResult.add("UPDATE SELLER SET TOTAL_SELL_PRICE = TOTAL_SELL_PRICE + 125.0 WHERE USERID = 2033513407");
         for(int i =0; i <expResult.size(); i++)
        {
            System.out.println(expResult.get(i));
        }
      
        instance.addItemToCart(item, quantity);
        
        
        
      
        ArrayList<String> result = instance.getUpdateSellerRevenueQueries();
        ArrayList<String> result1 = new ArrayList<String>();
        for(int i =0; i <result.size(); i++)
        {
            result1.add(i,result.get(i));
        }
        
        assertEquals(expResult, result1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
