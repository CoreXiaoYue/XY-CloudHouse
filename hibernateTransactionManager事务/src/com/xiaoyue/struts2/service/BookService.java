package com.xiaoyue.struts2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyue.struts2.Dao.BookDao;
import com.xiaoyue.struts2.bean.Book;

@Service
public class BookService {
		@Autowired
		private BookDao bookDao;
		
//		@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
		public List<Book> selectPerson(){
			List<Book> list = bookDao.selectPerson();
			return list;
		}
//		@Transactional(propagation=Propagation.REQUIRED)
		public void updatePrice( ){
			bookDao.updatePrice();
		}
		
		public void updateName(Integer id){
			bookDao.updateName(id);
		}
		
		public void testmain(Integer id){
			bookDao.testmain(id);
		}
		
}
