import java.util.HashMap;
public class Customer {

    //Instance variables
    private String firstName;
    private String lastName;
    private int pin;
    private HashMap<Integer,Account> accounts = new HashMap<Integer,Account>();

    /*Defualt Constructor*/
    public Customer(){

    }

    /*Constructor that sets all the fields to values passed in.
    * @param firstName first name of the customer
    * @param lastName last name of the customer
    * @param pin pin number of the customer*/
    public Customer(String firstName,String lastName,int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }


    /*Adds an account to the customer's HashMap*/
    public void addAccount(Account account) {

        accounts.put(account.getAccountNumber(),account);
        System.out.printf("Successfully added: %d to accounts!\n", account.getAccountNumber());
    }

    /*Removes an account from the customers HashMap
    * @param account An account object*/
    public void removeAccount(Account account) {

        accounts.remove(account.getAccountNumber());
        System.out.println("Successfully removed!");
    }

    /*Returns an account if the HashMap contains the
     * account number that it was passed
     * @param accountNumber account number used to find account
     * @return returns an account object if it's found or null if it's not found. */
    public Account getAccountByNum(int accountNumber) {

        Account accountReturn = null;

        if (accounts.containsKey(accountNumber)){
            accountReturn = accounts.get(accountNumber);
        }

        return accountReturn;
    }

    /*toString method that will print the customer's name and pin*/
    @Override
    public String toString() {
        return String.format("Customer's Name: %s  %s, PIN: %d", firstName, lastName, pin);
    }

    //Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<Integer, Account> accounts) {
        this.accounts = accounts;
    }
}
