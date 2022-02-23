package com.chalenge.ml.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.chalenge.ml.clients.Root;
import com.chalenge.ml.models.Book;

public interface BookService {
	
	public Root getGoogleBooks(@RequestParam(required = false) String key_word);
	
	public List<Book> getBooks();
	
	public Book getBooks(@PathVariable(required = false) String volumen, @RequestParam(required = false) String author);
	
	public ResponseEntity<Object> createBooks(@RequestBody Book request);
}
