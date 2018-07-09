package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService
{
    @Value("${server.name}")
    private String serverName;

    public String upload(int type, MultipartFile file)
    {
        String url = null;

        String rootPath = "target/classes/static";
        String filePath = "/upload/" + System.currentTimeMillis() + file.getOriginalFilename();
        FileUtil.saveFile(file, new File(rootPath, filePath));
        switch (type)
        {
            case 1:
                url = serverName + filePath;
                break;
            case 2:
            case 3:
                url = serverName + "/player?type=" + type + "&path=" + filePath;
                break;
            default:
                System.out.println("error");
                break;
        }
        return url;
    }
}
