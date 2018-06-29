package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.bean.BusinessCard;
import cn.demo.qr_code_generator.service.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BusinessCardController
{
    @Autowired
    private BusinessCardService businessCardService;

    @RequestMapping(value = "/businessCard", method = RequestMethod.GET)
    public String getBusinessCardById(Model model, int id)
    {
        System.out.println(id);
        BusinessCard businessCard = businessCardService.getBusinessCard(id);
        model.addAttribute(businessCard);
        return "card";
    }

    @RequestMapping(value = "/businessCard", method = RequestMethod.POST)
    @ResponseBody
    public Integer saveBusinessCard(BusinessCard businessCard)
    {
        businessCardService.save(businessCard);
        return businessCard.getId();
    }
}
