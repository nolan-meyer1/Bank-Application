import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TellerTest {
    private Bank bank = new Bank();
    private Customer customer = new Customer("Nolan","Meyer",678);

    private Account account = new Account(1000);

    private Teller teller = new Teller();



    @Test
    void deposit() {
        /*Adds the account to the customer list and then tries to make a deposit.*/
        customer.addAccount(account);
        teller.deposit();
        assertEquals(2000.00,account.getBalance());


    }

    @Test
    void withdrawal() {
        /*Withdraws 100 from the account balance. After the first test runs
        * the expected value should be 1900*/

        teller.withdrawal();
        assertEquals(1900.00,account.getBalance());
    }

    @Test
    void removeCustomerTeller() {
        /*Checks if the customer is removed*/

    }

}