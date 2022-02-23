package com.chalenge.ml.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chalenge.ml.clients.Root;
import com.chalenge.ml.models.Book;
import com.chalenge.ml.service.BookService;
import com.chalenge.ml.service.impl.BookServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class BookController {
	
	private BookServiceImpl bookServiceImpl;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/google/books")
	@PreAuthorize("hasRole('USER')")
	public Root getGoogleBooks(@RequestParam(required = false) String key_word) {
		bookServiceImpl= new BookServiceImpl();
		return bookServiceImpl.getGoogleBooks(key_word);		
	}
	
	@GetMapping("/books")
	@PreAuthorize("hasRole('USER')")
	public List<Book> getBooks() {		
		return bookService.getBooks();
	}
	
	@GetMapping("/books/{volumen}")
	@PreAuthorize("hasRole('USER')")
	public Book getBooks(@PathVariable String volumen, @RequestParam(required = false) String author){
		return bookService.getBooks(volumen, author);
	}
	
	@PostMapping("/books")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> createBooks(@RequestBody Book request){
		return bookService.createBooks(request);
	}
}
