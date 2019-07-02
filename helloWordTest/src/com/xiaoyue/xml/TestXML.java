package com.xiaoyue.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML {

	public static void main(String[] args) throws Exception {
		getXML();

	}

	public static void getXML() throws Exception {
		SAXReader sr = new SAXReader();
		Document document = sr.read(new File("src/afsql-mapping.xml"));
//		System.out.println(document);
		//获取根元素
		Element rootElement = document.getRootElement();
		System.out.println("根节点："+rootElement.getName());
		//根元素下的子元素
		Iterator<?>elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			//取出元素
			Element next = (Element) elementIterator.next();
			//
			System.out.println("元素节点："+next.getName());
			Attribute name= next.attribute("name");
			Attribute table = next.attribute("table");
			System.out.println("元素节点属性"+name.getName()+" :"+name.getValue());
			System.out.println("元素节点属性"+table.getName()+":"+table.getValue());
			//获取property元素节点
			 Element element = next.element("property");
			 //获取所有property节点
			 List<Element> elements = next.elements();
			 for (Element object : elements) {
					Attribute name1 = object.attribute("name");
					Attribute type = object.attribute("type");
					Attribute generated = object.attribute("generated");
					System.out.println(name1.getName()+"="+name1.getText());
					System.out.println(type.getName()+"="+type.getValue());
					System.out.println(generated.getName()+"="+generated.getText());
					System.out.println("==============================");
			}

			
		}
	}

}
