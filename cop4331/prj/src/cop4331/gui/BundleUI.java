/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop4331.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import cop4331.model.*;
/**
 * A class that gives interface to add bundle
 * @author Miles Robson
 */
public class BundleUI extends JFrame
{

    private JFrame revFrame;

    private JLabel lblTotalRevenue;
    private JLabel lblTotalCost;
    private JLabel lblTotalProfit;

    private JLabel txtTotalRevenue;
    private JLabel txtTotalCost;
    private JLabel txtTotalProfit;

    private JButton btnBack;
    private JPanel revPanel;
    private JPanel mainPanel;
    private JPanel btnPanel;
    Random rn = new Random();
    
    /**
     * constructor for BundleUI
     * @param seller the Seller object seller who is logged in
     */

    public BundleUI(Seller seller)
    {

        Bundle ourBundle = new Bundle();
        ourBundle.setBundleID(rn.nextInt(Integer.MAX_VALUE) + 1);

        nameLabel = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        invoiceLabel = new javax.swing.JLabel();
        sellLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField("", 15);
        qtyTextField = new javax.swing.JTextField("", 15);
        invoiceTextField = new javax.swing.JTextField("", 15);
        sellPriceTextField = new javax.swing.JTextField("", 15);
        cateTextField = new javax.swing.JTextField("", 15);
        disTextField = new javax.swing.JTextField("", 15);
        cancelButton = new javax.swing.JButton();
        saveAdd = new javax.swing.JButton();
        saveCloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setText("Name");

        qtyLabel.setText("QTY");

        invoiceLabel.setText("Invoice Rate");

        sellLabel.setText("Sell Price");

        categoryLabel.setText("Category");

        discountLabel.setText("Discount");

        nameTextField.setText("");

        qtyTextField.setText("");

        invoiceTextField.setText("");

        sellPriceTextField.setText("");

        cateTextField.setText("");

        disTextField.setText("");

        cancelButton.setText("Exit w/o save");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                //  cancelButtonActionPerformed(evt);
                dispose();
            }
        });

        saveAdd.setText("Save and add another");
        saveAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Product ourProduct;
                ourProduct = new Product(rn.nextInt(Integer.MAX_VALUE) + 1, nameTextField.getText(), Double.parseDouble(sellPriceTextField.getText()),
                        Integer.parseInt(qtyTextField.getText()), Double.parseDouble(invoiceTextField.getText()),
                        cateTextField.getText(), seller.getUserID());
                ourBundle.add(ourProduct);
                nameTextField.setText("");

                qtyTextField.setText("");

                invoiceTextField.setText("");

                sellPriceTextField.setText("");

                cateTextField.setText("");

                disTextField.setText("");

            }
        });

        saveCloseButton.setText("Save and close");
        saveCloseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Product ourProduct;
                ourProduct = new Product(rn.nextInt(Integer.MAX_VALUE) + 1, nameTextField.getText(), Double.parseDouble(sellPriceTextField.getText()),
                        Integer.parseInt(qtyTextField.getText()), Double.parseDouble(invoiceTextField.getText()),
                        cateTextField.getText(), seller.getUserID());
                ourBundle.add(ourProduct);
                nameTextField.setText("");

                qtyTextField.setText("");

                invoiceTextField.setText("");

                sellPriceTextField.setText("");

                cateTextField.setText("");

                disTextField.setText("");
                seller.getInventory().addBundle(ourBundle);
                dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(discountLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(disTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(categoryLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sellLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sellPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(invoiceLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(invoiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(qtyLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(nameLabel)
                                                .addGap(85, 85, 85)
                                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(saveAdd)
                                        .addGap(18, 18, 18)
                                        .addComponent(saveCloseButton)))
                        .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qtyLabel)
                                .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(invoiceLabel)
                                .addComponent(invoiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sellLabel)
                                .addComponent(sellPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(categoryLabel)
                                .addComponent(cateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(discountLabel)
                                .addComponent(disTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton)
                                .addComponent(saveAdd)
                                .addComponent(saveCloseButton))
                        .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }

    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cateTextField;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField disTextField;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JLabel invoiceLabel;
    private javax.swing.JTextField invoiceTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JTextField qtyTextField;
    private javax.swing.JButton saveAdd;
    private javax.swing.JButton saveCloseButton;
    private javax.swing.JLabel sellLabel;
    private javax.swing.JTextField sellPriceTextField;
}
