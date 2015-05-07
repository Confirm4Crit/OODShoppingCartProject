/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.gui;
import cop4331.model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
* This class provides user interface for seller to view his products for sell, add Line items, update Line Items.  
* @author Manisha
*/
public class SellerProductPage extends JFrame 
{

    private boolean DEBUG = false;
    private JPanel tblPanel;
    private JPanel txtPanel;
    //  private JLabel PID;
    private JLabel PDesc;
    private JLabel PQty;
    private JLabel PIRate;
    private JLabel PSRate;
    private JLabel PCategory;
    private JLabel PSID;
    
    //ADDED
    private JLabel PBID;
    private JLabel Pdiscount;

    //   private JTextField txtPID;
    private JTextField txtPDesc;
    private JTextField txtPQty;
    private JTextField txtPIRate;
    private JTextField txtPSRate;
    private JTextField txtPCategory;
    private JTextField txtPSID;
    
    //ADDED
    private JTextField txtPBID;
    private JTextField txtPdiscount;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnShowProfit;
    private JButton btnSave;
    private JButton btnCancel;

    //ADDED
     private JButton btnBundle;
     private JButton btnDelete;
     
    private JPanel btnPanel;
    private JPanel mainPanel;
    private JTable table ;
    private JLabel label;
     Random rn = new Random();//ADDED
    /**
     * Constructor that provides sellers product page.
     * @param seller The seller object who is logged into the system
     */
    public SellerProductPage(Seller seller) 
    {
        tblPanel = new JPanel(new GridLayout(1, 0));
        txtPanel = new JPanel(new GridLayout(8, 2));//changed from 7,2 to 8,2 after ADDED
        btnPanel = new JPanel(new GridLayout(1, 5, 3, 3));////changed from 1,4,3,3 to 1,5,3,3 after ADDED
        //super(new GridLayout(1, 0));

        MyTableModel tableModel =  new MyTableModel(seller);

        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        tblPanel.add(scrollPane);

        //    PID = new JLabel("Product ID: ");
        PDesc = new JLabel("Product Name: ");
        PQty = new JLabel("Quantity Available: ");
        PIRate = new JLabel("Invoice Rate: ");
        PSRate = new JLabel("Sell Price: ");
        PCategory = new JLabel("Category: ");
        PSID = new JLabel("Seller ID: ");
        
        //ADDED
        PBID = new JLabel("Bundle ID(0 by default):");
        Pdiscount = new JLabel("Discount: ");
        

        //    txtPID = new JTextField(" ", 15);
        txtPDesc = new JTextField("", 15);
        txtPQty = new JTextField("", 15);
        txtPIRate = new JTextField("", 15);
        txtPSRate = new JTextField("", 15);
        txtPCategory = new JTextField("", 15);
        txtPSID = new JTextField("", 15);
        txtPSID.setText(Integer.toString(seller.getUserID()));
        
        //ADDED
        txtPBID = new JTextField("0", 15);
        txtPdiscount = new JTextField("0", 15);

        //   txtPanel.add(PID);
        //   txtPanel.add(txtPID);
        txtPanel.add(PDesc);
        txtPanel.add(txtPDesc);
        txtPanel.add(PQty);
        txtPanel.add(txtPQty);
        txtPanel.add(PIRate);
        txtPanel.add(txtPIRate);
        txtPanel.add(PSRate);
        txtPanel.add(txtPSRate);
        txtPanel.add(PCategory);
        txtPanel.add(txtPCategory);
        txtPanel.add(PSID);
        txtPanel.add(txtPSID);
        
        //ADDED
        txtPanel.add(PBID);
        txtPanel.add(txtPBID);
        txtPanel.add(Pdiscount);
        txtPanel.add(txtPdiscount);
        
        label = new JLabel("");
        btnAdd = new JButton("Add Product");
        btnUpdate= new JButton("Update Product");
        btnShowProfit= new JButton("Show Profit Report");
        btnSave= new JButton("Save Product");
        btnCancel= new JButton("Cancel");
        //ADDED
        btnBundle = new JButton("Bundle");
        btnDelete = new JButton("Delete");
        
        btnPanel.add(btnAdd);
        btnPanel.add( btnUpdate);
        btnPanel.add( btnShowProfit);
        //ADDED
         btnPanel.add(btnBundle);
        btnPanel.add(btnDelete);//4/19
        
        
        
        btnPanel.add( btnCancel);
        mainPanel= new JPanel(new BorderLayout());

        mainPanel.add(tblPanel, BorderLayout.NORTH);
        mainPanel.add(txtPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel,BorderLayout.SOUTH );

        mainPanel.setBorder(BorderFactory.createTitledBorder("Product Page"));
        txtPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new RowListener(this));

