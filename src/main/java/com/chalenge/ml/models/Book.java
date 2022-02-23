package com.chalenge.ml.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "url")
	private String url;

	@Column(name = "title")
	private String title;
	
	@Column(name = "volumen")
	private String volumen;
	
	@Column(name = "authors")
	// private List<String> authors;
	private String authors;

	public Book() {
	}

	public Book(String url, String title) {
		this.url = url;
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumenId) {
		this.volumen = volumenId;
	}

	// public List<String> getAuthors() {
	public String getAuthors() {
		return authors;
	}

	// public void setAuthors(List<String> authors) {
	public void setAuthors(String authors) {
		this.authors = authors;
	}
}
