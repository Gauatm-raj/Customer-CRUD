package com.customer.customer_details.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contact")
@Data
public class Contact {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String firstName;
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;

    @JsonIgnore
    @ManyToOne
    private User user;
}
