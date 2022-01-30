import model.Customer;
import model.OrderProducts;
import model.Product;
import services.customers.CustomerService;
import services.orderproducts.OrderProductsService;
import services.orders.OrderService;
import services.producs.ProductService;

public class Main {
    public static void main(String[] args) {
        /*
        Implement ProductDao:

        - get productById/allProducts (as shown in class for CustomerDao)

        Implement OrderDao:

        - get productById/allProducts (as shown in class for CustomerDao)

        Add extra functionality to OrderDao:

        - get orders for a specific customer (hint: use join)

        - get all orders for all customers (hint: use join + another condition/filter)
        */


        //PRODUCTS
        ProductService productService = new ProductService();
        productService.printProductsList();

        //CUSTOMERS
        CustomerService customerService = new CustomerService();
        customerService.printCustomersList();

        //ORDERS
        OrderService orderService = new OrderService();
        orderService.printOrderList();

        for ( Customer customer : customerService.getCustomersWithOrders()){
            orderService.printOrderList4Customer(customer);
        }

        //BONUS: RAPOARTE
        System.out.println("\n-------------------------------------");

        System.out.println("RAPOARTE");

        OrderProductsService orderProductsService = new OrderProductsService();

        System.out.println("\n------VANZARI PE PRODUSE:------");

        for(Product product : productService.getAllProducts()){
            System.out.println("\t" + product.getName());
            double totalSales = 0;
            for (OrderProducts orderItem : orderProductsService.getOrderProducts4ProductID(product.getId())){
                System.out.println("\t\t\t" + orderItem);
                totalSales += orderItem.getValoare();
            }
            System.out.println("\tTOTAL valoare vanzari pentru " + product.getName() + ": " + totalSales);
            System.out.println("\n");
        }

        System.out.println("\n------VANZARI PE CLIENT------");
        for(Customer customer : customerService.getAllCustomers()){
            System.out.println("\t" + customer.getName());
            double totalSales = 0;
            for ( OrderProducts orderItem : orderProductsService.getOrderProduct4CustomerID(customer.getId())){
                System.out.println("\t\t\t" + orderItem);
                totalSales += orderItem.getValoare();
            }
            System.out.println("\tTOTAL valoare vanzari pentru " + customer.getName() + ": " + totalSales);
            System.out.println("\n");
        }

    }
}
