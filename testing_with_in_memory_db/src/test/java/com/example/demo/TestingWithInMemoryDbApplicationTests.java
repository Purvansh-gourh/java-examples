package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.repos.CustomerRepository;

@SpringBootTest
class TestingWithInMemoryDbApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private CustomerRepository repo;
	
	@Test
	public void testRowsAdded() {
		Customer customerActual = repo.save(new Customer(101,"Purvansh"));
		Optional<Customer> expected = repo.findById(customerActual.getId());
		
		assertEquals(customerActual.getName(),expected.get().getName());
	}
}
