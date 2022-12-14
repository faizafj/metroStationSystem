package com.emily.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	
	private int customerId;
	private String customerFirstName;
	private String customerSurname;
	private String customerEmail;
	private LocalDate customerDateOfBirth;
	private double customerBalance;
	private int stationId;
	

}
