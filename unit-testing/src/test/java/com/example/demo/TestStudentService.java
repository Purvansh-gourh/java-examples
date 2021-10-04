package com.example.demo;

import static org.junit.Assert.*;

import org.junit.*;

public class TestStudentService {
	StudentService service = null;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Set Up Method Called");
	}
	
	@Before
	public void beforeEachMethod() {
		service = new StudentService();
		System.out.println("Before Method Called");
	}
	
	@Test
	public void testGradeA() {
		int mark = 60;
		assertEquals("A",service.allotGrade(mark));
	}
	@Test
	public void testGradeB() {
		int mark = 20;
		assertEquals("B",service.allotGrade(mark));
	}
	@Test
	public void testGradeO() {
		int mark = 90;
		assertEquals("O",service.allotGrade(mark));
	}
	@Test
	public void testGradeWhenMark40() {
		int mark = 40;
		assertEquals("A",service.allotGrade(mark));
	}
	@Test
	public void testGradeWhenMark80() {
		int mark = 80;
		assertEquals("A",service.allotGrade(mark));
	}
	
	@After
	public void afterEachMethod() {
		service = null;
		System.out.println("After Method Called");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Tear Down Method Called");
	}
	
}
