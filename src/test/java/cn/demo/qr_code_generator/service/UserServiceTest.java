package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    //@Transactional
    public void test(){
        User user=new User();
        user.setPassword("123456");
        user.setUsername("tsw");
        userService.register(user);
        //userService.getUser();
    }
}