package cn.demo.qr_code_generator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {
    @Autowired
    FileService fileService;

    @Test
    public void test()
    {
        File file=new File("Task5.md");
        fileService.upload(3,null);
    }
}