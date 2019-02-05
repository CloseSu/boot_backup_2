package com.example.practice.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

@SpringBootTest
@WebAppConfiguration
public class LogTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private String username = "admin";
    private String password = "123";

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).
                addFilters((Filter) webApplicationContext.getBean("shiroFilter")).build();
    }


    @Test
    public void testLogin() {
        String loginUrl = "http://localhost:8080/login?username=+" + username + "&password=" + password;
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(loginUrl)).andReturn();
            System.out.println(result.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
