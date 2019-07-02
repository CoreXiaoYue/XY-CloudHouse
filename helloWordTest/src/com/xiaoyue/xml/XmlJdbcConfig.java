package com.xiaoyue.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.activation.MailcapCommandMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlJdbcConfig {
	private static JdbcPojo jdbcPojo;
	private static Map<String, String> map;
	

	public static Map<String, String> getMap() {
		return map;
	}
	public static JdbcPojo getJdbcPojo() {
		return jdbcPojo;
		
		
	}
	public XmlJdbcConfig(){
		try {
			jdbcMapping();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
//		jdbcMapping();
//		Set<String> keySet = map.keySet();
//		Iterator<String> iterator = keySet.iterator();
//		while (iterator.hasNext()) {
//			String string = (String) iterator.next();
//			System.out.println(map.get(string));
//			
//		}
	
//		System.out.println(jdbcPojo);
		
	}


	public static void jdbcMapping() throws DocumentException, FileNotFoundException {
		SAXReader sReader=new SAXReader();
		//获取外部xml文件.,获得Document.
		Document document = sReader.read(new FileInputStream("src/jdbc.xml"));
//		System.out.println(document);
		//获取根节点.
		Element rootElement = document.getRootElement();//<sql-jdbc>
//		System.out.println(rootElement.getName());
		//获取根节点下的元素节点
		Iterator<Element> element = rootElement.elementIterator();
		//遍历根节点下的节点
		jdbcPojo = new JdbcPojo();
		List<String> list=new ArrayList<String>();
		map= new HashMap<String, String>();
		while (element.hasNext()) {
			Element element2 = (Element) element.next();//<jdbc-mapping>
//			System.out.println(element2.getName());
			//获取element2节点下的元素
			Iterator<Element> elementIterator = element2.elementIterator();
			//遍历根节点下节点下的节点
			while (elementIterator.hasNext()) {
				Element element3 = (Element) elementIterator.next();
//				System.out.println(element3.getName()+":"+element3.getText());
				map.put(element3.getName(), element3.getText());
			}
			
		}
//		System.out.println(map.size());
		
	}

}
