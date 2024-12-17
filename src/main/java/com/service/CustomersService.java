package com.service;
 
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomersDAO;
import com.model.Customers;
@Service
public class CustomersService {
	@Autowired
	CustomersDAO customersDAO;
	
	public CustomersService() {}
	
	public void add(Customers customers) {
		customersDAO.save(customers);
	}
	public List<Customers> getAll(){
		return customersDAO.findAll();
	}
	public void update(Customers customers) {
		customersDAO.save(customers);
	}
	public void delete(int id) {
		Customers customers=customersDAO.findById(id).get();
		customersDAO.delete(customers);
	}
	public void save(Customers customers) {
		customersDAO.save(customers);
	}
}