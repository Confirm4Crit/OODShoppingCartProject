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
public class BundleIT
{

    public BundleIT()
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
     * Test of add method, of class Bundle.
     */
    @Test
    public void testAdd()
    {
        System.out.println("add");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        int expValue = 1;
        int result = instance.sizeOfBundle();
        assertEquals(expValue, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Bundle.
     */
    @Test
    public void testGetPrice()
    {
        System.out.println("getPrice");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        double expResult = 40;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bundle.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        String expResult = "Bundle: Test 20.0 3 1.0 Q, Test 20.0 7 1.0 Q";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSellerId method, of class Bundle.
     */
    @Test
    public void testGetSellerId()
    {
        System.out.println("getSellerId");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        int expResult = 5;
        int result = instance.getSellerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Bundle.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        String expResult = "Bundle: Test, Test";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableQty method, of class Bundle.
     */
    @Test
    public void testGetAvailableQty()
    {
        System.out.println("getAvailableQty");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        int expResult = 3;
        int result = instance.getAvailableQty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoicePrice method, of class Bundle.
     */
    @Test
    public void testGetInvoicePrice()
    {
        System.out.println("getInvoicePrice");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        double expResult = 2.0;
        double result = instance.getInvoicePrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class Bundle.
     */
    @Test
    public void testGetCategory()
    {
        System.out.println("getCategory");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        String expResult = "Category: Q, Q";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getBundleID method, of class Bundle.
     */
    @Test
    public void testGetBundleID()
    {
        System.out.println("getBundleID");
        Product ourProduct = new Product(2, "Test", 20, 3, 1, "Q", 5);
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        Bundle instance = new Bundle();
        instance.add(ourProduct);
        instance.add(ourProduct2);
        instance.setBundleID(3);
        int expResult = 3;
        int result = instance.getBundleID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setBundleID method, of class Bundle.
     */
    @Test
    public void testSetBundleID()
    {
        System.out.println("setBundleID");
        int inputBundleID = 0;
        Bundle instance = new Bundle();
        instance.setBundleID(inputBundleID);
        int result = instance.getBundleID();
        assertEquals(inputBundleID, result);
// TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class Bundle.
     */
    @Test
    public void testGetItem()
    {
        System.out.println("getItem");
        int inputItem = 0;
        Bundle instance = new Bundle();
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        instance.add(ourProduct2);
        LineItem expResult = ourProduct2;
        LineItem result = instance.getItem(inputItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sizeOfBundle method, of class Bundle.
     */
    @Test
    public void testSizeOfBundle()
    {
        System.out.println("sizeOfBundle");
        Bundle instance = new Bundle();
        Product ourProduct2 = new Product(2, "Test", 20, 7, 1, "Q", 5);
        instance.add(ourProduct2);
        int expResult = 1;
        int result = instance.sizeOfBundle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
