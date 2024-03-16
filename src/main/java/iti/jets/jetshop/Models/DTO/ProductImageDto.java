package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.ProductImage}*/
@Value
public class ProductImageDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 255)
    String imageUrl;
}