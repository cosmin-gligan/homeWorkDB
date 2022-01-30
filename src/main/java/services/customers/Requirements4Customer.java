package services.customers;

import model.Customer;

import java.util.List;

public interface Requirements4Customer {
    List<Customer> getCustomersWithOrders();
    void printCustomersList();
    Customer getCustomerByID(int id);
    List<Customer> getAllCustomers();
}
