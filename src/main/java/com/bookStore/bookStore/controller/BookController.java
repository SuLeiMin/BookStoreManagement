package com.bookStore.bookStore.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.service.BookService;

import java.util.ArrayList;


@Controller
public class BookController {

	@Autowired
	private BookService service;
	
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
}
