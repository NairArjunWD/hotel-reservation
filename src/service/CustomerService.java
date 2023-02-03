package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CustomerService {

    private static CustomerService customerService;

    Collection<Customer> customers = new HashSet<Customer>();

    public static CustomerService getInstance() {
        if (null == customerService) {
            customerService = new CustomerService();
        }
        return customerService;
    }


    public void addCustomer(String email, String firstName, String lastName) {

        Customer customer = new Customer(email, firstName, lastName);
        customers.add(customer);

    }

    public Customer getCustomer(String customerEmail) {
        for (Customer customerEmails:customers) {
            if (customerEmails.getEmail().equals(customerEmail)){
                return customerEmails;
            }
            return null;
        }
        return null;
    }

    public Collection<Customer> getAllCustomers(){

        return customers;
    }
}
