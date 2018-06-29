package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.bean.QRCode;
import cn.demo.qr_code_generator.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
public class QRCodeController
{
    @Autowired
    private QRCodeService qrCodeService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("type") Integer type, @RequestParam("file") MultipartFile file,
                         @RequestParam("label") String label, @RequestParam("info") String info)
    {
        return qrCodeService.upload(type, file, label, info);
    }

    @RequestMapping(value = "/qrCode", method = RequestMethod.GET)
    public String getQRCodes()
    {
        Set<QRCode> qrCodes = qrCodeService.getQRCodes();
        return null;
    }
}
