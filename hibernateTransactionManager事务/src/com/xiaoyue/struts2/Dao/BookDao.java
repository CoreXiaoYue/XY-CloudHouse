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
		public void testmain(Integer id){//���������������Ƿ�����ͬһ��������
			updateName(id);
			updatePrice();//ģ�����﷨��������ع�
		}
		//�޸�id=3�ļ۸�=1500
		public void updateName(Integer id) {
			String hql="update Book b set b.name='java���˼��' where b.bookId=?";
			int update = getSession().createQuery(hql).setParameter(0, id).executeUpdate();
			System.out.println("�ɹ�"+update);
		}
		//�޸�id=5�ļ۸�=1000
		public void updatePrice(){
			String hql="update Book b set b.price=41.6 where b.bookId=2";
			int update = getSession().createQuery(hql).executeUpdate();
			System.out.println("�ɹ�"+update);
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
