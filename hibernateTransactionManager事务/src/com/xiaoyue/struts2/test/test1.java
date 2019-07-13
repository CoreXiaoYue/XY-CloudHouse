package com.xiaoyue.struts2.test;

import java.sql.SQLException;






import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiaoyue.struts2.Dao.BookDao;
import com.xiaoyue.struts2.bean.Book;
import com.xiaoyue.struts2.bean.Person;
import com.xiaoyue.struts2.service.BookService;



public class test1 {
	public static void main(String[] args) throws SQLException {
		
		 ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		 BookDao bookDao = ioc.getBean(BookDao.class);
		 BookService bookService = ioc.getBean(BookService.class);
		 Book book = new Book(null, "java学习笔记", 35.9, 15);
//		 Person person = new Person(null, "杨兴虎", 25, "五根松", new Book(null, "疯狂Java讲义", 65.9, 8));
//		 bookDao.test2(person);
//		 bookDao.test1(book);
//		 bookDao.fromPerson();
		/* bookDao.fromPerson();
		 bookDao.testmain();
		 bookDao.fromPerson();*/
//		 bookDao.selectPersonToAge();
		/* List<Book> list = bookService.selectPerson();
		 for (Book book : list) {
			System.out.println(book.getBookId()+"  "+book.getName()+"  "+book.getPrice()+"  "+book.getStock());
		}*/
//		 bookService.updateName(6);
		 bookService.updatePrice();
	}

}
