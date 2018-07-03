package cn.demo.qr_code_generator.service;

import cn.demo.qr_code_generator.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService
{
    public String upload(int type, MultipartFile file)
    {
        // TODO: 2018/7/2 部署到服务器需要修改
        String url = "127.0.0.1:8080";

        // 根路径应该放到.class所在的文件夹
        String rootPath = "target/classes/static";
        String filePath = "/upload/" + System.currentTimeMillis() + file.getOriginalFilename();
        FileUtil.saveFile(file, new File(rootPath, filePath));
        switch (type)
        {
            case 1:
                url += filePath;
                break;
            case 2:
            case 3:
                url += "/player?type=" + type + "&path=" + filePath;
                break;
            default:
                System.out.println("error");
                break;
        }
        return url;
    }
}
