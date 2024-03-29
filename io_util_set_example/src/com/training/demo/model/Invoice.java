package com.training.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invoice {

	int invoiceNumber;
	String customerName;
	double amount;
	@Override
	public String toString() {
		return invoiceNumber + "," + customerName + "," + amount;
	}
	
	
	
	
}
