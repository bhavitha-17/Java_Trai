package CustomerManagement.CustomerServiceImpl;

import CustomerManagement.Domain.Customer;

import java.util.List;

public interface ICustomerService {
    Customer register(Customer var1);

    Customer findById(int var1);

    List<Customer> findCustomersByFirstNameAscendingId(String var1);
}
