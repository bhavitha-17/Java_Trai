package CustomerManagement.Ui;

import CustomerManagement.CustomerServiceImpl.CustomerServiceImpl;
import CustomerManagement.CustomerServiceImpl.ICustomerService;
import CustomerManagement.Domain.Customer;
import CustomerManagement.Exceptions.CustomException;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Customer> customerMap = new HashMap<>();
        int mapId = 1;
        ICustomerService service = new CustomerServiceImpl(customerMap, mapId);

        try {
            Customer customer = new Customer(1, "bhavitha", "reddy");
            System.out.println(service.register(customer));
            customer = new Customer(2, "mahesh", "rao");
            System.out.println(service.register(customer));
             customer = new Customer(3, "sampath", "bro");
            System.out.println(service.register(customer));
             customer = new Customer(4, "Karthik", "Kumar");
            System.out.println(service.register(customer));
             customer = new Customer(5, "Govind", "appan");
            System.out.println(service.register(customer));


            System.out.println("\n\n");
            System.out.println(service.findById(1));


            System.out.println("\n\n");
            List<Customer> cust=service.findCustomersByFirstNameAscendingId("bav");

            for(Customer c:cust){
                System.out.println(c);
            }


        }catch (CustomException e){
            System.out.println(e.getMessage());
        }





    }
}
