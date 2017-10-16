package beitech.test.order.application.ordersApplication.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.loader.plan.build.internal.LoadGraphLoadPlanBuildingStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by alejandra on 14/10/17.
 */
@Entity
@Table(name="`order`")
public class Order implements Serializable{

    public Order(){}

    private Integer orderId;
    private Customer customer;
    private Integer deliveryAddress;
    private Calendar creationDate;
    private List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name="delivery_address")
    public Integer getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Integer deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Column(name = "creation_date", nullable = false, length = 19)
    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetail(OrderDetail orderDetail){
        this.orderDetails.add(orderDetail);
    }
}

