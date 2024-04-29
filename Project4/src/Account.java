public class Account {

    //Instance variables for balance, accountNumber, and the number of instances created of the class
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    //Constructor that has an initial deposit, and increments the numberOfAccounts and sets the account number to that number
    public Account(double deposit){
        numberOfAccounts = numberOfAccounts + 1;
        accountNumber = numberOfAccounts;
        balance = deposit;
    }

    //Another constructor for creating accounts
    public Account(double balance,int accountNumber){
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    //Defualt constructor
    public Account(){

    }

    //Method to deposit money into the account
    public void deposit(double deposit){
        /*Takes in a deposit amount and
        * updates the balance of the account*/

        balance = balance + deposit;
        System.out.printf("Amount Deposited: $%.2f\n",deposit);
        System.out.printf("Updated Balance: $%.2f\n",balance);
    }

    //Method to withdraw money from the account
    public void withdraw(double amount){
        /*Takes in a withdrawal amount
        * and updates the account balance.*/

        if (amount > balance){
            System.out.println("Insufficient Funds");

        }else{
            balance = balance - amount;
            System.out.printf("Amount Withdrawn: $%.2f\n", amount);
            System.out.printf("Updated Balance: $%.2f\n", balance);
        }
    }

    //toString method override
    @Override
    public String toString(){
        return String.format("Account Number: %d\nBalance: $%.2f\n",accountNumber,balance);
    }


    //Getters and setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        Account.numberOfAccounts = numberOfAccounts;
    }
}
