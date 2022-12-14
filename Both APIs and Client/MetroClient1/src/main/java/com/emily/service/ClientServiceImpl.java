package com.emily.service;

import java.time.LocalDate;

import com.emily.entity.StationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emily.entity.Customer;

@Service
public class ClientServiceImpl implements ClientService {
	
	// Import RestTemplate to call Rest API - to connect to customer database
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Customer loginCheck(int id) {	
		try {
			// Call API to search for customer with inputed Id
			Customer customer = restTemplate.getForObject("http://localhost:8089/customers/"+id, Customer.class);
			return customer;
		} catch(Exception exception) {
			return null;
		}	
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		try {
			return restTemplate.postForObject("http://localhost:8089/customers", customer, Customer.class);
		} catch(Exception exception) {
			return null;
		}
	}

	@Override
	public StationList getAllStations() {
		try {
			StationList allStations = restTemplate.getForObject("http://localhost:8082/allStations", StationList.class);
			return allStations;
		} catch(Exception exception) {
			return null;
		}
	}
}
