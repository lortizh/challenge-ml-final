package com.chalenge.ml.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wishlists")
public class Wishlist {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date")
	private String date;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	
	// @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private List <Book> book;
	
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}
	
	public Wishlist(String name, String date, User user, List <Book> book) {
		this.name=name;
		this.date=date;
		this.user=user;
		this.book=book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Integer getId() {
		return id;
	}
	
	
}
