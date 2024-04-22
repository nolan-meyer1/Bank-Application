import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank = new Bank();
    private Customer customer1 = new Customer("Nolan","Meyer",101);


    @Test
    void addCustomer() {
        /* Adds the customer to the bank list. Then tries to grab the customer
        and see if the customer is in the list. Should return the customer.*/

        bank.addCustomer(customer1);
        assertEquals(customer1,bank.getCustomer(101));

        //Removes Customer
        bank.removeCustomer(customer1);
    }

    @Test
    void removeCustomer() {
        /*Adds that customer to the bank list. Then removes it and
        checks if the customer has been removed. Should return null*/

        bank.addCustomer(customer1);
        bank.removeCustomer(customer1);
        assertNull(bank.getCustomer(customer1.getPin()));
    }

    @Test
    void getCustomer() {
        /*Adds the customer to the list. Then checks tries
         * to return the customer. Should be able to return the customer*/
        bank.addCustomer(customer1);
        assertEquals(customer1, bank.getCustomer(customer1.getPin()));

        //Removes customer
        bank.removeCustomer(customer1);

    }

}