package com.maria.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int customerId;
	private String customerFirstName;
	private String customerSurname;
	private String customerEmail;
	private LocalDate customerDateOfBirth;
	private double customerBalance;
	private int stationId;
}
