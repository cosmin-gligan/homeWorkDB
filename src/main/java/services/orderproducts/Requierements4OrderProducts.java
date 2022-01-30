package services.orderproducts;

import model.Customer;
import model.Order;
import model.OrderProducts;
import model.Product;

import java.util.List;

public interface Requierements4OrderProducts {

    List<OrderProducts> getOrderProducts4Order(Order order);
    List<OrderProducts> getOrderProducts4OrderID(int order_id);
    List<OrderProducts> getAllOrderProducts4Order();
    void printOrderProducts4Order(Order order);
    void printAllOrderProducts();
    List<OrderProducts> getOrderProducts4Product(Product product);
    List<OrderProducts> getOrderProducts4ProductID(int product_id);
    List<OrderProducts> getOrderProduct4Customer(Customer customer);
    List<OrderProducts> getOrderProduct4CustomerID(int customer_id);

}
