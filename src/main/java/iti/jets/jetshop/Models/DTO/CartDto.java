package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link iti.jets.jetshop.Persistence.Entities.Cart}
 */
@Value
public class CartDto implements Serializable {
    Integer id;
    @NotNull
    CustomerDto customer;
    Set<CartItemDto> cartItems;
}