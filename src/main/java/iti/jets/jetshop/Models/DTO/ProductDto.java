package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.Product}*/
@Value
public class ProductDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 255)
    String productName;
    @NotNull
    Integer stockQuantity;
    @Size(max = 255)
    String productDescription;
    @NotNull
    BigDecimal productPrice;
    @NotNull
    CategoryDto category;
    List<ProductImageDto> productImages;
}