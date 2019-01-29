package com.example.practice.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserPermission implements Serializable {
    private static final long serialVersionUID = -2526704321249491125L;
    Integer perId;
    String permission;
}
