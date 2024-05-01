import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TellerTest {


    /*Adds the account to the customer list and then tries to make a deposit. Uses
     * mock object*/
    @Test
    void deposit() {

        Bank bank = new Bank();
        Customer customer = new Customer("Nolan","Meyer",678);
        Account account = new Account(1000);
        MockTeller teller = new MockTeller();

        customer.addAccount(account);
        bank.addCustomer(customer);
        teller.deposit(1000, account.getAccountNumber(),customer.getPin());
        assertEquals(2000.00,account.getBalance());

    }

    /*Withdraws 100 from the account balance. After the first test runs
     * the expected value should be 1900*/
    @Test
    void withdrawal() {

        Bank bank = new Bank();
        Customer customer = new Customer("Nolan","Meyer",678);
        Account account = new Account(1000);
        MockTeller teller = new MockTeller();

        customer.addAccount(account);
        bank.addCustomer(customer);
        teller.withdrawal(1000, account.getAccountNumber(),customer.getPin());
        assertEquals(0.00,account.getBalance());

    }

    /*Checks if the customer is removed*/
    @Test
    void removeCustomerTeller() {

        Bank bank = new Bank();
        Customer customer = new Customer("Nolan","Meyer",678);
        Account account = new Account(1000);
        MockTeller teller = new MockTeller();

        //Adds customer to the bank
        bank.addCustomer(customer);
        teller.removeCustomerTeller(customer.getPin());

        assertNull(bank.getCustomer(customer.getPin()));
    }

}