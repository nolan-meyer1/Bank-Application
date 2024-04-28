<h1 align="center"> Bank-Application </h1>

## Overview

| Number | Item | Description |
|:----: |-------| ----------|
|C1| [Account Class](https://github.com/nolan-meyer1/Bank-Application/blob/43cfa1b3689eccde26133cd8386755a6f32a3b61/Project4/src/Account.java)|This is what makes the customer's have accounts|
|C2| [Bank Class](https://github.com/nolan-meyer1/Bank-Application/blob/43cfa1b3689eccde26133cd8386755a6f32a3b61/Project4/src/Bank.java)|Contains all the customers|
|C3| [Customer Class](https://github.com/nolan-meyer1/Bank-Application/blob/43cfa1b3689eccde26133cd8386755a6f32a3b61/Project4/src/Customer.java)|Contains details about the customer|
|C4| [Teller Class](https://github.com/nolan-meyer1/Bank-Application/blob/43cfa1b3689eccde26133cd8386755a6f32a3b61/Project4/src/Teller.java)|Subclass of bank|
|C5| [Menu Class](https://github.com/nolan-meyer1/Bank-Application/blob/43cfa1b3689eccde26133cd8386755a6f32a3b61/Project4/src/Menu.java)|Controlls the menu|
|C6| [Main Class](https://github.com/nolan-meyer1/Bank-Application/blob/43cfa1b3689eccde26133cd8386755a6f32a3b61/Project4/src/Main.java)|Starts the menu|

This is is a simple bank application. When you load the application you will be prompted with four options:
1. Acesss Account
2. Open a New Account
3. Close All Accounts
4. Teller Sign in
5. Exit

This application has a little bit of a heiarchy that goes like this:
Main -> Menu -> Bank -> Teller -> Customer -> Account

In order to get started with this application the first thing that you should do is create an account. After you create an account you can acess that account by choosing the first option. There you will type in your PIN that you set when you created the account and you can start running the application! 

EX: 

<img width="207" alt="Screenshot 2024-04-19 at 11 08 51 PM" src="https://github.com/nolan-meyer1/Bank-Application/assets/145584308/91b0b2d4-b372-4c0a-8685-385e233f7ae1">
<img width="300" alt="Screenshot 2024-04-19 at 11 09 25 PM" src="https://github.com/nolan-meyer1/Bank-Application/assets/145584308/cd61d846-26b2-42ae-94e9-9f1e4e5fbb47">
<img width="360" alt="Screenshot 2024-04-23 at 5 55 07 PM" src="https://github.com/nolan-meyer1/Bank-Application/assets/145584308/93ac2d22-89e3-4b8d-bc86-3e42dfce190c">


# Menu Class
The menu class is what controls most of this application. It has three fields that are all private. It has an instance of the Scanner class so we can get input, an instance of the Bank class that will store all the customers, and an instance of the Teller class that will be discussed later. It also has multiple methods.

## Methods

### displayMenu
This is what display the menu. When it is called it will only print the first menu. It will print the following: 

********* MENU *********

Please make a selection:
1) Access Account
2) Open a New Account
3) Close All Accounts
4) Teller Sign in
5) Exit

### runMenu
This is what acutally runs the menu. It looks for userInput. Then based off that user input it will call different methods to whatever the user wants to do. For example:

Option 1: runs acessAccount
Option 2: openAccount
Option 3: closeAllAccounts
Option 4: tellerMenu
Option 5: Will exit the loop and print "Thank you for using BSU Banking App! Exiting..."

If none of these options are selected it will print not a valid option! If a string is entered instead of a number it will set the userInput variable to 5 which will automatically close out of the program. 

### acessAccount
Asks the user for their PIN. If the PIN is correct it will print out all of the active accounts. You will then be prompted to select an account. If you select a valid account the printAccountMenu method will then run. 

### printAccountMenu
Takes in the instance of the account you chose, and the instance of the customer. Will print the following: 

Please make a selection:
1) Make a deposit
2) Make a withdrawl
3) See account balance
4) Close account
5) Exit

Once this is printed it will look for user input and then call the proper methods to update the account's value. 

### openAccount
This method is what will allow you open an account. It will at first ask you if you are a new customer or not. If you say that you are a new customer it will call the createCustomer method that will create an instance of the customer class and go through the process of adding the needed values and then return it. If you are not a new customer it will ask you for your PIN. After that it will ask you for an initial deposit amount and just like that you have created your first account! 

### createNewCustomer
Helper method of open account. Creates an instance of the customer class and will ask you for first name, last name, and PIN. It will then assign those values to the proper attributes of the customer class, add it to the bank customer list and then return that instance of the customer back. 

