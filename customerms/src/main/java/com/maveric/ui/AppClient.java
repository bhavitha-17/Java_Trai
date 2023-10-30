package com.maveric.ui;

import com.maveric.domain.Customer;
import com.maveric.exceptions.CustomerNotFoundException;
import com.maveric.exceptions.InsufficientTextForSearch;
import com.maveric.exceptions.InvalidCustomerId;
import com.maveric.exceptions.InvalidNameException;
import com.maveric.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AppClient {

    public CustomerService cusSer = new CustomerService();
    private static final Logger Log =  LogManager.getLogger(AppClient.class);

    public static void main(String[] args) {
        AppClient appClient = new AppClient();
        appClient.runApp();
    }

    public void runApp() {
        Log.info("************* Register Customer *************");
        registerCustomer("Linita", "Lyle");
        registerCustomer("Bhavitha", "Reddy");
        registerCustomer("Samuel", "Prem");
        registerCustomer("Komala", "Komal");
        registerCustomer("Sammy", "Daniel");
        registerCustomer("", "Brown");//Throws Exception
        registerCustomer("Brown", ""); //Throws Exception
        displayCustomers();

        Log.info("\n************* Find Customer by Id *************");
        int customerId = 2;
        findCustomerById(customerId);
        findCustomerById(0); // throws exception;
        Log.info("\n************* Find Customer Starting with... *************");
        customerStartingWith("Sam");
        customerStartingWith("ab");//Throws exception
        customerStartingWith("abc");//No customer found

    }

    public void registerCustomer(String firstName, String lastName) {
        try {
            Customer resObj = cusSer.register(firstName, lastName);
            Log.info("Details of customer registered: " + resObj);
        } catch (InvalidNameException e) {
            Log.debug (e.getMessage());
        }
    }

    public void findCustomerById(int custId) {

        try {
            Customer resObj = cusSer.findById(custId);
            Log.info("Details of customer with id " + custId + " is " + resObj);
        } catch (InvalidCustomerId | CustomerNotFoundException e) {
            Log.debug(e.getMessage());
        }
    }

    public void displayCustomers() {
        Log.info("\nDetails of all registered customers....");
        cusSer.displayCustomers();
    }

    public void customerStartingWith(String str) {
        try {
            List<Customer> allCustomers = cusSer.findCustomersByFirstNameAscendingId(str);
            Log.info("Details of customers whose name starts with " + str);
            Log.debug(allCustomers);
        } catch (InvalidNameException e) {
            Log.debug(e.getMessage());
        } catch (InsufficientTextForSearch e) {
            Log.debug(e.getMessage());
        } catch (CustomerNotFoundException e) {
            Log.debug(e.getMessage());
        }
    }
}
