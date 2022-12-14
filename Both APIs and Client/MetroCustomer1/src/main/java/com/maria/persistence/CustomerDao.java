package com.maria.persistence;


import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maria.entity.Customer;
import com.maria.entity.CustomerInvoice;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public List<CustomerInvoice>getInvoicesByCustomerId(int customerId);
	
}