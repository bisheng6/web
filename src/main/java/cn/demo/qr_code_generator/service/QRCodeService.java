package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.bean.QRCode;
import cn.demo.qr_code_generator.bean.User;
import cn.demo.qr_code_generator.dao.QRCodeDAO;
import cn.demo.qr_code_generator.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Set;

@Service
public class QRCodeService
{
    @Autowired
    private QRCodeDAO qrCodeDAO;

    @Autowired
    private UserService userService;

    public boolean save(String url, String label, String info, Integer type)
    {
        try
        {
            QRCode qrCode = new QRCode();
            qrCode.setDate(new Date());
            qrCode.setType(type);
            qrCode.setUrl(url);
            qrCode.setLabel(label);
            qrCode.setInfo(info);
            qrCode.setUser(userService.getUser());
            Set<QRCode> qrCodes = qrCode.getUser().getQrCodes();
            qrCodes.add(qrCode);
            qrCodeDAO.saveAll(qrCodes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Set<QRCode> getQRCodes()
    {
        User user = userService.getUser();
        return user.getQrCodes();
    }
}
