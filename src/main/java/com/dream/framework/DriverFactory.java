/**
 * 
 */
package com.dream.framework;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.dream.config.LocalConfig;
import com.dream.utils.Log;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：驱动封装
 * 邮箱地址：15084954817@163.com
 */
public class DriverFactory {
	//设置日志监听
	private static Log log = new Log(DriverFactory.class);
	public static WebDriver getDriver(){
		return getDriver("chrome");
	}
	private static WebDriver getDriver(String driverType) {
		WebDriver driver=null;
		if(driverType.equalsIgnoreCase("chrome")){
			driver=getChromeDriver();
		}else if(driverType.equalsIgnoreCase("firefox")){
			driver = getFirefoxDriver();
		}else if(driverType.equalsIgnoreCase("ie")){
//			driver = getIeDriver();
		}
		return driver;
	}
	private static WebDriver driver;
	static Runtime runtime=Runtime.getRuntime();
	public static WebDriver getChromeDriver(){
		//杀掉开启的浏览器
//		try {
//			runtime.exec("taskkill /F /IM chrome.exe");
//			log.info("杀死chrome浏览器进程成功");
//		} catch (IOException e) {
//			log.error("杀死chrome浏览器进程失败");
//			e.printStackTrace();
//		}
		System.setProperty("webdriver.chrome.driver", LocalConfig.CHROME_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities =DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		options.addArguments("--test-type","--start-maximized");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return  driver;
	}
	private static WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", LocalConfig.FIREFOX_DRIVER_PATH);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
