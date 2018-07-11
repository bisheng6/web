package com.etyero.testcase;

import java.util.concurrent.TimeUnit;

import cn.demo.qr_code_generator.QrCodeGeneratorApplication;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.Before;
import org.junit.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = QrCodeGeneratorApplication.class)
public class SQL_test {

    private WebDriver driver;
    private String baseUrl = "http://www.svortex.top/login";
    private StringBuffer verificationErrors = new StringBuffer("");

    @Before
    public void setUp() throws Exception {
        String browserDriverUrl = "chromedriver.exe";// 浏览器驱动路径
        System.setProperty("webdriver.chrome.driver", browserDriverUrl);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//设置操作超时时长，该设置是全局性的，即所有操作都最长等待30s
        driver.manage().window().maximize();// 最大化浏览器
    }

    @Test
    public void test()
    {
        driver.get(baseUrl);
        driver.findElement(By.name("username")).sendKeys("1'#");
        driver.findElement(By.name("username")).sendKeys("123456"); //错误的密码
        driver.findElement(By.className("sign-in")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        System.out.println(verificationErrorString);
        if (!"".equals(verificationErrorString)) {
            System.out.println("test");
            Assert.fail(verificationErrorString);
        }
    }
}
