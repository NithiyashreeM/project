package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CouponsDAO;
import com.model.Coupons;
@Service
public class CouponsService {
	@Autowired
	CouponsDAO couponsDAO;
	
	public CouponsService() {}
	
	public void add(Coupons coupons) {
		couponsDAO.save(coupons);
	}
	public List<Coupons> getAll(){
		return couponsDAO.findAll();
	}
	public void update(Coupons coupons) {
		couponsDAO.save(coupons);
	}
	public void delete(int id) {
		Coupons coupons=couponsDAO.findById(id).get();
		couponsDAO.delete(coupons);
	}
	public void save(Coupons coupons) {
		couponsDAO.save(coupons);
	}
}
