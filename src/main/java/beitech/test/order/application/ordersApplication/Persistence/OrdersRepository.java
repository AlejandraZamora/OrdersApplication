package beitech.test.order.application.ordersApplication.Persistence;

import beitech.test.order.application.ordersApplication.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alejandra on 15/10/17.
 */
public interface OrdersRepository extends JpaRepository<Order, Long>{
}
