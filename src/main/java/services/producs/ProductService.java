package services.producs;

import dao.ProductDao;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService implements Requirements4Product {
    ProductDao productDao = new ProductDao();

    @Override
    public List<Product> getAllProducts() {
        return productDao.getProductsList();
    }

    @Override
    public void printProductsList(){
        System.out.println("\nList of available products: ");
        for ( Product product : getAllProducts()){
            System.out.println("\t" + product.toString());
        }
        return;
    }

    @Override
    public Product getProductByID(int id) {
        return productDao.getProductByID(id);
    }
}
