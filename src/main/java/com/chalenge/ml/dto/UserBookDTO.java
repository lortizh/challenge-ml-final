package com.chalenge.ml.dto;

import java.util.List;

import com.chalenge.ml.models.Book;
import com.chalenge.ml.models.User;

import lombok.Data;

@Data
public class UserBookDTO {
	private Integer idWishlist;
	private String nameWishlist;
	private List<Book> bookList;
	private String userName;
	private String userEmail;
	private String date;

	public UserBookDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdWishlist() {
		return idWishlist;
	}

	public void setIdWishlist(Integer idWishlist) {
		this.idWishlist = idWishlist;
	}

	public String getNameWishlist() {
		return nameWishlist;
	}

	public void setNameWishlist(String nameWishlist) {
		this.nameWishlist = nameWishlist;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
