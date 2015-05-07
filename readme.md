UML Documentation can be found here: https://github.com/Confirm4Crit/OODShoppingCartProject/blob/master/docs/Shopping%20Cart%20System_final%20Report.pdf



Opening the program is though project\cop4331\prj\dist\prj.jar

This system stored data on fau oracle server.
In order to compile, you will need to add the ojdbc6.jar to the libraries in your IDE. The jar is downloadable here https://www.dropbox.com/s/dx9rt5vyc3mayhl/ojdbc6.jar?dl=0


Two example accounts are already created:
Buyer with username: allen and password: allen
Seller with username: manisha and password: manisha

User is also able to create new accounts from this aplication.
Buyer can add items to cart, review and edit their cart, and checkout.
Seller can add, remove, and update items, and review a revenue report.
Seller can add a bundle to the inventory.

Incomplete features: The discount feature is currently not properly implemented on seller side. That means system is not able to create discounted item. But for buyer side all functionality is given and coded.

Bundles are currently only able to be added to the inventory, no moddifcation or editing is avaible.

Known bugs: QTY for buyer side cannot be empty, no error handling prompt.
Seller side update and delete does not show update in table immediately but if you return to that page again we can see the updates and deletes. Adding item immediately sets value in the table.



![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/cartUI.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/buyerUI.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/checkOut.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/loginUI.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/newSeller.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/orderInvoice.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/revReport.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/sellerUI.PNG)
![alt tag](https://raw.githubusercontent.com/Confirm4Crit/OODShoppingCartProject/master/pictures/bundleUI.PNG)