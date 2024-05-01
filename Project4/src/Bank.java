import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Bank {

    /*ArrayList that contains a list of the customers*/
    protected static ArrayList<Customer> customerList = new ArrayList<Customer>();


    /*Default constructor*/
    public Bank() {

    }

    /*Adds customer from the customerList ArrayList
    * @param customer A customer object*/
    public void addCustomer(Customer customer){

        customerList.add(customer);
    }

    /*Removes customer from the customerList ArrayList
    * @param customer A customer object*/
    public void removeCustomer(Customer customer){

        customerList.remove(customer);
    }

    /*Searches for a customer by their pin number
    * @param pin Takes in a pin number that is used to search for a customer
    * @return returns a customer object*/
    public Customer getCustomer(int pin){

        Customer customerReturned = null;

        for (Customer customer: customerList){

            if (customer.getPin() == pin){
                customerReturned = customer;
            }
        }
        return customerReturned;
    }

    /*Prints all the customer data from
     * an overridden toString method*/
    public void printAllCustomer(){

        for(Customer customer: customerList){
            System.out.println(customer.toString());
        }

    }

    /*Returns the customer list
    * @return customerList field*/
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    /*Takes in a xml file and parses
     * through it. It will load all customers
     * in to the bank's array list*/
    protected void loadCustomers() throws IOException, SAXException, ParserConfigurationException {

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
