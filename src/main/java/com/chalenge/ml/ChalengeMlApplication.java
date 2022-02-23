package com.chalenge.ml;
/*
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
import com.chalenge.ml.models.Book;
import com.chalenge.ml.models.User;
import com.chalenge.ml.models.Wishlist;
import com.chalenge.ml.repository.BookRepository;
import com.chalenge.ml.repository.UserRepository;
import com.chalenge.ml.repository.WishlistRepository;
*/

@SpringBootApplication
// public class ChalengeMlApplication implements CommandLineRunner {
public class ChalengeMlApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChalengeMlApplication.class, args);
	}
	
/*
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Optional<User> user;
		Book book= new Book();
		List<Book> bookList;
		Wishlist wishlist1 = new Wishlist();
		
		// cargo informacion de un usuario ya registrado
		user= userRepository.findByUsername("leoh");
		
		// defino la  informacion de un libro
		book.setTitle("Bitcoin el futuro");
		book.setUrl("http://google.api.books/btc");
		
		// persisto la informacion de un libro
		bookRepository.save(book);
		bookList= bookRepository.findAll();
		
		// defino la  informacion de una lista de deseo
		wishlist1.setName("Mi Lista 1");
		wishlist1.setDate("2022-02-14");
		wishlist1.setBook(bookList);
		wishlist1.setUser((User)user.get());
		wishlistRepository.save(wishlist1);
	}
*/
}
