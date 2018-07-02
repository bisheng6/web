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
//        System.out.println(id);
        BusinessCard businessCard = businessCardService.getBusinessCard(id);
        model.addAttribute(businessCard);
        return "card";
    }

    @RequestMapping(value = "/businesscard", method = RequestMethod.POST)
    public String saveBusinessCard(Model model, BusinessCard businessCard)
    {
        businessCardService.save(businessCard);
        // TODO: 2018/7/2 部署服务器时修改
        String url = "127.0.0.1:8080/businesscard?id=" + businessCard.getId();
        model.addAttribute("url", url);
        model.addAttribute("type", 4);
        return "main";
    }

    @RequestMapping(value = "/cardInfo", method = RequestMethod.GET)
    public String cardInfo()
    {
        return "cardInfo";
    }
}
