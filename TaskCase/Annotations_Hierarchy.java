package TaskCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations_Hierarchy {
	
	@Test
	public static void login() {
		System.out.println("Just login into the page");
	}
	
	@Test
	public static void amazonLogin() {
		System.out.println("Just Lohin to the Amazon page");
	}
	@AfterMethod
	public static void aftermethod() {
		System.out.println("The run after method will run after the test");
	}
	@BeforeMethod
	public static void beforemethod() {
		System.out.println("The run before method will run before the test");
	}
	@BeforeTest
	public static void beforeTest() {
		System.out.println("The run before test will run before the beforeclass");
	}
	@AfterTest
	public static void AfterTest() {
		System.out.println("The run after test will execute before the afterclass");
	}
	@BeforeSuite
	public static void beforesuite() {
		System.out.println("The run before suite will run first");
	}
	@AfterSuite
	public static void aftersuite() {
		System.out.println("The run after suite will run last");
	}
	@BeforeClass
	public static void beforeclass() {
		System.out.println("The run before class will execute after BeforeTest");
	}
	@AfterClass
	public static void afterclass() {
		System.out.println("The run after class will execute before AfterTest");
	}

}
