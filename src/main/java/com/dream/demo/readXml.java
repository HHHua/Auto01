/**
 * 
 */
package com.dream.demo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dream.framework.Locator;
import com.dream.framework.Locator.ByType;
import com.dream.utils.xmlUtils;

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月16日
 * 功能描述：读取xml元素信息****
 * 邮箱地址：15084954817@163.com
 */
public class readXml {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		HashMap<String,Locator> ls = xmlUtils.readElementInfo("LoginPage.xml");
		ls.get("usernameInputBox").getElementName();
}}









