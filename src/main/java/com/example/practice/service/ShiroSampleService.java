package com.example.practice.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

@Service
public class ShiroSampleService {

    public String read() {
        return "reading";
    }

    public String write() {
        return "writting";
    }
}
