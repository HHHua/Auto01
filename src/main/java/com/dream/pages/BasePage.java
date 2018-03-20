/**
 * 
 */
package com.dream.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.dream.framework.WebElementUtils;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：页面封装
 * 邮箱地址：15084954817@163.com
 */
public class BasePage extends WebElementUtils {
	
	public BasePage(WebDriver driver) throws DocumentException {
		super(driver);	
	}
	//获取网页源代码、js弹窗的问题、frame
	public String getPageSource(){
		wait(3);
		return driver.getPageSource();
	}
	public void alertConfirm(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertDisMiss(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public String getAlertText(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	public void inputAlert(String value){
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

}
