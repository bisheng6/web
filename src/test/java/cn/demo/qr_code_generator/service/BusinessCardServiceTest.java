package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.BusinessCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCardServiceTest {
    @Autowired
    BusinessCardService businessCardService;

    @Test
    @Transactional
    public void setBusinessCardService_test() throws Exception{
        BusinessCard businessCard=new BusinessCard();
        businessCard.setAddress("china");
        businessCard.setCompany("xidian");
        //businessCard.setId(1);
        businessCard.setEmail("tsw@163.com");
        businessCard.setName("tsw");
        businessCard.setDepartment("IT");
        businessCard.setTelephone("1234567");
        businessCardService.save(businessCard);
        Assert.assertEquals("china",businessCardService.getBusinessCard(businessCard.getId()).getAddress());
        Assert.assertEquals("tsw@163.com",businessCardService.getBusinessCard(businessCard.getId()).getEmail());
        Assert.assertEquals("IT",businessCardService.getBusinessCard(businessCard.getId()).getDepartment());
    }
}