import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    /*Adds customer. Checks if it's added to
     * the list. If it is it will return true.
     * then remove the account. */
    @Test
    void addAccount() {

        Customer customer = new Customer("Nolan","Meyer",101);
        Account account = new Account(100);

        customer.addAccount(account);
        assertEquals(account,customer.getAccountByNum(account.getAccountNumber()));

    }

    /*Adds customer. Then remove the customer from
    * the list and checks if it is removed*/
    @Test
    void removeAccount() {

        Customer customer = new Customer("Nolan","Meyer",101);
        Account account = new Account(100);


        customer.addAccount(account);
        customer.removeAccount(account);

        assertNull(customer.getAccountByNum(account.getAccountNumber()));
    }

    /*Adds an account to the list. Then tries to
     * get it by the account number. Then removes it
     * again to be default empty*/
    @Test
    void getAccountByNum() {

        Customer customer = new Customer("Nolan","Meyer",101);
        Account account = new Account(100);

        customer.addAccount(account);
        assertEquals(account,customer.getAccountByNum(account.getAccountNumber()));
    }
}