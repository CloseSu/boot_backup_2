package com.example.practice.entity;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 2372642699588340536L;
    Integer userId;
    String username;
    String password;
    String roleIds;
    String perIds;
}
