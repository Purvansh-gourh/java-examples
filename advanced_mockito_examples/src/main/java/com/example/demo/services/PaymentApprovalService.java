package com.example.demo.services;

import com.example.demo.ifaces.CardPayment;

public class PaymentApprovalService {

	private CardPayment pmtApproval;

	public PaymentApprovalService() {
		super();
	}

	public PaymentApprovalService(CardPayment pmtApproval) {
		super();
		this.pmtApproval = pmtApproval;
	}
	
	public boolean applyForApproval(long cardNumber,String merchant) {
		boolean result = false;
		if(!merchant.contains("jewellery")) {
			result =  this.pmtApproval.approve(cardNumber, merchant);
			System.out.println(merchant+" : "+result);
		} 
		
		return result;
	}
	
}
