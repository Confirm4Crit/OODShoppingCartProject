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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
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
* The class that provides user interface for viewing product catalog
* and adding Line Items to shopping cart.
* @author Manisha
*/
public class ProductCatalogUI extends JFrame {

private boolean DEBUG = false;
private JPanel tblPanel;
private JPanel txtPanel;
private JLabel PID;
private JLabel PDesc;
private JLabel PQty;
//private JLabel PIRate;
private JLabel PSRate;
private JLabel POrderQty;
private JLabel PBID;

private JTextField txtPID;
private JTextField txtPDesc;
private JTextField txtPQty;
//private JTextField txtPIRate;
private JTextField txtPSRate;
private JTextField txtPOrderQty;
private JTextField txtPBID;

private JButton btnAdd;
private JButton btnUpdate;
//private JButton btnDelete;
// private JButton btnSave;
private JButton btnCancel;

private JPanel btnPanel;
private JPanel mainPanel;
private JTable table ;
private JLabel label;
private int currentListItemIndex;
/**
 * Constructor for creating Product Catalog UI
 * @param buyer The buyer object the current buyer who is logged in.
 */
public ProductCatalogUI(UsersofSystem buyer) {
    tblPanel = new JPanel(new GridLayout(1, 0));
    txtPanel = new JPanel(new GridLayout(6, 2));
    btnPanel = new JPanel(new GridLayout(1, 4,5,5));
    table = new JTable(new MyTableModel2((Buyer) buyer));
    table.setPreferredScrollableViewportSize(new Dimension(500, 100));

    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    //Add the scroll pane to this panel.
    tblPanel.add(scrollPane);

    // PID = new JLabel("Product ID: ");
    PDesc = new JLabel("Product Name: ");
    PQty = new JLabel("Quantity Available: ");
    PSRate = new JLabel("Sell Price: ");
    POrderQty = new JLabel("Order Quantity: ");
    txtPDesc = new JTextField("", 15);
    txtPQty = new JTextField("", 15);
    txtPSRate = new JTextField("", 15);
    txtPOrderQty = new JTextField("", 15);
    
    txtPanel.add(PDesc);
    txtPanel.add(txtPDesc);
    txtPanel.add(PQty);
    txtPanel.add(txtPQty);
    txtPanel.add(PSRate);
    txtPanel.add(txtPSRate);
    txtPanel.add(POrderQty);
    txtPanel.add(txtPOrderQty);
    

    txtPanel.setBorder(BorderFactory.createTitledBorder("Product Details"));

    label = new JLabel("");
    btnAdd = new JButton("Add To Cart");
    btnAdd.setSize(20, 20);
    btnUpdate= new JButton("Review/Update Cart");
    btnUpdate.setSize(20, 30);
    //btnDelete= new JButton("Delete Product");
    // btnSave= new JButton("Save Product");
    // btnSave.setSize(20, 20);
    btnCancel= new JButton("Cancel");
    btnCancel.setSize(20, 20);
    
    btnPanel.add(btnAdd);
    btnAdd.addActionListener(new
    ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
            boolean stockeVerified = false;
            table.enableInputMethods(true);
            ArrayList<LineItem> allProducts = ShoppingCartSystem.getInstance().retrieveAllProducts();
            int stock =  Integer.parseInt(txtPQty.getText().trim());        
            int quantity = Integer.parseInt(txtPOrderQty.getText().trim()); 
            if(quantity <= stock)
            {
                ((Buyer)buyer).addToShoppingCart(allProducts.get(currentListItemIndex), quantity);
                JOptionPane.showMessageDialog(null,"Item Added!!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Not enough available in stock!!reenter the order quantity."); 
                txtPOrderQty.setText("");
                txtPOrderQty.grabFocus();
            }
        }
    });
    btnPanel.add( btnUpdate);
    btnUpdate.addActionListener(new
    ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
            ReviewUpdateCartUI reviewUpdateCartUI = new ReviewUpdateCartUI((Buyer)buyer);                
        }
    });

    //btnPanel.add( btnDelete);
    //btnPanel.add(btnSave);

    btnPanel.add( btnCancel);


    mainPanel= new JPanel(new BorderLayout());

    mainPanel.add(tblPanel, BorderLayout.NORTH);
    mainPanel.add(txtPanel, BorderLayout.CENTER);
    mainPanel.add(btnPanel,BorderLayout.SOUTH );

    mainPanel.setBorder(BorderFactory.createTitledBorder("Browse Catalog Page"));
    txtPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    ListSelectionModel selectionModel = table.getSelectionModel();
    selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    selectionModel.addListSelectionListener(new RowListener(this));

    JFrame frame = new JFrame("Browse Catalog ");
    frame.setSize(500, 400);
    frame.add(mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.pack();
    frame.setVisible(true);
    table.enableInputMethods(false);
    btnCancel.addActionListener(new
    ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
            frame.dispose();
        }
    });
}


