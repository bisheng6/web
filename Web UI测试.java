package com.etyero.testcase;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class WebDriverDemo {
	private WebDriver driver;
	private String baseUrl = "http://www.svortex.top/login";
	private StringBuffer verificationErrors = new StringBuffer();
 
	@BeforeMethod
	public void setUp() throws Exception {
		String browserDriverUrl = "D:/work/workplace/webUITest/browserDriver/chromedriver.exe";// 浏览器驱动路径
		//启动chrome浏览器
		System.setProperty("webdriver.chrome.driver", browserDriverUrl);
		driver = new ChromeDriver();
		driver.manage().window().maximize();// 最大化浏览器
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//设置操作超时时长，该设置是全局性的，即所有操作都最长等待30s
 
	}
 
	@Test
	/**
	 * 搜索selenium
	 * 
	 * */
	public void testLogin() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();// 按id找到元素后，清空该元素
		driver.findElement(By.name("username")).sendKeys("halomoto");// 输入selenium
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("allisfine");
		driver.findElement(By.className("sign-in")).click(); //点击搜索按钮
	}
 
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
