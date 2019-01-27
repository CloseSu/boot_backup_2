package com.example.practice.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

@Service
public class ShiroSampleService {

//    @RequiresPermissions("read")
    public String read(){return "reading";}
//    @RequiresPermissions("write")
    public String write(){return "writting";}
}
