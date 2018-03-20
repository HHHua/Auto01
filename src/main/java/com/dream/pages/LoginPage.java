/**
 * 
 */
package com.dream.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dream.config.LocalConfig;
import com.dream.framework.Locator;
import com.dream.utils.xmlUtils;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月13日
 * 功能描述：
 * 邮箱地址：15084954817@163.com
 */
public class LoginPage extends BasePage{
	//构造
	public LoginPage(WebDriver driver) throws Exception{
		//调用父类driver
		super(driver);
		//继承：调用父类方法openWeb()
		openWeb(LocalConfig.URL);
	}
	//利用locator类获取元素信息
	Locator usernameInputBox = getLocator("usernameInputBox");
	Locator passwordInputBox = getLocator("passwordInputBox");
	Locator loginBotton = getLocator("loginBotton");

	//登录成功
	public MainPage loginOperate(String name,String password) throws DocumentException{
		//调用父类的元素操作方法
		input(usernameInputBox,name);
		input(passwordInputBox,password);
		click(loginBotton);
		wait(3);
		return new MainPage(getDriver());
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	//登录失败
	public String loginFailOperate(String name,String password){
		input(usernameInputBox,name);
		input(passwordInputBox,password);
		click(loginBotton);
		wait(3);
		//登录失败的提示框处理
		String value = getAlertText();
		alertConfirm();
		return value;
	}
	
	

}
