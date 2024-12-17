package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Menu_ItemDAO;
import com.model.Menu_Items;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuItemService {

    @Autowired
    private Menu_ItemDAO menuItemDAO;

    private List<Menu_Items> menuItemsList;

    public MenuItemService() {
        menuItemsList = new ArrayList<>();
    }

    public List<Menu_Items> getAll(Long restaurantId) {
        return menuItemDAO.findByRestaurantId(restaurantId);
    }

    public void add(Menu_Items menuItem) {
        menuItemsList.add(menuItem);
        menuItemDAO.save(menuItem);
    }

    public void update(Menu_Items menuItem, Integer itemId) {
        Optional<Menu_Items> existingItemOptional = menuItemDAO.findById(itemId);

        if (existingItemOptional.isPresent()) {
            Menu_Items existingItem = existingItemOptional.get();
            existingItem.setItem_name(menuItem.getItem_name());
            existingItem.setItem_descrption(menuItem.getItem_descrption());
            existingItem.setItem_price(menuItem.getItem_price());
            existingItem.setRestaurant_id(menuItem.getRestaurant_id());
            menuItemDAO.save(existingItem);
        } else {
            throw new EntityNotFoundException("Menu item with ID " + itemId + " not found.");
        }
    }

    public void delete(Long restaurantId, Long itemId) {
        Optional<Menu_Items> existingItemOptional = menuItemDAO.findByRestaurantIdAndItemId(restaurantId, itemId);

        if (existingItemOptional.isPresent()) {
            menuItemDAO.delete(existingItemOptional.get());
        } else {
            throw new EntityNotFoundException("Menu item with ID " + itemId + " and restaurant ID " + restaurantId + " not found.");
        }
    }

    public boolean menuItemExists(Long restaurantId, Long itemId) {
        return menuItemDAO.existsByRestaurantIdAndItemId(restaurantId, itemId);
    }
}
