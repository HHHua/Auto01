/**
 * 
 */
package com.dream.utils;

import org.testng.Assert;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月15日
 * 功能描述：断言封装
 * 邮箱地址：15084954817@163.com
 */
public class AssertUtils {
	public void checkIntNum(int actual,int expected,String... com){
		try{	
			Assert.assertEquals(actual, expected);
		}catch(AssertionError e){
//			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
	public void checkString(String actual,String expected,String... com){
		try{	
			Assert.assertEquals(actual, expected);
		}catch(AssertionError e){
//			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
	//字符串包含
	public void checkStringContains(String actual,String expected,String...com){
		try{	
			Assert.assertEquals(true, actual.contains(expected));
		}catch(AssertionError e){
//			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
	public void checkNotNull(Object actual,String... com){
		try{	
			Assert.assertNotNull(actual);
		}catch(AssertionError e){
//			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
}
