public class Account {

    //Instance variables for balance, accountNumber, and the number of instances created of the class
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    /*Constructor that has an initial deposit, and increments the numberOfAccounts and sets the account number to that number
    * @param deposit Initial deposit when creating the account*/
    public Account(double deposit){
        numberOfAccounts = numberOfAccounts + 1;
        accountNumber = numberOfAccounts;
        balance = deposit;
    }

    /*Another constructor for creating accounts
    * @param balance Initial balance when creating the account.
    * @param accountNumber Custom account number if you would like to set one.*/
    public Account(double balance,int accountNumber){
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    /*Default constructor*/
    public Account(){

    }

    /*Takes in a deposit amount and
     * updates the balance of the account
     * @param deposit Deposit amount that you want to add to account balance*/
    public void deposit(double deposit){

        balance = balance + deposit;
        System.out.printf("Amount Deposited: $%.2f\n",deposit);
        System.out.printf("Updated Balance: $%.2f\n",balance);
    }

    /*Takes in a withdrawal amount
     * and updates the account balance.
     * @param amount Amount that you want to subtract from account balance.*/
    public void withdraw(double amount){

        if (amount > balance){
            System.out.println("Insufficient Funds");

        }else{
            balance = balance - amount;
            System.out.printf("Amount Withdrawn: $%.2f\n", amount);
            System.out.printf("Updated Balance: $%.2f\n", balance);
        }
    }

    /*toString method override that prints the account number, and balance*/
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
