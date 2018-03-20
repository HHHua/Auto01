/**
 * 
 */
package com.dream.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月15日
 * 功能描述：鼠标封装
 * 邮箱地址：15084954817@163.com
 */
public class MouseUtils {
	private Actions action;

	public MouseUtils(WebDriver dr){
		action=new Actions(dr);	
	}
	public void rightClick(WebElement e){
		action.contextClick(e).perform();
	}
	public void doubleClick(WebElement e){
		action.doubleClick(e).perform();
	}
	public void mouseHold(WebElement e){
		action.clickAndHold(e).perform();
	}
	public void Drop(WebElement e1,WebElement e2){
		action.dragAndDrop(e1, e2).perform();
	}
	public void mouseMove(WebElement e){
		action.moveToElement(e).perform();
	}
	public void clickHoldMove(WebElement e1,WebElement e2){
		action.clickAndHold(e1).moveToElement(e2).release();
	}
}