//private static class object {
//
//    public object() {
//    }
//}

    /**
     * Sets the item index in the list.
     * @param index The index.
     */
    public void setCurrentListItemIndex(int index)
    {
        currentListItemIndex = index;
    }

    class RowListener implements ListSelectionListener
    {
        ProductCatalogUI readRow;
        JTable table;

        public RowListener(ProductCatalogUI rar)
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
            readRow.setCurrentListItemIndex(rowIndex);

            ArrayList<String> data= new ArrayList<String>();
            for(int col = 0; col < columns; col++)
            {
            Object o = table.getValueAt(rowIndex, col);
            data.add(col, o.toString());

            }

            //        readRow.txtPID.setText(data.get(0));
            readRow.txtPDesc.setText(data.get(0));
            readRow.txtPQty.setText(data.get(1));
            // readRow.txtPIRate.setText(data.get(2));
            readRow.txtPSRate.setText(data.get(2));


        }

        private void getTblRowInTxt(String str)
        {

        }

    }

}

/**
 * * Inner class that extends AbstractTableModel which provides default implementations for most of the methods in the TableModel interface.
 * @author Manisha
 */
class MyTableModel2 extends AbstractTableModel 
{
    ResultSet rs;
    String query;
    private String[] columnNames = {  "Product Name","Quantity","Sell Price"};
    LinkedList<Object[]> records = new LinkedList<>();
    ArrayList<LineItem> productsavailable;
    Buyer currentBuyer;
    /**
     * Constructor for MyTableModel3
     * @param cs The Buyer current buyer who is currently logged in
     */
    public MyTableModel2(Buyer cs)
    {
        currentBuyer = cs;
        productsavailable = ShoppingCartSystem.getInstance().retrieveAllProducts();
    }
    /**
     * Returns the number of columns in the model. 
     * A JTable uses this method to determine how many columns it should create and display by default.
     * @return return  the number of columns in the model.
     */

    public int getColumnCount() {
        return columnNames.length;
    }
    /**
     * Returns the number of rows in the model. A JTable uses this method to determine how many rows it should display.
     * @return int The number of rows in the model
     */
    public int getRowCount() {

    //return currentBuyer.getProductCount();
        return productsavailable.size();
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
    Object val = null;
    //***********************Iterator Pattern Check***************//
    int i = 0;
    for(LineItem it:productsavailable)
    {
        if( i == row )
        {
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
                    val = it.getPrice();
                    break;


            }

            System.out.println(it.getDescription());
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
    * Don't need to implement this method unless our table's editable.
    */
    /**
     * Returns true if the cell at rowIndex and columnIndex is editable. Otherwise, setValueAt on the cell will not change the value of that cell.
     * @param row  the row whose value to be queried.
     * @param col the column whose value to be queried.
     * @return 
     */
    public boolean isCellEditable(int row, int col) {
    //Note that the data/cell address is constant,
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
//    int numRows = getRowCount();
//    int numCols = getColumnCount();
//
//    for (int i = 0; i < numRows; i++) {
//    System.out.print("    row " + i + ":");
//    for (int j = 0; j < numCols; j++) {
//    //System.out.print("  " + data[i][j]);
//    System.out.print("  " + records.get(i));
//    }
//    System.out.println();
//    }
//    System.out.println("--------------------------");
    }

}
