package com.bookStore.bookStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.respository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRep;
	
	public void save(Book b) {
		bRep.save(b);
	}
	
	public ArrayList<Book> getAllBook() {
		return (ArrayList<Book>) bRep.findAll();
	}
	
	public Book getBookById(int id) {
		return bRep.findById(id).get();
	}
	
	public void deleteById(int id)
	{
		bRep.deleteById(id);
	}
}
