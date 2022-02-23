package com.chalenge.ml.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.chalenge.ml.dto.UserBookDTO;
import com.chalenge.ml.models.Book;

public interface WishlistService {

	public List<UserBookDTO> getAllWishList();
	
	public List<UserBookDTO> getWishListByUserName(@PathVariable String userName);
	
	public List<Book> getBooksByIdWishlist(@PathVariable Integer idWishList, @PathVariable String userName);
	
	public ResponseEntity<Object> deleteWishlist(@PathVariable Integer idWishList);
	
	public ResponseEntity<Object> createWishlistBooks(@RequestBody UserBookDTO request);
	
	public ResponseEntity<Object> addBooksToWishlist(@PathVariable Integer idWishList, @RequestBody UserBookDTO request);
}
