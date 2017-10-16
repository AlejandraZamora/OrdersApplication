package beitech.test.order.application.ordersApplication.Services;

import beitech.test.order.application.ordersApplication.Entities.Customer;
import beitech.test.order.application.ordersApplication.Entities.Order;
import beitech.test.order.application.ordersApplication.Entities.Product;

import java.util.List;

/**
 * Created by alejandra on 14/10/17.
 */
public interface CustomerServices {

    public List<Customer> getCustomers();

    public Customer getCustomerById(Integer customerId);

    public List<Order> getCustomerOrders(Integer customerId);

    public void saveNewOrder(Order order);

    public List<Product> getCustomerProducts(Integer customerId);
}