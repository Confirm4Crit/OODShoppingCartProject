/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cop4331.model;
import cop4331.gui.*;
import java.util.ArrayList;

/**
* 
* @author Manisha
*/
public class Order 
{
    ArrayList<LineItem> itemsBoughtList;
    public  Order(int sc,ArrayList<LineItem> orderItem ){
    sc =0;
    itemsBoughtList = orderItem;
    }

}
