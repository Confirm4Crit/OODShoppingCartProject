/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.gui;
import cop4331.model.*;
import cop4331.model.ShoppingCartSystem.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
//import static cop4331.model.ShoppingCartSystem.query;

/**
* A class that creates user interface to see the revenue report.
* @author Manisha
*/
public class RevenueReportUI extends JFrame
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
    /**
     * constructor to create revenue report UI.
     * @param seller The Seller object- logged in seller.
     */
    public RevenueReportUI (Seller seller)
    {

        lblTotalRevenue = new JLabel("Total Revenue: ");
        lblTotalCost = new JLabel("Total Cost: ");
        lblTotalProfit = new JLabel("Total Profit: ");
        ArrayList<Integer> rev = ShoppingCartSystem.getInstance().retrieveSellerRevenueDetails(seller.getUserID());
        // txtTotalRevenue = new JTextField("", 15);
        txtTotalRevenue = new JLabel("");
        //txtTotalRevenue.setEnabled(false);
        txtTotalRevenue.setForeground(Color.DARK_GRAY);
        seller.setRevenue(rev.get(2));
//        txtTotalRevenue.setText(Integer.toString(rev.get(2)));
         txtTotalRevenue.setText(Double.toString(seller.getRevenue()));
        //  txtTotalCost = new JTextField("", 15);
        txtTotalCost =new JLabel("");
        // txtTotalCost.setEnabled(false);
        txtTotalCost.setText(Integer.toString(rev.get(1)));
        txtTotalCost.setForeground(Color.DARK_GRAY);
        // txtTotalProfit= new JTextField("", 15);
        txtTotalProfit= new JLabel("");
        if((rev.get(2)<rev.get(1)))
        txtTotalProfit.setForeground(Color.red);
        else
         txtTotalProfit.setForeground(Color.BLACK);
        // txtTotalProfit.setEnabled(false);
        txtTotalProfit.setText(Integer.toString(rev.get(0)));
        btnBack= new JButton("Back");
        btnBack.setSize(20, 20);
        revPanel= new JPanel(new GridLayout(4, 2));
        btnPanel = new JPanel(new FlowLayout());
        revPanel.add(lblTotalRevenue);
        revPanel.add(txtTotalRevenue);
        revPanel.add(lblTotalCost);
        revPanel.add(txtTotalCost);
        revPanel.add(lblTotalProfit);
        revPanel.add(txtTotalProfit);
        btnPanel.add(btnBack);


        revFrame = new JFrame("Revenue Report....");

        revFrame.setSize(400, 200);
        mainPanel= new JPanel(new BorderLayout());
        mainPanel.add(revPanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        revFrame.add(mainPanel);
        revFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        revFrame.setVisible(true);
        btnBack.addActionListener(new
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                revFrame.dispose();
            }
        });
    }


}
