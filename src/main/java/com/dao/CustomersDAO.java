package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Customers;
@Repository
public interface CustomersDAO extends JpaRepository<Customers, Integer>{

}
