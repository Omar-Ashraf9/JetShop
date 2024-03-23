package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.Order}*/
@Value
public class OrderDto implements Serializable {
    Integer id;
    @NotNull
    CustomerDto customer;
    @NotNull
    Instant orderedAt;
    BigDecimal amount;
}