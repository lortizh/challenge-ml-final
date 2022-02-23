package com.chalenge.ml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chalenge.ml.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	Optional<Book> findBookByVolumen(String volumen);
	Optional<Book> findBookByAuthors(String author);
}
