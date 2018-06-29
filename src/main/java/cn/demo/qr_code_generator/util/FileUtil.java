package cn.demo.qr_code_generator.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil
{
    public static String saveFile(MultipartFile file)
    {
        // TODO: 2018/6/29 上传服务器时修改文件路径
        String rootPath = "D:/Learn/Document/Document/Web工程";
        String filePath = "/upload" + file.getOriginalFilename();
        File newFile = new File(rootPath + filePath);
        try
        {
            newFile.createNewFile();
            file.transferTo(newFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return filePath;
    }
}
