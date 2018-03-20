/**
 * 
 */
package com.dream.demo;

import com.dream.utils.PropertiesUtils;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月14日
 * 功能描述：
 * 邮箱地址：15084954817@163.com
 */
public class read {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertiesUtils p =new PropertiesUtils("local.properties");
		String url = p.getPropertiesValue("url");
		System.out.println(url);
	}

}
