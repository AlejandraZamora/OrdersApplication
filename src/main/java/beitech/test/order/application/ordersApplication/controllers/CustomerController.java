package beitech.test.order.application.ordersApplication.controllers;


import beitech.test.order.application.ordersApplication.Entities.Customer;
import beitech.test.order.application.ordersApplication.Entities.Order;
import beitech.test.order.application.ordersApplication.Entities.Product;
import beitech.test.order.application.ordersApplication.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alejandra on 14/10/17.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST CUSTOMERS CHECK!!";
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getCustomers(){
        List<Customer> customers=customerServices.getCustomers();
        if(customers!=null){
            return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}", produces = "application/json")
    public ResponseEntity<?> getCustomer(@PathVariable Integer customerId) {
        Customer customer=customerServices.getCustomerById(customerId);
        if(customer!=null){
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}/order", produces = "application/json")
    public ResponseEntity<?> getCustomerOrders(@PathVariable Integer customerId) {
        List<Order> orders=customerServices.getCustomerOrders(customerId);
        if(orders!=null){
            return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{customerId}/order", consumes = "application/json")
    public ResponseEntity<?> saveNewOrder(@PathVariable Integer customerId, @RequestBody Order order) {
        customerServices.saveNewOrder(order);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}/product", produces = "application/json")
    public ResponseEntity<?> getCustomerProducts(@PathVariable Integer customerId) {
        List<Product> products=customerServices.getCustomerProducts(customerId);
        if(products!=null){
            return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}



