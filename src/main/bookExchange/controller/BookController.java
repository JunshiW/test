package main.bookExchange.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.bookExchange.dto.Book;
import main.bookExchange.service.BookService;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping(value = "/books")
public class BookController extends HttpServlet {
	@Autowired
	private BookService bookService;
	
	   @RequestMapping(value = "/add", method = RequestMethod.GET)
	   public ModelAndView add() {
	      return new ModelAndView("addNewBook", "command", new Book());
	   }
	   
	   @RequestMapping(value = "/addOne", method = RequestMethod.POST)
	   public String addByBook(@ModelAttribute("SpringWeb")Book book, ModelMap model) {
		   bookService.addBook(book);
		   bookService.setModelBook(book, model);
		   return "result";
	   }
	   
	   @RequestMapping(value = "/list", method = RequestMethod.GET)
	   public String books(@RequestParam(value = "page", required = false)Integer page, ModelMap model) { 
		  List<Book> bookList = bookService.getBooksForPage(page);
		  int endpage = bookService.getPageCount();
		  
		  model.addAttribute("endpage",endpage);
		  model.addAttribute("bookList",bookList);
		  
	      return "list";
	   }
	   
	   
	   
	   @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	   public String deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		   Integer id= Integer.parseInt(request.getParameter("bookId")); 
		   bookService.deleteBook(id);
		   
	       return "redirect:list?page=1";
	   }
	   
	   @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException{
		  Integer id= Integer.parseInt(request.getParameter("bookId"));
		  Book book = bookService.getBookById(id);
		  model.addAttribute("book",book);
	      return "editBook";
	   }
	   
	   @RequestMapping(value = "/editOne", method = RequestMethod.POST)
	   public String editBook(@ModelAttribute("SpringWeb")Book book, ModelMap model){ 
		   bookService.editBook(book);
		   
	       return "redirect:list?page=1";
	   }
}
