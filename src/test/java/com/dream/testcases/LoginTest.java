package com.dream.testcases;

import org.testng.annotations.Test;

import com.dream.framework.DriverFactory;
import com.dream.pages.LoginPage;
import com.dream.pages.MainPage;
import com.dream.utils.AssertUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginTest {
	WebDriver driver;
	DriverFactory driverFactory;
	//引用断言
	AssertUtils assertUtils;
	
	@BeforeMethod
	public void setUp() {
		//初始化异常处理
		try{
		driverFactory=new DriverFactory();
		assertUtils=new AssertUtils();
		driver = driverFactory.getChromeDriver();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
  @Test
  public void LoginSuccessTest() throws Exception {
	  LoginPage lp = new LoginPage(driver);
	  MainPage mp = lp.loginOperate("admin", "123456");
	  String value = mp.getUserName();
	  assertUtils.checkStringContains(value, "admin");
  }

  @Test
  public void LoginFailTest() throws Exception {
	  LoginPage lp = new LoginPage(driver);
	  String value=lp.loginFailOperate("admin", "12345678");
	  assertUtils.checkStringContains(value, "登录失败");
  }
  
  @AfterMethod
  public void quit() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
