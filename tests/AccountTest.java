import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    /*Deposits another 100. The default value is set at 100
     * so the updated balance should be 200.00*/
    @Test
    void deposit() {

        Account account = new Account(100);

        account.setBalance(100);
        account.deposit(100);
        assertEquals(200.00,account.getBalance());
    }

    /*Withdrawals from the orginal account balance of 100*/
    @Test
    void withdraw() {

        Account account = new Account(100);

        account.setBalance(100);
        account.withdraw(50);
        assertEquals(50.00,account.getBalance());
    }

    /*Tests to make sure that
     * the printout is correct*/
    @Test
    void testToString() {

        Account account = new Account(100);

        assertEquals(String.format("Account Number: %d\nBalance: $%.2f\n",account.getAccountNumber(),account.getBalance()),account.toString());
    }
}