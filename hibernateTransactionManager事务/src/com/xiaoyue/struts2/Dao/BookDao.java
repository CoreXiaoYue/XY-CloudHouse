package com.xiaoyue.struts2.Dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoyue.struts2.bean.Book;
import com.xiaoyue.struts2.bean.Person;
@Repository
public class BookDao {
		@Autowired
		private  SessionFactory sessionFactory;
		
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		public Session getSession() {
				Session session=null;
				session=sessionFactory.getCurrentSession();
			return session;
		}
		public void testmain(Integer id){//测试这两个方法是否是在同一个事务中
			updateName(id);
			updatePrice();//模拟有语法错误。事务回滚
		}
		//修改id=3的价格=1500
		public void updateName(Integer id) {
			String hql="update Book b set b.name='java编程思想' where b.bookId=?";
			int update = getSession().createQuery(hql).setParameter(0, id).executeUpdate();
			System.out.println("成功"+update);
		}
		//修改id=5的价格=1000
		public void updatePrice(){
			String hql="update Book b set b.price=41.6 where b.bookId=2";
			int update = getSession().createQuery(hql).executeUpdate();
			System.out.println("成功"+update);
		}
		
		public List<Book> selectPerson(){
			String hql="from Book";
			List<Book> list = getSession().createQuery(hql, Book.class).list();
			return list;
		}
		
		public void selectPersonToAge(){
			String hql="from Person p where p.age=18";
			 Person result = getSession().createQuery(hql,Person.class).uniqueResult();
			
			System.out.println(result);
		}
//		@Transactional(propagation=Propagation.REQUIRED)
		public void save(){
			Book dao1 = new Book(null,"book6",150.6,12);
			Book dao2 = new Book(null,"book7",27.6,18);
			Book dao3 = new Book(null,"book8",43.6,29);
			
			getSession().save(dao1);
			getSession().save(dao2);
			getSession().save(dao3);
		}
}
