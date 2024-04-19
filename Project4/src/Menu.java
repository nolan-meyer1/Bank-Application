import java.util.Scanner;
import java.util.HashMap;
public class Menu {
    private Scanner scnr = new Scanner(System.in);
    private Bank bank = new Bank();

    private Teller teller = new Teller();

    //Displays the menu
    private void displayMenu(){
        int userInput;

        System.out.println("********* MENU *********");
        System.out.println();
        System.out.println("Please make a selection:");
        System.out.println("1) Access Account");
        System.out.println("2) Open a New Account");
        System.out.println("3) Close All Accounts");
        System.out.println("4) Teller Sign in");
        System.out.println("5) Exit");
        System.out.print(">> ");

    }
    //This is what is called to run the menu using a while loop then going to whatever the userInput's desired
    public void runMenu(){

        boolean keepGoing = true;

        while (keepGoing){
            int userInput;

            displayMenu();

            try {
                userInput = Integer.parseInt(scnr.nextLine());
            }catch(Exception excpt){
                userInput = 5;
            }

            if (userInput == 1){
                accessAccount();
            }else if(userInput == 2){
                openAccount();
            }else if (userInput == 3){
                closeAllAccounts();
            }else if (userInput == 4){
                tellerMenu();
            } else if (userInput == 5){
                keepGoing = false;
                System.out.println("Thank you for using BSU Banking App! Exiting...");

            }else{
                System.out.println("Not a valid option!");
            }

        }

    }


    //Access an account
    private void accessAccount(){
        int userPIN;
        Customer customer;

        System.out.print("Please enter PIN: ");

        try {
            userPIN = Integer.parseInt(scnr.nextLine());
        }catch (Exception excpt){
            System.out.println("Invalid Input- Must be a number");
            return;
        }

        if (bank.getCustomer(userPIN) == null){
            System.out.println("PIN is not valid");
            return;

        }else{
            int accountNumber;
            customer = bank.getCustomer(userPIN);
            HashMap<Integer,Account> customerAccounts = customer.getAccounts();

            //Checks if the list is empty(user has no accounts) if there isn't end the method execution
            if(customerAccounts.isEmpty()){
                System.out.println("No currently active accounts!");
                return;
            }

            System.out.println("*** Active Accounts ***");

            customerAccounts.forEach((id,account) -> System.out.println(account.toString()));

            System.out.println();
            System.out.println("Please Enter the account number");
            System.out.print("of the account you would like to access: ");

            try {
                accountNumber = Integer.parseInt(scnr.nextLine());
            }catch (Exception excpt){
                System.out.println("Invalid Input");
                return;
            }

            if (customer.getAccountByNum(accountNumber) == null){
                System.out.println("Account number invalid");
                return;

            }else{
                printAccountMenu(customer.getAccountByNum(accountNumber),customer);
            }
        }


    }

    //Prints menu after the user tries to access the account
    private void printAccountMenu(Account account, Customer customer){

        int userSelection = 0;
        boolean keepGoing = true;


        while (keepGoing) {

            System.out.println();
            System.out.println("Please make a selection:");
            System.out.println("1) Make a deposit");
            System.out.println("2) Make a withdrawl");
            System.out.println("3) See account balance");
            System.out.println("4) Close account");
            System.out.println("5) Exit");
            System.out.print(">> ");

            try {
                userSelection = Integer.parseInt(scnr.nextLine());
            } catch (Exception excpt) {
                System.out.println("Invalid Input- Must be a number");
                keepGoing = false;
            }

            if (userSelection == 1) {
                System.out.print("Deposit Amount: ");

                try {
                    account.deposit(Integer.parseInt(scnr.nextLine()));
                }catch(Exception excpt){
                    System.out.println("Invalid Input- Must be a number");
                }

            } else if (userSelection == 2) {
                System.out.print("Withdraw Amount: ");

                try {
                    account.withdraw(Double.parseDouble(scnr.nextLine()));
                }catch(Exception excpt){
                    System.out.println("Invalid Input- Must be a number");
                }

            } else if (userSelection == 3) {
                System.out.printf("Account Balance: $%.2f\n", account.getBalance());

            } else if (userSelection == 4) {
                customer.removeAccount(account);
                return;

            } else if (userSelection == 5) {
                keepGoing = false;

            } else {
                System.out.println("Invalid Input");
            }
        }

    }

