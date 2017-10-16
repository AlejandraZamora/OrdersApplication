package beitech.test.order.application.ordersApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by alejandra on 14/10/17.
 */

@SpringBootApplication
@EnableJpaRepositories("beitech.test.order.application.ordersApplication.Persistence")
//@EntityScan("beitech.test.order.application.ordersApplication.Entities")
public class OrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}
}
