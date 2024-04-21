package com.customers.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Getter
@Setter
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cname;
    private String lname;
    private Integer AccountNumber;
    private String email;
    private String phone;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date updatedDate;

    public Long getId() {
        return this.id;
    }
}
