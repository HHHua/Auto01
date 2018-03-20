/**
 * 
 */
package com.dream.framework;

import java.io.IOException;
import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dream.framework.Locator.ByType;
import com.dream.utils.xmlUtils;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：元素操作封装
 * 邮箱地址：15084954817@163.com
 */
public class WebElementUtils extends DriverUtils{
	protected HashMap<String,Locator> locatorMap;
	protected String path;

	public WebElementUtils(WebDriver driver) throws DocumentException {
		super(driver);
		path=System.getProperty("user.dir")+"/webelementdata/"+this.getClass().getSimpleName()+".xml";
		locatorMap=xmlUtils.readElementInfo(path);
	}

	public WebElement getElement(Locator locator){
		WebElement el = null;
		ByType type=locator.getByType();
		try{
		switch(type){
		case id:
			el = driver.findElement(By.id(locator.getLocatorInfo()));
			break;
		case name:
			el = driver.findElement(By.name(locator.getLocatorInfo()));
			break;
		case css:
			el = driver.findElement(By.cssSelector(locator.getLocatorInfo()));
			break;
		case xpath:
			el = driver.findElement(By.xpath(locator.getLocatorInfo()));
			break;
		}}catch(Exception e){
			try {
				takeScreenShot("findElementErrorImage");
				log.info("元素："+locator.getElementName()+" 识别异常！");
				Assert.fail("查找元素异常，退出当前测试用例");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		return el;
	}
	public WebElement findElement(final Locator locator){
		WebDriverWait wait = new WebDriverWait(driver,locator.getTimeout());
		WebElement el = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return getElement(locator);
			}
		});
		return el;
	}
	public void click(Locator locator){
		WebElement e = findElement(locator);
		e.click();
	}
	public void input(Locator locator,String content){
		WebElement e = findElement(locator);
		e.sendKeys(content);
	}
	public void submit(Locator locator){
		WebElement e = findElement(locator);
		e.submit();
	}
	public String getText(Locator locator){
		WebElement e = findElement(locator);
		log.info("获取元素： "+locator.getElementName()+" 文本值");
		return e.getText();
	}
	public String getAttribute(Locator locator,String attribute){
		WebElement e = findElement(locator);
		return e.getAttribute(attribute);
	}
	protected Locator getLocator(String locatorName){
		Locator locator = locatorMap.get(locatorName);
		return locator;
	}
}
