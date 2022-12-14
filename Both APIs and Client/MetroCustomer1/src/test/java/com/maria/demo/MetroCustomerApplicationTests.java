package com.maria.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.maria.entity.Customer;
import com.maria.persistence.CustomerDao;
import com.maria.service.CustomerServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class MetroCustomerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	private CustomerServiceImpl service;
	@Mock
	private CustomerDao dao;
	private AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);

	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	
	// test that should pass
	@Test
	@Order(1)
	public void testAddCustomer() {

		LocalDate date = LocalDate.of(2010, 1, 8);
		Customer customer = new Customer(103, "Helen", "Bower", "helen@gmail.com", date, 100, 0);
		assertEquals(customer,service.addCustomer(customer));
	}
	
	
	@Test
	@Order(2)
	 public void testAddCustomerTwo() {
	
		LocalDate date = LocalDate.of(2020, 1, 8);
		Customer customer = new Customer(102, "Helen", "Bower", "helen@gmail.com", date, 100, 0);
		assertNull(service.addCustomer(customer));
		
			}
		
	
	@Test
	@Order(3)
	public void testGetAllCustomers() {
		List<Customer> myList = null;
		when(dao.findAll()).thenReturn(myList);
		assertEquals(service.getAllCustomers(),myList);
		
	}
	
	
	@Test
	@Order(4)
	public void testDeductBalance() {
		LocalDate date = LocalDate.of(1995, 8, 16);
		Customer customer = new Customer(104,"Megan","Tales", "megan@gmail.com",date,100,0);
		when(dao.findById(104)).thenReturn(Optional.of(customer));
		//assertTrue(service.getCustomer(104) !=null);
		assertTrue(service.deductBalance(104,5).getCustomerBalance()==95);
	}
	
	
	@Test
	@Order(5)
	public void testTopUpbalance() {
		LocalDate date = LocalDate.of(1994, 4, 11);
		Customer customer = new Customer(105,"Bob","Bells", "bob@gmail.com",date,100,0);
		when(dao.findById(105)).thenReturn(Optional.of(customer));
		assertTrue(service.topUpbalance(105, 10).getCustomerBalance()==110);
	}
	
	@Test
	@Order(6)
	public void testSetStationToZero() {
		LocalDate date = LocalDate.of(1994, 4, 11);
		Customer customer = new Customer(105,"Bob","Bells", "bob@gmail.com",date,100,2);
		when(dao.findById(105)).thenReturn(Optional.of(customer));
		assertTrue(service.setStationIdToCustomer(105,5).getStationId()==5);
	}
	
	@Test
	@Order(7)
	public void testGetCustomer() {
		LocalDate date = LocalDate.of(1990, 5, 16);
		Customer customer = new Customer(106,"Shana","Sparks", "shana@gmail.com",date,100,0);
		when(dao.findById(106)).thenReturn(Optional.of(customer));
		assertTrue(service.getCustomer(106) !=null);
	}
	
}