package com.example.OnlineBankingWebAppSpringMVC.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "bank_account")
public class Admin {
    @NotEmpty
    @Column(name = "User_ID")
    private String userID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "Account_ID")
    private int accID;
    @NotEmpty
    @Column(name = "Account_Type")
    private String accType;
    @NotEmpty
    private String name;
    @Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message="Please enter valid Email")
    private String email;
    @NotEmpty
    @Column(name = "Mobile_Number")
    private String mobileNo;
    @NotEmpty
    private String address;
    @NotEmpty
    private String panCard;
    @NotEmpty
    private String question;
    @NotEmpty
    private String answer;
    @Column(name = "Balance")
    @NotNull
    private int accBal;
    @NotNull
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Past
    @Column(name = "Open_Date")
    private Date openDate;
    @NotEmpty
    @Size(min = 6,max = 15)
    @Pattern(regexp = "\\S+", message = "Spaces are not allowed")
    private String password;
}
