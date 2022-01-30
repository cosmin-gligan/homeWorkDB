package services.customers;

import dao.CustomerDao;
import model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerService implements Requirements4Customer {
    private CustomerDao customerDao;

    public CustomerService(){
        customerDao = new CustomerDao();
    }

    @Override
    public List<Customer> getCustomersWithOrders() {
        return customerDao.getCustomersWithOrders();
    }


    public void printCustomersList(){
        System.out.println("\nCustomers with orders: ");
        for ( Customer customer : getCustomersWithOrders()){
            System.out.println("\t" + customer.toString());
        }
        return;
    }

    @Override
    public Customer getCustomerByID(int id) {
        return customerDao.getCustomerByID(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
}
