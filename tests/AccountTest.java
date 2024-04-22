import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account = new Account(100);

    @Test
    void deposit() {
        /*Deposits another 100. The defualt value is set at 100
        * so the updated balance should be 200.00*/

        account.setBalance(100);
        account.deposit(100);
        assertEquals(200.00,account.getBalance());


    }

    @Test
    void withdraw() {
        /*Withdrawals 50 after first setting balance back
        to defualt 100.
         */

        account.setBalance(100);
        account.withdraw(50);
        assertEquals(50.00,account.getBalance());
    }

    @Test
    void testToString() {
        /*Tests to make sure that
        * the printout is correct*/

        assertEquals(String.format("Account Number: %d\nBalance: $%.2f\n",account.getAccountNumber(),account.getBalance()),account.toString());
    }
}