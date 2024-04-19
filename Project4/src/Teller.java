import java.util.ArrayList;
import java.util.Scanner;

public class Teller extends Bank{

    //Fields of the teller
    private int pin = 445;

    private Scanner scnr = new Scanner(System.in);

    //Defualt constructor that calls the parent constructor
    public Teller(){

    }

    //Allows for you to deposit into any account
    public void deposit(){
        /*This allows you to deposit into any
        * account. It will look search until it finds
        * a customer with the account and ask for the pin.
        * If the pin is correct you can withdrawal. If not
        * you won't be able to.*/

        Account accountFound = null;
        Customer customerFound = null;
        Integer userInput;
        Double depositAmount;
        int pin;

        System.out.print("Account Number: ");
        userInput = Integer.parseInt(scnr.nextLine());

        ArrayList<Customer> customerArray = super.getCustomerList();

        //Searches for the account using the parent customer list
        for(Customer customer: super.getCustomerList()){

            if (customer.getAccounts().containsKey(userInput)){
                accountFound = customer.getAccountByNum(userInput);
                customerFound = customer;
            }
        }

        //Checks if no account was found it not it will return
        if (accountFound == null){
            System.out.println("No account was found!");
            return;
        }else{
            System.out.print("Please enter your PIN: ");
            userInput = Integer.parseInt(scnr.nextLine());

            if (userInput == customerFound.getPin()){
                System.out.print("Deposit Amount: ");
                depositAmount = Double.parseDouble(scnr.nextLine());
                accountFound.deposit(depositAmount);

            }else{
                System.out.println("Incorrect PIN please try again later!");
                return;
            }

        }

    }

    public void withdrawal(){
        /*This allows you to deposit into any
         * account. It will look search until it finds
         * a customer with the account and ask for the pin.
         * If the pin is correct you can deposit. If not
         * you won't be able to.*/

        Account accountFound = null;
        Customer customerFound = null;
        Integer userInput;
        Double withdrawalAmount;
        int pin;

        System.out.print("Account Number: ");
        userInput = Integer.parseInt(scnr.nextLine());

        ArrayList<Customer> customerArray = getCustomerList();

        //Searches for the account using the parent customer list
        for(Customer customer: getCustomerList()){

            if (customer.getAccounts().containsKey(userInput)){
                accountFound = customer.getAccountByNum(userInput);
                customerFound = customer;
            }
        }

        //Checks if no account was found it not it will return
        if (accountFound == null){
            System.out.println("No account was found!");
            return;
        }else{
            System.out.print("Please enter your PIN: ");
            userInput = Integer.parseInt(scnr.nextLine());

            if (userInput == customerFound.getPin()){
                System.out.print("Withdrawal Amount: ");
                withdrawalAmount = Double.parseDouble(scnr.nextLine());
                accountFound.withdraw(withdrawalAmount);

            }else{
                System.out.println("Incorrect PIN please try again later!");
                return;
            }

        }

    }





    //Setters and getters
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
