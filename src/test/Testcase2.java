package test;

import org.testng.annotations.Test;

public class Testcase2 {

	@Test(description = "Verify the homepage functionality")
	public void HomePageTest() {
		
		System.out.println("Inside Home Page Test");	
		
	}

	@Test(dependsOnMethods="HomePageTest")
	public void HomePageTest2() {
		
		System.out.println("Inside Home Page Test2");	
		
	}
	
	@Test(dependsOnMethods="HomePageTest2")
	public void HomePageTest3() {
		
		System.out.println("Inside Home Page Test3");	
		
	}
}
