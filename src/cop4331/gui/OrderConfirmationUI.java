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
import java.awt.FlowLayout;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
* The class That displays order
* @author Manisha
*/
public class OrderConfirmationUI extends JFrame
{
    private JLabel lblOrderNo;
    private JLabel lblOrderDate;
    private JLabel lblTotal;
    private JTextField txtOrderNo;
    private JTextField txtOrderDate;
    private JButton btnOK;
    private JTable table ;
    private JPanel btnPanel;
    private JPanel mainPanel;
    private JPanel tblPanel;
    private JPanel txtPanel; 
    /**
     * Constructor for OrderConfirmationUI.
     * @param buyer The Buyer object, the buyer who logged into the system.
     */
    public OrderConfirmationUI(Buyer buyer)
    {
        updateInventory(buyer.getShoppingCart());
        updateSellerRevenue(buyer.getShoppingCart());
        tblPanel = new JPanel(new GridLayout(1, 0));
        txtPanel = new JPanel(new GridLayout(1, 4));
        btnPanel = new JPanel(new BorderLayout());
        lblTotal = new JLabel("Total: " + Double.toString(buyer.getShoppingCart().calculateTotal()) + "               ");
        btnPanel.add(lblTotal,BorderLayout.EAST );
        MyTableModel3 tableModel =  new MyTableModel3(buyer);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        tblPanel.add(scrollPane);

        lblOrderNo = new JLabel("Order No:");
        lblOrderDate = new JLabel("Order Date: ");
        txtOrderNo = new JTextField("", 15);
        txtOrderDate = new JTextField("", 15);
        btnOK = new JButton("OK");
        btnOK.setSize(20, 20);

        txtPanel.add(lblOrderNo);
        txtPanel.add(txtOrderNo);
        txtPanel.add(lblOrderDate);
        txtPanel.add(txtOrderDate);
        Random rn = new Random();
        int orderNo = rn.nextInt(Integer.MAX_VALUE) + 1;
        txtOrderNo.setText(Integer.toString(orderNo));
        //txtOrderDate = new JTextField(" ", 15);
        Date date = Calendar.getInstance().getTime();

        SimpleDateFormat format =  new SimpleDateFormat("MM-DD-YYYY");
        String DateToStr;
        DateToStr = format.format(date);
        DateToStr = format.format(date);
        txtOrderDate.setText(DateToStr); 
        btnPanel.add( btnOK, BorderLayout.SOUTH );

        mainPanel= new JPanel(new BorderLayout());
        mainPanel.add(txtPanel, BorderLayout.NORTH);
        mainPanel.add(tblPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel,BorderLayout.SOUTH );
        mainPanel.setBorder(BorderFactory.createTitledBorder("Order Confirmation"));
        txtPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new OrderConfirmationUI.RowListener(this));

        JFrame frame = new JFrame("Order Confirmation Page");
        frame.setSize(500, 400);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        table.enableInputMethods(false);
        //anonymous class
        btnOK.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                frame.dispose();
                java.awt.Window win[] = java.awt.Window.getWindows(); 
                for(int i=0;i<win.length;i++)
                { 
                    win[i].dispose(); 
                } 
                new LogInUI();
            }
        });
    } 
    /**
     * The method to update inventory of shopped items
     * @param shoppingCart The ShoppingCart object.
     */
    private void updateInventory(ShoppingCart shoppingCart)
    {
        ShoppingCartSystem.getInstance().updateInventory(shoppingCart);
    }
    /**
     * The method to update seller revenue.
     * @param shoppingCart The ShoppingCart object
     */
    private void updateSellerRevenue(ShoppingCart shoppingCart)
    {
        ShoppingCartSystem.getInstance().updateSellerRevenue(shoppingCart);
    }

//    private static class object {
//
//        public object() {
//        }
//    }

//    public static void main(String[] args) {
//    //OrderConfirmationUI orderConfirmationPage =  new OrderConfirmationUI((Buyer)buyer);
//    }

    private static class RowListener implements ListSelectionListener {

        public RowListener(OrderConfirmationUI aThis) {
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
/**
 * Inner class that extends AbstractTableModel which provides default implementations for most of the methods in the TableModel interface.
 * @author Manisha
 */
    class MyTableModel3 extends AbstractTableModel 
    {
        ResultSet rs;
        String query;
        private String[] columnNames = { "Product Name","Price", "Quantity","Amount" };
        LinkedList<Object[]> records = new LinkedList<>();
        Buyer currentBuyer;
        /**
         * Constructor for MyTableModel3
         * @param cb The Buyer current object that means a buyer who is currently logged in.
         */
        public MyTableModel3(Buyer cb)
        {
            currentBuyer = cb;
        }
        /**
         * Returns the number of columns in the model. A JTable uses this method to determine how many columns it should create and display by default.
         * @return int the number of columns in the model.
         */
        public int getColumnCount() {
            return columnNames.length;
        }
        /**
         * Returns the number of rows in the model. A JTable uses this method to determine how many rows it should display.
         * @return int The number of rows in the model
         */
        public int getRowCount() {
            return currentBuyer.getShoppingCart().getItemsToBuy().size();
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
        public Object getValueAt(int row, int col) 
        {

            ArrayList<LineItem> ItemsBought = currentBuyer.getShoppingCart().getItemsToBuy();
            ArrayList<Integer> ItemsBoughtQty = currentBuyer.getShoppingCart().getQuantity();
            ArrayList<Double>  amtForProductBought = currentBuyer.getShoppingCart().calculateUnitPrice();
            Object val = null ;

            for(int i =0; i< ItemsBought.size(); i++)
            {
            if( i == row )
                {
                    switch(col)
                    {
                        case 0:
                        val = ItemsBought.get(i).getDescription().trim();
                        break;

                        case 1:
                        val = ItemsBought.get(i).getPrice();
                        break;
                        case 2:
                        val = ItemsBoughtQty.get(i);
                        break;
                        case 3:
                        val = amtForProductBought.get(i);
                        break;
                    }
                }  
            }
            return val;
        }

        /*
        * JTable uses this method to determine the default renderer/ editor for
        * each cell.  This is used by the JTable to set up a default renderer and editor for the column.
        */
        /**
         * Returns the most specific superclass for all the cell values in the column.
         * @param c the index of the column
         * @return the class of the object values in the model.
         */
        @Override
        public Class getColumnClass(int c) 
        {
            return getValueAt(0, c).getClass();
        }

        /*
        * Don't need to implement this method unless our table's editable.
        */
        @Override
        public boolean isCellEditable(int row, int col) 
        {
            // the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < getColumnCount()) {
                return false;
            } else {
                return true;
            }
        }

        /*
        * Don't need to implement this method unless our table's data can
        * change.
        */
        @Override
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
        //        
        //        try {
        //      if (!rs.absolute(row + 1)) {
        //        return;
        //      }
        //      rs.updateObject(col + 1, value);
        //    } catch (SQLException e) {
        //    }
        }

        private void printDebugData() 
        {
//            int numRows = getRowCount();
//            int numCols = getColumnCount();
//
//            for (int i = 0; i < numRows; i++) {
//                System.out.print("    row " + i + ":");
//                for (int j = 0; j < numCols; j++) 
//                {
//                //System.out.print("  " + data[i][j]);
//                    System.out.print("  " + records.get(i));
//                }
//                System.out.println();
//            }
//            System.out.println("--------------------------");
        }
}
