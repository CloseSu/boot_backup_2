package com.example.practice.controllerTest;

import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LogTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private String username = "admin";
    private String password = "123";

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).
                  addFilters((Filter) webApplicationContext.getBean("shiroFilter")).build();

        String loginUrl = "http://localhost:8080/login?username=+"+ username + "&password=" + password;
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(loginUrl)).andReturn();
            System.out.println(result.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPer() {
       String readUrl = "http://localhost:8080/read";
       try {
           MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(readUrl)).andReturn();
           System.out.println(result.getResponse().getStatus());
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
}
