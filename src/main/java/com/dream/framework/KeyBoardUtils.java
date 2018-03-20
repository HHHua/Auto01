/**
 * 
 */
package com.dream.framework;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月15日
 * 功能描述：键盘封装
 * 邮箱地址：15084954817@163.com
 */
public class KeyBoardUtils {
	private Actions action;

	public KeyBoardUtils(WebDriver dr){
		action=new Actions(dr);
	}
	//循环按方向下键
	public void pressDown(int times){
		try {
			//安卓自带模拟键盘robot
			Robot robot=new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//Ctrl+v
	public void paste(){
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	}
	//Ctrl+tab
	public void ctrlTab(){
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).perform();
	}
}
