package beitech.test.order.application.ordersApplication.Services;

import beitech.test.order.application.ordersApplication.Entities.Customer;
import beitech.test.order.application.ordersApplication.Entities.CustomerProduct;
import beitech.test.order.application.ordersApplication.Entities.Order;
import beitech.test.order.application.ordersApplication.Entities.Product;
import beitech.test.order.application.ordersApplication.Persistence.CustomerProductRepository;
import beitech.test.order.application.ordersApplication.Persistence.CustomerRepository;
import beitech.test.order.application.ordersApplication.Persistence.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandra on 14/10/17.
 */
@Service
public class CustomerServicesDBImplementation implements CustomerServices{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerProductRepository customerProductRepository;

    @Override
    public List<Customer> getCustomers() {
        ArrayList<Customer> customers=new ArrayList<Customer>();
        for(Object customer : customerRepository.findAll()){
            customers.add((Customer) customer);
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Customer customer=(Customer) customerRepository.findOne(customerId);
        return customer;
    }

    @Override
    public List<Order> getCustomerOrders(Integer customerId) {
        List<Order> orders=ordersRepository.findAll();
        List<Order> ordersCustomer= new ArrayList<Order>();
        for (Order order: orders) {
            if(order.getCustomer().getCustomerId()==customerId){
                ordersCustomer.add(order);
            }
        }
        return ordersCustomer;
    }

    @Override
    public void saveNewOrder(Order order) {
        ordersRepository.save(order);
    }

    @Override
    public List<Product> getCustomerProducts(Integer customerId) {
        List<Product> products= new ArrayList<Product>();
        List<CustomerProduct> customerProducts =customerProductRepository.findAll();
        for (CustomerProduct customerProduct :customerProducts) {
            if(customerProduct.getCustomerProductId().getCustomerId()==customerId){
                products.add(customerProduct.getProduct());
            }
        }
        return products;
    }
}
