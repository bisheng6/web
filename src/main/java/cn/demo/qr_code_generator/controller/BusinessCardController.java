package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.bean.BusinessCard;
import cn.demo.qr_code_generator.service.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BusinessCardController
{
    @Autowired
    private BusinessCardService businessCardService;

    @RequestMapping(value = "/businesscard", method = RequestMethod.GET)
    public String getBusinessCardById(Model model, int id)
    {
        System.out.println(id);
        BusinessCard businessCard = businessCardService.getBusinessCard(id);
        model.addAttribute(businessCard);
        // TODO: 2018/6/18 返回到一个页面
        return null;
    }
}
