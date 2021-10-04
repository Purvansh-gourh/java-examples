package com.example.demo;

import static org.junit.Assert.*;

import org.junit.*;

public class TestGreeting {
	Greeting grtObj=null;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Set Up Method Called");
	}
	
	@Before
	public void beforeEachMethod() {
		grtObj = new Greeting();
		System.out.println("Before Method Called");
	}
	// gets called everytime a test is run.
	
	@Test
	public void testGreet() {
		
		assertEquals("Good Morning", grtObj.greet());
		
	}
	
	@Test
	public void testGreetMessageLength() {
		int actLen = grtObj.greet().length();
		assertEquals(6, actLen);
	}
	
	@Ignore
	@Test
	public void testGreetForNotNull() {
		fail("Not yet implemented");
	}
	
	@After
	public void afterEachMethod() {
		grtObj = null;
		System.out.println("After Method Called");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Tear Down Method Called");
	}
	
}
