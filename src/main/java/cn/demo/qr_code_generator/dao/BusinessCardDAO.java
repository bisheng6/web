package cn.demo.qr_code_generator.dao;

import cn.demo.qr_code_generator.bean.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCardDAO extends JpaRepository<BusinessCard, Integer>
{
    BusinessCard findByNameAndCompany(String name, String company);
}
