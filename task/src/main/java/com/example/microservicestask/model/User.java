package com.example.microservicestask.model;

import lombok.*;


import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_Task")
public class User {

    private  String firstName;
    private String lastName;
    private String  emailAddress;
    @Id
    @GeneratedValue
    private int id;

    private Integer PhoneNumber;


}
