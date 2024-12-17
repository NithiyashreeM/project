package com.controller;

import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.service.CustomersService;
import com.service.OrdersService;
import com.service.RatingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ReviewService reviewService;

    // GET: Retrieve all customers
    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        List<Customers> customers = customersService.getAllCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.status(404).body("{\"code\": \"GETFAILS\", \"message\": \"Customer list is empty\"}");
        }
        return ResponseEntity.ok(customers);
    }

    // GET: Retrieve a specific customer by ID
    @GetMapping("/{customersId}")
    public ResponseEntity<Object> getCustomersById(@PathVariable("customersId") Long customersId) {
        Customers customer = customersService.getCustomersById(customersId);
        if (customer == null) {
            return ResponseEntity.status(404).body("{\"code\": \"GETFAILS\", \"message\": \"Customer not found\"}");
        }
        return ResponseEntity.ok(customer);
    }

    // PUT: Update details of a specific customer
    @PutMapping("/{customersId}")
    public ResponseEntity<Object> updateCustomers(@PathVariable("customersId") Long customersId, @RequestBody Customers customers) {
        if (!customersService.customersExists(customersId)) {
            return ResponseEntity.status(404).body("{\"code\": \"UPDTFAILS\", \"message\": \"Customer doesn't exist\"}");
        }
        customersService.updateCustomers(customersId, customers);
        return ResponseEntity.ok("{\"code\": \"UPDATESUCCESS\", \"message\": \"Customer updated successfully\"}");
    }

    // DELETE: Delete a specific customer
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") Long customerId) {
        if (!customersService.customerExists(customerId)) {
            return ResponseEntity.status(404).body("{\"code\": \"DELFAILS\", \"message\": \"Customer doesn't exist\"}");
        }
        customersService.deleteCustomer(customerId);
        return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Customer deleted successfully\"}");
    }

    // GET: Retrieve all orders placed by a specific customer
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<Object> getOrdersByCustomer(@PathVariable("customerId") Long customerId) {
        if (!customersService.customerExists(customerId)) {
            return ResponseEntity.status(404).body("{\"code\": \"GETFAILS\", \"message\": \"Customer doesn't exist\"}");
        }
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    // GET: Retrieve all reviews submitted by a specific customer
    @GetMapping("/{customerId}/reviews")
    public ResponseEntity<Object> getReviewsByCustomer(@PathVariable("customerId") Long customerId) {
        if (!customersService.customerExists(customerId)) {
            return ResponseEntity.status(404).body("{\"code\": \"GETFAILS\", \"message\": \"Customer doesn't exist\"}");
        }
        List<Review> reviews = reviewService.getReviewsByCustomerId(customerId);
        return ResponseEntity.ok(reviews);
    }

    // POST: Add a restaurant to the customer's favorites
    @PostMapping("/{customerId}/favorites")
    public ResponseEntity<Object> addRestaurantToFavorites(@PathVariable("customerId") Long customerId, @RequestBody Long restaurantId) {
        if (!customersService.customerExists(customerId)) {
            return ResponseEntity.status(404).body("{\"code\": \"ADDFAILS\", \"message\": \"Customer doesn't exist\"}");
        }
        customersService.addFavoriteRestaurant(customerId, restaurantId);
        return ResponseEntity.ok("{\"code\": \"ADDSUCCESS\", \"message\": \"Restaurant added to favorites successfully\"}");
    }

    // DELETE: Remove a restaurant from the customer's favorites
    @DeleteMapping("/{customerId}/favorites/{restaurantId}")
    public ResponseEntity<Object> removeRestaurantFromFavorites(@PathVariable("customerId") Long customerId, @PathVariable("restaurantId") Long restaurantId) {
        if (!customersService.customerExists(customerId)) {
            return ResponseEntity.status(404).body("{\"code\": \"DELFAILS\", \"message\": \"Customer doesn't exist\"}");
        }
        customersService.removeFavoriteRestaurant(customerId, restaurantId);
        return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Restaurant removed from favorites successfully\"}");
    }
}
