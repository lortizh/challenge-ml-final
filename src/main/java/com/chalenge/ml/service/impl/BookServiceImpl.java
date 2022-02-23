package com.chalenge.ml.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chalenge.ml.clients.Root;
import com.chalenge.ml.clients.SimpleClientGet;
import com.chalenge.ml.enums.EnumResponseCodes;
import com.chalenge.ml.models.Book;
import com.chalenge.ml.payload.response.ResponseHandler;
import com.chalenge.ml.repository.BookRepository;
import com.chalenge.ml.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private SimpleClientGet simpleClient;

	@Autowired
	private BookRepository bookRepository;

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	private EnumResponseCodes enumRespCodes;

	public BookServiceImpl() {
	}

	@Override
	public Root getGoogleBooks(String key_word) {
		// TODO Auto-generated method stub
		logger.info(":: BookServiceImpl::>getGoogleBooks() ::");
		simpleClient = new SimpleClientGet(key_word);
		Root object = simpleClient.ConsumeService();
		logger.info(":: Object:: " + object.totalItems);
		return object;
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		logger.info(":: BookServiceImpl::>getBooks() ::");
		return bookRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> createBooks(Book request) {
		// TODO Auto-generated method stub
		logger.info(":: BookServiceImpl::> createBooks() ::" + request);
		Book bookToSave = new Book();
		bookToSave.setTitle(request.getTitle());
		bookToSave.setVolumen(request.getVolumen());
		bookToSave.setAuthors(request.getAuthors());
		bookToSave.setUrl(request.getUrl());
		bookRepository.save(bookToSave);
		return ResponseHandler.generateResponse(enumRespCodes.SUCCESS.getDescripcion(),
				enumRespCodes.SUCCESS.getCodigo(), "[]", HttpStatus.CREATED);
	}

	@Override
	public Book getBooks(String volumen, String author) {
		// TODO Auto-generated method stub
		logger.info(":: BookServiceImpl::>getBooks(volumen, author) ::");
		logger.info(":: Volumen:: " + volumen);
		logger.info(":: Author:: " + author);
		Optional<Book> book = Optional.empty();
		if (author == null) {
			book = bookRepository.findBookByVolumen(volumen);
		} else
			book = bookRepository.findBookByAuthors(author);
		return (Book) book.get();
	}
}
