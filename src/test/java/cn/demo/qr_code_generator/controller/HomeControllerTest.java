package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.QrCodeGeneratorApplication;
import cn.demo.qr_code_generator.bean.QRCode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = QrCodeGeneratorApplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public  void setup()
    {
        //this.mvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test1 () throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(MockMvcResultMatchers.status().isOk());
        //mvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }

    @Test
    public void test2() throws Exception
    {
        //mvc.perform(MockMvcRequestBuilders.post("/register"));
    }

}