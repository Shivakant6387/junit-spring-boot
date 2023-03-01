package com.example.microservicesaccounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String firstName;
    private String lastName;
    private BigInteger accountNumber;
    private BigInteger phoneNumber;
    private String address;
    private String district;
    private String state;
}
