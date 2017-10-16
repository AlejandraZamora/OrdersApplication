package beitech.test.order.application.ordersApplication.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alejandra on 14/10/17.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    public Customer() {
    }

    private Integer customerId;
    private String name;
    private String email;

    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
