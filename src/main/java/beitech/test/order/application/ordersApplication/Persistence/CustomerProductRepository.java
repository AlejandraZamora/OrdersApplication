package beitech.test.order.application.ordersApplication.Persistence;

import beitech.test.order.application.ordersApplication.Entities.CustomerProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alejandra on 15/10/17.
 */
public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Integer> {
}