        JFrame frame = new JFrame("Product Page");
        frame.setSize(500, 400);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
        
        //ADDED
        btnBundle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                BundleUI bundleUI = new BundleUI(seller);
                bundleUI.setVisible(true);
            }
        });
        btnAdd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                //TODO FIX USER ID PARAMTER

                int bundleID = 0;

                Product ourProduct;
                // ourProduct = new Product(5, txtPDesc.getText(),
                //    Double.parseDouble(txtPSRate.getText()), Integer.getInteger(txtPQty.getText()), Double.parseDouble(txtPIRate.getText()), txtPCategory.getText(), 2);

                //if bundle.text != 0 and not null
                //if its a bundle, lineitme bundle
                ourProduct = new Product(rn.nextInt(Integer.MAX_VALUE) + 1, txtPDesc.getText(), Double.parseDouble(txtPSRate.getText()),
                        Integer.parseInt(txtPQty.getText().trim()), Double.parseDouble(txtPIRate.getText().trim()),
                        txtPCategory.getText().trim(), seller.getUserID());

                if (txtPBID.getText() != null && !txtPBID.getText().isEmpty()) {
                    bundleID = Integer.parseInt(txtPBID.getText().trim());

                }

                seller.addNewItem(ourProduct, bundleID);

                JOptionPane.showMessageDialog(null,
                        "Prodcut saved!");
                tableModel.fireTableDataChanged();

                //TODO FIX USERID PARMATER
            }
        });
        
        //4/19
         btnDelete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if (tableModel.selectedProductID != 0) {
                    int productID = tableModel.selectedProductID;
                    seller.deleteExistingItem(productID);
                    //tableModel.fireTableDataChanged();
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if (tableModel.selectedProductID != 0) {
                    int bundleID = 0;
                    System.out.println(tableModel.selectedProductID);
                    Product ourProduct;
                    if (txtPBID.getText() != null && !txtPBID.getText().isEmpty()) {
                        bundleID = Integer.parseInt(txtPBID.getText());

                    }
                    ourProduct = new Product(tableModel.selectedProductID, txtPDesc.getText(), Double.parseDouble(txtPSRate.getText()),
                            Integer.parseInt(txtPQty.getText()), Double.parseDouble(txtPIRate.getText()),
                            txtPCategory.getText(), seller.getUserID());
                    seller.updateItem(ourProduct, bundleID);

                    JOptionPane.showMessageDialog(null,
                            "Prodcut update made");
                  //  tableModel.fireTableDataChanged();
                }

            }
        });

        
        //////////////////////////////
        
        
        
        
        
        
        
        btnCancel.addActionListener(new
        ActionListener()
        {
        public void actionPerformed(ActionEvent event)
        {
        frame.dispose();
        }
        });
        btnShowProfit.addActionListener(new
        ActionListener()
        {
        public void actionPerformed(ActionEvent event)
        {
        RevenueReportUI revRepo = new RevenueReportUI(seller);
        }
        });
    }




    ////////////////////////////////////////
    ///////////////////////////////////////
    private static class object {

    public object() {
    }
    }


    class RowListener implements ListSelectionListener
    {
        SellerProductPage readRow;
        JTable table;

        public RowListener(SellerProductPage rar)
        {
            readRow = rar;
            table = readRow.table;
        }

        public void valueChanged(ListSelectionEvent e)
        {
            if(!e.getValueIsAdjusting())
            {
                ListSelectionModel model = table.getSelectionModel();
                int lead = model.getLeadSelectionIndex();
                displayRowValues(lead);
            }
        }

        private void displayRowValues(int rowIndex)
        {
            int columns = table.getColumnCount();
            //String s = "";
            // String[] str = null;
            ArrayList<String> data= new ArrayList<String>();
            for(int col = 0; col < columns; col++)
            {
                Object o = table.getValueAt(rowIndex, col);
                data.add(col, o.toString());

            }

            //        readRow.txtPID.setText(data.get(0));
            readRow.txtPDesc.setText(data.get(0).trim());
            readRow.txtPQty.setText(data.get(1).trim());
            readRow.txtPIRate.setText(data.get(2).trim());
            readRow.txtPSRate.setText(data.get(3).trim());
            readRow.txtPCategory.setText(data.get(4).trim());
            readRow.txtPSID.setText(data.get(5).trim());
        }

        private void getTblRowInTxt(String str)
        {

        }

    }

}
/**
 * Inner class that extends AbstractTableModel which provides default implementations for most of the methods in the TableModel interface.
 * @author Manisha
 */


