package iti.jets.jetshop.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotNull
    @Column(name = "ordered_at", nullable = false)
    private Instant orderedAt;

    @OneToMany(mappedBy = "order" ,fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private Set<OrdersItem> ordersItems = new LinkedHashSet<>();


    public void addOrderItem(Product product , Integer quantity , BigDecimal amount){
        ordersItems.add(new OrdersItem(this,product,quantity,amount));
    }

//    public void removeOrderItem(OrdersItem ordersItem){
//        ordersItems.remove(ordersItem);
//        ordersItem.setOrder(null);
//    }
}