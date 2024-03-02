package iti.jets.jetshop.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @NotNull
    @Column(name = "job", nullable = false)
    private String job;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "credit_limit", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @Size(max = 255)
    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @Size(max = 255)
    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @Size(max = 255)
    @NotNull
    @Column(name = "street_no", nullable = false)
    private String streetNo;

    @Size(max = 255)
    @NotNull
    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Size(max = 255)
    @NotNull
    @Column(name = "interests", nullable = false)
    private String interests;

}