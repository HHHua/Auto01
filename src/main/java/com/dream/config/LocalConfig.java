/**
 * 
 */
package com.dream.config;

import com.dream.utils.PropertiesUtils;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：
 * 邮箱地址：15084954817@163.com
 */
public class LocalConfig {
	static PropertiesUtils p =new PropertiesUtils("local.properties");
	public static final String URL = p.getPropertiesValue("url");
	public static final String CHROME_DRIVER_PATH=p.getPropertiesValue("chromeDriverPath");
	public static final String FIREFOX_DRIVER_PATH=p.getPropertiesValue("fireFoxDriverPath");
	public static final String SCREENSHOTPATH=p.getPropertiesValue("shotPath");
}
