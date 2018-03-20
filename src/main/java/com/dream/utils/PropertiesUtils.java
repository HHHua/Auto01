/**
 * 
 */
package com.dream.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：读取properties文件封装
 * 邮箱地址：15084954817@163.com
 */
public class PropertiesUtils {
	private static Properties properties=null;
	private static String propertiesFileName = null;
	//构造方法传入文件路径
	public PropertiesUtils(String path){
		this.propertiesFileName=path;
	}
	//取出文件内容
	public String getPropertiesValue(String key){
		String value=null;
		properties = new Properties();
		//文件的绝对路径
		String path = System.getProperty("user.dir")+"/configs/"+this.propertiesFileName;
		FileInputStream in;
		try {
			in = new FileInputStream(path);
			properties.load(in);
			value = properties.getProperty(key);
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return value;
	}

}
