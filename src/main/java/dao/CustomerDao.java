package dao;

import config.DatabaseConnection;
import model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerDao {

    public CustomerDao() {
    }


    public Customer getCustomerByID(int id) {
        String sql = "SELECT * FROM customers WHERE customers.id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return mapDBCustomer(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //o sa ajunga aici daca nu exista clientul cu id-ul cerut
        return null;
    }

    public ArrayList<Customer> getCustomersWithOrders(){
        String sql = "SELECT customers.* FROM customers JOIN orders ON orders.customer_id = customers.id GROUP BY customers.id ORDER BY customers.name";
        ArrayList<Customer> customersWithOrdersList = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){
                customersWithOrdersList.add(mapDBCustomer(rs));
            }

        }catch (SQLException e){
            System.out.println("Error when getting customers with orders list: " + e.getMessage());
        }

        return customersWithOrdersList;
    }

    public ArrayList<Customer> getAllCustomers(){
        String sql = "SELECT customers.* FROM customers ORDER BY customers.name";
        ArrayList<Customer> customersList = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){
                customersList.add(mapDBCustomer(rs));
            }

        }catch (SQLException e){
            System.out.println("Error when getting customers list: " + e.getMessage());
        }

        return customersList;
    }

    private Customer mapDBCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getDate("birthday").toLocalDate());
        return customer;
    }

}
