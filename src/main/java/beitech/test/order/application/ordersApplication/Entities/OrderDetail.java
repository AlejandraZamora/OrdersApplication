package beitech.test.order.application.ordersApplication.Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alejandra on 14/10/17.
 */
@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable {

    public OrderDetail(){

    }

    private static final long serialVersionUID = 8518145128362313552L;
    private Integer orderDetailId=null;
    private String productDescription=null;
    private Integer price=null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_detail_id", unique = true, nullable = false)
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    @Column(name="product_description", nullable = false)
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Column(name="price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
