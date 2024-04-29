import java.util.ArrayList;

public class MockTeller extends Teller{

    private int pin = 445;

    public MockTeller(){
        super();
    }

    public void deposit(double deposit,int accountNum, int customerPin){
        /*This allows you to deposit into any
         * account. It will look search until it finds
         * a customer with the account and ask for the pin.
         * If the pin is correct you can withdrawal. If not
         * you won't be able to.*/

        Account accountFound = null;
        Customer customerFound = null;
        Integer userInput;
        Double depositAmount;

        System.out.print("Account Number: ");

        try {
            userInput = accountNum;
        } catch (Exception excpt){
            System.out.println("Invalid Response!");
            return;
        }

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
            userInput = customerPin;

            if (userInput == customerFound.getPin()){
                System.out.print("Deposit Amount: ");
                depositAmount = deposit;
                accountFound.deposit(depositAmount);

            }else{
                System.out.println("Incorrect PIN please try again later!");
                return;
            }

        }
    }

    public void withdrawal(double withdrawalTest,int accountNum, int customerPin){
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
        try {
            userInput = accountNum;
        }catch (Exception excpt){
            System.out.println("Invalid Response!");
            return;
        }

        ArrayList<Customer> customerArray = getCustomerList();

        //Searches for the account using the parent customer list
        for(Customer customer: customerList){

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
            try {
                userInput = customerPin;
            }catch (Exception excpt){
                System.out.println("Invalid response!");
                return;
            }

            if (userInput == customerFound.getPin()){
                System.out.print("Withdrawal Amount: ");
                withdrawalAmount = withdrawalTest;
                accountFound.withdraw(withdrawalAmount);

            }else{
                System.out.println("Incorrect PIN please try again later!");
                return;
            }
        }
    }

    public void removeCustomerTeller(int pin){
        /*This will ask for a customer's pin
         * if the pin is correct it will remove the customer
         * from the customer list*/

        int userInput;
        Customer customerFound = null;

        System.out.print("Please enter a PIN: ");
        try {
            userInput = pin;
        }catch(Exception excpt){
            System.out.println("Invalid Response!");
            return;
        }

        for (Customer customer: customerList){
            if (customer.getPin() == userInput){
                customerFound = customer;
            }
        }

        if (customerFound == null){
            System.out.println("Customer not found!");
            return;

        }else{
            removeCustomer(customerFound);
            System.out.println("Customer removed!");

        }
    }

}
