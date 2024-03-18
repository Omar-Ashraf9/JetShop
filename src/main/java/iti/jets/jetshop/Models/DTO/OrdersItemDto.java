package iti.jets.jetshop.Models.DTO;

import iti.jets.jetshop.Persistence.Entities.OrdersItemId;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.OrdersItem}*/
@Value
public class OrdersItemDto implements Serializable {
    OrdersItemId id;

    @NotNull
    Integer quantity;
    @NotNull
    BigDecimal amount;
}