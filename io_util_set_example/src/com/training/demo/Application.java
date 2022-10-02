package com.training.demo;
import java.util.Collection;
import java.io.IOException;
import java.util.*;

import com.training.demo.ifaces.Repository;
import com.training.demo.model.Invoice;
import com.training.demo.services.InvoiceRepositoryImplementation;
import com.training.demo.services.FileHandlingService;
public class Application {
	public static void printElements(Collection<?> collection) {
		
		Collection<Invoice> castedColl = (Collection<Invoice>) collection;
		for(Invoice eachInvoice : castedColl) {
			System.out.println(eachInvoice);
		}
	}
	
	public static void main(String[] args) {
		Repository<Invoice> repo =
				new InvoiceRepositoryImplementation();
		Invoice ram = new Invoice(101,"Ramesh",75757);
		Invoice nikhil = new Invoice(102,"Nikhil",9000);
		
		System.out.println("Element added : "+ repo.add(ram));
		System.out.println("Element added : "+ repo.add(nikhil));
		
		Set<Invoice> list = (Set<Invoice>)repo.getAll();
		
		FileHandlingService service = new FileHandlingService(list);
		try {
			System.out.println("File Created : " +service.writeToFile("invoice.csv"));
			
			Set<Invoice> invSet = service.readFromFile("invoice.csv");
			printElements(invSet);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
//		printElements(repo);
	}
}
