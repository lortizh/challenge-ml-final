package com.chalenge.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chalenge.ml.models.User;
import com.chalenge.ml.models.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	// Optional<List<Wishlist>> findWishlistByUser(User user);
	List<Wishlist> findWishlistByUser(User user);
}
