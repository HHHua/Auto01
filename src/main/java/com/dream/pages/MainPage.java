/**
 * 
 */
package com.dream.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dream.framework.Locator;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月13日
 * 功能描述：
 * 邮箱地址：15084954817@163.com
 */
public class MainPage extends BasePage {
	
	public MainPage(WebDriver driver) throws DocumentException{
		super(driver);
	}
	Locator userMenu = getLocator("userMenu");
	
	public String getUserName(){
		wait(2);
		return getText(userMenu);
	}
}
