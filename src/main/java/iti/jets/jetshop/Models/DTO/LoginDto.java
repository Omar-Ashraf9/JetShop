package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.Customer}*/
@Value
public class LoginDto implements Serializable {
    @NotNull
    @Size(max = 255)
    String password;
    @NotNull
    @Size(max = 255)
    String email;
}