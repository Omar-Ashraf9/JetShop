package iti.jets.jetshop.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart" ,fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    public void addCartItem(Product product , Integer quantity , BigDecimal amount){
        cartItems.add(new CartItem(this,product,quantity,amount));
    }

}