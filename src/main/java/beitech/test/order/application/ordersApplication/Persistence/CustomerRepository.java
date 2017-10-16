package beitech.test.order.application.ordersApplication.Persistence;

import beitech.test.order.application.ordersApplication.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alejandra on 14/10/17.
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
