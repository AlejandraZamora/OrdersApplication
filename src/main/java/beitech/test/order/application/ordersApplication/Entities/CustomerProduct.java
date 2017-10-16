package beitech.test.order.application.ordersApplication.Entities;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alejandra on 14/10/17.
 */
@Entity
@Table(name="customer_products")
public class CustomerProduct implements Serializable{
    public CustomerProduct(){}

    private  CustomerProductId customerProductId;
    private Product product;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
            @AttributeOverride(name = "customerId", column = @Column(name = "customer_id", nullable = false)) })
    public CustomerProductId getCustomerProductId() {
        return customerProductId;
    }

    public void setCustomerProductId(CustomerProductId customerProductId) {
        this.customerProductId = customerProductId;
    }

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
