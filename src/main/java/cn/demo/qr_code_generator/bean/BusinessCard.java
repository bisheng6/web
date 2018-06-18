package cn.demo.qr_code_generator.bean;

import javax.persistence.*;

@Entity
@Table
public class BusinessCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String telephone;
    private String email;
    private String company;
    private String department;
    private String position;
    private String address;
    private String signature;
    private String avatarurl;
}
