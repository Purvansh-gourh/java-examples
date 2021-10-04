package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repos.CustomerRepository;

@Service
public class CustomerServices {
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer add(Customer entity) {
		return this.repo.save(entity);
	}
	
	public List<Customer> findByName(String searchName){
		return this.repo.findByName(searchName);
	}
}
