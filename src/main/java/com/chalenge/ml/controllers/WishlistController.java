package com.chalenge.ml.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chalenge.ml.dto.UserBookDTO;
import com.chalenge.ml.models.Book;
import com.chalenge.ml.service.WishlistService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping("/wishlist")
	@PreAuthorize("hasRole('USER')")
	public List<UserBookDTO> getAllWishList() {
		return wishlistService.getAllWishList();
	}

	@GetMapping("/wishlist/{userName}")
	@PreAuthorize("hasRole('USER')")
	public List<UserBookDTO> getWishListByUserName(@PathVariable String userName) {
		return wishlistService.getWishListByUserName(userName);
	}

	// MEJORAR ENVIANDO USER COMO PARAMETRO
	@GetMapping("/wishlist/{idWishList}/{userName}")
	@PreAuthorize("hasRole('USER')")
	public List<Book> getBooksByIdWishlist(@PathVariable Integer idWishList, @PathVariable String userName) {
		return wishlistService.getBooksByIdWishlist(idWishList, userName);
	}
	
	// MEJORAR ENVIANDO USER COMO PARAMETRO
	@DeleteMapping("/wishlist/{idWishList}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> deleteWishlist(@PathVariable Integer idWishList) {
		return wishlistService.deleteWishlist(idWishList);
	}

	@PostMapping("/wishlist")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> createWishlistBooks(@RequestBody UserBookDTO request) {
		return wishlistService.createWishlistBooks(request);
	}

	@PostMapping("/wishlist/book/{idWishlist}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> addBooksToWishlist(@PathVariable Integer idWishlist,
			@RequestBody UserBookDTO request) {
		return null;
	}
}