class MyTableModel extends AbstractTableModel 
{
    ResultSet rs;
    String query;
    private String[] columnNames = { "Product Name","Quantity","Invoice Price","Sell Price" ,"Category","Seller ID"};
    LinkedList<Object[]> records = new LinkedList<>();
    Seller currentSeller;
    //ADDED 4/19
    int selectedProductID;
    
    
    /**
         * Constructor for MyTableModel
         * @param cs The Seller current object that means a seller who is currently logged in.
         */

    public MyTableModel(Seller cs)
    {
        currentSeller = cs;
    }

 /**
  * 
  * Returns the number of columns in the model. A JTable uses this method to determine how many columns it should create and display by default.
  * @return int the number of columns in the model.
  */

    public int getColumnCount() {
        return columnNames.length;
    }
    /**
     *  Returns the number of rows in the model. A JTable uses this method to determine how many rows it should display.
     * @return int The number of rows in the model
     */

    public int getRowCount() {
        return currentSeller.getProductCount();
    }
    /** 
     * Returns the name of the column at columnIndex. 
     * @param col The columnIndex.
     * @return string the name of the column
     */

    public String getColumnName(int col) {
        return columnNames[col];
    }
    /**
     * Returns the value for the cell at columnIndex and rowIndex.
     * @param row the row whose value is to be queried.
     * @param col the column whose value is to be queried.
     * @return the value Object at the specified cell
     */


    public Object getValueAt(int row, int col) {

        Inventory sellerInventory = currentSeller.getInventory();
        Object val = null;
        //***********************Iterator Pattern Check***************//
        int i = 0;
        for(LineItem it:sellerInventory)
        {
            if( i == row )
            {
		selectedProductID = it.getProductId();
                System.out.println("works iterator");
                switch (col)
                {
                    case 0:
                    val = it.getDescription();
                    break;
                    case 1:
                    val = it.getAvailableQty();
                    break;
                    case 2:
                    val = it.getInvoicePrice();
                    break;
                    case 3:
                    val = it.getPrice();
                    break;
                    case 4:
                    val = it.getCategory();
                    break;
                    case 5:
                    val = currentSeller.getUserID();
                    break;
                        /////////Miles4/19
                    //case 6:
                    //val = currentSeller.getProductId();
                    //break;    
                        
                }

                // System.out.println(it.getDescription());
            }
            i++;
        }
        //***********************************************************//
        return val;
    }

    /*
    * JTable uses this method to determine the default renderer/ editor for
    * each cell. If we didn't implement this method, then the last column
    * would contain text ("true"/"false"), rather than a check box.
    */
    /**
     * Returns the most specific superclass for all the cell values in the column.
     * @param c the index of the column
     * @return the class of the object values in the model.
     */

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
    * Don't need to implement this method unless your table's editable.
    */
    public boolean isCellEditable(int row, int col) {
    //the data/cell address is constant,
    //no matter where the cell appears onscreen.
        if (col < getColumnCount()) {
            return false;
        } 
        else {
            return true;
        }
    }

    /*
    * Don't need to implement this method unless your table's data can
    * change.
    */
    public void setValueAt(Object value, int row, int col) {
    //      if (DEBUG) {
    //        ShoppingCartSystem.out.println("Setting value at " + row + "," + col
    //            + " to " + value + " (an instance of "
    //            + value.getClass() + ")");
    //      }
    //
    //      data[row][col] = value;
    //      fireTableCellUpdated(row, col);
    //
    //      if (DEBUG) {
    //        ShoppingCartSystem.out.println("New value of data:");
    //        printDebugData();
    //      }

    //        try {
    //      if (!rs.absolute(row + 1)) {
    //        return;
    //      }
    //      rs.updateObject(col + 1, value);
    //    } catch (SQLException e) {
    //    }
    }

    private void printDebugData() {
    //      int numRows = getRowCount();
    //      int numCols = getColumnCount();
    //
    //      for (int i = 0; i < numRows; i++) {
    //        System.out.print("    row " + i + ":");
    //        for (int j = 0; j < numCols; j++) {
    //          //System.out.print("  " + data[i][j]);
    //            System.out.print("  " + records.get(i));
    //        }
    //        System.out.println();
    //      }
    //      System.out.println("--------------------------");
    }

}
