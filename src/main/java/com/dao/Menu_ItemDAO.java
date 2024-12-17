package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Menu_Items;

@Repository
public interface Menu_ItemDAO extends JpaRepository<Menu_Items, Integer> {

	boolean existsByRestaurantIdAndItemId(Long restaurantId, Long itemId);

	Optional<Menu_Items> findByRestaurantIdAndItemId(Long restaurantId, Long itemId);

	List<Menu_Items> findByRestaurantId(Long restaurantId);
}