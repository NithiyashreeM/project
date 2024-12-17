package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Menu_Items;
import com.service.MenuItemService;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public ResponseEntity<Object> getAllMenuItems(@PathVariable("restaurantId") Long restaurantId) {
        try {
            List<Menu_Items> menuItems = menuItemService.getAll(restaurantId);

            if (menuItems.isEmpty()) {
                return ResponseEntity.status(404)
                        .body("{\"code\": \"GETFAILS\", \"message\": \"No menu items found for the restaurant\"}");
            }

            return ResponseEntity.ok(menuItems);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"code\": \"ERROR\", \"message\": \"An error occurred while retrieving menu items\"}");
        }
    }

    @PostMapping
    public ResponseEntity<Object> addMenuItem(@PathVariable("restaurantId") Long restaurantId,
            @RequestBody Menu_Items menuItem) {
        try {
            menuItemService.add(menuItem);

            return ResponseEntity.ok(
                    "{\"code\": \"POSTSUCCESS\", \"message\": \"Menu item added to the restaurant successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"code\": \"ADDFAILS\", \"message\": \"Error adding menu item\"}");
        }
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Object> updateMenuItem(@PathVariable("restaurantId") Long restaurantId,
            @PathVariable("itemId") Long itemId, @RequestBody Menu_Items menuItem) {
        try {
            if (!menuItemService.menuItemExists(restaurantId, itemId)) {
                return ResponseEntity.status(404)
                        .body("{\"code\": \"UPDTFAILS\", \"message\": \"Menu item doesn't exist\"}");
            }

            menuItemService.update(menuItem, null);

            return ResponseEntity.ok(
                    "{\"code\": \"UPDATESUCCESS\", \"message\": \"Menu item details updated successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"code\": \"UPDTFAILS\", \"message\": \"Error updating menu item\"}");
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Object> deleteMenuItem(@PathVariable("restaurantId") Long restaurantId,
            @PathVariable("itemId") Long itemId) {
        try {
            if (!menuItemService.menuItemExists(restaurantId, itemId)) {
                return ResponseEntity.status(404)
                        .body("{\"code\": \"DELFAILS\", \"message\": \"Menu item doesn't exist\"}");
            }

            menuItemService.delete(restaurantId, itemId);

            return ResponseEntity.ok(
                    "{\"code\": \"DELETESUCCESS\", \"message\": \"Menu item deleted successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"code\": \"DELFAILS\", \"message\": \"Error deleting menu item\"}");
        }
    }
}
