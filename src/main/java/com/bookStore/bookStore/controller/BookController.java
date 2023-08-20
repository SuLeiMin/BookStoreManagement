package com.bookStore.bookStore.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListService;

import java.util.ArrayList;


@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookServie;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister(){
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		ArrayList<Book> list = service.getAllBook();
		/*
		 * ModelAndView m=new ModelAndView(); m.setViewName("booklist");
		 * m.addObject("book",list);
		 */
		return new ModelAndView("booklist","book",list);
		
	}
	
	@PostMapping("/save")
	public String addBoook(@ModelAttribute Book b)
	{
		service.save(b);
		
		return "redirect:/available_books";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		ArrayList<MyBookList> list = (ArrayList<MyBookList>) myBookServie.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookServie.saveMyBooks(mb);
		return "redirect:/my_books";
	}
}
