package main.bookExchange.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import main.bookExchange.dto.Book;

@Service
@Configurable
public class BookService {
	@Autowired
	private DataService dataService;
	
	public List<Book> getBooks(){
		return dataService.listBook();
	}
	
	public void addBook(Book book){
		dataService.addBook(book);
	}
	
	public void deleteBook(Integer id){
		dataService.deleteBook(id);
	}
	
	public void editBook(Book book){
		dataService.editBook(book);
	}
	
	public Book getBookById(Integer id){
		return dataService.getBookById(id);
	}
	
	public List<Book> getBooksForPage(Integer page){
		List<Book> bookList = getBooks();
		int bookPerPage = 20;
		List<Book> bookListForPage = new ArrayList<> ();
		if (page == null)
			page = 1;

		for (int i = 0; i < bookPerPage; i++) {
			int index = (page - 1) * bookPerPage + i;
			if (index < bookList.size())
				bookListForPage.add(bookList.get(index));
			else break;
		}

		return bookListForPage;
	}
	
	public int getPageCount() {
		int bookPerPage = 20;
		int bookCount = getBooks().size();
		int endPage = bookCount % bookPerPage == 0 ? bookCount / bookPerPage : bookCount / bookPerPage + 1;

		return endPage;
	}
	
	public void setModelBook(Book book, ModelMap model) {
		model.addAttribute("author", book.getAuthor());
		model.addAttribute("title", book.getTitle());
		model.addAttribute("year", book.getYear());
		model.addAttribute("country", book.getCountry());
		model.addAttribute("language", book.getLanguage());
		model.addAttribute("link", book.getLink());
		model.addAttribute("imageLink", book.getImageLink());
		model.addAttribute("ISBN", book.getIsbn());
		model.addAttribute("category", book.getCategory());
		model.addAttribute("description", book.getDescription());
		model.addAttribute("totalPage", book.getPages());
	}

}
