import java.util.ArrayList;
public class Bank {

    //ArrayList that contains a list of the customers
    protected static ArrayList<Customer> customerList = new ArrayList<Customer>();


    //Default constructor
    public Bank(){

    }

    //Adds a customer to the list
    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    //Removes a customer from the list
    public void removeCustomer(Customer customer){
        customerList.remove(customer);
    }

    //Gets a customer by pin
    public Customer getCustomer(int pin){

        Customer customerReturned = null;

        for (Customer customer: customerList){

            if (customer.getPin() == pin){
                customerReturned = customer;
            }
        }
        return customerReturned;
    }

    //Prints all customer info needs review
    public void printAllCustomer(){

        for(Customer customer: customerList){
            System.out.println(customer.toString());
        }

    }

    //Return the customer list
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
