package com.bookStore.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

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
	public String getAllBook() {
		return "bookList";
	}
}
