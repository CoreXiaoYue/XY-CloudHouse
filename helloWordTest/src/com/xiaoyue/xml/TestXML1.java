package com.xiaoyue.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML1 {
	
	

	public static void main(String[] args) throws Exception {
		mappingJDBC();
		
	}


	public static void mappingJDBC() throws DocumentException, FileNotFoundException {
		//创建解析器对象
		SAXReader sReader=new SAXReader();
		//获取外部xml文件.,获得Document.
		Document document = sReader.read(new FileInputStream("src/student.xml"));
//		System.out.println(document);
		//获取根节点.
		Element rootElement = document.getRootElement();
		//获取根节点的属性
		
		//获取根节点名称.
		System.out.println(rootElement.getName());
		
		//获取根节点下的元素集合.
		Iterator<Element> iterator = rootElement.elementIterator();
		//遍历根节点下的节点
		while (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Attribute name = element.attribute("name");
			System.out.println(name.getName()+":"+name.getValue());
			
			Attribute table = element.attribute("table");
			System.out.println(table.getName()+":"+table.getValue());
			
			System.out.println(element.getName());
			Iterator <Element>iterator2 = element.elementIterator();
			//遍历根节点节点下的节点
			while (iterator2.hasNext()) {
				Element element2 = (Element) iterator2.next();
				System.out.println(element2.getName()+":"+element2.getText());
			}
			System.out.println("--------------------");
			
			
		}
	}

}
