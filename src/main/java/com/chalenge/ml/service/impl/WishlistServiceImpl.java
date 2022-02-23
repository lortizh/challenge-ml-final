package com.chalenge.ml.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chalenge.ml.dto.UserBookDTO;
import com.chalenge.ml.enums.EnumResponseCodes;
import com.chalenge.ml.models.Book;
import com.chalenge.ml.models.User;
import com.chalenge.ml.models.Wishlist;
import com.chalenge.ml.repository.BookRepository;
import com.chalenge.ml.repository.UserRepository;
import com.chalenge.ml.repository.WishlistRepository;
import com.chalenge.ml.security.jwt.AuthTokenFilter;
import com.chalenge.ml.service.WishlistService;
import com.chalenge.ml.payload.response.ResponseHandler;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRep;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	private static final Logger logger = LoggerFactory.getLogger(WishlistServiceImpl.class);
	
	private EnumResponseCodes enumRespCodes;

	public WishlistServiceImpl() {
	}

	@Override
	public List<UserBookDTO> getAllWishList() {
		logger.info(":: WishlistServiceImpl::>getAllWishList() ::");
		return wishlistRep.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<UserBookDTO> getWishListByUserName(String userName) {		
		// TODO Auto-generated method stub
		List<UserBookDTO> userBookDTOs= new ArrayList<>();
		List<Wishlist> myWishlist = new ArrayList<>();
		logger.info(":: WishlistServiceImpl::>getWishListByUserName() ::");
		Optional <User> user= userRepository.findByUsername(userName);
		if(user.isPresent()) {
			logger.info(":: Antes de Consultar Wishlist por User :: ");
			myWishlist= wishlistRep.findWishlistByUser((User)user.get());
			userBookDTOs=convertEntityToDto(myWishlist);
		}
		else
			return null; //PENDIENTE DEFINIR ERROR HANDLER
		return userBookDTOs;
	}
	
	@Override
	public List<Book> getBooksByIdWishlist(Integer idWishList, String userName) {
		// TODO Auto-generated method stub
		logger.info(":: WishlistServiceImpl::>getBooksByIdWishlist() :: "+idWishList+", "+userName);
		Optional <Wishlist> wishlist= wishlistRep.findById(idWishList);
		List<Book> books= new ArrayList<>();
		if(wishlist.isPresent()) {			
			if(((Wishlist)wishlist.get()).getUser().getUsername().equals(userName)) {
				books=((Wishlist)wishlist.get()).getBook();
			}
		}
		else
			return null; //PENDIENTE DEFINIR ERROR HANDLER
		return books;
	}
	
	@Override
	public ResponseEntity<Object> deleteWishlist(Integer idWishList) {
		// TODO Auto-generated method stub
		logger.info(":: WishlistServiceImpl::>deleteWishlist() ::");
		Optional<Wishlist> wishlist= wishlistRep.findById(idWishList);
		if(wishlist.isPresent()) {
			wishlistRep.delete((Wishlist)wishlist.get());
		}else {
			return ResponseHandler.generateResponse(enumRespCodes.ERROR.getDescripcion(), enumRespCodes.SUCCESS.getCodigo(),
					"[]", HttpStatus.NOT_FOUND);
		}
		return ResponseHandler.generateResponse(enumRespCodes.SUCCESS.getDescripcion(), enumRespCodes.SUCCESS.getCodigo(), 
				"[]", HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Object> createWishlistBooks(UserBookDTO request) {
		// TODO Auto-generated method stub
		logger.info(":: WishlistServiceImpl::>createWishlistBooks() ::");
		Optional<User> user = userRepository.findByUsername(request.getUserName());
		List<Book> bookEntityList = new ArrayList<Book>();
		bookEntityList= convertDtoToEntity(request);
		List<Integer> ids= new ArrayList<>();
		for (Book book : bookEntityList) {
			ids.add(book.getId());
		}
		List <Book> bookList= (List<Book>)bookRepository.findAllById(ids);		
		Wishlist wishlist = new Wishlist();
		wishlist.setName(request.getNameWishlist());
		wishlist.setDate(request.getDate());
		wishlist.setUser((User) user.get());
		wishlist.setBook(bookList);
		wishlistRep.save(wishlist);
		return ResponseHandler.generateResponse(enumRespCodes.SUCCESS.getDescripcion(), enumRespCodes.SUCCESS.getCodigo(), 
				"[]", HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Object> addBooksToWishlist(Integer idWishList, UserBookDTO request) {
		// TODO Auto-generated method stub
		Optional <Wishlist> wishlist= wishlistRep.findById(idWishList);
		return null;		
	}

	public List<Book> convertDtoToEntity(UserBookDTO userBookDto) {
		logger.info(":: WishlistServiceImpl::>convertDtoToEntity() ::");
		List<Book> bookList = new ArrayList<Book>();
		Iterator<Book> it = userBookDto.getBookList().iterator();
		while (it.hasNext()) {
			// logger.info(":: it.next():: "+it.next());
			bookList.add(it.next());
		}
		return bookList;
	}

	private UserBookDTO convertEntityToDto(Wishlist wishlist) {
		logger.info(":: WishlistServiceImpl::>convertEntityToDto() ::");
		UserBookDTO userBookDTO = new UserBookDTO();
		userBookDTO.setIdWishlist(wishlist.getId());
		userBookDTO.setNameWishlist(wishlist.getName());
		userBookDTO.setBookList(wishlist.getBook());
		userBookDTO.setUserName(wishlist.getUser().getUsername());
		userBookDTO.setUserEmail(wishlist.getUser().getEmail());
		userBookDTO.setDate(wishlist.getDate());
		return userBookDTO;
	}
	
	private List<UserBookDTO> convertEntityToDto(List<Wishlist> wishlist){
		logger.info(":: WishlistServiceImpl::>List convertEntityToDto() ::");
		List<UserBookDTO> userBookDtoList= new ArrayList<>();
		UserBookDTO userBookDto;
		for (Wishlist list : wishlist) {
			userBookDto= new UserBookDTO();
			userBookDto.setIdWishlist(list.getId());
			userBookDto.setNameWishlist(list.getName());
			userBookDto.setUserName(list.getUser().getUsername());
			userBookDto.setUserEmail(list.getUser().getEmail());
			userBookDto.setBookList(list.getBook());
			userBookDto.setDate(list.getDate());
			userBookDtoList.add(userBookDto);
		}
		return userBookDtoList;
	}

}
