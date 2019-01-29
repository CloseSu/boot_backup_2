package com.example.practice.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserRole implements Serializable {
    private static final long serialVersionUID = -5864368208538229460L;

    Integer roleId;
    String role;
}
