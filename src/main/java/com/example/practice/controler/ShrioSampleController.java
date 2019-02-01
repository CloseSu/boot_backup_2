package com.example.practice.controler;

import com.example.practice.service.ShiroSampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "登入測試")
public class ShrioSampleController {

    @Autowired
    private ShiroSampleService shiroSampleService;

    @ApiOperation(value = "登入" , notes = "登入方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用戶名稱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用戶密碼", required = true, dataType = "String")
    })
    @GetMapping("/login")
    public void login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
    }

    @ApiOperation(value = "logout" , notes = "登出")
    @GetMapping("/logout")
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

    @ApiOperation(value = "test read" , notes = "測試讀")
    @GetMapping("/read")
    @RequiresPermissions("read")
    public String read() {
        return this.shiroSampleService.read();
    }

    @ApiOperation(value = "test write" , notes = "測試寫")
    @GetMapping("/write")
    @RequiresPermissions("write")
    public String write() {
        return this.shiroSampleService.write();
    }
}
