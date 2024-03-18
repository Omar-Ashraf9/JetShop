package iti.jets.jetshop.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrdersItem {
    @EmbeddedId
    private OrdersItemId id;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public OrdersItem(){}
    public OrdersItem(Order order, Product product, Integer quantity, BigDecimal amount) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.id=new OrdersItemId(order.getId(),product.getId());
    }

    @NotNull
    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

}