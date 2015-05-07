/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.gui;
import cop4331.model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
//import static cop4331.model.ShoppingCartSystem.query;

/**
 * A class that gives interface for reviewing or updating the cart.
 * @author Manisha
 */
public class ReviewUpdateCartUI 
{
  
    private JTextField txtDescription;
    private JTextField txtPrice;
    private JTextField txtQty;
    private JTextField txtAmt;

    private JLabel lblDescription;
    private JLabel lblPrice;
    private JLabel lblQty;
    private JLabel lblAmt;

    private JPanel productPanel;
    private JPanel btnPanel;
          private JPanel mainPanel;
    private JPanel middlePanel;

    private JButton btnprevious;
    private JButton btnNext;
    private JButton btnUpdateCart;
    private JButton btnReturn;
    private JButton btnPlaceOrder;
    int indexOfDisplayedProduct;
    /**
     * Constructor for for reviewUpdateCart UI.
     * @param buyer 
     */
    public  ReviewUpdateCartUI(Buyer buyer)
    {
        ShoppingCart shoppingCart = buyer.getShoppingCart();
        ArrayList<LineItem> itemsToBuy = shoppingCart.getItemsToBuy();
        ArrayList<Integer> orderQty = shoppingCart.getQuantity();

        txtDescription = new JTextField("", 15);
        txtPrice = new JTextField("", 15);
        txtQty = new JTextField("", 15);
        txtAmt= new JTextField("", 15);

        lblDescription= new JLabel("Product Description:");
        lblDescription.setPreferredSize(new Dimension(150,40));
        lblPrice= new JLabel("Price:");
        lblPrice.setPreferredSize(new Dimension(150,40));

        lblQty= new JLabel("Quantity:");
        lblQty.setPreferredSize(new Dimension(150,40));
        lblAmt= new JLabel("Amount:");
        lblAmt.setPreferredSize(new Dimension(150,40));

        if(itemsToBuy.size() > 0)
        {
            indexOfDisplayedProduct = 0;
            txtDescription.setText(itemsToBuy.get(indexOfDisplayedProduct).getDescription());
            txtPrice.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice()));
            txtQty.setText(Integer.toString(orderQty.get(indexOfDisplayedProduct)));
            txtAmt.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice() * orderQty.get(indexOfDisplayedProduct)) );
        }
        btnprevious = new JButton("<<              ");
        btnprevious.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if(indexOfDisplayedProduct > 0)
                {
                    indexOfDisplayedProduct--;
                    txtDescription.setText(itemsToBuy.get(indexOfDisplayedProduct).getDescription());
                    txtPrice.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice()));
                    txtQty.setText(Integer.toString(orderQty.get(indexOfDisplayedProduct)));
                    txtAmt.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice() * orderQty.get(indexOfDisplayedProduct)) );
                }
            }
        });
        btnNext = new JButton("               >>");
        btnNext.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if(indexOfDisplayedProduct < itemsToBuy.size() - 1)
                {
                    indexOfDisplayedProduct++;
                    txtDescription.setText(itemsToBuy.get(indexOfDisplayedProduct).getDescription());
                    txtPrice.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice()));
                    txtQty.setText(Integer.toString(orderQty.get(indexOfDisplayedProduct)));
                    txtAmt.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice() * orderQty.get(indexOfDisplayedProduct)) );
                }
            }
        });
        btnUpdateCart = new JButton("UpdateCart");
        btnUpdateCart.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                boolean isStockValidated = false;
                txtAmt.setText(Double.toString(itemsToBuy.get(indexOfDisplayedProduct).getPrice() * Integer.parseInt(txtQty.getText())) );
                if(itemsToBuy.get(indexOfDisplayedProduct).getAvailableQty() > Integer.parseInt(txtQty.getText())){



                buyer.updateQuantityAtIndex(indexOfDisplayedProduct, Integer.parseInt(txtQty.getText()));
                JOptionPane.showMessageDialog(null,"Shopping Cart Updated!"); 
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Not enough available in stock!!reenter the order quantity."); 
               txtQty.setText("");
               txtQty.grabFocus();
                }
            }
        });
        btnReturn = new JButton("Return");
        btnReturn.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {

            }
        });

        btnPlaceOrder = new JButton("ProceedToCheckout");
        btnPlaceOrder.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                CheckOutUI checkOut = new CheckOutUI(buyer);
            }
        });
        productPanel = new JPanel(new GridLayout(6, 2));
        productPanel.add(lblDescription);
        productPanel.add(txtDescription);
        productPanel.add(lblPrice);
        productPanel.add(txtPrice);
        productPanel.add(lblQty);
        productPanel.add(txtQty);
        productPanel.add(lblAmt);
        productPanel.add(txtAmt);
        // middlePanel = new JPanel(new GridLayout(1, 2));
        JLabel space1 = new JLabel("               ");
        JLabel space2 = new JLabel("               ");
        productPanel.add(space1);
        productPanel.add(space2);
        productPanel.add(btnprevious);
        productPanel.add(btnNext);

        btnPanel = new JPanel(new GridLayout(1, 3,5,5));
        btnPanel.add(btnUpdateCart);
        btnPanel.add(btnReturn);
        btnPanel.add(btnPlaceOrder);
        mainPanel= new JPanel(new BorderLayout());
        mainPanel.add(productPanel, BorderLayout.CENTER);
        //mainPanel.add(middlePanel, BorderLayout.CENTER);

        mainPanel.add(btnPanel,BorderLayout.SOUTH );

        mainPanel.setBorder(BorderFactory.createTitledBorder("Review Update Cart..."));
        productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JFrame frame = new JFrame("Review Update Cart");
        frame.setSize(600, 400);
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
         btnReturn.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                frame.dispose();
            }
        });
    }

    //////////private void getTxtFieldData(UsersofSystem p) {
    //////////
    //////////      
    //////////      p.setUserName(username.getText());
    //////////      p.setPassword(password.getPassword().toString());
    //////////      
    //////////
    //////////   }

    /////////////////////////////
    //public static void main(String[] args) {
    //    ReviewUpdateCartUI myUI = new ReviewUpdateCartUI();
    //}
    ///////////////////////
}
    

