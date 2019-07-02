package com.xiaoyue.io.SequenceInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小岳
 *将java对象存到文件中。使用：ObjectOutputStream，将单个对象写入到文件中
 *从文件中读取数据转成java对象。使用：ObjectInputStream，将多个对象存入集合中，再将集合写到文件中，
 *使用readObject()读取读取集合，在使用遍历
 */
public class ObjectInputStreamTest {

	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
		ObjectOutputStream();
//		ObjectInputStreamTest1();
	}

	/**将java对象存到文件中。使用：ObjectOutputStream，将单个对象写入到文件中
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void ObjectInputStreamTest1() throws IOException, FileNotFoundException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		Person person1 = new Person("小岳1",23,"成都1");
		oos.writeObject(person1);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
		Person persons = (Person) ois.readObject();
		System.out.println(persons);
		ois.close();
	}

	/**
	 * 使用readObject()读取读取集合，在使用遍历。
	 * 从文件中读取数据转成java对象。使用：ObjectInputStream，将多个对象存入集合中，再将集合写到文件中，
	 * 1。创建对象输出流ObjectInputStream。
	 * 2.创建要保存的对象。
	 * 3.将对象保存到集合当中。
	 * 4.writeObject(list)，将集合次写到文件中。
	 * 5.关闭输出流。
	 * 6.创建输入流对象ObjectInputStream，关联文件抽象路径。
	 * 7.readObject()从文件中获取数据返回指定类型集合对象。
	 * 8.遍历集合打印。
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void ObjectOutputStream() throws IOException, FileNotFoundException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		Person person1 = new Person("小岳1",23,"成都1");
		Person person2 = new Person("小岳2",24,"成都2");
		Person person3 = new Person("小岳3",25,"成都3");
		Person person4 = new Person("小岳4",26,"成都4");
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		oos.writeObject(list);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
		 List<Person> personlist = (List<Person>) ois.readObject();
		 for (Person person : personlist) {
			 System.out.println(person);
		}
		ois.close();
	}

}
