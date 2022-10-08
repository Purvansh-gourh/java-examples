package com.training.demo.services;
import java.util.*;
import com.training.demo.model.Invoice;
import java.io.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FileHandlingService {
	
	private Set<Invoice> invoiceSet;

	public FileHandlingService(Set<Invoice> invoiceSet) {
		super();
		this.invoiceSet = invoiceSet;
	}
	
	public boolean writeToFile(String fileName) throws IOException{
		PrintWriter out = 
				new PrintWriter(new FileWriter(new File(fileName),true));
		// decorator design pattern
		
		for(Invoice eachInvoice:invoiceSet) {
			out.println(eachInvoice);
			
		}
		out.close();
		
		return true;
	}
	public Set<Invoice> readFromFile(String fileName) throws IOException {
		Set<Invoice> invoiceSet = new HashSet<Invoice>();
		BufferedReader reader = 
				new BufferedReader(new FileReader(new File(fileName)));
		
		String line;
		while((line=reader.readLine()) != null) {
			String[] values = line.split(",");
			Invoice inv = new Invoice(Integer.parseInt(values[0]),
					values[1],Double.parseDouble(values[2]));
			invoiceSet.add(inv);
		}
		
		return invoiceSet;
	}
	
}
