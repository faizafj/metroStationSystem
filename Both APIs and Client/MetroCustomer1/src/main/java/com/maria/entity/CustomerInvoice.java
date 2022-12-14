package com.maria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInvoice {

	private int invoiceId;
	private int customerId;
	private String startStation;
	private String endStation;
	private double cost;
	private double updatedBalance;
}