    //Opens an account. Asks if the user is a new customer or not. If they are create a new customer. If not then deposit
    private void openAccount(){
        int userInput;
        int pin;
        double deposit;

        System.out.println("Are you a new Customer? ");
        System.out.println("1) Yes");
        System.out.println("2) No");
        System.out.print(">>");

        try {
            userInput = Integer.parseInt(scnr.nextLine());
        }catch(Exception excpt){
            System.out.println("Invalid Input- Must be a number");
            return;
        }

        if (userInput == 1){
            Customer customer = createNewCustomer();

            //Look at this line as well
            if (customer != null) {
                pin = customer.getPin();
            }else{
                return;
            }

        }else if (userInput == 2){
            System.out.print("Please enter PIN: ");

            try {
                pin = Integer.parseInt(scnr.nextLine());
            }catch(Exception excpt){
                System.out.println("Invalid Input- Must be a number");
                return;
            }
            if (bank.getCustomer(pin) == null){
                System.out.println("Invalid PIN");
                return;
            }

        }else{
            System.out.println("Invalid Input");
            return;
        }

        System.out.print("Enter deposit amount: ");

        try {
            deposit = Double.parseDouble(scnr.nextLine());
        }catch(Exception excpt){
            System.out.println("Invalid Input- Must be a number");
            return;
        }

        Account account = new Account(deposit);
        bank.getCustomer(pin).addAccount(account);
        System.out.println("Account successfully created!");

    }

    //Creates a new customer
    private Customer createNewCustomer(){
        String firstName;
        String lastName;
        int pin;

        System.out.print("Enter First Name: ");
        firstName = scnr.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = scnr.nextLine();

        System.out.print("Enter PIN: ");

        try {
            pin = Integer.parseInt(scnr.nextLine());
        }catch (Exception excpt){
            System.out.println("Invalid Input- Must be a number");
            return null; //Change this line
        }

        Customer newCustomer = new Customer(firstName,lastName,pin);
        bank.addCustomer(newCustomer);

        return newCustomer;

    }

    //Close all the accounts of the customer
    private void closeAllAccounts(){
        int userInput;

        System.out.print("Please enter your PIN: ");

        try {
            userInput = Integer.parseInt(scnr.nextLine());
        }catch (Exception excpt){
            System.out.println("Invalid Input- Must be a number");
            return;
        }

        if(bank.getCustomer(userInput) == null){
            System.out.println("PIN not found");
            return;
        }else{
            bank.removeCustomer(bank.getCustomer(userInput));
            System.out.println("Customer has been removed from the bank registry");
        }
    }

    //Creates the teller's menu and gives the teller options
    public void tellerMenu(){

        int userSelection = 0;
        boolean keepGoing = true;


        System.out.print("Enter Teller ID: ");
        userSelection = Integer.parseInt(scnr.nextLine());

        if (userSelection == teller.getPin()){
            System.out.println("Welcome!");
        }else{
            System.out.println("Invalid ID");
            return;
        }


        while (keepGoing) {

            System.out.println();
            System.out.println("Please make a selection:");
            System.out.println("1) Make a deposit");
            System.out.println("2) Make a withdrawl");
            System.out.println("3) Exit");
            System.out.print(">> ");

            try {
                userSelection = Integer.parseInt(scnr.nextLine());
            } catch (Exception excpt) {
                System.out.println("Invalid Input- Must be a number");
                keepGoing = false;
            }

            if (userSelection == 1) {
                teller.deposit();

            } else if (userSelection == 2) {
                teller.withdrawal();

            }else if (userSelection == 3){
                keepGoing = false;
                System.out.println("Exiting Teller Menu!");
            }else{
                System.out.println("Invalid Input!");
            }
        }

    }
}






