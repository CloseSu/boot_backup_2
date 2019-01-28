package com.example.practice.enums;

public enum UserRoleEnum {
    ADMIN(0,"admin"),
    GUEST(1, "guest");


    private Integer roleId;
    private String role;

    UserRoleEnum(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }
}
