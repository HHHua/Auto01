/**
 * 
 */
package com.dream.utils;

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

/**
 * @author 罗宝兰
 * @version 1.0.0
 * 创建时间：2018年3月16日
 * 功能描述：读取元素信息xml
 * 邮箱地址：15084954817@163.com
 */
public class xmlUtils {
	public static HashMap<String,Locator> readElementInfo(String filePath) throws DocumentException{
		//定义一个map集合，存放元素数据信息
		Map<String,Locator> elementInfos=new HashMap<String,Locator>();
		//dom4j读取xml
		SAXReader saxReader=new SAXReader();
		Document document=saxReader.read(new File(filePath));
		//读取根节点
		Element root=document.getRootElement();
		//读取根节点的子节点
		List<Element> childList=root.elements("locator");
		for(Element e:childList){
			//元素的识别信息
			String value = e.attributeValue("value").toString();
			int timeOut = Integer.parseInt(e.attributeValue("timeout"));
			String name = e.attributeValue("name").toString();
			//定位方式，枚举类型处理
			String type = e.attributeValue("type").toString();
			Locator locator = new Locator(value,timeOut,getType(type),name);
			String keyName=e.getText();
			elementInfos.put(keyName, locator);
		}
		return (HashMap<String, Locator>) elementInfos;
	}
	//返回枚举类型数据
	public static ByType getType(String value){
		ByType type = null;
		switch(value){
		case "css":
			type = ByType.css;
			break;
		case "xpath":
			type = ByType.xpath;
			break;
		}
		return type;
	}
}
