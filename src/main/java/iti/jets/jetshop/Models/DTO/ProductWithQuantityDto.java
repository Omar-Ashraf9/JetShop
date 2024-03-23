package iti.jets.jetshop.Models.DTO;

import iti.jets.jetshop.Persistence.Entities.Product;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Value
@Data
public class ProductWithQuantityDto implements Serializable {

    int productId;
    String productName;
    BigDecimal productPrice;
    String productDescription;
    String productImage;
    Integer productQuantity;

}
