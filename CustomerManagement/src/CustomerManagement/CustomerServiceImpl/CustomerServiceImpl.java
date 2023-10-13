package CustomerManagement.CustomerServiceImpl;


import CustomerManagement.Domain.Customer;
import CustomerManagement.Exceptions.CustomException;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements ICustomerService {
    Map<Integer, Customer> customerMap;
    int mapId;

    public CustomerServiceImpl(Map<Integer, Customer> customerMap, int mapId) {
        this.customerMap = customerMap;
        this.mapId = mapId;
    }

    public Customer register(Customer customer) throws CustomException {
        if (!this.isValidName(customer.getFirstName()) && !this.isValidName(customer.getLastName())) {
            this.customerMap.put(this.mapId++, customer);
            return customer;
        } else {
            throw new CustomException("Invalid name");
        }
    }

    public Customer findById(int id) throws CustomException {
        if (id < 1) {
            throw new CustomException("Invalid ID");
        } else {
            Optional<Customer> c=customerMap.entrySet().stream().filter(entrySet -> entrySet.getValue().getId()==id).map(Map.Entry::getValue).findFirst();

            if(((Optional<?>) c).isPresent()){
                return c.get();
            }

            throw new CustomException("Customer with ID " + id + " not found");

//            if (customer == null) {
//                throw new CustomException("Domain.Customer with ID " + id + " not found");
//            } else {
//                System.out.println("Domain.Customer found");
//                System.out.println(customer);
//                return customer;
//            }
        }
    }

    public List<Customer> findCustomersByFirstNameAscendingId(String firstName) throws CustomException {
        if (firstName.length() < 3) {
            throw new CustomException("Insufficient text for search");
        } else {
            List<Customer> customers = customerMap.values().stream().filter((customer) ->
                customer.getFirstName().startsWith(firstName)).sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
            if (customers.isEmpty()) {
                throw new CustomException("No customer found");
            } else {
                return customers;
            }
        }
    }

    private boolean isValidName(String name) {
        return name.length() < 2 || name.length() > 10;
    }
}

