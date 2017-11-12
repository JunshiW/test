package main.bookExchange.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import main.bookExchange.dto.Book;

//@Component("DataService")
@Service
public class DataService {
	
	public void addBook(Book book) {
		SqlSession session = MyBatisUtilService.getSqlSessionFactory().openSession();	
		session.insert("main.resources.bookMapper.insertBook", book);
		session.commit();
		session.close();
	}
	
	public List<Book> listBook() {
		List<Book> bookList = new ArrayList<Book> ();
		
		SqlSession session = MyBatisUtilService.getSqlSessionFactory().openSession();	
		bookList = session.selectList("main.resources.bookMapper.getAll");
		session.commit();
		session.close();
		return bookList;
	}
	
	public void deleteBook(Integer id) {
		SqlSession session = MyBatisUtilService.getSqlSessionFactory().openSession();	
		session.delete("main.resources.bookMapper.deleteBookById", id);
		session.commit();
		session.close();
	}
	
	public void editBook(Book book) {
		SqlSession session = MyBatisUtilService.getSqlSessionFactory().openSession();	
		session.update("main.resources.bookMapper.editBook", book);
		session.commit();
		session.close();
	}
	
	public Book getBookById(Integer id){
		SqlSession session = MyBatisUtilService.getSqlSessionFactory().openSession();	
		Book book = (Book) session.selectOne("main.resources.bookMapper.selectBookById", id);
		session.commit();
		session.close();
		return book;
	}

}
