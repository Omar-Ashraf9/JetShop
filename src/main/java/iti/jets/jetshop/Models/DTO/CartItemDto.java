package iti.jets.jetshop.Models.DTO;

import iti.jets.jetshop.Persistence.Entities.CartItemId;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link iti.jets.jetshop.Persistence.Entities.CartItem}
 */
@Value
public class CartItemDto implements Serializable {
    CartItemId id;
    ProductDto product;
    @NotNull
    Integer quantity;
    @NotNull
    BigDecimal amount;
}