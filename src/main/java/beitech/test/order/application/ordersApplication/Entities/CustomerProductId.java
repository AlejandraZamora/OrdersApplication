package beitech.test.order.application.ordersApplication.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by alejandra on 15/10/17.
 */
@Embeddable
public class CustomerProductId implements Serializable {

    private static final long serialVersionUID = 3237914100408508473L;
    private Integer productId;
    private Integer customerId;

    public CustomerProductId(){}

    public CustomerProductId(Integer productId, Integer customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    @Column(name = "producto_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "customer_id", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof CustomerProductId))
            return false;
        CustomerProductId castOther = (CustomerProductId) other;

        return (this.getProductId() == castOther
                .getProductId())
                && (this.getCustomerId() == castOther.getCustomerId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getProductId();
        result = 37 * result + this.getCustomerId();
        return result;
    }
}

