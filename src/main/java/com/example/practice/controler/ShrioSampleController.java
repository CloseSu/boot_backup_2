package com.example.practice.controler;

import com.example.practice.service.ShiroSampleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShrioSampleController {

    @Autowired
    private ShiroSampleService shiroSampleService;

    @GetMapping("/login")
    public void login(String username, String password) {
        System.out.println(username + " " + password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        System.out.println(token);
    }

    @GetMapping("/logout")
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

    @GetMapping("/read")
    @RequiresPermissions("read")
    public String read() {
        return this.shiroSampleService.read();
    }

    @GetMapping("/write")
    @RequiresPermissions("write")
    public String write() {
        return this.shiroSampleService.write();
    }
}
