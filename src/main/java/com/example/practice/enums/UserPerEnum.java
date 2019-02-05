package com.example.practice.enums;

public enum UserPerEnum {
    READ(0, "read"),
    WRITE(1, "write");

    Integer perId;
    String permision;

    UserPerEnum(Integer perId, String permision) {
        this.perId = perId;
        this.permision = permision;
    }
}
