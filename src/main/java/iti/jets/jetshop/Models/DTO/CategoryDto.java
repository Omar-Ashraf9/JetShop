package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.Category}*/
@Value
public class CategoryDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 255)
    String categoryName;
}