package cn.demo.qr_code_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class QrCodeGeneratorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(QrCodeGeneratorApplication.class, args);
    }
}
