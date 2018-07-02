package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.bean.QRCode;
import cn.demo.qr_code_generator.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class QRCodeController
{
    @Autowired
    private QRCodeService qrCodeService;

    @RequestMapping(value = "/qrcode", method = RequestMethod.GET)
    public String getQRCodes()
    {
        Set<QRCode> qrCodes = qrCodeService.getQRCodes();
        return null;
    }

    @RequestMapping(value = "/qrcode", method = RequestMethod.POST)
    public String save(@RequestParam("content") String url,
                       @RequestParam("label") String label,
                       @RequestParam("text") String info)
    {
        return qrCodeService.save(url, label, info) ? "ok" : "error";
    }
}
