package com.example.jwttest.jwtbase.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="FX_USER_ROLE")
@IdClass(FXUserRole.class)
public class FXUserRole implements Serializable {
    private static final long serialVersionUID = 6746672328835480737L;
    @Id
    @Column(name = "USER_ID",nullable = false)
    private Integer userId;

    @Id
    @Column(name = "ROLE_ID",nullable = false)
    private Integer roleId;
}
