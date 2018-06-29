package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.BusinessCard;
import cn.demo.qr_code_generator.dao.BusinessCardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCardService
{
    @Autowired
    private BusinessCardDAO businessCardDAO;

    public BusinessCard getBusinessCard(int id)
    {
        return businessCardDAO.getOne(id);
    }

    // TODO: 2018/6/29 设置服务端mysql数据库
    public void save(BusinessCard businessCard)
    {
        businessCardDAO.save(businessCard);
    }
}
