package com.example.jwttest.jwtbase.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="FX_ROLE")
public class FXRole implements Serializable {
    private static final long serialVersionUID = -3112666718610962186L;
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ROLE_NAME",nullable = false)
    private String name;
}
