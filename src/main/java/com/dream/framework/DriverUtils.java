/**
 * 
 */
package com.dream.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dream.utils.Log;
import com.first.config.LocalConfig;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：浏览器操作封装
 * 邮箱地址：15084954817@163.com
 */

public class DriverUtils {
	//protected后面的类都可以用
	protected WebDriver driver;
	//创建鼠标对象
	protected static MouseUtils mouse;
	protected static KeyBoardUtils keyBoard;
	protected static Log log=new Log(DriverUtils.class);
	
	public DriverUtils(WebDriver driver){
		this.driver=driver;
		//引用MouseUtils类
		this.mouse=new MouseUtils(driver);
		this.keyBoard=new KeyBoardUtils(driver);
	}
	
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址："+url);
	}
	
	public void back(){
		driver.navigate().back();
	}
	
	public void forward(){
		driver.navigate().forward();
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	public void quit(){
		driver.quit();
		log.info("退出浏览器！");
	}
	public void close(){
		driver.close();
	}
	public void wait(int s){
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void takeScreenShot(String...pngName) throws IOException{
		String fileName;
		String filePath=LocalConfig.SCREENSHOTPATH;
		File file=new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		if(pngName.length==0){
			fileName="shotImage";
		}else{
			fileName=pngName[0];
		}
		SimpleDateFormat sf=new SimpleDateFormat("yyyy_MM_dd_HH");
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		String dateStr=sf.format(date);
		String path="\\"+filePath+"\\"+fileName+"_"+date+"\\"+dateStr;
		takeScreenShot(driver,path);
	}
	public  void takeScreenShot(WebDriver drivername, String path) {
		String currentPath=System.getProperty("user.dir");
		File scrFile=((TakesScreenshot)drivername).getScreenshotAs(OutputType.FILE);
		File picFile=new File(currentPath+path);
		try {
			FileUtils.copyFile(scrFile,picFile);
			log.info("截图成功，图片保存路径为： "+currentPath+path);
		} catch (IOException e) {
			log.error("截图失败");
		}
		log.screenShotLog("截图："+scrFile, picFile);
	}
}
