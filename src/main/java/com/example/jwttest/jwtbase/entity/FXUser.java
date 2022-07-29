package com.example.jwttest.jwtbase.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="FX_USER")
public class FXUser implements Serializable {
    private static final long serialVersionUID = 4517281710313312135L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_NAME",nullable = false)
    private String name;

    @Column(name = "USER_PASSWORD",nullable = false)
    private String password;

    @Transient
    private List<String> roles;
}
