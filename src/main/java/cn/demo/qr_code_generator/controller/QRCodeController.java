package cn.demo.qr_code_generator.controller;

import cn.demo.qr_code_generator.bean.QRCode;
import cn.demo.qr_code_generator.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class QRCodeController
{
    @Autowired
    private QRCodeService qrCodeService;

    @RequestMapping(value = "/qrcode", method = RequestMethod.GET)
    public String getQRCodes(Model model)
    {
        Set<QRCode> qrCodes = qrCodeService.getQRCodes();
        model.addAttribute("qrCodes", qrCodes);
        return "ucenter";
    }

    @RequestMapping(value = "/qrcode", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestParam("content") String url,
                       @RequestParam("label") String label,
                       @RequestParam("text") String info,
                       @RequestParam("type") Integer type)
    {
        return qrCodeService.save(url, label, info, type) ? "ok" : "error";
    }
}
