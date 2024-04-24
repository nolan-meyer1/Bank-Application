import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Bank {

    //ArrayList that contains a list of the customers
    protected static ArrayList<Customer> customerList = new ArrayList<Customer>();


    //Default constructor
    public Bank() {

    }

    //Adds a customer to the list
    public void addCustomer(Customer customer){
        /*Adds customer from the customerList ArrayList*/

        customerList.add(customer);
    }

    //Removes a customer from the list
    public void removeCustomer(Customer customer){
        /*Removes customer from the customerList ArrayList*/

        customerList.remove(customer);
    }

    //Gets a customer by pin
    public Customer getCustomer(int pin){
        /*Searches for a customer by their pin number*/

        Customer customerReturned = null;

        for (Customer customer: customerList){

            if (customer.getPin() == pin){
                customerReturned = customer;
            }
        }
        return customerReturned;
    }

    //Prints all customer info
    public void printAllCustomer(){
        /*Prints all the customer data from
        * an overridden toString method*/

        for(Customer customer: customerList){
            System.out.println(customer.toString());
        }

    }

    //Return the customer list
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    //Loads the current list of customers from an xml file
    protected void loadCustomers() throws IOException, SAXException, ParserConfigurationException {
        /*Takes in a xml file and parses
        * through it. It will load all customers
        * in to the bank's array list*/

        try{
            File input = new File("customers.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(input);

            NodeList customers = doc.getElementsByTagName("customer");
            NodeList accountNum = doc.getElementsByTagName("numberOfAccounts");

            //Sets the accounts number to the number of accounts
            Account.setNumberOfAccounts(Integer.parseInt(accountNum.item(0).getTextContent()));

            for (int i = 0; i < customers.getLength();i++){

                Node node = customers.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    Customer customer = new Customer(element.getElementsByTagName("firstName").item(0).getTextContent(),element.getElementsByTagName("lastName").item(0).getTextContent(),Integer.parseInt(element.getElementsByTagName("PIN").item(0).getTextContent()));

                    NodeList accounts = element.getElementsByTagName("account");

                    //Loops over every account
                    for (int j = 0; j < accounts.getLength();j++){
                        Node node2 = accounts.item(j);

                        if (node.getNodeType() == Node.ELEMENT_NODE){
                            Element element2 = (Element) node;

                            Account account = new Account(Double.parseDouble(element2.getElementsByTagName("balance").item(0).getTextContent()),Integer.parseInt(element2.getElementsByTagName("accountNum").item(0).getTextContent()));
                            customer.addAccount(account);

                        }


                    }
                    addCustomer(customer);

                }

            }

        }catch (Exception excpt){
            excpt.printStackTrace();
        }
    }
}
