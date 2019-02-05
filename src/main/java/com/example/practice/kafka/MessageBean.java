package com.example.practice.kafka;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MessageBean implements Serializable {
    private static final long serialVersionUID = -8175713374890395837L;
    private String uuid;
    private Date date;
}
