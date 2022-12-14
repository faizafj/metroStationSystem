package com.emily.service;

import com.emily.entity.Customer;
import com.emily.entity.StationList;

public interface ClientService {

	Customer loginCheck(int id);

	Customer addNewCustomer(Customer customer);

	StationList getAllStations();


}
