package iti.jets.jetshop.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotNull
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Size(max = 255)
    @Column(name = "product_description")
    private String productDescription;

    @NotNull
    @Column(name = "product_price", nullable = false, precision = 15, scale = 2)
    private BigDecimal productPrice;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OrdersItem> ordersItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductImage> productImages = new LinkedList<>();

    public void addProductImage(String imgPath) {
        ProductImage productImage = new ProductImage(this, imgPath);
        productImages.add(productImage);
    }
}