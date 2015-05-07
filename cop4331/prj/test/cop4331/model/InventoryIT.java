/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.model;

import java.util.Iterator;
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
public class InventoryIT
{

    public InventoryIT()
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
     * Test of addItem method, of class Inventory.
     */
    @Test
    public void testAddItem()
    {
        System.out.println("addItem");
        Product ourProduct = new Product(2, "Test", 2, 3, 1, "Q", 5);
        String username = "";
        int bundleID = 0;
        Inventory instance = new Inventory("Example");
        int expectedVaule = instance.getProductCount() + 1;
        instance.addItem(ourProduct, username, bundleID);
        int result = instance.getProductCount();
        assertEquals(expectedVaule, result);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addBundle method, of class Inventory.
     */
    @Test
    public void testAddBundle()
    {
        System.out.println("addBundle");
        Bundle inputBundle = new Bundle();
        Product ourProduct = new Product(2, "Test", 2, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(3, "Test", 2, 3, 1, "Q", 5);
        inputBundle.add(ourProduct);
        inputBundle.add(ourProduct2);
        Inventory instance = new Inventory("Example");
        int exVal = instance.getProductCount() + 1;
        instance.addBundle(inputBundle);
        int result = instance.getProductCount();
        assertEquals(exVal, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProductCount method, of class Inventory.
     */
    @Test
    public void testGetProductCount()
    {
        System.out.println("getProductCount");
        Inventory instance = new Inventory("Example");
        Product ourProduct = new Product(2, "Test", 2, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(3, "Test", 2, 3, 1, "Q", 5);
        instance.addItem(ourProduct, "Example", 3);
        instance.addItem(ourProduct, "Example", 2);
        int expResult = 2;
        int result = instance.getProductCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
