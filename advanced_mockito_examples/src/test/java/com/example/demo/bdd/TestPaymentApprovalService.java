package com.example.demo.bdd;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.InvocationInterceptor.Invocation;
import org.mockito.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.hamcrest.MockitoHamcrest.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatcher.*;


import com.example.demo.ifaces.CardPayment;
import com.example.demo.services.PaymentApprovalService;

public class TestPaymentApprovalService {
	
	@Mock
	private CardPayment payment;
	
	@InjectMocks
	private PaymentApprovalService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApplyForApprovalFailure() {
		given(payment.approve(1234,"Punjab jewellery")).willReturn(false);
		
		boolean returnValue = service.applyForApproval(1234, "Punjab jewellery");
		
		assertEquals(returnValue, false);
	}
	
	@Test
	public void testApplyForApprovalSuccess() {
		given(payment.approve(1234,"Real Estate")).willReturn(true);
		
		boolean returnValue = service.applyForApproval(1234, "Real Estate");
		
		assertEquals(returnValue, true);
	}
	
	@Test
	public void testForArgumentCaptor() {
		ArgumentCaptor<Long> captor1 =
				ArgumentCaptor.forClass(Long.class);
		ArgumentCaptor<String> captor2 =
				ArgumentCaptor.forClass(String.class);
		
		given(payment.approve(1020, "ramesh hotel")).willReturn(true);
		
		// when
		service
			.applyForApproval(1020, "ramesh hotel");

		// then
		then(payment)
			.should(times(1))
			.approve(captor1.capture(), captor2.capture());
		// assertEquals(captor1.getAllValues().size(), 1);
		assertEquals(captor1.getValue(), 1020);
	}
	
	@Test
	public void testWithAnswer() {
		when(payment.approve(BDDMockito.anyLong(), BDDMockito.anyString())).thenAnswer((i) -> {
			// System.out.println(i.getArguments()[0]);
			return ((String) i.getArguments()[1]).length() == 3;
		});

		assertEquals(true, service.applyForApproval(2020, "grt"));

	}

}
