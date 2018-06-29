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

    public String upload(Integer type, MultipartFile file, String label, String info)
    {
        QRCode qrCode = new QRCode();
        qrCode.setDate(new Date());
        qrCode.setType(type);
        qrCode.setUrl(FileUtil.saveFile(file));
        qrCode.setLabel(label);
        qrCode.setInfo(info);
        qrCode.setUser(userService.getUser());
        Set<QRCode> qrCodes = qrCode.getUser().getQrCodes();
        qrCodes.add(qrCode);
        qrCodeDAO.saveAll(qrCodes);
        return qrCode.getUrl();
    }

    public Set<QRCode> getQRCodes()
    {
        User user = userService.getUser();
        return user.getQrCodes();
    }
}
