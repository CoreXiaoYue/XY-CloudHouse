package com.xiaoyue.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Test5 {
	static int a=1;
	
	public static void main(String[] args) throws IOException {
	
		
		
		//生成Document对象,文档对象..
		Document document = DocumentHelper.createDocument();
//		document.addElement("books").addElement("class").addAttribute("name", "book");
		//添加根节点
		Element root = document.addElement("beans");
		//添加子元素
		Element book = root.addElement("class");
		//添加子元素属性
		book.addAttribute("name", "book");
		book.addAttribute("table", "tb_book");
		//在子元素下添加元素property
		Element property1 = book.addElement("property");
		//property元素添加属性name,type.
		property1.addAttribute("name", "id");
		property1.addAttribute("type", "java.lang.Integer");
		
		//在子元素下添加元素property
		Element property2 = book.addElement("property");
		property2.addAttribute("name", "name");
		property2.addAttribute("type", "java.lang.String");
		
		Element property3 = book.addElement("property");
		property3.addAttribute("name", "author");
		property3.addAttribute("type", "java.lang.String");
		
		Element property4 = book.addElement("property");
		property4.addAttribute("name", "price");
		property4.addAttribute("type", "java.lang.Double");
		
//		Element name = book.addElement("name");
//		Element author = book.addElement("author");
//		id.setText("1");
//		name.setText("java学习指南");
//		author.addText("shaofa");
		//创建输出流
		OutputFormat outputFormat=OutputFormat.createPrettyPrint();//格式化输出xml文件
		Writer writer=new FileWriter("src/books1.xml");//关联输出文件抽象路径
		XMLWriter writer2 = new XMLWriter(writer, outputFormat);//包装格式化对象和文件流.
	
		writer2.write(document);//输出文件
		//关闭流
		writer.close();
	}
}
