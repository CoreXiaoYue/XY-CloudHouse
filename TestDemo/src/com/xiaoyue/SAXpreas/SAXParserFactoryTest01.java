package com.xiaoyue.SAXpreas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserFactoryTest01 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// 1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2、从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3、加载文档 Document 注册处理器
		// 4、编写处理器
		PersonHandler handler = new PersonHandler();
		
		
		
		parse.parse(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaoyue/SAXpreas/person.xml"),
				handler);

		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag = null;

	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (null != qName) {
			tag = qName;
		}
		if (null != qName && qName.equals("person")) {
			person = new Person();
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		if (null != tag && tag.equals("name")) {
			// System.out.println(new String(ch,start,length));
			person.setName(str);
		} else if (null != tag && tag.equals("age")) {
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// System.out.println("结束一个元素" +qName);
		if (qName.equals("person")) {
			this.persons.add(person);
		}
		tag = null;
	}

	@Override
	public void endDocument() throws SAXException {
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}

class Person {
	private String name;
	private Integer age;

	public Person() {
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}