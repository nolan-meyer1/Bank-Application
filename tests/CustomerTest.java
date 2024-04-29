import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void addAccount() {
        /*Adds customer. Checks if it's added to
        * the list. If it is it will return true.
        * then remove the account. */

        Customer customer = new Customer("Nolan","Meyer",101);
        Account account = new Account(100);

        customer.addAccount(account);
        assertEquals(account,customer.getAccountByNum(account.getAccountNumber()));

    }

    @Test
    void removeAccount() {
        /*Adds customer. Then remove the customer from
        the list and checks if it is removed */

        Customer customer = new Customer("Nolan","Meyer",101);
        Account account = new Account(100);


        customer.addAccount(account);
        customer.removeAccount(account);

        assertNull(customer.getAccountByNum(account.getAccountNumber()));
    }

    @Test
    void getAccountByNum() {
        /*Adds an account to the list. Then tries to
        * get it by the account number. Then removes it
        * again to be default empty*/

        Customer customer = new Customer("Nolan","Meyer",101);
        Account account = new Account(100);

        customer.addAccount(account);
        assertEquals(account,customer.getAccountByNum(account.getAccountNumber()));
    }
}