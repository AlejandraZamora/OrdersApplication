package beitech.test.order.application.ordersApplication.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandra on 14/10/17.
 */
@Entity
@Table(name="product")
public class Product implements Serializable{
    public Product(){}

    private Integer productId;
    private String name;
    private Integer price;
    private List<CustomerProduct> customerProducts= new ArrayList<CustomerProduct>();

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name="name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    public List<CustomerProduct> getCustomers() {
        return customerProducts;
    }

    public void setCustomers(List<CustomerProduct> customers) {
        this.customerProducts = customers;
    }
}
