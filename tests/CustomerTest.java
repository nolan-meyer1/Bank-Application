import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer = new Customer("Nolan","Meyer",101);
    private Account account = new Account(100);

    @Test
    void addAccount() {
        /*Adds customer. Checks if it's added to
        * the list. If it is it will return true.
        * then remove the account. */

        customer.addAccount(account);
        assertEquals(account,customer.getAccountByNum(account.getAccountNumber()));

        //Removes account
        customer.removeAccount(account);
    }

    @Test
    void removeAccount() {
        /*Adds customer. Then remove the customer from
        the list and checks if it is removed */

        customer.addAccount(account);
        customer.removeAccount(account);

        assertNull(customer.getAccountByNum(account.getAccountNumber()));
    }

    @Test
    void getAccountByNum() {
        /*Adds an account to the list. Then tries to
        * get it by the account number. Then removes it
        * again to be defualt empty*/

        customer.addAccount(account);
        assertEquals(account,customer.getAccountByNum(account.getAccountNumber()));
    }
}