### closeAllAccounts
Will asks for a PIN number. If the PIN number is found it will remove that customer from the bank customer list essentially closing all of their accounts. If the PIN is not found it will print that the PIN is not found and then exit that method. 

### tellerMenu
Will start by asking for the Teller PIN. There is only one teller that has an ID of 445 which you will need to enter to sign in. If the ID is correct it will print the following menu: 

Please make a selection:
1) Make a deposit
2) Make a withdrawal
3) Remove Customer
4) Exit

Base off what you click will call the Methods of the Teller class. 

# Bank Class
The bank class is a very small class that only has a few methods/attributes but is crucial to the functunality of this program. The bank class only has one field. This is a static field called customerList that contains an ArrayList of Customer objects. It is static because it's going to need to be used in it's subclass (Teller).

## Methods

### addCustomer
Takes in a customer object as a parameter. It will then call the ArrayList's add method and add that object to the customerList ArrayList. 

### removeCustomer
Takes in a customer obejct as a parameter.  It will then call the ArrayList's remove method and remove that object to the customerList ArrayList. 

### getCustomer
Takes in a PIN number as a parameter. It will then loop through the customerList and look at each customer's PIN number. If the PIN number's match it will return that customer. If no customer is found with the PIN number it will return null.

### printAllCustomer
This method will loop through ever customer in the customerList and will print the customer's toString method that is overridden to print out that customer's first/last name, and PIN number. 

### loadCustomers
This method loads from the customers.xml file. It will look for every element of the tag customer and then create an instance of the Customer class and pass it the sub elements like firstName, lastName, and PIN. Then it will look for every account element attatched to that customer and create an instance of the Account class and look at it's sub elements and pass it to the account's constructor such as account number, and balance. Lastly, it will set the account static variable to the element numberOfAccounts. 

# Customer Class
The customer class is the class that contains all the data about the customer. It's attributes are firstName, lastName, PIN, and a HashMap containing all the customer's accounts. The key is the account number and the value is an instance of the account class. 

## Methods

### addAccount
Takes in an instance of the account class and grabs the account's account number using it's getAccountNumber method. It will then put the account to the customer's account HashMap. 

### removeAccount
Takes in an instance of the account class. Calls the HashMap remove method and grabs the account's account number using the account's getAccountNumber method. 

### getAccountByNum
Takes in an accountNumber as a parameter. Checks if the account HashMap contains the key. If it does it will get that account and return it. If not it will return null. 

### toString (Overridden)
Return's a string. It will return a printout of all the customer's attributes.

Ex: Customer's Name: Nolan Meyer, PIN: 678

# Account 
This class contains all the information about an account. It has three attributes. A balance, accountNumber, and a static attribute callled numberOfAccounts that is set defualt to be 1000 but is incrimented every time an instance of an account is made and that is how the accountNumber is generated. 

## Methods 

### deposit
Takes in a deposit as a parameter. It will add the deposit to the balance and then print out the amount deposited followed by the updated balance. 

### withdraw
Takes in an amount as a parameter. Checks if that amount is greater than the balance. If it is it will print "Insufficient Funds". If it is not it will subtract the amount from the balance and print the amount withdrawn followed by the updated balance. 

### toString (Overridden)
This returns a string with the accounts attributes. 

EX: 
Account Number: 1001
Balance: $1000.00

# Teller Class
The Teller class is a subclass of the bank class. It can do a few things that Teller can do such as deposit, withdraw, and close a customer's accounts. It has a couple attributes. The attributes are a PIN number, and an instance of the Scanner class. 

## Methods

### deposit
Asks the user for an account number. Then it will loop through every customer and check if their account HashMap contains that key. If it does it will store that account into a variable, and store the customer into a variable. If no account is found it will print that no account is found. If no account is found it will return. If an account is found it will ask for the PIN number and check if it is the correct PIN number. If the PIN number is correct you will be able to deposit and add to the account balance. If it is not you will not be able to deposit. 

### withdrawal
Withdrawal functions the exact same way as deposit does. Except instead of adding to the account balance it will subtract from account balance. 

### removeCustomer
The first thing that this method will do is ask your for PIN number. It will loop through every customer in the customerList (static variable from parent class bank) and check each of that customer's PIN. If it finds a customer with that PIN it will store it into a variable. Once the loop is done executing if a customer isn't found it will print "Customer not found!" and return. If it is found it will remove the customer from the customerList (static variable from parent class bank) and print that the customer has been removed. 

# Unit Testing
There is also a subdirectory that contains unit tests for the following class's:
* Customer
* Account
* Bank
* Teller

There isn't a test for every method apart of these class's but all of the crucial methods have unit tests. This was accomplished using the JUnit 5 framework. There is also a MockTestTeller class that was generated in order to make it easier to test the teller's methods because a lot of those require user input. 
