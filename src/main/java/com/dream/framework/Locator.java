/**
 * 
 */
package com.dream.framework;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月16日
 * 功能描述：元素定位类
 * 邮箱地址：15084954817@163.com
 */
public class Locator {
	//定义一个枚举类型
	public enum ByType{
		xpath,id,linkText,name,className,css,partiaLinkText,tagName
	}
	private String elementName;
	private String locatorInfo;
	private int timeout;
	private ByType byType;
	
	//初始化元素名称，等待时间，定位方式，元素识别信息
	public Locator(String element,int waitSec,ByType byType,String name){
		this.elementName=name;
		this.locatorInfo=element;
		this.timeout=waitSec;
		this.byType=byType;
	}
	
	public String getElementName() {
		return elementName;
	}
	public String getLocatorInfo() {
		return locatorInfo;
	}
	public int getTimeout() {
		return timeout;
	}
	public ByType getByType() {
		return byType;
	}
}
