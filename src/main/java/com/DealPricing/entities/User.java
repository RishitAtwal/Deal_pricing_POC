package com.DealPricing.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_dealPricing")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_code")
    private int employeeCode;

    @Column(name = "userName")
    private String userName;

    @Column(name = "mobile_number")
    private int mobNum;

    @Column(name = "phone_number")
    private String phoneNum;

    @Column(name = "technology")
    private String technology;

    @Column(name = "designation")
    private String designation;

    @Column(name = "address")
    private String addressType;

    @Column(name = "address1")
    private String address1;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private long pinCode;

}
