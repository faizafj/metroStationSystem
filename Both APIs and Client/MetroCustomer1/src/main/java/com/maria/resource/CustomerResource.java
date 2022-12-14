package com.maria.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maria.entity.Customer;
import com.maria.entity.ListInvoices;
import com.maria.service.CustomerServiceImpl;

@RestController
public class CustomerResource {

	@Autowired
	private CustomerServiceImpl service;

	//get customer by id
	@GetMapping(path = "customers/{cId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerByIdResource(@PathVariable("cId") int id) {

		return service.getCustomer(id);
	}
	//get all customers
	@GetMapping (path = "customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}

	//add new customer
	@PostMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer addNewCustomerResource(@RequestBody Customer customer) {
		return service.addCustomer(customer);

	}
	//update customer balance after deduction
	@PutMapping(path = "customers/deduct/{cId}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer deductFromCustomerBalanceResource(@PathVariable ("cId") int id, @PathVariable("amount") double amount) {
		return service.deductBalance(id,amount);

	}

	//update customer balance after top up
	@PutMapping(path = "customers/topup/{cId}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer topUpBalanceResource(@PathVariable("cId") int id, @PathVariable("amount") double amount) {
		return service.topUpbalance(id, amount);
	}

	//update customer's starting point
	@PutMapping(path = "customers/resetStation/{cId}/{sId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer setStationIdToCustomerResource(@PathVariable("cId") int id, @PathVariable("sId")int stationId) {
		return service.setStationIdToCustomer(id, stationId);
	}

}