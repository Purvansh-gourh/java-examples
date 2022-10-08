package com.training.demo.services;
import java.util.*;

import com.training.demo.ifaces.Repository;
import com.training.demo.model.Invoice;
public class InvoiceRepositoryImplementation implements Repository<Invoice> {

	private Set<Invoice> invoiceSet;
	
	
	public InvoiceRepositoryImplementation() {
		super();
		invoiceSet = new HashSet<>();
	}

	@Override
	public Set<Invoice> getAll() {
		return this.invoiceSet;
	}

	@Override
	public boolean add(Invoice t) {
		return this.invoiceSet.add(t);
	}
	
	
	
}
