package services.producs;

import model.Customer;
import model.Product;

import java.util.List;

public interface Requirements4Product {
    List<Product> getAllProducts();
    void printProductsList();
    Product getProductByID(int id);

}
