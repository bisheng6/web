package cn.demo.qr_code_generator.dao;

import cn.demo.qr_code_generator.bean.QRCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QRCodeDAOTest {
    @Autowired
    QRCodeDAO qrCodeDAO;

    @Test
    @Transactional
    public void test(){
        QRCode qrCode=new QRCode();
        Date date=new Date();
        qrCode.setDate(date);
        qrCode.setInfo("info");
        qrCode.setLabel("test/image");
        qrCode.setUrl("a/b/c");
        //qrCode.setUser("user");
        qrCodeDAO.save(qrCode);
        Assert.assertEquals(qrCode.getInfo(),qrCodeDAO.getOne(qrCode.getId()).getInfo());
        Assert.assertEquals(qrCode.getLabel(),qrCodeDAO.getOne(qrCode.getId()).getLabel());
        Assert.assertEquals(qrCode.getDate(),qrCodeDAO.getOne(qrCode.getId()).getDate());
        Assert.assertEquals(qrCode.getUrl(),qrCodeDAO.getOne(qrCode.getId()).getUrl());
    }
}