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
 * @author Miles Robson
 */
public class DiscountedItemIT
{

    public DiscountedItemIT()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of getPrice method, of class DiscountedItem.
     */
    @Test
    public void testGetPrice()
    {
        System.out.println("getPrice");
        Product ourProduct = new Product(2, "Test", 10, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        double expResult = 5;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetDiscount()
    {
        System.out.println("getDiscount");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        double expResult = 50;
        double result = instance.getDiscount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DiscountedItem.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);

        String expResult = ourProduct.toString() + " (Discount " + instance.getDiscount() + "%)";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class DiscountedItem.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        //"Discounted (" + getDiscount() + " %): " + item.getDescription().trim();
        String expResult = "Discounted (50.0 %): Test";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableQty method, of class DiscountedItem.
     */
    @Test
    public void testGetAvailableQty()
    {
        System.out.println("getAvailableQty");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        int expResult = 3;
        int result = instance.getAvailableQty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUpdateInventoryQueries method, of class DiscountedItem.
     */
    /**
     * Test of getProductId method, of class DiscountedItem.
     */
    @Test
    public void testGetProductId()
    {
        System.out.println("getProductId");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        int expResult = 2;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSellerId method, of class DiscountedItem.
     */
    @Test
    public void testGetSellerId()
    {
        System.out.println("getSellerId");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        int expResult = 5;
        int result = instance.getSellerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoicePrice method, of class DiscountedItem.
     */
    @Test
    public void testGetInvoicePrice()
    {
        System.out.println("getInvoicePrice");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        double expResult = 1;
        double result = instance.getInvoicePrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class DiscountedItem.
     */
    @Test
    public void testGetCategory()
    {
        System.out.println("getCategory");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        DiscountedItem instance = new DiscountedItem(ourProduct, 50);
        String expResult = "Q";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscount method, of class DiscountedItem.
     */
}
