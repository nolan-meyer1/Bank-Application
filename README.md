# Bank-Application

## Overview
This is is a simple bank application. When you load the application you will be prompted with four options:
1. Acesss Account
2. Open a New Account
3. Close All Accounts
4. Teller Sign in
5. Exit

In order to get started with this application the first thing that you should do is create an account. After you create an account you can acess that account by choosing the first option. There you will type in your PIN that you set when you created the account and you can start running the application! 

EX: 

<img width="207" alt="Screenshot 2024-04-19 at 11 08 51 PM" src="https://github.com/nolan-meyer1/Bank-Application/assets/145584308/91b0b2d4-b372-4c0a-8685-385e233f7ae1">
<img width="300" alt="Screenshot 2024-04-19 at 11 09 25 PM" src="https://github.com/nolan-meyer1/Bank-Application/assets/145584308/cd61d846-26b2-42ae-94e9-9f1e4e5fbb47">
<img width="300" alt="Screenshot 2024-04-19 at 11 09 25 PM" src="https://github.com/nolan-meyer1/Bank-Application/assets/145584308/92e8f5ed-7945-4d33-93ed-50a003b14626">

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
Will start by asking for the Teller ID. If the ID is correct it will print the following menu: 

Please make a selection:
1) Make a deposit
2) Make a withdrawal
3) Remove Customer
4) Exit

Base off what you click will call the Methods of the Teller class. 

# Bank Class





