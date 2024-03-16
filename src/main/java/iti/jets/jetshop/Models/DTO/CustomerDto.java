package iti.jets.jetshop.Models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**

 DTO for {@link iti.jets.jetshop.Persistence.Entities.Customer}*/
@Value
public class CustomerDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 255)
    String customerName;
    @NotNull
    Date birthday;
    @NotNull
    @Size(max = 255)
    String password;
    @NotNull
    @Size(max = 255)
    String job;
    @NotNull
    @Size(max = 255)
    String email;
    BigDecimal creditLimit;
    @NotNull
    @Size(max = 255)
    String city;
    @NotNull
    @Size(max = 255)
    String country;
    @NotNull
    @Size(max = 255)
    String streetName;
}